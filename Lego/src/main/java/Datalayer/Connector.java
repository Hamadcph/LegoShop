package Datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;






public class Connector {

    private static final String URL = "jdbc:mysql://localhost:3306/LegoShop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hamad2660";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
