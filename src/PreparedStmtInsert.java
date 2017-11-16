import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PreparedStmtInsert {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = (Connection) DBUtil.getConnection(DBType.MySQL);
		int id,TextSize;
		String url,Type;
		
		/*Scanner s =new Scanner(System.in);
		System.out.print("Enter the id : ");
		Integer.parseInt(s.nextLine());
		System.out.print("Enter the URL : ");
		s.nextLine();
		System.out.print("Enter the size of the Text : ");
		s.nextInt();
		System.out.print("Enter the type of the URL : ");
		s.nextLine();
		String sql = "insert into record " + " (id, url, TextSize,Type)" + " values (?, ?, ?,?)";*/
		String sql ="insert into record values(?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		/*pstmt.setInt(1, id);
		pstmt.setString(2, url);
		pstmt.setInt(3, TextSize);
		pstmt.setString(4, Type);*/
		pstmt.setInt(1, 6);
		pstmt.setString(2, "http://www.klm.com");
		pstmt.setInt(3, 33121);
		pstmt.setString(4, "html/text");
		
				
		int result = pstmt.executeUpdate();
		
		if(result ==1 ){
			System.out.println("Record has been INSERTED successfully");
		}
		else
			System.out.println("Error in inserting the records");
		

	}

}
