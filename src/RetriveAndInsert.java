import java.sql.* ;

import com.mysql.jdbc.PreparedStatement;   
public class RetriveAndInsert 
{ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null,conn1 = null;
		Statement stmt1 = null;
				
				
		try {
			conn = DBUtil.getConnection(DBType.MySQL);
			Statement stTruncate = conn.createStatement();
			stTruncate.executeUpdate("truncate table url_only");
			conn1 = DBUtil.getConnection(DBType.MySQL);
			stmt1 = conn1.createStatement();
			String sql ="insert into url_only select url,Type from record";
			int rows = stmt1.executeUpdate(sql);
			
			PreparedStatement pstmt1 = (PreparedStatement) conn1.prepareStatement(sql);
			
			System.out.println("Total number of Rows updated on the url_only table : "+rows);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
} 