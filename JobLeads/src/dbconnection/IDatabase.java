package dbconnection;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface IDatabase {

    public void openConnectionForGenerateDB() throws ClassNotFoundException, SQLException;
    public void openConnection() throws ClassNotFoundException, SQLException;
    public void closeConnection();
    public ResultSet executeQuery(String sql);
    public int executeUpdate(String sql);
    public int executeUpdateWithConnectionOn(String sql);
    public ResultSet executeQueryWithConnectionOn(String sql);
}

