package com.example.salary.servlet;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.salary.listener.GrossPayListener;
import com.example.salary.listener.NetPayListener;
import com.example.salary.model.GrossPay;
import com.example.salary.model.NetPay;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "UploadServlet", urlPatterns = "/processExcel")
@MultipartConfig(
        maxFileSize = 100 * 1024 * 1024
)
public class UploadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer month = Integer.parseInt(request.getParameter("month"));

        // 获取上传的文件
        Part filePart = request.getPart("file");
        InputStream sheet1 = filePart.getInputStream();
        EasyExcel.read(sheet1, GrossPay.class, new GrossPayListener(year, month)).excelType(ExcelTypeEnum.XLSX).sheet("sheet1").doRead();
        InputStream sheet2 = filePart.getInputStream();
        EasyExcel.read(sheet2, NetPay.class, new NetPayListener(year, month)).excelType(ExcelTypeEnum.XLSX).sheet("sheet2").doRead();

        request.setAttribute("result", " 文件上传成功");
        request.setAttribute("mainPage", "upload.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}