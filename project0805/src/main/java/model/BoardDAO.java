package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class BoardDAO implements BoardCon{
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<Board> getBoardList(){
		List<Board> list = new ArrayList<>();
		
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board dto = new BoardDTO(rs.getInt("boardNo"), 
						rs.getString("title"), 
						rs.getString("regtime"), 
						rs.getString("upRegtime"), 
						rs.getInt("hits"),
						rs.getInt("memberNo"), 
						rs.getString("content")) ;
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	public List<Board> getBoardList(int memberNo){
		List<Board> list = new ArrayList<>();
		
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_WHERE_WRITER);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new BoardDTO(rs.getInt("boardNo"), 
						rs.getString("title"), 
						rs.getString("regtime"), 
						rs.getString("upRegtime"), 
						rs.getInt("hits"),
						rs.getInt("memberNo"), 
						rs.getString("content"));
				list.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				JDBCUtil.close(rs, pstmt, con);
			}else {
				JDBCUtil.close(pstmt, con);
			}
		}
		
		return list;
	}
	
	public Board getBoard(int no) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_WHERE_NUM);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			Board board = new BoardDTO(rs.getInt("boardNo"), 
					rs.getString("title"), 
					rs.getString("regtime"), 
					rs.getString("upRegtime"), 
					rs.getInt("hits"),
					rs.getInt("memberNo"), 
					rs.getString("content"));
			return board;
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return null;
	}
	
	public void increaseHits(int num) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_HITS_INCREMENT);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	
	public boolean insertBoard(Board board) {
		con = JDBCUtil.getConnection();
		boolean result = false;
		try {
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, board.getTitle());
			pstmt.setInt(2, board.getMemberNo());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
			result = true;
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
		return result;
	}
	
	public void updateBoard(int boardNo, String title, String content) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, boardNo);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	public void deleteBoard(int boardNo) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	

	@Override
	public boolean setInvisible(int no) {
		// 비공개처리만들라햇는데시간이없네여;;
		return false;
	}

	//수정가능한 권한 여부 질의
	@Override
	public boolean isUpdatable(int bNo, int no) {
		if(no == 0) return false;
		Board board = getBoard(bNo);
		MemberCon mCon = new MemberDAO();
		Member member = mCon.getMember(no);
		return (member != null && (board.getMemberNo() == member.getMemberNo() ||  mCon.isAdmin(member.getMemberNo())))?true:false;
	}
}
