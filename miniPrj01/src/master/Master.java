package master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.Util;

public class Master {
	public static int num0 = 5;
	public void masterLogin() throws Exception {
		if (num0 > 0) {
			Connection conn = Util.getConn();
			String sql = "SELECT ID FROM MASTER WHERE ID = ? AND PWD1 = ? AND PWD2 = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("마스터 계정 로그인");
			System.out.println("아이디 :");
			String id = Util.SC.nextLine();
			System.out.println("1차 비밀번호 : ");
			String pwd1 = Util.SC.nextLine();
			System.out.println("2차 비밀번호 : ");
			String pwd2 = Util.SC.nextLine();

			pstmt.setString(1, id);
			pstmt.setString(2, pwd1);
			pstmt.setString(3, pwd2);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbid = rs.getString("ID");
				MasterVo vo = new MasterVo(dbid);
				Util.mvo = vo;
			}
			if (Util.mvo == null) {
				num0--;
				System.out.println("로그인 실패 / 남은 시도 가능 횟수" + num0);
				return;
			}
			System.out.println("로그인 성공");
			if(Util.num == 0) {
				System.out.println("승인되지 않은 권한 요청 0건");
			}
			if (Util.num != 0) {
				System.out.println("승인되지 않은 권한 요청이 " + Util.num + "건 있습니다.");
				System.out.println("1. 상세조회");
				String inputNum = Util.SC.nextLine();
				if (inputNum.equals("1")) {
					System.out.println("승인 요청한 사용자의 No : " + Util.No);
					System.out.println("요청을 승인하시겠습니까? (Y/N)");
					String inputString = Util.SC.nextLine();
					if (inputString.equals("Y")) {
						System.out.println("요청을 승인하였습니다.");
						grantMaster();
						Util.No = 0;
						Util.num--;
					} else if (inputString.equals("N")) {
						System.out.println("요청을 거부하였습니다.");
						Util.No = 0;
						Util.num--;
					} else {
						System.out.println("잘못된 입력입니다.");
						return;
					}
				} else {
					System.out.println("잘못된 입력입니다.");
					return;
				}
			}
		} else {
			System.out.println("계정이 잠겼습니다. 새로운 계정을 생성해주세요");
		}
	}

	public void grantMaster() throws Exception {
		if (Util.num != 0) {
			Connection conn = Util.getConn();
			String sql = "UPDATE MEMBERS SET SIGN_UP_YN = " + "'" + "Y" + "'" + "WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(Util.No));
			int result = pstmt.executeUpdate();
			if (result != 1) {
				System.out.println("권한 승인 실패..");
				return;
			}
			System.out.println("권한 승인이 완료되었습니다.");
		}
	}
}
