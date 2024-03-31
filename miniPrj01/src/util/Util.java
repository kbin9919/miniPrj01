package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import master.MasterVo;
import member.MemberVo;
import personalInformation.PersonalInformationVo;

public class Util {
	
	public static MemberVo vo = null;
	public static MasterVo mvo = null;
	public static ArrayList<PersonalInformationVo> pvo = new ArrayList<>();
	public static boolean run = true;
	public static int num = 0;
	public static int No = 0;
	public static final Scanner SC = new Scanner(System.in);
	
	public static final Connection getConn() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KB01";
		String pwd = "1234";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		return conn;
	}
}
