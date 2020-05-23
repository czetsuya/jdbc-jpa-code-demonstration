/**
 * Copyright 2020 - present, Edward P. Legaspi | czetsuya@gmail.com.
 * All rights reserved.
 * 
 * This source code is license under the license found in the 
 * License.md file in the root directory of this source tree.
 */
package com.czetsuya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Demonstrates JDBC operations with MySQL database.
 * 
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since 0.0.1
 */
public class JdbcTemplateMysqlDemo {

    private Connection conn;

    public static void main(String[] args) {
        new JdbcTemplateMysqlDemo();
    }

    public JdbcTemplateMysqlDemo() {

        try {
            // com.mysql.jdbc.Driver - this driver is deprecated
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.101:3306/catalog";
            conn = DriverManager.getConnection(url, "kerri", "kerri");
            jdbcTest();

        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void jdbcTest() {
        testSelect();

        testInsert();
        testSelect();
        testUpdate();
        testSelect();
        testDelete();
        testSelect();
    }

    private void testSelect() {

        System.out.println("\nSelect product from database");
        String query = "SELECT id, code, amount, description, created_at FROM product WHERE disabled=false";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                double amount = rs.getDouble("amount");
                String description = rs.getString(3);

                System.out.println(String.format("%d %s %f %s", id, code, amount, description));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void testInsert() {

        System.out.println("\nInsert data into product");
        try {
            Statement st = conn.createStatement();
            String createdAt = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
            // no need to fill the id as its value is auto-incremented
            st.executeUpdate("INSERT INTO product (code, amount, description, created_at)  VALUES ('IPHONE11', 70000, 'iPhone11 v1', '" + createdAt + "')");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void testUpdate() {

        System.out.println("\nUpdate data in product");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(
                    "UPDATE product SET description='Meet iPhone 11. All-new dual-camera system with Ultra Wide and Night mode. All-day battery. Six new colors. And the A13 Bionic, our fastest chip ever.' WHERE code='IPHONE11'");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void testDelete() {

        System.out.println("\nDelete IPHONE11 in product");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM product WHERE code='IPHONE11'");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
