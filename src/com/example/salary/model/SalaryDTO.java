package com.example.salary.model;

public class SalaryDTO {

    private GrossPay grossPay;
    private NetPay netPay;


    public GrossPay getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(GrossPay grossPay) {
        this.grossPay = grossPay;
    }

    public NetPay getNetPay() {
        return netPay;
    }

    public void setNetPay(NetPay netPay) {
        this.netPay = netPay;
    }
}
