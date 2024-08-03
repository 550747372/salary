package com.example.salary.servlet;


import com.example.salary.model.SalaryDTO;
import com.example.salary.model.Staff;
import com.example.salary.service.SalaryService;
import com.example.salary.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "SalarySearchServlet", urlPatterns = "/salarySearch")
@MultipartConfig()
public class SalarySearchServlet extends HttpServlet {


    static final SalaryService salaryService = new SalaryService();
    static final StaffService staffService = new StaffService();

    public static void main(String[] args) {
        SalaryDTO salaryDTO = salaryService.searchSalary("12999", 2024, 1);
        System.out.println(salaryDTO.getNetPay());
        System.out.println(salaryDTO.getGrossPay());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String staffCode = request.getParameter("staffCode");
        String password = request.getParameter("password");
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));

        Staff staff = staffService.findStaff(staffCode);

        if (staff == null) {
            request.setAttribute("error", "请修改初始密码后重试");
            request.setAttribute("mainPage", "search.jsp");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        } else {
            if (!Objects.equals(password, staff.getPassword())) {
                request.setAttribute("error", "用户名或者密码错误，请检查");
                request.setAttribute("mainPage", "search.jsp");
                request.getRequestDispatcher("main.jsp").forward(request, response);
                return;
            }
        }

        SalaryDTO salaryDTO = salaryService.searchSalary(staffCode, year, month);
        if (salaryDTO == null) {
            request.setAttribute("error", "未找到工资信息");
            request.setAttribute("mainPage", "search.jsp");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }
        request.setAttribute("dto", salaryDTO);
        request.setAttribute("mainPage", "salary.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}