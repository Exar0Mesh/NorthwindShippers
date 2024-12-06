package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class NorthwindDataManager {
    private DataSource dataSource;

    public NorthwindDataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public static void insertIntoDirect(DataSource dataSource) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert new shipper data: ");
        System.out.print("Name of the shipper: ");
        String shipp = scanner.nextLine();
        System.out.print("Phone number of the shipper: ");
        String shipPhone = scanner.nextLine();


        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Shippers (CompanyName) VALUES (?);")) {
                preparedStatement.setString(1, shipp);
                //preparedStatement.setString(2,"%" + shipPhone + "%");
                int rows = preparedStatement.executeUpdate();
                System.out.printf("Rows updated in CompanyName: %d\n", rows);
            }
            try (PreparedStatement pS = connection.prepareStatement(
                    "INSERT INTO Shippers (CompanyName) VALUES (?);")) {
                pS.setString(1, shipp);
                //preparedStatement.setString(2,"%" + shipPhone + "%");
                int rows = pS.executeUpdate();
                System.out.printf("Rows updated in CompanyName: %d\n", rows);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
