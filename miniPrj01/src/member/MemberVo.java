package member;

public class MemberVo {
	private String no;
	private String id;
	private String pwd;
	private String name;
	private String rank;
	private String armyNum;
	private String signUpYn;
	
	public MemberVo() {
		super();
	}
	
	public MemberVo(String no, String id, String pwd, String name, String rank, String armyNum, String signUpYn) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.rank = rank;
		this.armyNum = armyNum;
		this.signUpYn = signUpYn;
	}
	
	
	public String getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getRank() {
		return rank;
	}

	public String getArmyNum() {
		return armyNum;
	}

	public String getSignUpYn() {
		return signUpYn;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", rank=" + rank + ", armyNum="
				+ armyNum + ", signUpYn=" + signUpYn + "]";
	}

	
	
	
	
}
