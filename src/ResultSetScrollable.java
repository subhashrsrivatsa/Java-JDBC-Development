import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ResultSetScrollable {

	public static void main(String[] args) throws SQLException {
		
		try {
			Connection conn = (Connection) DBUtil.getConnection(DBType.MySQL);
			Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select * from record limit 20");
			
			String format = "%-4d%-10s\n";
			
			rs.beforeFirst();
			System.out.println("The first 20 URLs are : ");
			while(rs.next()){
				System.out.format(format, rs.getInt("id"),rs.getString("URL"));
			}
			System.out.println("\n\n");
			rs.afterLast();
			System.out.println("The last 20 URLs are : ");
			while(rs.previous()){
				System.out.format(format, rs.getInt("id"),rs.getString("URL"));
			}
			System.out.println("\n\n");
			rs.first();
			System.out.format(format, rs.getInt("id"),rs.getString("URL"));
			System.out.println("\n\n");
			System.out.println("The specified 4th URL is :");
			rs.absolute(4);
			System.out.format(format, rs.getInt("id"),rs.getString("URL"));
			System.out.println("\n\n");
			rs.relative(6);
			System.out.println("The relative URL from the previous absolute URL is : ");
			System.out.format(format, rs.getInt("id"),rs.getString("URL"));
			System.out.println("\n\n");
			rs.relative(-2);
			System.out.println("The relative URL from the previous absolute URL is : ");
			System.out.format(format, rs.getInt("id"),rs.getString("URL"));
			System.out.println("\n\n");
			rs.last();
			System.out.println("The last URL is :");
			System.out.format(format, rs.getInt("id"),rs.getString("URL"));
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
