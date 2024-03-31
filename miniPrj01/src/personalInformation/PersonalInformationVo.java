package personalInformation;

public class PersonalInformationVo {
	private String no;
	private String affiliation;
	private String name;
	private String armyNum;
	private String rank;
	private String address;
	private String academicBackground;
	private String hobby;
	private String specialNote;
	private String family;
	private String familyPhoneNuber;
	private String armyJoinYn;
	
	public PersonalInformationVo() {
		super();
	}
	
	public PersonalInformationVo(String no, String affiliation, String name, String armyNum, String rank,
			String address, String academicBackground, String hobby, String specialNote, String family,
			String familyPhoneNuber, String armyJoinYn) {
		super();
		this.no = no;
		this.affiliation = affiliation;
		this.name = name;
		this.armyNum = armyNum;
		this.rank = rank;
		this.address = address;
		this.academicBackground = academicBackground;
		this.hobby = hobby;
		this.specialNote = specialNote;
		this.family = family;
		this.familyPhoneNuber = familyPhoneNuber;
		this.armyJoinYn = armyJoinYn;
	}
	
	public String getNo() {
		return no;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public String getName() {
		return name;
	}
	public String getArmyNum() {
		return armyNum;
	}
	public String getRank() {
		return rank;
	}
	public String getAddress() {
		return address;
	}
	public String getAcademicBackground() {
		return academicBackground;
	}
	public String getHobby() {
		return hobby;
	}
	public String getSpecialNote() {
		return specialNote;
	}
	public String getFamily() {
		return family;
	}
	public String getFamilyPhoneNuber() {
		return familyPhoneNuber;
	}
	public String getArmyJoinYn() {
		return armyJoinYn;
	}
	
	@Override
	public String toString() {
		return "[" + no + ", 소속 : " + affiliation + ", 이름 : " + name + ", 군번 : "
				+ armyNum + ", 계급 : " + rank + ", 주소 : " + address + ", 학력 : " + academicBackground
				+ ", 취미 : " + hobby + ", 특이사항 : " + specialNote + ", 가족 : " + family + ", 가족 핸드폰 번호 "
				+ familyPhoneNuber + ", 동반입대 여부" + armyJoinYn + "]";
	}
	
	
	
}
