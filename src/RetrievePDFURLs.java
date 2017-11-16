import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class RetrievePDFURLs {
	
	public static void main(String[] args){
		Connection c1,c2,c3,c4 = null;
		Statement s1,s2,s3,s4 = null;
		
		try{
			c1 = (Connection) DBUtil.getConnection(DBType.MySQL);
			s1 = (Statement) c1.createStatement();
			s1.executeUpdate("truncate table url_only");
			c2 = (Connection) DBUtil.getConnection(DBType.MySQL);
			s2 = (Statement) c2.createStatement();
			String sql1 ="insert into url_only select url from record ";
			int rows = s2.executeUpdate(sql1);
			System.out.println("Total number of Rows updated on the url_only table : "+rows);
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try{
			c3 = (Connection) DBUtil.getConnection(DBType.MySQL);
			s3 = (Statement) c3.createStatement();
			s3.executeUpdate("truncate table pdf_only");
			c4 = (Connection) DBUtil.getConnection(DBType.MySQL);
			s4 = (Statement) c4.createStatement();
			String sql2 ="insert into pdf_only select url,Type from record "+" where Type = 'application/pdf' ";
			int rows = s4.executeUpdate(sql2);
			System.out.println("Total number of Rows updated on the pdf_only table : "+rows);
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
