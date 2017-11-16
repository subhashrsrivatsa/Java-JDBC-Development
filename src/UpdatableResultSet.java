import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class UpdatableResultSet {

	public static void main(String[] args) {
		try{
			Connection conn = (Connection) DBUtil.getConnection(DBType.MySQL);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select id, url,TextSize,Type from record");
			
			//String format = "%-4d%-10s\n";
			/*rs.absolute(33);
			rs.updateString("url", "http://www.unitedairlines.com/");
			rs.updateInt("TextSize", 1100);
			rs.updateString("Type", "text/html");
			rs.insertRow();
			System.out.println("Record INSERTED Successfully");*/
			rs.absolute(32);
			rs.updateString("url", "http://www.aircanada.com/");
			rs.updateInt("TextSize", 1300);
			rs.updateString("Type", "text/html/charset");
			System.out.println("Record UPDATED Successfully");
		}
		
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
