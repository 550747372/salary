package com.example.salary.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class NetPay {

    @ExcelIgnore
    private Integer year;
    @ExcelIgnore
    private Integer month;

    /**
     * 唯一标识
     */
    @ExcelProperty(value = "唯一标识")
    private String staffCode;

    @ExcelProperty("总序号")
    private String totalNum;


    @ExcelProperty("序号")
    private String num;


    @ExcelProperty("部门")
    private String deptName;


    @ExcelProperty("单位")
    private String company;


    @ExcelProperty("姓名")
    private String staffName;


    @ExcelProperty("原职务（级）")
    private String originPosition;


    @ExcelProperty("现职务（级）")
    private String position;


    @ExcelProperty("起薪（停薪）时间")
    private String beginPayTime;


    @ExcelProperty("变动前移动通讯补贴")
    private String phoneSubsidyBefore;


    @ExcelProperty("变动前特殊岗位通讯补贴")
    private String specialPositionSubsidyBefore;


    @ExcelProperty("变动前住房提租补贴")
    private String rentSubsidyBefore;


    @ExcelProperty("变动前班车补贴")
    private String shuttleSubsidyBefore;


    @ExcelProperty("变动前住房补贴")
    private String housingSubsidyBefore;


    @ExcelProperty("变动前公车补贴")
    private String busSubsidyBefore;


    @ExcelProperty("变动前物业补贴")
    private String propertySubsidyBefore;


    @ExcelProperty("变动后移动通讯补贴")
    private String phoneSubsidyAfter;


    @ExcelProperty("变动后特殊岗位移动通讯补贴")
    private String specialPositionSubsidyAfter;


    @ExcelProperty("变动后住房提租补贴")
    private String rentSubsidyAfter;


    @ExcelProperty("变动后班车补贴")
    private String shuttleSubsidyAfter;


    @ExcelProperty("变动后住房补贴")
    private String housingSubsidyAfter;


    @ExcelProperty("变动后公车补贴")
    private String busSubsidyAfter;


    @ExcelProperty("变动后物业补贴")
    private String propertySubsidyAfter;


    @ExcelProperty("补发月数")
    private String backPayMonth;


    @ExcelProperty("补发津补贴额")
    private String backSubsidy;


    @ExcelProperty("移动通讯补贴明细")
    private String phoneSubsidyDetail;


    @ExcelProperty("特殊岗位移动通讯补明细")
    private String specialPositionSubsidyDetail;


    @ExcelProperty("住房提租补贴明细")
    private String rentSubsidyDetail;


    @ExcelProperty("班车补贴明细")
    private String shuttleSubsidyDetail;


    @ExcelProperty("住房补贴明细")
    private String housingSubsidyDetail;


    @ExcelProperty("公车补贴明细")
    private String busSubsidyDetail;


    @ExcelProperty("物业补贴明细")
    private String propertySubsidyDetail;


    @ExcelProperty("备注")
    private String remark;


    @ExcelProperty("补发工资")
    private String backPay;


    @ExcelProperty("补扣工资")
    private String deductedWages;


    @ExcelProperty("应发工资")
    private String grossPay;


    @ExcelProperty("实发工资")
    private String netPay;

    @ExcelProperty("预留字段1")
    private String remarkA;

    @ExcelProperty("预留字段1")
    private String remarkB;

    @ExcelProperty("预留字段1")
    private String remarkC;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getOriginPosition() {
        return originPosition;
    }

    public void setOriginPosition(String originPosition) {
        this.originPosition = originPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBeginPayTime() {
        return beginPayTime;
    }

    public void setBeginPayTime(String beginPayTime) {
        this.beginPayTime = beginPayTime;
    }

    public String getPhoneSubsidyBefore() {
        return phoneSubsidyBefore;
    }

    public void setPhoneSubsidyBefore(String phoneSubsidyBefore) {
        this.phoneSubsidyBefore = phoneSubsidyBefore;
    }

    public String getSpecialPositionSubsidyBefore() {
        return specialPositionSubsidyBefore;
    }

    public void setSpecialPositionSubsidyBefore(String specialPositionSubsidyBefore) {
        this.specialPositionSubsidyBefore = specialPositionSubsidyBefore;
    }

    public String getRentSubsidyBefore() {
        return rentSubsidyBefore;
    }

    public void setRentSubsidyBefore(String rentSubsidyBefore) {
        this.rentSubsidyBefore = rentSubsidyBefore;
    }

    public String getShuttleSubsidyBefore() {
        return shuttleSubsidyBefore;
    }

    public void setShuttleSubsidyBefore(String shuttleSubsidyBefore) {
        this.shuttleSubsidyBefore = shuttleSubsidyBefore;
    }

    public String getHousingSubsidyBefore() {
        return housingSubsidyBefore;
    }

    public void setHousingSubsidyBefore(String housingSubsidyBefore) {
        this.housingSubsidyBefore = housingSubsidyBefore;
    }

    public String getBusSubsidyBefore() {
        return busSubsidyBefore;
    }

    public void setBusSubsidyBefore(String busSubsidyBefore) {
        this.busSubsidyBefore = busSubsidyBefore;
    }

    public String getPropertySubsidyBefore() {
        return propertySubsidyBefore;
    }

    public void setPropertySubsidyBefore(String propertySubsidyBefore) {
        this.propertySubsidyBefore = propertySubsidyBefore;
    }

    public String getPhoneSubsidyAfter() {
        return phoneSubsidyAfter;
    }

    public void setPhoneSubsidyAfter(String phoneSubsidyAfter) {
        this.phoneSubsidyAfter = phoneSubsidyAfter;
    }

    public String getSpecialPositionSubsidyAfter() {
        return specialPositionSubsidyAfter;
    }

    public void setSpecialPositionSubsidyAfter(String specialPositionSubsidyAfter) {
        this.specialPositionSubsidyAfter = specialPositionSubsidyAfter;
    }

    public String getRentSubsidyAfter() {
        return rentSubsidyAfter;
    }

    public void setRentSubsidyAfter(String rentSubsidyAfter) {
        this.rentSubsidyAfter = rentSubsidyAfter;
    }

    public String getShuttleSubsidyAfter() {
        return shuttleSubsidyAfter;
    }

    public void setShuttleSubsidyAfter(String shuttleSubsidyAfter) {
        this.shuttleSubsidyAfter = shuttleSubsidyAfter;
    }

    public String getHousingSubsidyAfter() {
        return housingSubsidyAfter;
    }

    public void setHousingSubsidyAfter(String housingSubsidyAfter) {
        this.housingSubsidyAfter = housingSubsidyAfter;
    }

    public String getBusSubsidyAfter() {
        return busSubsidyAfter;
    }

    public void setBusSubsidyAfter(String busSubsidyAfter) {
        this.busSubsidyAfter = busSubsidyAfter;
    }

    public String getPropertySubsidyAfter() {
        return propertySubsidyAfter;
    }

    public void setPropertySubsidyAfter(String propertySubsidyAfter) {
        this.propertySubsidyAfter = propertySubsidyAfter;
    }

    public String getBackPayMonth() {
        return backPayMonth;
    }

    public void setBackPayMonth(String backPayMonth) {
        this.backPayMonth = backPayMonth;
    }

    public String getBackSubsidy() {
        return backSubsidy;
    }

    public void setBackSubsidy(String backSubsidy) {
        this.backSubsidy = backSubsidy;
    }

    public String getPhoneSubsidyDetail() {
        return phoneSubsidyDetail;
    }

    public void setPhoneSubsidyDetail(String phoneSubsidyDetail) {
        this.phoneSubsidyDetail = phoneSubsidyDetail;
    }

    public String getSpecialPositionSubsidyDetail() {
        return specialPositionSubsidyDetail;
    }

    public void setSpecialPositionSubsidyDetail(String specialPositionSubsidyDetail) {
        this.specialPositionSubsidyDetail = specialPositionSubsidyDetail;
    }

    public String getRentSubsidyDetail() {
        return rentSubsidyDetail;
    }

    public void setRentSubsidyDetail(String rentSubsidyDetail) {
        this.rentSubsidyDetail = rentSubsidyDetail;
    }

    public String getShuttleSubsidyDetail() {
        return shuttleSubsidyDetail;
    }

    public void setShuttleSubsidyDetail(String shuttleSubsidyDetail) {
        this.shuttleSubsidyDetail = shuttleSubsidyDetail;
    }

    public String getHousingSubsidyDetail() {
        return housingSubsidyDetail;
    }

    public void setHousingSubsidyDetail(String housingSubsidyDetail) {
        this.housingSubsidyDetail = housingSubsidyDetail;
    }

    public String getBusSubsidyDetail() {
        return busSubsidyDetail;
    }

    public void setBusSubsidyDetail(String busSubsidyDetail) {
        this.busSubsidyDetail = busSubsidyDetail;
    }

    public String getPropertySubsidyDetail() {
        return propertySubsidyDetail;
    }

    public void setPropertySubsidyDetail(String propertySubsidyDetail) {
        this.propertySubsidyDetail = propertySubsidyDetail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBackPay() {
        return backPay;
    }

    public void setBackPay(String backPay) {
        this.backPay = backPay;
    }

    public String getDeductedWages() {
        return deductedWages;
    }

    public void setDeductedWages(String deductedWages) {
        this.deductedWages = deductedWages;
    }

    public String getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(String grossPay) {
        this.grossPay = grossPay;
    }

    public String getNetPay() {
        return netPay;
    }

    public void setNetPay(String netPay) {
        this.netPay = netPay;
    }

    public String getRemarkA() {
        return remarkA;
    }

    public void setRemarkA(String remarkA) {
        this.remarkA = remarkA;
    }

    public String getRemarkB() {
        return remarkB;
    }

    public void setRemarkB(String remarkB) {
        this.remarkB = remarkB;
    }

    public String getRemarkC() {
        return remarkC;
    }

    public void setRemarkC(String remarkC) {
        this.remarkC = remarkC;
    }

    @Override
    public String toString() {
        return "NetPay{" +
                "year=" + year +
                ", month=" + month +
                ", staffCode='" + staffCode + '\'' +
                ", totalNum='" + totalNum + '\'' +
                ", num='" + num + '\'' +
                ", deptName='" + deptName + '\'' +
                ", company='" + company + '\'' +
                ", staffName='" + staffName + '\'' +
                ", originPosition='" + originPosition + '\'' +
                ", position='" + position + '\'' +
                ", beginPayTime='" + beginPayTime + '\'' +
                ", phoneSubsidyBefore='" + phoneSubsidyBefore + '\'' +
                ", specialPositionSubsidyBefore='" + specialPositionSubsidyBefore + '\'' +
                ", rentSubsidyBefore='" + rentSubsidyBefore + '\'' +
                ", shuttleSubsidyBefore='" + shuttleSubsidyBefore + '\'' +
                ", housingSubsidyBefore='" + housingSubsidyBefore + '\'' +
                ", busSubsidyBefore='" + busSubsidyBefore + '\'' +
                ", propertySubsidyBefore='" + propertySubsidyBefore + '\'' +
                ", phoneSubsidyAfter='" + phoneSubsidyAfter + '\'' +
                ", specialPositionSubsidyAfter='" + specialPositionSubsidyAfter + '\'' +
                ", rentSubsidyAfter='" + rentSubsidyAfter + '\'' +
                ", shuttleSubsidyAfter='" + shuttleSubsidyAfter + '\'' +
                ", housingSubsidyAfter='" + housingSubsidyAfter + '\'' +
                ", busSubsidyAfter='" + busSubsidyAfter + '\'' +
                ", propertySubsidyAfter='" + propertySubsidyAfter + '\'' +
                ", backPayMonth='" + backPayMonth + '\'' +
                ", backSubsidy='" + backSubsidy + '\'' +
                ", phoneSubsidyDetail='" + phoneSubsidyDetail + '\'' +
                ", specialPositionSubsidyDetail='" + specialPositionSubsidyDetail + '\'' +
                ", rentSubsidyDetail='" + rentSubsidyDetail + '\'' +
                ", shuttleSubsidyDetail='" + shuttleSubsidyDetail + '\'' +
                ", housingSubsidyDetail='" + housingSubsidyDetail + '\'' +
                ", busSubsidyDetail='" + busSubsidyDetail + '\'' +
                ", propertySubsidyDetail='" + propertySubsidyDetail + '\'' +
                ", remark='" + remark + '\'' +
                ", backPay='" + backPay + '\'' +
                ", deductedWages='" + deductedWages + '\'' +
                ", grossPay='" + grossPay + '\'' +
                ", netPay='" + netPay + '\'' +
                ", remarkA='" + remarkA + '\'' +
                ", remarkB='" + remarkB + '\'' +
                ", remarkC='" + remarkC + '\'' +
                '}';
    }
}
