import java.sql.*;

public class IteratingRSJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection(DBType.MySQL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select url from record ");
			
			//String format = "%-4d%-10s%-55s\n";
			
			while(rs.next()){
				//System.out.format(format,rs.getInt("id"),rs.getString("url"),rs.getString("type"));
				System.out.println(rs.getString("url"));
				//System.out.format(format, rs.getString("URL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
