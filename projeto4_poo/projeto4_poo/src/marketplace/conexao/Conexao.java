package marketplace.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String url = "jdbc:mysql://localhost:3306/chocolatesbd";
	private static final String user = "root";
	private static final String password = "60064231gg";

    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null) {
            	conn = DriverManager.getConnection(url, user, password);
            	return conn;
            }else{
            	return conn;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
    
}
