package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ReplyDTO;
import repository.ReplyRepository;
import util.JDBCUtil;

public class ReplyDAO implements ReplyRepository{

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public boolean insertReply(String content, int boardNo, int memberNo) {
		con = JDBCUtil.getConnection();
		boolean result = false;
		try {
			pstmt = con.prepareStatement(REPLY_INSERT);
			pstmt.setString(1, content);
			pstmt.setInt(2, boardNo);
			pstmt.setInt(3, memberNo);
			if(pstmt.executeUpdate() == 1) {
				result = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, con);
		}
		return result;
	}

	@Override
	public List<ReplyDTO> getReplyFromBoard(int bNo) {
		con = JDBCUtil.getConnection();
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();
		try {
			pstmt = con.prepareStatement(REPLY_LIST_BOARDNO);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReplyDTO(rs.getInt("replyNo"),
					rs.getString("regdate"), rs.getBoolean("updated"),
					rs.getString("content"), rs.getInt("boardNo"),
					rs.getInt("memberNo")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public boolean deleteReply(int replyNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReply(int replyNo, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ReplyDTO> getReplyFromMember(int mNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
