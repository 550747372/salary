package com.example.salary.service;

import com.example.salary.dao.StaffDAO;
import com.example.salary.model.Staff;

public class StaffService {

    StaffDAO staffDAO = new StaffDAO();

    public Staff findStaff(String staffCode) {
        return staffDAO.selectByStaff(staffCode);
    }

    public void insertStaff(Staff staff) {
        staffDAO.insert(staff);
    }

    public void updateStaff(Staff staff) {
        staffDAO.update(staff);
    }
}
