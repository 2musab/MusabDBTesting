import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;

public class MyTestCases {

	Random rand = new Random();
	Random rand2 = new Random();

	Connection con;
	Statement stmt;

	ResultSet rs;

	int randomnumber = rand.nextInt(500);

	@BeforeTest
	public void mySetup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
	}

	@Test
	public void selectData() throws SQLException {
		String query = "select * from job";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);

	}

	@Test
	public void addData() throws SQLException {
		String query = "insert into job ( id,FirstName ,LastName ,DepartmentID ) values ( 99,'Leo','Messi',6)";
		stmt = con.createStatement();
		stmt.executeUpdate(query);

	}

	@Test
	public void updateData() throws SQLException {

		String query = "update job set DepartmentID = 7 where DepartmentID = 6 ";
		stmt = con.createStatement();
		stmt.executeUpdate(query);

	}
	
	@Test
	public void deleteData() throws SQLException {
		
		String query = "Delete from job where id = 99";
		con.createStatement();
		stmt.executeUpdate(query);
		
	}

}