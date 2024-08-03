package com.example.salary.servlet;

import com.example.salary.model.Staff;
import com.example.salary.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ChangePassword", urlPatterns = "/changePassword")
@MultipartConfig()
public class ChangePassword extends HttpServlet {

    private final static StaffService staffService = new StaffService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String staffCode = request.getParameter("staffCode");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");


        Staff staff = staffService.findStaff(staffCode);
        if (staff == null) {
            staff = new Staff();
            staff.setStaffCode(staffCode);
            staff.setPassword(newPassword);
            staffService.insertStaff(staff);
            request.setAttribute("error", "密码修改成功");
            request.setAttribute("mainPage", "password.jsp");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        } else {
            if (!Objects.equals(staff.getPassword(), currentPassword)) {
                request.setAttribute("error", "当前密码错误，请检查");
                request.setAttribute("mainPage", "password.jsp");
                request.getRequestDispatcher("main.jsp").forward(request, response);
                return;
            } else {
                staff.setPassword(newPassword);
                staffService.updateStaff(staff);
            }
        }
        request.setAttribute("error", "密码修改成功");
        request.setAttribute("mainPage", "password.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);


    }
}
