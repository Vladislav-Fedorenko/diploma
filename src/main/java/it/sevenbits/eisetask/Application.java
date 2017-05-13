package it.sevenbits.eisetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication

public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        /*Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/students";
        String username = "postgres";
        String password = "nhbujyjvtnhbz21";
        Connection connection =
                DriverManager.getConnection(
                        url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement.executeQuery("SELECT * FROM mpb302");
        while (resultSet.next())
        {
            System.out.println(
                    String.format("%s\t%s",
                            resultSet.getInt(1),
                            resultSet.getString(2)));
        }
        resultSet.close();
        statement.close();
        connection.close();
    */}
}
