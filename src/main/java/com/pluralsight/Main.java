package com.pluralsight;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import javax.sql.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (args.length != 2) {
            System.out.println(
                    "Application needs two arguments to run: " +
                            "java com.hca.jdbc.UsingDriverManager <username> " +
                            "<password>");
            System.exit(1);
        }
// Get the username and password
        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");

        dataSource.setUsername(username);
        dataSource.setPassword(password);

        NorthwindDataManager dataManager =
                new NorthwindDataManager(dataSource);

        // dataManager.doSimpleQuery(dataSource);
        // dataManager.doJoin(dataSource);
        dataManager.insertIntoDirect(dataSource);
        // dataManager.insertIntoWithGeneratedKeys(dataSource);
        // dataManager.updateRecord(dataSource);
        // dataManager.deleteRecord(dataSource);
    }
}