package com.example.salary.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.salary.dao.GrossPayDAO;
import com.example.salary.model.GrossPay;

import java.util.ArrayList;
import java.util.List;

public class GrossPayListener extends AnalysisEventListener<GrossPay> {


    private final Integer year;

    private final Integer month;


    List<GrossPay> handleList = new ArrayList<>();

    GrossPayDAO grossPayDAO = new GrossPayDAO();

    @Override
    public void invoke(GrossPay grossPay, AnalysisContext analysisContext) {

        grossPay.setYear(year);
        grossPay.setMonth(month);
        handleList.add(grossPay);

        if (handleList.size() > 200) {
            grossPayDAO.insert(handleList);
            handleList = new ArrayList<>();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (!handleList.isEmpty()) {
            grossPayDAO.insert(handleList);
        }
    }

    public GrossPayListener(Integer year, Integer month) {
        this.year = year;
        this.month = month;
    }
}
