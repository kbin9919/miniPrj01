package main;

import java.util.ArrayList;

import member.MemberController;
import personalInformation.PersonalInformationController;
import personalInformation.PersonalInformationVo;
import util.Util;

public class Main {
	PersonalInformationController pi = new PersonalInformationController();
	MemberController mc = new MemberController();
	
	
	
	public void main() throws Exception {
		
		while (Util.run) {
			if (Util.vo == null) {
				mc.printMenu();
			}
			if (Util.vo != null) {
				
				System.out.println("사용하실 기능을 선택하세요");

				System.out.println("0. 권한 요청");
				System.out.println("1. 신규 등록");
				System.out.println("2. 정보 조회");
				System.out.println("3. 로그아웃");
				System.out.println("9. 종료");

				System.out.print("번호 입력 : ");
				String inputNum = Util.SC.nextLine();

				switch (inputNum) {
				case "0":
					mc.grant();
					break;
				case "1":
					pi.signUp();
					break;
				case "2":
					pi.info();
					pi.info2();
					break;
				case "3":
					mc.logout();
					break;
				case "9":
					Util.run = false;
					System.out.println("사용 종료");
					break;
				default:
					System.out.println("잘못된 입력입니다.");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.main();
	}
}
