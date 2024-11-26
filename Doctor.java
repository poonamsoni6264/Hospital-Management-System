package hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Doctor 
{

	 private Connection connection;
	    
	                
	    //this is a constructor of Doctor class
		public Doctor(Connection connection)
		{
			this.connection=connection;
			
		}
		
		

		//viewDoctors method
		public void viewDoctors()
		{
			String query = "Select * from doctors";
			try
			{
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println("Doctors");
				System.out.println("+------------+--------------------+-------------------+------------+");
				System.out.println("| Doctor Id  | Name               | Specialization    | Fees       |");
				System.out.println("+------------+--------------------+-------------------+------------+");
				while(resultSet.next())
				{
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String specialization = resultSet.getString("specialization");
					String Fees = resultSet.getString("Fees");
					System.out.printf("| %-10s | %-18s | %-18s| %-10s |\n", id, name, specialization, Fees);
					System.out.println("+------------+--------------------+-------------------+------------+");
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		//getPatients through their id
		public boolean getDoctorById(int id)
		{
			String query = "Select * from doctors WHERE id = ?";
			try
			{
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					return true;
				}else
				{
					return false;
				}
				
			}catch(Exception e)
			{
				
			}
			return false;
		}
}
