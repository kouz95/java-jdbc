package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection create() {
        Connection connection = null;
        String server = "localhost:3306";
        String database = "mydb";
        String option = "?useSSL=false&serverTimezone=UTC";
        String userName = "root";
        String password = "1234";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + option, userName, password);
            System.out.println("연결 성공");
        } catch (SQLException e) {
            System.err.println("연결 실패:" + e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }
}
