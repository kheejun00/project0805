package model;

import java.util.List;

public interface MemberCon {
	final static String SELECT_ADMINMEMBER = "select * from adminMember where memberNo = ?";
	final static String SELECT_ALL = "select * from member";
	final static String INSERT_MEMBER = "insert into member"
			+ "(joinDate, name, birth, id, nickname, pw, tel, email) "
			+ "values(now(), ?,?,?,?,?,?,?)";
	final static String SELECT_ONE = "select * from member where memberNo = ?";
	final static String SELECT_WHERE_ID= "select * from member where id = ?";
	final static String UPDATE_MEMBER = "update member set name = ?, birth = ?, nickname = ?, pw = ?, tel = ?, email = ? where memberNo = ?";
	
	Member getMember(int no);
	Member getMember(String id);
	boolean login(String id, String pw);
	boolean join(Member member);
	boolean isExist(int no);
	boolean isAdmin(int no);
	List<Member> getMembers();
	void updateMember(Member member);
}
