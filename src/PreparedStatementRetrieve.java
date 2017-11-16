import java.sql.*;
public class PreparedStatementRetrieve {

	public static void main(String[] args) {
		
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			conn = DBUtil.getConnection(DBType.MySQL);
			String sql = "select * from record where Type = ?";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatementRetrieve(pstmt, "text/html");
			System.out.println("-----------------------------------------------");
			preparedStatementRetrieve(pstmt, "text/html");
									
		}
		catch(SQLException e){
			DBUtil.showErrorMessage(e);
		}

	}

	private static void preparedStatementRetrieve(PreparedStatement pstmt, String type) throws SQLException {
		ResultSet rs;
		pstmt.setString(1,type);
		rs = pstmt.executeQuery();
		
		//String f = "-20s%\n";
		while(rs.next()){
			//System.out.format(f,rs.getString("URL"));
			System.out.println(rs.getString("URL"));
		}
		System.out.println("-----------------------------------------------");
		rs.last();
		System.out.println("Total number of URLs are : "+rs.getRow());
	}

}
