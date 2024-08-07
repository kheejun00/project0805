package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;
import repository.MemberRepository;
import util.JDBCUtil;

public class MemberDAO implements MemberRepository{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//로그인
	public boolean login(String id, String pw) {
		List<MemberDTO> list = getMembers();
		for(MemberDTO dto : list) {
			if(dto.getId().equals(id)&&dto.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}

	public List<MemberDTO> getMembers(){
		List<MemberDTO> list = new ArrayList<>();
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
	public boolean join(MemberDTO dto) {
		con = JDBCUtil.getConnection();
		boolean result = false;
		try {
			pstmt = con.prepareStatement(INSERT_MEMBER);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getTel());
			pstmt.setString(7, dto.getEmail());
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
	public MemberDTO getMember(int no) {
		con = JDBCUtil.getConnection();
		MemberDTO rsDto = null;
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
	
	public MemberDTO getMember(String id) {
		con = JDBCUtil.getConnection();
		MemberDTO rsDto = null;
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
	public void updateMember(MemberDTO dto) {
		try {
			if(!isExist(dto.getMemberNo())) {throw new SQLException();}
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(UPDATE_MEMBER);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getPw());
			pstmt.setString(5, dto.getTel());
			pstmt.setString(6, dto.getEmail());
			pstmt.setInt(7, dto.getMemberNo());
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
