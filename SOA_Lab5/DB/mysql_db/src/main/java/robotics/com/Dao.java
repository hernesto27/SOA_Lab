package robotics.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	private Connection con;
	private PreparedStatement pstmtInsert;
	private PreparedStatement pstmtRecords;
	@SuppressWarnings("unused")
	private ResultSet rsRecords;

	public Dao() {

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			String url = "jdbc:derby://localhost:1527/BrRobotics";
			String user = "root";
			String pass = "root";
			
			con = DriverManager.getConnection(url, user, pass);
			
			pstmtInsert = con.prepareStatement("INSERT INTO pedidos VALUES ( ?, ?, ?, ?, ?, ? )");
			pstmtRecords = con.prepareStatement("SELECT * FROM pedidos");
			rsRecords = pstmtRecords.executeQuery();

		} catch (ClassNotFoundException e) {
            System.out.println("Error1: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error:2 " + e.getMessage());
        }

	}
	
	
	  public void insert(PedidoBean pedido) {
	        try {
	            pstmtInsert.setInt(1, pedido.getCodigo());
	            pstmtInsert.setString(2, pedido.getCliente());
	            pstmtInsert.setString(3, pedido.getEndereco());
	            pstmtInsert.setString(4, pedido.getEstado());
	            pstmtInsert.setString(5, pedido.getItensReator());
	            pstmtInsert.setDouble(6, pedido.getTotal());

	            pstmtInsert.executeUpdate();
	            
	            rsRecords = pstmtInsert.executeQuery();
	            //return true;
	        } catch (SQLException e) {
	            System.out.println("Error3: " + e.getMessage());
	            //return false;
	        }

	    }

}
