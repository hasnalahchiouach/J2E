package classes_diag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.DBConnection;

public class Funct_medecins {
public void ajoutMedecins(int id , String version , String titre , String nom , String prenom ) {
	Connection conn = DBConnection.getConnection();
	
	try
	{
	                        String sql = "INSERT INTO medecins (id, version, titre, nom, prenom) VALUES (?, ?, ?, ?, ?)";
	                        PreparedStatement statement = conn.prepareStatement(sql);
	                        statement.setInt(1, id);
	                        statement.setString(2, version);
	                        statement.setString(3, titre);
	                        statement.setString(4, nom);
	                        statement.setString(5, prenom);
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

public void getMedecins () {
	Connection conn = DBConnection.getConnection();
	
	try
	{
		String query = "Select * From medecins";
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

public void deleteMedecin(int id) throws SQLException{
	Connection conn = DBConnection.getConnection();
    String sql = "delete from medecins where id = ?";
    PreparedStatement  st = conn.prepareStatement(sql);
    st.setInt(1, id);
    int affectedRecords = st.executeUpdate();
    System.out.println("Number of deleted records:- " + affectedRecords);
}
}