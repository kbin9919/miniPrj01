package personalInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.Util;

public class PersonalInformationController {
	public void info() throws Exception {
		Connection conn = Util.getConn();
		String sql = "SELECT * FROM PERSONAL_INFORMATION";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String no = rs.getString("NO");
			String affiliation = rs.getString("AFFILIATION");
			String name = rs.getString("NAME");
			String armyNum = rs.getString("ARMY_NUM");
			String rank = rs.getString("RANK");
			String address = rs.getString("ADDRESS");
			String academicBackground = rs.getString("ACADEMIC_BACKGROUND");
			String hobby = rs.getString("HOBBY");
			String specialNote = rs.getString("SPECIAL_NOTE");
			String family = rs.getString("FAMILY");
			String familyPhoneNuber = rs.getString("FAMILY_PHONE_NUBER");
			String armyJoinYn = rs.getString("ARMY_JOIN_YN");
			PersonalInformationVo vo = new PersonalInformationVo(no, affiliation, name, armyNum, rank, address, academicBackground, hobby, specialNote, family, familyPhoneNuber, armyJoinYn);
			Util.pvo.add(vo);
		}
	}
	public void info2() {
		System.out.println("1. 전체조회");
		System.out.println("2. 상세조회");
		String inputNum = Util.SC.nextLine();
		switch(inputNum) {
		case "1" :
			for(int i = 0; i<Util.pvo.size(); i++) {
				System.out.println(Util.pvo.get(i));
			}
			break;
		case "2" :
			System.out.println("이름 : ");
			String str = Util.SC.nextLine();
			for(int i = 0; i<Util.pvo.size(); i++) {
				if(Util.pvo.get(i).getName().equals(str)) {
					System.out.println(Util.pvo.get(i));
				}
			}
			break;
		default : System.out.println("잘못된 입력입니다."); break;
		}
	}

	public void signUp() throws Exception {
		System.out.println("신규 등록을 시작합니다.");
		if (Util.vo.getSignUpYn().equals("Y")) {
			Connection conn = Util.getConn();
			String sql = "INSERT INTO PERSONAL_INFORMATION(NO, AFFILIATION, NAME, ARMY_NUM, RANK, ADDRESS, ACADEMIC_BACKGROUND, HOBBY, SPECIAL_NOTE, FAMILY, FAMILY_PHONE_NUBER, ARMY_JOIN_YN) VALUES(SQC_P_INFO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("소속 : ");
			String affiliation = Util.SC.nextLine();
			pstmt.setString(1, affiliation);

			System.out.println("이름 : ");
			String name = Util.SC.nextLine();
			pstmt.setString(2, name);

			System.out.println("군번 : ");
			String army_num = Util.SC.nextLine();
			pstmt.setString(3, army_num);

			System.out.println("계급 : ");
			String rank = Util.SC.nextLine();
			pstmt.setString(4, rank);

			System.out.println("주민번호 : ");
			String address = Util.SC.nextLine();
			pstmt.setString(5, address);

			System.out.println("학력 : ");
			String academic_background = Util.SC.nextLine();
			pstmt.setString(6, academic_background);

			System.out.println("취미 : ");
			String hobby = Util.SC.nextLine();
			pstmt.setString(7, hobby);

			System.out.println("특이사항 : ");
			String special_note = Util.SC.nextLine();
			pstmt.setString(8, special_note);

			System.out.println("가족관계 : ");
			String family = Util.SC.nextLine();
			pstmt.setString(9, family);

			System.out.println("가족 전화번호 : ");
			String family_phone_nuber = Util.SC.nextLine();
			pstmt.setString(10, family_phone_nuber);

			System.out.println("동반입대 여부 : ");
			String army_join_yn = Util.SC.nextLine();
			pstmt.setString(11, army_join_yn);

			int result = pstmt.executeUpdate();
			if (result != 1) {
				System.out.println("등록 실패, 다시 시도해 주세요.");
				return;
			}
			System.out.println("신규 등록이 완료되었습니다.");
		}

	}
}
