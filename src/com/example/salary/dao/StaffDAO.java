package com.example.salary.dao;

import com.example.salary.db.HikariCPConfig;
import com.example.salary.model.Staff;
import com.example.salary.util.AesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO {

    private final static String COLUMNS = "id, staffCode, password, remark";


    public void insert(Staff staff) {

        String INSERT_SQL = " INSERT INTO staff  ( staffCode, password, remark ) VALUES (?,?,?)";


        // 建立数据库连接
        try (Connection conn = HikariCPConfig.getDataSource().getConnection()) {
            // 关闭自动提交模式
            conn.setAutoCommit(false);

            // 创建SQL插入语句
            try (PreparedStatement prepareStatement = conn.prepareStatement(INSERT_SQL)) {
                // 设置参数
                prepareStatement.setString(1, staff.getStaffCode());
                prepareStatement.setString(2, AesUtil.encrypt(staff.getPassword()));
                prepareStatement.setString(3, "手动录入");

                // 执行插入操作
                int affectedRows = prepareStatement.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("插入成功，影响了 " + affectedRows + " 行。");
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

    public void update(Staff staff) {

        String INSERT_SQL = " UPDATE  staff  SET password = ? where id = ? ";


        // 建立数据库连接
        try (Connection conn = HikariCPConfig.getDataSource().getConnection()) {
            // 关闭自动提交模式
            conn.setAutoCommit(false);

            // 创建SQL插入语句
            try (PreparedStatement prepareStatement = conn.prepareStatement(INSERT_SQL)) {
                // 设置参数
                prepareStatement.setString(1, AesUtil.encrypt(staff.getPassword()));
                prepareStatement.setLong(2, staff.getId());

                // 执行插入操作
                int affectedRows = prepareStatement.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("影响了 " + affectedRows + " 行。");
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

    public Staff selectByStaff(String staffCode) {
        String SELECT_SQL = " SELECT " + COLUMNS + " FROM staff  WHERE  staffCode =?  order by create_time desc limit 1 ";

        ResultSet rs = null;
        Staff staff = null;
        try (Connection conn = HikariCPConfig.getDataSource().getConnection()) {
            try (PreparedStatement prepareStatement = conn.prepareStatement(SELECT_SQL)) {

                // 设置参数
                prepareStatement.setString(1, staffCode);

                rs = prepareStatement.executeQuery();
                while (rs.next()) {
                    staff = new Staff();
                    staff.setId(rs.getLong("id"));
                    staff.setStaffCode(rs.getString("staffCode"));
                    staff.setPassword(AesUtil.decrypt(rs.getString("password")));
                    staff.setRemark(rs.getString("remark"));
                }
                rs.close();
                return staff;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }

        return null;
    }


}
