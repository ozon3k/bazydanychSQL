package pl.sdacademy.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException {
        String connectionString = "jdbc:mysql://localhost:3306/baza_testowa";
        String dbPassword = "password";
        String dbUser = "pawel";
        String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";

        Properties prop = new Properties();
        prop.put("password", dbPassword);
        prop.put("user", dbUser);


        Connection connection = DriverManager.getConnection(connectionString+connectionOptions, prop);
    }
}
