package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class MemberDAO implements MemberCon{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//로그인
	public boolean login(String id, String pw) {
		List<Member> list = getMembers();
		for(Member memberDTO : list) {
			if(memberDTO.getId().equals(id)&&memberDTO.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}

	public List<Member> getMembers(){
		List<Member> list = new ArrayList<>();
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberDTO(rs.getInt("memberNo"),
					rs.getString("name"), rs.getString("birth"), rs.getString("id"),
					rs.getString("nickname"),rs.getString("pw"),rs.getString("tel"),
					rs.getString("email")));
			}
		} catch (SQLException e) {
			System.out.println("SelectAllMember Failed");
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return list;
	}
	//가입
	public boolean join(Member member) {
		con = JDBCUtil.getConnection();
		boolean result = false;
		try {
			pstmt = con.prepareStatement(INSERT_MEMBER);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getId());
			pstmt.setString(4, member.getNickname());
			pstmt.setString(5, member.getPw());
			pstmt.setString(6, member.getTel());
			pstmt.setString(7, member.getEmail());
			if(pstmt.executeUpdate()!=1) throw new SQLException();
			result = true;
		}catch(SQLException e) {
			System.out.println("join Failed: insert 실패");
		} finally {
			JDBCUtil.close(pstmt, con);
		}
		return result;
	}
	
	//현재 로그인한 사용자 정보 읽기
	public Member getMember(int no) {
		con = JDBCUtil.getConnection();
		Member rsDto = null;
		try {
			pstmt = con.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(!rs.next()) throw new SQLException();
			rsDto = new MemberDTO(rs.getInt("memberNo"),
					rs.getString("name"), rs.getString("birth"), rs.getString("id"),
					rs.getString("nickname"),rs.getString("pw"),rs.getString("tel"),
					rs.getString("email"));
		}catch(SQLException e) {
			System.out.println("GetMemberInfo Failed");
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return rsDto;
	}
	
	public Member getMember(String id) {
		con = JDBCUtil.getConnection();
		Member rsDto = null;
		try {
			pstmt = con.prepareStatement(SELECT_WHERE_ID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) throw new SQLException();
			rsDto = new MemberDTO(rs.getInt("memberNo"),
					rs.getString("name"), rs.getString("birth"), rs.getString("id"),
					rs.getString("nickname"),rs.getString("pw"),rs.getString("tel"),
					rs.getString("email"));
		}catch(SQLException e) {
			System.out.println("GetMemberInfo Failed");
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return rsDto;
	}
	
	public boolean isExist(int no) {
		return getMember(no) != null?true:false;
	}
	
	//회원정보 수정
	public void updateMember(Member member) {
		try {
			if(!isExist(member.getMemberNo())) {throw new SQLException();}
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(UPDATE_MEMBER);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getNickname());
			pstmt.setString(4, member.getPw());
			pstmt.setString(5, member.getTel());
			pstmt.setString(6, member.getEmail());
			pstmt.setInt(7, member.getMemberNo());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("UpdateMember Failed");
			
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}

	@Override
	public boolean isAdmin(int no) {
		boolean result = false;
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(SELECT_ADMINMEMBER);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			result = rs.next()?true:false;
		}catch (SQLException e) {
			System.out.println("isAdmin failed");
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return result;
	}
}
