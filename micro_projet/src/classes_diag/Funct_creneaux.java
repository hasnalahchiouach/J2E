package classes_diag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.DBConnection;

public class Funct_creneaux {
public void ajoutCreneaux(int id , String version , String hdebut, String mdebut , String hfin, String mfin , String id_medecin ) {
	Connection conn = DBConnection.getConnection();
	
	try
	{
	                        String sql = "INSERT INTO creneaux (id, version, hdebut, mdebut, hfin,mfin,id_medecin) VALUES (?, ?, ?, ?, ?,?,?)";
	                        PreparedStatement statement = conn.prepareStatement(sql);
	                        statement.setInt(1, id);
	                        statement.setString(2, version);
	                        statement.setString(3, hdebut);
	                        statement.setString(4, mdebut);
	                        statement.setString(5, hfin);
	                        statement.setString(6, mfin);
	                        statement.setString(7, id_medecin);
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

public void getCreneaux () {
	Connection conn = DBConnection.getConnection();
	
	try
	{
		String query = "Select * From creneaux";
		Statement st = conn.createStatement();
		ResultSet rst = st.executeQuery(query);
		
		while(rst.next())
		{
			System.out.println(rst.getString("id")+" "+rst.getString("version"));	
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void deleteCreneaux(int id) throws SQLException{
	Connection conn = DBConnection.getConnection();
    String sql = "delete from creneaux where id = ?";
    PreparedStatement  st = conn.prepareStatement(sql);
    st.setInt(1, id);
    int affectedRecords = st.executeUpdate();
    System.out.println("Number of deleted records:- " + affectedRecords);
}
}