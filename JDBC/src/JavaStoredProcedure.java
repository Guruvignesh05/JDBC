import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JavaStoredProcedure {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Agathiyan@5";


        Connection connection = null;
        CallableStatement callableStatement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcUrl, username, password);

            callableStatement = connection.prepareCall("{call getEmployeeInfo(?, ?, ?)}");

            callableStatement.setInt(1, 2);

            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);

            callableStatement.execute();

            String employeeName = callableStatement.getString(2);
            String employeeDegree = callableStatement.getString(3);


            System.out.println("Employee Name: " + employeeName);
            System.out.println("Employee Degree: " + employeeDegree);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
