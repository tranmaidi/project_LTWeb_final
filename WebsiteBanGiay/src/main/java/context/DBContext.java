package context;


import java.sql.Connection;
import java.sql.SQLException;

//import javax.servlet.jsp.tagext.TryCatchFinally;


public class DBContext 
{
    public Connection getConnection() throws SQLException, ClassNotFoundException
    {
        return SQLServerConnection.initializeDatabase();
    }
}