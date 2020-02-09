package Classes;

import java.sql.*;

public class DBConnection
{
	private static Connection conn;
	
	private DBConnection(){}
	
	public static Connection getConnection()
	{
	try
	{
	if(conn==null)
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
	}
	}catch(Exception e)
	{
	e.printStackTrace();
	}
	String requete = "INSERT INTO student VALUES (3,'souad')";
	try {
	   Statement stmt = conn.createStatement();
	   int nbMaj = stmt.executeUpdate(requete);
	   
	} catch (SQLException e) {
	   e.printStackTrace();
	}
	return conn;
	}
	






}