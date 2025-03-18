package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnect {
    private static String URL = "jdbc:mysql://localhost:3306/jmx_bolosDB";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Insira sua senha do MySQL aqui

    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
