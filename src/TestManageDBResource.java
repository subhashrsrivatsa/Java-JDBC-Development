import java.sql.*;
public class TestManageDBResource {
	
	
	public static void main(String[] args) throws SQLException {
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
		try {
			//conn = DriverManager.getConnection(dbUrl, username, password);
			conn = DBUtil.getConnection(DBType.MySQL);
			System.out.println("\nThe connection was successful ");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from url_only");
			rs.last();
			System.out.println("Rows : "+rs.getRow());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DBUtil.showErrorMessage(e);
		}
		finally {
			if(conn != null){
				conn.close();
			}
		}
		
	}

}
