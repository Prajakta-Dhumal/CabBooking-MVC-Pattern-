package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Model lAYER
public class CabBookingModel 
{
	 Connection con;
	
	{
		//Load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm?user=root&password=sql@123");
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//TOTAL AMOUNT WITHOUT WAITING CHARGES
	public double totalAmount( String cab_type,int km) 
	{
		//declare the resources
		PreparedStatement pstmt;
		ResultSet rs=null;
		double total=0;
		//write the query
		String query="select rate_per_km from cab_info where cab_type=?";
		//create the platform
		try {
		    	pstmt=con.prepareStatement(query);
				//set the value
				pstmt.setString(1,cab_type);
				//execute the query
				rs=pstmt.executeQuery();
				if (rs.next())
				{
					int rate=rs.getInt(1);
					total=km*rate;
				}
					
				}
		catch (SQLException e)
	      	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		
		
		return total;
	}
	
	//FINDING WAITING CHARGES
	 public double waitingCharges(String cab_type,int waitingtime) 
	 {
		//declare the resources
			PreparedStatement pstmt;
			ResultSet rs=null;
			double totalCharge=0;
			//write the query
			String query="select waiting_time_min from cab_info where cab_type=?";
			//create the platform
			try {
			    	pstmt=con.prepareStatement(query);
					//set the value
					pstmt.setString(1,cab_type);
					//execute the query
					rs=pstmt.executeQuery();
					if (rs.next())
					{
						int waiting_rate=rs.getInt(1);
						totalCharge=waitingtime*waiting_rate;
					}
						
				}
			catch (SQLException e)
		      	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
			return totalCharge;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	



}
