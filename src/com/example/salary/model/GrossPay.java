package com.example.salary.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class GrossPay {

    @ExcelIgnore
    private Integer year;
    @ExcelIgnore
    private Integer month;

    /**
     * 唯一标识
     */
    @ExcelProperty(value = "唯一标识")
    private String staffCode;
    /**
     * 单位编码
     */
    @ExcelProperty(value = "单位编码")
    private String companyCode;


    /**
     * 单位名称
     */
    @ExcelProperty(value = "单位名称")
    private String companyName;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String staffName;


    /**
     * 身份证号
     */
    @ExcelProperty(value = "身份证号")
    private String idNumber;

    /**
     * 基本工资
     */
    @ExcelProperty(value = "基本工资")
    private String basePay;

    /**
     * 职务（职级\技术等级）
     */
    @ExcelProperty(value = "职务（职级技术等级）")
    private String position;

    /**
     * 职务（职级技术等级）工资
     */
    @ExcelProperty(value = "职务（职级技术等级）工资")
    private String positionPay;


    /**
     * 工资级别（岗位）
     */
    @ExcelProperty(value = "工资级别（岗位）")
    private String payLevel;

    /**
     * 级别（岗位）工资
     */
    @ExcelProperty(value = "级别（岗位）工资")
    private String levelPay;


    /**
     * 保留字段1
     */
    @ExcelProperty(value = "保留字段1")
    private String remarkA;


    /**
     * 保留字段2
     */
    @ExcelProperty(value = "保留字段2")
    private String remarkB;


    /**
     * 津、补贴小记
     */
    @ExcelProperty(value = "津、补贴小记")
    private String subsidyTag;


    /**
     * 工作性津贴
     */
    @ExcelProperty(value = "工作性津贴")
    private String workSubsidy;


    /**
     * 生活性补贴
     */
    @ExcelProperty(value = "生活性补贴")
    private String liveSubsidy;


    /**
     * 工改保留补贴
     */
    @ExcelProperty(value = "工改保留补贴")
    private String workAdjustSubsidy;


    /**
     * 在京中央国家机关补贴
     */
    @ExcelProperty(value = "在京中央国家机关补贴")
    private String governmentSubsidy;


    /**
     * 住宅公务电话包干费
     */
    @ExcelProperty(value = "住宅公务电话包干费")
    private String phoneSubsidy;


    /**
     * 高级干部保姆自雇费
     */
    @ExcelProperty(value = "高级干部保姆自雇费")
    private String nannySubsidy;


    /**
     * 独生子女奖励
     */
    @ExcelProperty(value = "独生子女奖励")
    private String onlyChildSubsidy;


    /**
     * 婴幼儿补贴
     */
    @ExcelProperty(value = "婴幼儿补贴")
    private String babySubsidy;


    /**
     * 信访岗位津贴
     */
    @ExcelProperty(value = "信访岗位津贴")
    private String visitsSubsidy;


    /**
     * 少数民族津贴
     */
    @ExcelProperty(value = "少数民族津贴")
    private String minorityNationalitySubsidy;


    /**
     * 保留字段1
     */
    @ExcelProperty(value = "保留字段3")
    private String remarkC;


    /**
     * 保留字段2
     */
    @ExcelProperty(value = "保留字段4")
    private String remarkD;


    /**
     * 保留字段3
     */
    @ExcelProperty(value = "保留字段5")
    private String remarkE;


    /**
     * 应发合计
     */
    @ExcelProperty(value = "应发合计")
    private String totalGrossPay;


    /**
     * 补发工资
     */
    @ExcelProperty(value = "补发工资")
    private String subsidyPay;


    /**
     * 代扣合计
     */
    @ExcelProperty(value = "代扣合计")
    private String totalDeductions;


    /**
     * 住房公积金
     */
    @ExcelProperty(value = "住房公积金")
    private String housingProvidentFund;


    /**
     * 个人所得税
     */
    @ExcelProperty(value = "个人所得税")
    private String individualIncomeTax;


    /**
     * 基本养老保险个人缴费
     */
    @ExcelProperty(value = "基本养老保险个人缴费")
    private String pensionInsurance;


    /**
     * 职业年金个人缴费
     */
    @ExcelProperty(value = "职业年金个人缴费")
    private String annuity;


    /**
     * 补扣工资
     */
    @ExcelProperty(value = "补扣工资")
    private String adjustedPay;

    /**
     * 实发合计
     */
    @ExcelProperty(value = "实发合计")
    private String totalNetPay;

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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getBasePay() {
        return basePay;
    }

    public void setBasePay(String basePay) {
        this.basePay = basePay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionPay() {
        return positionPay;
    }

    public void setPositionPay(String positionPay) {
        this.positionPay = positionPay;
    }

    public String getPayLevel() {
        return payLevel;
    }

    public void setPayLevel(String payLevel) {
        this.payLevel = payLevel;
    }

    public String getLevelPay() {
        return levelPay;
    }

    public void setLevelPay(String levelPay) {
        this.levelPay = levelPay;
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

    public String getSubsidyTag() {
        return subsidyTag;
    }

    public void setSubsidyTag(String subsidyTag) {
        this.subsidyTag = subsidyTag;
    }

    public String getWorkSubsidy() {
        return workSubsidy;
    }

    public void setWorkSubsidy(String workSubsidy) {
        this.workSubsidy = workSubsidy;
    }

    public String getLiveSubsidy() {
        return liveSubsidy;
    }

    public void setLiveSubsidy(String liveSubsidy) {
        this.liveSubsidy = liveSubsidy;
    }

    public String getWorkAdjustSubsidy() {
        return workAdjustSubsidy;
    }

    public void setWorkAdjustSubsidy(String workAdjustSubsidy) {
        this.workAdjustSubsidy = workAdjustSubsidy;
    }

    public String getGovernmentSubsidy() {
        return governmentSubsidy;
    }

    public void setGovernmentSubsidy(String governmentSubsidy) {
        this.governmentSubsidy = governmentSubsidy;
    }

    public String getPhoneSubsidy() {
        return phoneSubsidy;
    }

    public void setPhoneSubsidy(String phoneSubsidy) {
        this.phoneSubsidy = phoneSubsidy;
    }

    public String getNannySubsidy() {
        return nannySubsidy;
    }

    public void setNannySubsidy(String nannySubsidy) {
        this.nannySubsidy = nannySubsidy;
    }

    public String getOnlyChildSubsidy() {
        return onlyChildSubsidy;
    }

    public void setOnlyChildSubsidy(String onlyChildSubsidy) {
        this.onlyChildSubsidy = onlyChildSubsidy;
    }

    public String getBabySubsidy() {
        return babySubsidy;
    }

    public void setBabySubsidy(String babySubsidy) {
        this.babySubsidy = babySubsidy;
    }

    public String getVisitsSubsidy() {
        return visitsSubsidy;
    }

    public void setVisitsSubsidy(String visitsSubsidy) {
        this.visitsSubsidy = visitsSubsidy;
    }

    public String getMinorityNationalitySubsidy() {
        return minorityNationalitySubsidy;
    }

    public void setMinorityNationalitySubsidy(String minorityNationalitySubsidy) {
        this.minorityNationalitySubsidy = minorityNationalitySubsidy;
    }

    public String getRemarkC() {
        return remarkC;
    }

    public void setRemarkC(String remarkC) {
        this.remarkC = remarkC;
    }

    public String getRemarkD() {
        return remarkD;
    }

    public void setRemarkD(String remarkD) {
        this.remarkD = remarkD;
    }

    public String getRemarkE() {
        return remarkE;
    }

    public void setRemarkE(String remarkE) {
        this.remarkE = remarkE;
    }

    public String getTotalGrossPay() {
        return totalGrossPay;
    }

    public void setTotalGrossPay(String totalGrossPay) {
        this.totalGrossPay = totalGrossPay;
    }

    public String getSubsidyPay() {
        return subsidyPay;
    }

    public void setSubsidyPay(String subsidyPay) {
        this.subsidyPay = subsidyPay;
    }

    public String getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(String totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public String getHousingProvidentFund() {
        return housingProvidentFund;
    }

    public void setHousingProvidentFund(String housingProvidentFund) {
        this.housingProvidentFund = housingProvidentFund;
    }

    public String getIndividualIncomeTax() {
        return individualIncomeTax;
    }

    public void setIndividualIncomeTax(String individualIncomeTax) {
        this.individualIncomeTax = individualIncomeTax;
    }

    public String getPensionInsurance() {
        return pensionInsurance;
    }

    public void setPensionInsurance(String pensionInsurance) {
        this.pensionInsurance = pensionInsurance;
    }

    public String getAnnuity() {
        return annuity;
    }

    public void setAnnuity(String annuity) {
        this.annuity = annuity;
    }

    public String getAdjustedPay() {
        return adjustedPay;
    }

    public void setAdjustedPay(String adjustedPay) {
        this.adjustedPay = adjustedPay;
    }

    public String getTotalNetPay() {
        return totalNetPay;
    }

    public void setTotalNetPay(String totalNetPay) {
        this.totalNetPay = totalNetPay;
    }

    @Override
    public String toString() {
        return "GrossPay{" +
                "year=" + year +
                ", month=" + month +
                ", staffCode='" + staffCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", basePay='" + basePay + '\'' +
                ", position='" + position + '\'' +
                ", positionPay='" + positionPay + '\'' +
                ", payLevel='" + payLevel + '\'' +
                ", levelPay='" + levelPay + '\'' +
                ", remarkA='" + remarkA + '\'' +
                ", remarkB='" + remarkB + '\'' +
                ", subsidyTag='" + subsidyTag + '\'' +
                ", workSubsidy='" + workSubsidy + '\'' +
                ", liveSubsidy='" + liveSubsidy + '\'' +
                ", workAdjustSubsidy='" + workAdjustSubsidy + '\'' +
                ", governmentSubsidy='" + governmentSubsidy + '\'' +
                ", phoneSubsidy='" + phoneSubsidy + '\'' +
                ", nannySubsidy='" + nannySubsidy + '\'' +
                ", onlyChildSubsidy='" + onlyChildSubsidy + '\'' +
                ", babySubsidy='" + babySubsidy + '\'' +
                ", visitsSubsidy='" + visitsSubsidy + '\'' +
                ", minorityNationalitySubsidy='" + minorityNationalitySubsidy + '\'' +
                ", remarkC='" + remarkC + '\'' +
                ", remarkD='" + remarkD + '\'' +
                ", remarkE='" + remarkE + '\'' +
                ", totalGrossPay='" + totalGrossPay + '\'' +
                ", subsidyPay='" + subsidyPay + '\'' +
                ", totalDeductions='" + totalDeductions + '\'' +
                ", housingProvidentFund='" + housingProvidentFund + '\'' +
                ", individualIncomeTax='" + individualIncomeTax + '\'' +
                ", pensionInsurance='" + pensionInsurance + '\'' +
                ", annuity='" + annuity + '\'' +
                ", adjustedPay='" + adjustedPay + '\'' +
                ", totalNetPay='" + totalNetPay + '\'' +
                '}';
    }
}
