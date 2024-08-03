package com.example.salary.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.salary.dao.NetPayDAO;
import com.example.salary.model.NetPay;

import java.util.ArrayList;
import java.util.List;

public class NetPayListener extends AnalysisEventListener<NetPay> {


    private final Integer year;

    private final Integer month;


    List<NetPay> handleList = new ArrayList<>();

    NetPayDAO netPayDAO = new NetPayDAO();

    @Override
    public void invoke(NetPay grossPay, AnalysisContext analysisContext) {

        grossPay.setYear(year);
        grossPay.setMonth(month);
        handleList.add(grossPay);

        if (handleList.size() > 200) {
            netPayDAO.insert(handleList);
            handleList = new ArrayList<>();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (!handleList.isEmpty()) {
            netPayDAO.insert(handleList);
        }
    }

    public NetPayListener(Integer year, Integer month) {
        this.year = year;
        this.month = month;
    }
}
