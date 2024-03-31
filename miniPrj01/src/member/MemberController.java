package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.Main;
import master.Master;
import util.Util;

public class MemberController {
	Master m = new Master();

	public void printMenu() throws Exception {

		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("9. 취소");
		System.out.print("번호 입력 : ");
		String inputNum = Util.SC.nextLine();
		switch (inputNum) {
		case "1":
			login();
			break;
		case "2":
			join();
			break;
		case "9":
			System.out.println("종료..");
			Util.run = false;
			return;
		case "masterLogin":
			m.masterLogin();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}

	public void grant() {
		if (Util.vo.getSignUpYn().equals("N")) {
			System.out.println("승인 대기중 ...");
			Util.No = Integer.parseInt(Util.vo.getNo());
			Util.num++;
			return;
		} else if (Util.vo.getSignUpYn().equals("Y")) {
			System.out.println("이미 승인된 계정입니다.");
			return;
		} else {
			System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
			return;
		}
	}

	public void logout() {
		System.out.println("로그아웃 진행중...");
		Util.vo = null;
		System.out.println("로그아웃 성공!");
		return;
	}

	

	private void login() throws Exception {
		System.out.println("로그인");
		Connection conn = Util.getConn();
		String sql = "SELECT NO, ID, PWD, NAME, RANK, ARMY_NUM, SIGN_UP_YN FROM MEMBERS WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.println("아이디 : ");
		String id = Util.SC.nextLine();
		System.out.println("패스워드 : ");
		String pwd = Util.SC.nextLine();
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String dbNo = rs.getString("NO");
			String dbId = rs.getString("ID");
			String dbPwd = rs.getString("PWD");
			String dbName = rs.getString("NAME");
			String dbRank = rs.getString("RANK");
			String dbArmyNum = rs.getString("ARMY_NUM");
			String dbSignUpYn = rs.getString("SIGN_UP_YN");
			Util.vo = new MemberVo(dbNo, dbId, dbPwd, dbName, dbRank, dbArmyNum, dbSignUpYn);
		}
		if (Util.vo == null) {
			System.out.println("로그인 실패");
			return;
		}
		System.out.println("로그인 성공!");
		System.out.println(Util.vo.getId() + "님 환영합니다. ");
	}

	private void join() throws Exception {
		System.out.println("회원 가입을 시작합니다.");
		int n = 0;
		Connection conn = Util.getConn();
		String sql = "INSERT INTO MEMBERS(NO, ID, PWD, NAME, RANK, ARMY_NUM) VALUES(SQC_M.NEXTVAL , ? , ? , ? , ? , ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.print("아이디 : ");
		String id = Util.SC.nextLine();
		System.out.print("패스워드(특수문자 1개 이상 포함) : ");
		String pwd = Util.SC.nextLine();
		for (int i = 0; i < pwd.length(); i++) {
			if (pwd.charAt(i) >= 33 && pwd.charAt(i) <= 42 || pwd.charAt(i) == 64 || pwd.charAt(i) == 94) {
				n++;
			}
		}
		if (n <= 0) {
			System.out.println("특수문자 미포함 / 다시 입력해 주세요");
			return;
		}
		System.out.print("이름 : ");
		String name = Util.SC.nextLine();
		System.out.print("계급 : ");
		String rank = Util.SC.nextLine();
		System.out.print("군번 : ");
		String num = Util.SC.nextLine();

		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setString(4, rank);
		pstmt.setString(5, num);

		int result = pstmt.executeUpdate();
		if (result != 1) {
			System.out.println("등록 실패, 다시 시도해 주세요.");
			return;
		}
		System.out.println("회원가입 성공!");
	}
}
