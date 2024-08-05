package model;

public class MemberDTO implements Member {
	private int memberNo;
	private String name;
	private String birth;
	private String id;
	private String nickname;
	private String pw;
	private String tel;
	private String email;
	
	public MemberDTO(int memberNo, String name, String birth,
			String id, String nickname, String pw,
			String tel, String email) {
		this.memberNo = memberNo;
		this.name = name;
		this.birth = birth;
		this.id = id;
		this.nickname = nickname;
		this.pw = pw;
		this.tel = tel;
		this.email = email;
	}
	
	public MemberDTO(String name, String birth,
			String id, String nickname, String pw,
			String tel, String email) {
		this(0, name, birth, nickname,id, pw, tel, email);
	}
	
	public MemberDTO(int memberNo, String name, String birth, String nickname, String pw, String tel, String email) {
		this(memberNo, name, birth, "", nickname, pw, tel, email);
	}
	

	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
