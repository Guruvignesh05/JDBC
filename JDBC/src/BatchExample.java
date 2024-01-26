import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExample {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Agathiyan@5";


        Connection connection = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            connection = DriverManager.getConnection(jdbcUrl, username, password);


            statement = connection.createStatement();


            statement.addBatch("INSERT INTO batch_example (id, name) VALUES (7, 'guru')");
            statement.addBatch("INSERT INTO batch_example (id, name) VALUES (8, 'bharathi')");
            statement.addBatch("INSERT INTO batch_example (id, name) VALUES (9, 'pragathi')");


            int[] updateCounts = statement.executeBatch();


            for (int updateCount : updateCounts) {

            }

            System.out.println("Batch executed successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
