package classes_diag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.DBConnection;

public class Funct_rv{
public void ajoutRv(int id , String jour , String id_client , String id_creneau  ) {
	Connection conn = DBConnection.getConnection();
	
	try
	{
	                        String sql = "INSERT INTO rv (id, jour, id_client, id_creneau) VALUES (?, ?, ?, ?)";
	                        PreparedStatement statement = conn.prepareStatement(sql);
	                        statement.setInt(1, id);
	                        statement.setString(2, jour);
	                        statement.setString(3, id_client);
	                        statement.setString(4, id_creneau);
	                        
	                        int rowsInserted = statement.executeUpdate();
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally
	{
		try{
			conn.close();
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
}
public void getrv () {
	Connection conn = DBConnection.getConnection();
	
	try
	{
		String query = "Select * From rv";
		Statement st = conn.createStatement();
		ResultSet rst = st.executeQuery(query);
		
		while(rst.next())
		{
			System.out.println(rst.getString("id")+" "+rst.getString("jour"));	
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}}
	
	public void deleteRv(int id) throws SQLException{
		Connection conn = DBConnection.getConnection();
	    String sql = "delete from rv where id = ?";
	    PreparedStatement  st = conn.prepareStatement(sql);
	    st.setInt(1, id);
	    int affectedRecords = st.executeUpdate();
	    System.out.println("Number of deleted records:- " + affectedRecords);
	}
	
	
}
