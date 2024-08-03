package com.example.salary.dao;

import com.example.salary.db.HikariCPConfig;
import com.example.salary.model.GrossPay;
import com.example.salary.util.AesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GrossPayDAO {


    private final static String COLUMNS =
            "staffCode, " +
                    "companyCode, " +
                    "companyName, " +
                    "staffName," +
                    "idNumber, " +
                    "basePay, " +
                    "position, " +
                    "payLevel, " +
                    "levelPay, " +
                    "remarkA, " +
                    "remarkB, " +
                    "subsidyTag, " +
                    "workSubsidy, " +
                    "liveSubsidy, " +
                    "workAdjustSubsidy, " +
                    "governmentSubsidy, " +
                    "phoneSubsidy, " +
                    "nannySubsidy, " +
                    "onlyChildSubsidy, " +
                    "babySubsidy, " +
                    "visitsSubsidy, " +
                    "minorityNationalitySubsidy, " +
                    "remarkC, " +
                    "remarkD, " +
                    "remarkE, " +
                    "totalGrossPay, " +
                    "subsidyPay, " +
                    "totalDeductions, " +
                    "housingProvidentFund, " +
                    "individualIncomeTax, " +
                    "pensionInsurance, " +
                    "annuity, " +
                    "adjustedPay, " +
                    "totalNetPay, " +
                    "year, " +
                    "month, " +
                    "positionPay";

    private void builderGrossPay(PreparedStatement prepareStatement, List<GrossPay> grossPayList) throws SQLException {

        for (GrossPay grossPay : grossPayList) {
            prepareStatement.setString(1, grossPay.getStaffCode());
            prepareStatement.setString(2, AesUtil.encrypt(grossPay.getCompanyCode()));
            prepareStatement.setString(3, AesUtil.encrypt(grossPay.getCompanyName()));
            prepareStatement.setString(4, AesUtil.encrypt(grossPay.getStaffName()));
            prepareStatement.setString(5, AesUtil.encrypt(grossPay.getIdNumber()));
            prepareStatement.setString(6, AesUtil.encrypt(grossPay.getBasePay()));
            prepareStatement.setString(7, AesUtil.encrypt(grossPay.getPosition()));
            prepareStatement.setString(8, AesUtil.encrypt(grossPay.getPayLevel()));
            prepareStatement.setString(9, AesUtil.encrypt(grossPay.getLevelPay()));
            prepareStatement.setString(10, AesUtil.encrypt(grossPay.getRemarkA()));
            prepareStatement.setString(11, AesUtil.encrypt(grossPay.getRemarkB()));
            prepareStatement.setString(12, AesUtil.encrypt(grossPay.getSubsidyTag()));
            prepareStatement.setString(13, AesUtil.encrypt(grossPay.getWorkSubsidy()));
            prepareStatement.setString(14, AesUtil.encrypt(grossPay.getLiveSubsidy()));
            prepareStatement.setString(15, AesUtil.encrypt(grossPay.getWorkAdjustSubsidy()));
            prepareStatement.setString(16, AesUtil.encrypt(grossPay.getGovernmentSubsidy()));
            prepareStatement.setString(17, AesUtil.encrypt(grossPay.getPhoneSubsidy()));
            prepareStatement.setString(18, AesUtil.encrypt(grossPay.getNannySubsidy()));
            prepareStatement.setString(19, AesUtil.encrypt(grossPay.getOnlyChildSubsidy()));
            prepareStatement.setString(20, AesUtil.encrypt(grossPay.getBabySubsidy()));
            prepareStatement.setString(21, AesUtil.encrypt(grossPay.getVisitsSubsidy()));
            prepareStatement.setString(22, AesUtil.encrypt(grossPay.getMinorityNationalitySubsidy()));
            prepareStatement.setString(23, AesUtil.encrypt(grossPay.getRemarkC()));
            prepareStatement.setString(24, AesUtil.encrypt(grossPay.getRemarkD()));
            prepareStatement.setString(25, AesUtil.encrypt(grossPay.getRemarkE()));
            prepareStatement.setString(26, AesUtil.encrypt(grossPay.getTotalGrossPay()));
            prepareStatement.setString(27, AesUtil.encrypt(grossPay.getSubsidyPay()));
            prepareStatement.setString(28, AesUtil.encrypt(grossPay.getTotalDeductions()));
            prepareStatement.setString(29, AesUtil.encrypt(grossPay.getHousingProvidentFund()));
            prepareStatement.setString(30, AesUtil.encrypt(grossPay.getIndividualIncomeTax()));
            prepareStatement.setString(31, AesUtil.encrypt(grossPay.getPensionInsurance()));
            prepareStatement.setString(32, AesUtil.encrypt(grossPay.getAnnuity()));
            prepareStatement.setString(33, AesUtil.encrypt(grossPay.getAdjustedPay()));
            prepareStatement.setString(34, AesUtil.encrypt(grossPay.getTotalNetPay()));
            prepareStatement.setInt(35, grossPay.getYear());
            prepareStatement.setInt(36, grossPay.getMonth());
            prepareStatement.setString(37, AesUtil.encrypt(grossPay.getPositionPay()));
            prepareStatement.addBatch();
        }
    }

    public void insert(List<GrossPay> grossPayList) {


        String INSERT_SQL = " INSERT INTO gross_pay (" +
                COLUMNS + ")" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";


        // 建立数据库连接
        try (Connection conn = HikariCPConfig.getDataSource().getConnection()) {
            // 关闭自动提交模式
            conn.setAutoCommit(false);

            // 创建SQL插入语句
            try (PreparedStatement prepareStatement = conn.prepareStatement(INSERT_SQL)) {
                // 设置参数
                builderGrossPay(prepareStatement, grossPayList);
                // 执行插入操作
                int[] affectedRows = prepareStatement.executeBatch();
                if (affectedRows.length > 0) {
                    System.out.println("插入成功，影响了 " + affectedRows.length + " 行。");
                    // 手动提交事务
                    conn.commit();
                } else {
                    System.out.println("插入失败。");
                    // 如果插入失败，可以选择回滚事务
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // 如果发生异常，可以选择回滚事务
                try {
                    if (conn != null) {
                        conn.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    // 关闭数据库连接
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public GrossPay selectByStaff(String staffCode, int year, int month) {
        String SELECT_SQL = " SELECT " + COLUMNS + " FROM gross_pay  WHERE  staffCode =? and year =? and month =? order by create_time desc limit 1 ";

        ResultSet rs = null;
        GrossPay grossPay = null;
        // 建立数据库连接
        try (Connection conn = HikariCPConfig.getDataSource().getConnection()) {
            // 关闭自动提交模式
//            conn.setAutoCommit(false);

            // 创建SQL插入语句
            try (PreparedStatement prepareStatement = conn.prepareStatement(SELECT_SQL)) {

                // 设置参数
                prepareStatement.setString(1, staffCode);
                prepareStatement.setInt(2, year);
                prepareStatement.setInt(3, month);

                rs = prepareStatement.executeQuery();
                while (rs.next()) {
                    grossPay = buildGrossPay(rs);
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }

        return grossPay;
    }

    private GrossPay buildGrossPay(ResultSet resultSet) throws SQLException {
        GrossPay grossPay = new GrossPay();

        grossPay.setStaffCode(resultSet.getString("staffCode"));
        grossPay.setCompanyCode(AesUtil.decrypt(resultSet.getString("companyCode")));
        grossPay.setCompanyName(AesUtil.decrypt(resultSet.getString("companyName")));
        grossPay.setStaffName(AesUtil.decrypt(resultSet.getString("staffName")));
        grossPay.setIdNumber(AesUtil.decrypt(resultSet.getString("idNumber")));
        grossPay.setBasePay(AesUtil.decrypt(resultSet.getString("basePay")));
        grossPay.setPosition(AesUtil.decrypt(resultSet.getString("position")));
        grossPay.setPayLevel(AesUtil.decrypt(resultSet.getString("payLevel")));
        grossPay.setLevelPay(AesUtil.decrypt(resultSet.getString("levelPay")));
        grossPay.setRemarkA(AesUtil.decrypt(resultSet.getString("remarkA")));
        grossPay.setRemarkB(AesUtil.decrypt(resultSet.getString("remarkB")));
        grossPay.setSubsidyTag(AesUtil.decrypt(resultSet.getString("subsidyTag")));
        grossPay.setWorkSubsidy(AesUtil.decrypt(resultSet.getString("workSubsidy")));
        grossPay.setLiveSubsidy(AesUtil.decrypt(resultSet.getString("liveSubsidy")));
        grossPay.setWorkAdjustSubsidy(AesUtil.decrypt(resultSet.getString("workAdjustSubsidy")));
        grossPay.setGovernmentSubsidy(AesUtil.decrypt(resultSet.getString("governmentSubsidy")));
        grossPay.setPhoneSubsidy(AesUtil.decrypt(resultSet.getString("phoneSubsidy")));
        grossPay.setNannySubsidy(AesUtil.decrypt(resultSet.getString("nannySubsidy")));
        grossPay.setOnlyChildSubsidy(AesUtil.decrypt(resultSet.getString("onlyChildSubsidy")));
        grossPay.setBabySubsidy(AesUtil.decrypt(resultSet.getString("babySubsidy")));
        grossPay.setVisitsSubsidy(AesUtil.decrypt(resultSet.getString("visitsSubsidy")));
        grossPay.setMinorityNationalitySubsidy(AesUtil.decrypt(resultSet.getString("minorityNationalitySubsidy")));
        grossPay.setRemarkC(AesUtil.decrypt(resultSet.getString("remarkC")));
        grossPay.setRemarkD(AesUtil.decrypt(resultSet.getString("remarkD")));
        grossPay.setRemarkE(AesUtil.decrypt(resultSet.getString("remarkE")));
        grossPay.setTotalGrossPay(AesUtil.decrypt(resultSet.getString("totalGrossPay")));
        grossPay.setSubsidyPay(AesUtil.decrypt(resultSet.getString("subsidyPay")));
        grossPay.setTotalDeductions(AesUtil.decrypt(resultSet.getString("totalDeductions")));
        grossPay.setHousingProvidentFund(AesUtil.decrypt(resultSet.getString("housingProvidentFund")));
        grossPay.setIndividualIncomeTax(AesUtil.decrypt(resultSet.getString("individualIncomeTax")));
        grossPay.setPensionInsurance(AesUtil.decrypt(resultSet.getString("pensionInsurance")));
        grossPay.setAnnuity(AesUtil.decrypt(resultSet.getString("annuity")));
        grossPay.setAdjustedPay(AesUtil.decrypt(resultSet.getString("adjustedPay")));
        grossPay.setTotalNetPay(AesUtil.decrypt(resultSet.getString("totalNetPay")));
        grossPay.setYear(resultSet.getInt("year"));
        grossPay.setMonth(resultSet.getInt("month"));
        grossPay.setPositionPay(AesUtil.decrypt(resultSet.getString("positionPay")));


        return grossPay;
    }

}
