package com.example.salary.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class HikariCPConfig {
    private static final String URL = "jdbc:mysql://120.53.236.189:3306/salary";
    private static final String USER = "luowen";
    private static final String PASSWORD = "luo123!@#";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setDriverClassName(DRIVER_CLASS);
        config.setMaximumPoolSize(10); // 设置最大连接数
        config.setIdleTimeout(30000); // 设置空闲连接超时时间
        config.setConnectionTimeout(30000); // 设置连接获取超时时间
        config.setLeakDetectionThreshold(60000); // 设置连接泄露检测阈值

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
