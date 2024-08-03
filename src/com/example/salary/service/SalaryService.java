package com.example.salary.service;

import com.example.salary.dao.GrossPayDAO;
import com.example.salary.dao.NetPayDAO;
import com.example.salary.model.GrossPay;
import com.example.salary.model.NetPay;
import com.example.salary.model.SalaryDTO;

public class SalaryService {

    GrossPayDAO grossPayDAO = new GrossPayDAO();
    NetPayDAO netPayDAO = new NetPayDAO();

    public SalaryDTO searchSalary(String staffCode, int year, int month) {

        SalaryDTO dto = new SalaryDTO();


        GrossPay grossPay = grossPayDAO.selectByStaff(staffCode, year, month);
        NetPay netPay = netPayDAO.selectByStaff(staffCode, year, month);

        dto.setGrossPay(grossPay);
        dto.setNetPay(netPay);

        if (grossPay == null && netPay == null) {
            return null;
        }
        return dto;
    }
}
