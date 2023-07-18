// package myapp.db;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Dbconnection {
    final static String dbDriver = "com.mysql.jdbc.Driver";
    final static String dbURL = "jdbc:mysql://localhost:3306/";

    static String dbName = "sess_data";
    static String dbUsername = "root";
    static String dbPassword = "root";

    static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (Exception e) {
            conn = null;
        } finally {
            return conn;
        }

    }
}
