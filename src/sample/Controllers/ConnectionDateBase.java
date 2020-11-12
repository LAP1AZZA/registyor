package sample.Controllers;

import java.sql.*;


public class ConnectionDateBase extends Configs{
Connection dbConnection;
        public Connection getDbConnection()
                throws ClassCastException, SQLException {
                String ConnectionString = "jdbc:h2:mem:" + dbPath + "/" + dbName;
                try {
                        Class.forName("org.h2.Driver");
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
                dbConnection = DriverManager.getConnection(ConnectionString, dbUser, dbPass);
                return dbConnection;
        }
        public ResultSet getUser(User user) {
                ResultSet rs = null;
                String select = "SELECT * FROM " + ConstantDB.USERS_TABLE + " WHERE " +
                        ConstantDB.USERS_LOGIN + " = ? AND " + ConstantDB.USERS_PASSWORD +
                        " = ? AND " + ConstantDB.USERS_PRIORITY + "= ?";
                try {
                        PreparedStatement prSt = getDbConnection().prepareStatement(select);
                        prSt.setString(1, user.getLogin());
                        prSt.setString(2, user.getPassword());
                        prSt.setBoolean(3, user.getAdmin_status());
                        rs = prSt.executeQuery();
                }catch (SQLException throwables) {
                        throwables.printStackTrace();
                }
                return rs;
        }
        public void registerUser(User user) throws SQLException {
                ResultSet rs = getDbConnection().createStatement().executeQuery(
                        "SELECT COUNT(*) AS Qty FROM " + ConstantDB.USERS_TABLE);
                rs.next();
                int CounterID = rs.getInt(1) + 1;
                String insert = "INSERT INTO " + ConstantDB.USERS_TABLE + "(" +
                        ConstantDB.USERS_ID + "," + ConstantDB.USERS_LOGIN + "," +
                        ConstantDB.USERS_NAME + "," + ConstantDB.USERS_PASSWORD + "," +
                        ConstantDB.USERS_PRIORITY + ")" +
                        "VALUES(?, ?, ?, ?, ?)";
                try {
                        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                        prSt.setInt(1, CounterID);
                        prSt.setString(2, user.getLogin());
                        prSt.setString(3, user.getName());
                        prSt.setString(4, user.getPassword());
                        prSt.setBoolean(5, user.getAdmin_status());
                        prSt.executeUpdate();
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }
        }
}

