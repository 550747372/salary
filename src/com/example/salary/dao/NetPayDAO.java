package com.example.salary.dao;

import com.example.salary.db.HikariCPConfig;
import com.example.salary.model.NetPay;
import com.example.salary.util.AesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NetPayDAO {

    private final static String COLUMNS =
            " staffCode                   ," +
                    " totalNum                    ," +
                    " num                         ," +
                    " deptName                    ," +
                    " company                     ," +
                    " staffName                   ," +
                    " originPosition              ," +
                    " position                    ," +
                    " beginPayTime                ," +
                    " phoneSubsidyBefore          ," +
                    " specialPositionSubsidyBefore," +
                    " rentSubsidyBefore           ," +
                    " shuttleSubsidyBefore        ," +
                    " housingSubsidyBefore        ," +
                    " busSubsidyBefore            ," +
                    " propertySubsidyBefore       ," +
                    " phoneSubsidyAfter           ," +
                    " specialPositionSubsidyAfter ," +
                    " rentSubsidyAfter            ," +
                    " shuttleSubsidyAfter         ," +
                    " housingSubsidyAfter         ," +
                    " busSubsidyAfter             ," +
                    " propertySubsidyAfter        ," +
                    " backPayMonth                ," +
                    " backSubsidy                 ," +
                    " phoneSubsidyDetail          ," +
                    " specialPositionSubsidyDetail," +
                    " rentSubsidyDetail           ," +
                    " shuttleSubsidyDetail        ," +
                    " housingSubsidyDetail        ," +
                    " busSubsidyDetail            ," +
                    " propertySubsidyDetail       ," +
                    " remark                      ," +
                    " backPay                     ," +
                    " deductedWages               ," +
                    " grossPay                    ," +
                    " remarkA                     ," +
                    " remarkB                     ," +
                    " remarkC                     ," +
                    " year                        ," +
                    " month                       ," +
                    " netPay                       ";

    private void builderNetPay(PreparedStatement prepareStatement, List<NetPay> netPayList) throws SQLException {

        for (NetPay netPay : netPayList) {
            prepareStatement.setString(1, netPay.getStaffCode());
            prepareStatement.setString(2, AesUtil.encrypt(netPay.getTotalNum()));
            prepareStatement.setString(3, AesUtil.encrypt(netPay.getNum()));
            prepareStatement.setString(4, AesUtil.encrypt(netPay.getDeptName()));
            prepareStatement.setString(5, AesUtil.encrypt(netPay.getCompany()));
            prepareStatement.setString(6, AesUtil.encrypt(netPay.getStaffName()));
            prepareStatement.setString(7, AesUtil.encrypt(netPay.getOriginPosition()));
            prepareStatement.setString(8, AesUtil.encrypt(netPay.getPosition()));
            prepareStatement.setString(9, AesUtil.encrypt(netPay.getBeginPayTime()));
            prepareStatement.setString(10, AesUtil.encrypt(netPay.getPhoneSubsidyBefore()));
            prepareStatement.setString(11, AesUtil.encrypt(netPay.getSpecialPositionSubsidyBefore()));
            prepareStatement.setString(12, AesUtil.encrypt(netPay.getRentSubsidyBefore()));
            prepareStatement.setString(13, AesUtil.encrypt(netPay.getShuttleSubsidyBefore()));
            prepareStatement.setString(14, AesUtil.encrypt(netPay.getHousingSubsidyBefore()));
            prepareStatement.setString(15, AesUtil.encrypt(netPay.getBusSubsidyBefore()));
            prepareStatement.setString(16, AesUtil.encrypt(netPay.getPropertySubsidyBefore()));
            prepareStatement.setString(17, AesUtil.encrypt(netPay.getPhoneSubsidyAfter()));
            prepareStatement.setString(18, AesUtil.encrypt(netPay.getSpecialPositionSubsidyAfter()));
            prepareStatement.setString(19, AesUtil.encrypt(netPay.getRentSubsidyAfter()));
            prepareStatement.setString(20, AesUtil.encrypt(netPay.getShuttleSubsidyAfter()));
            prepareStatement.setString(21, AesUtil.encrypt(netPay.getHousingSubsidyAfter()));
            prepareStatement.setString(22, AesUtil.encrypt(netPay.getBusSubsidyAfter()));
            prepareStatement.setString(23, AesUtil.encrypt(netPay.getPropertySubsidyAfter()));
            prepareStatement.setString(24, AesUtil.encrypt(netPay.getBackPayMonth()));
            prepareStatement.setString(25, AesUtil.encrypt(netPay.getBackSubsidy()));
            prepareStatement.setString(26, AesUtil.encrypt(netPay.getPhoneSubsidyDetail()));
            prepareStatement.setString(27, AesUtil.encrypt(netPay.getSpecialPositionSubsidyDetail()));
            prepareStatement.setString(28, AesUtil.encrypt(netPay.getRentSubsidyDetail()));
            prepareStatement.setString(29, AesUtil.encrypt(netPay.getShuttleSubsidyDetail()));
            prepareStatement.setString(30, AesUtil.encrypt(netPay.getHousingSubsidyDetail()));
            prepareStatement.setString(31, AesUtil.encrypt(netPay.getBusSubsidyDetail()));
            prepareStatement.setString(32, AesUtil.encrypt(netPay.getPropertySubsidyDetail()));
            prepareStatement.setString(33, AesUtil.encrypt(netPay.getRemark()));
            prepareStatement.setString(34, AesUtil.encrypt(netPay.getBackPay()));
            prepareStatement.setString(35, AesUtil.encrypt(netPay.getDeductedWages()));
            prepareStatement.setString(36, AesUtil.encrypt(netPay.getGrossPay()));
            prepareStatement.setString(37, AesUtil.encrypt(netPay.getRemarkA()));
            prepareStatement.setString(38, AesUtil.encrypt(netPay.getRemarkB()));
            prepareStatement.setString(39, AesUtil.encrypt(netPay.getRemarkC()));

            prepareStatement.setInt(40, netPay.getYear());
            prepareStatement.setInt(41, netPay.getMonth());
            prepareStatement.setString(42, AesUtil.encrypt(netPay.getNetPay()));


            prepareStatement.addBatch();
        }
    }

    public void insert(List<NetPay> netPayList) {

        String INSERT_SQL = " INSERT INTO net_pay (" + COLUMNS + " ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        // 建立数据库连接
        try (Connection conn = HikariCPConfig.getDataSource().getConnection()) {
            // 关闭自动提交模式
            conn.setAutoCommit(false);

            // 创建SQL插入语句
            try (PreparedStatement prepareStatement = conn.prepareStatement(INSERT_SQL)) {
                // 设置参数
                builderNetPay(prepareStatement, netPayList);
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

    public NetPay selectByStaff(String staffCode, int year, int month) {
        String SELECT_SQL = " SELECT " + COLUMNS + " FROM net_pay  WHERE  staffCode =? and year =? and month =? order by create_time desc limit 1 ";

        ResultSet rs = null;
        NetPay netPay = null;
        // 建立数据库连接
        try (Connection conn = HikariCPConfig.getDataSource().getConnection()) {

            // 创建SQL插入语句
            try (PreparedStatement prepareStatement = conn.prepareStatement(SELECT_SQL)) {

                // 设置参数
                prepareStatement.setString(1, staffCode);
                prepareStatement.setInt(2, year);
                prepareStatement.setInt(3, month);

                rs = prepareStatement.executeQuery();
                while (rs.next()) {
                    netPay = buildGrossPay(rs);
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }

        return netPay;
    }

    private NetPay buildGrossPay(ResultSet resultSet) throws SQLException {
        NetPay netPay = new NetPay();

        netPay.setStaffCode(resultSet.getString("staffCode"));
        netPay.setTotalNum(AesUtil.decrypt(resultSet.getString("totalNum")));
        netPay.setNum(AesUtil.decrypt(resultSet.getString("num")));
        netPay.setDeptName(AesUtil.decrypt(resultSet.getString("deptName")));
        netPay.setCompany(AesUtil.decrypt(resultSet.getString("company")));
        netPay.setStaffName(AesUtil.decrypt(resultSet.getString("staffName")));
        netPay.setOriginPosition(AesUtil.decrypt(resultSet.getString("originPosition")));
        netPay.setPosition(AesUtil.decrypt(resultSet.getString("position")));
        netPay.setBeginPayTime(AesUtil.decrypt(resultSet.getString("beginPayTime")));
        netPay.setPhoneSubsidyBefore(AesUtil.decrypt(resultSet.getString("phoneSubsidyBefore")));
        netPay.setSpecialPositionSubsidyBefore(AesUtil.decrypt(resultSet.getString("specialPositionSubsidyBefore")));
        netPay.setRentSubsidyBefore(AesUtil.decrypt(resultSet.getString("rentSubsidyBefore")));
        netPay.setShuttleSubsidyBefore(AesUtil.decrypt(resultSet.getString("shuttleSubsidyBefore")));
        netPay.setHousingSubsidyBefore(AesUtil.decrypt(resultSet.getString("housingSubsidyBefore")));
        netPay.setBusSubsidyBefore(AesUtil.decrypt(resultSet.getString("busSubsidyBefore")));
        netPay.setPropertySubsidyBefore(AesUtil.decrypt(resultSet.getString("propertySubsidyBefore")));
        netPay.setPhoneSubsidyAfter(AesUtil.decrypt(resultSet.getString("phoneSubsidyAfter")));
        netPay.setSpecialPositionSubsidyAfter(AesUtil.decrypt(resultSet.getString("specialPositionSubsidyAfter")));
        netPay.setRentSubsidyAfter(AesUtil.decrypt(resultSet.getString("rentSubsidyAfter")));
        netPay.setShuttleSubsidyAfter(AesUtil.decrypt(resultSet.getString("shuttleSubsidyAfter")));
        netPay.setHousingSubsidyAfter(AesUtil.decrypt(resultSet.getString("housingSubsidyAfter")));
        netPay.setBusSubsidyAfter(AesUtil.decrypt(resultSet.getString("busSubsidyAfter")));
        netPay.setPropertySubsidyAfter(AesUtil.decrypt(resultSet.getString("propertySubsidyAfter")));
        netPay.setBackPayMonth(AesUtil.decrypt(resultSet.getString("backPayMonth")));
        netPay.setBackSubsidy(AesUtil.decrypt(resultSet.getString("backSubsidy")));
        netPay.setPhoneSubsidyDetail(AesUtil.decrypt(resultSet.getString("phoneSubsidyDetail")));
        netPay.setSpecialPositionSubsidyDetail(AesUtil.decrypt(resultSet.getString("specialPositionSubsidyDetail")));
        netPay.setRentSubsidyDetail(AesUtil.decrypt(resultSet.getString("rentSubsidyDetail")));
        netPay.setShuttleSubsidyDetail(AesUtil.decrypt(resultSet.getString("shuttleSubsidyDetail")));
        netPay.setHousingSubsidyDetail(AesUtil.decrypt(resultSet.getString("housingSubsidyDetail")));
        netPay.setBusSubsidyDetail(AesUtil.decrypt(resultSet.getString("busSubsidyDetail")));
        netPay.setPropertySubsidyDetail(AesUtil.decrypt(resultSet.getString("propertySubsidyDetail")));
        netPay.setRemark(AesUtil.decrypt(resultSet.getString("remark")));
        netPay.setBackPay(AesUtil.decrypt(resultSet.getString("backPay")));
        netPay.setDeductedWages(AesUtil.decrypt(resultSet.getString("deductedWages")));
        netPay.setGrossPay(AesUtil.decrypt(resultSet.getString("grossPay")));
        netPay.setRemarkA(AesUtil.decrypt(resultSet.getString("remarkA")));
        netPay.setRemarkB(AesUtil.decrypt(resultSet.getString("remarkB")));
        netPay.setRemarkC(AesUtil.decrypt(resultSet.getString("remarkC")));
        netPay.setYear(resultSet.getInt("month"));
        netPay.setMonth(resultSet.getInt("month"));
        netPay.setNetPay(AesUtil.decrypt(resultSet.getString("netPay")));


        return netPay;
    }

}
