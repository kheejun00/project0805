package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import repository.BoardRepository;
import util.JDBCUtil;

public class BoardDAO implements BoardRepository{
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<BoardDTO> getBoardList(){
		List<BoardDTO> list = new ArrayList<>();
		
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("boardNo"), 
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
	
	public List<BoardDTO> getBoardList(int memberNo){	// 유저 번호로 부터 추출
		List<BoardDTO> list = new ArrayList<>();
		
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_WHERE_WRITER);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt("boardNo"), 
						rs.getString("title"), 
						rs.getString("regtime"), 
						rs.getString("upRegtime"), 
						rs.getInt("hits"),
						rs.getInt("memberNo"), 
						rs.getString("content"));
				list.add(dto);
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
	
	public BoardDTO getBoard(int no) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_WHERE_NUM);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			BoardDTO dto = new BoardDTO(rs.getInt("boardNo"), 
					rs.getString("title"), 
					rs.getString("regtime"), 
					rs.getString("upRegtime"), 
					rs.getInt("hits"),
					rs.getInt("memberNo"), 
					rs.getString("content"));
			return dto;
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
	
	public boolean insertBoard(BoardDTO dto) {
		con = JDBCUtil.getConnection();
		boolean result = false;
		try {
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, dto.getTitle());
			pstmt.setInt(2, dto.getMemberNo());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
			result = true;
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
		return result;
	}
	
	public void updateBoard(int no, String title, String content) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}
	public void deleteBoard(int no) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, no);
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

	@Override
	public boolean isWriter(int bNo, int mNo) {
		if(mNo == 0) return false;
		BoardDTO dto = getBoard(bNo);
		return dto!=null&&dto.getMemberNo() == mNo?true:false;
	}
}
