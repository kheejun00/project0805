package repository;

import java.util.List;

import dto.ReplyDTO;

public interface ReplyRepository {
	final static String REPLY_LIST_BOARDNO = "select * from reply where boardNo = ?";
	final static String REPLY_INSERT = "insert into reply(regdate, updated, content, boardNo, memberNo)"
			+ "values(now(), false, ?, ?, ?)";
	
	boolean insertReply(String content, int boardNo, int memberNo);
	boolean deleteReply(int replyNo);
	boolean updateReply(int replyNo, String content);
	
	List<ReplyDTO> getReplyFromBoard(int bNo);
	List<ReplyDTO> getReplyFromMember(int mNo);
}
