import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PreparedStmtUpdate {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = (Connection) DBUtil.getConnection(DBType.MySQL);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id : ");
		int id = s.nextInt();
		System.out.println("Enter the new url you want to modify : ");
		String url = s.next();
		
		String sql = "Update record set url = ? where id = ?";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, url);
		pstmt.setInt(2, id);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1){
			System.out.println("The record has been UPDATED successfully");
		}
		else
			System.out.println("Error while UPDATE");

	}

}
