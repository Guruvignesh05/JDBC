import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTriggerExample {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Agathiyan@5";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            connection = DriverManager.getConnection(jdbcUrl, username, password);


            String insertSQL = "INSERT INTO sample (id, name, value1) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);


            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "ThamaraiSan");
            preparedStatement.setInt(3, 50);
            // Execute the insert statement
            preparedStatement.executeUpdate();

            System.out.println("New row inserted successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
