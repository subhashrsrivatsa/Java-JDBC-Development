import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PreparedStmtDelete {

	public static void main(String[] args) throws SQLException {
		Connection conn = (Connection) DBUtil.getConnection(DBType.MySQL);
		String sql = "delete from record where id = ?";
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the ID you want to delete : ");
		int id = s.nextInt();
		
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1){
			System.out.println("\nThe record has been successfully REMOVED");
		}
		else
			System.out.println("Error while deleting the record");
		
	}

}
