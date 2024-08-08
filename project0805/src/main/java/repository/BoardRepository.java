package repository;

import java.util.List;

import dto.BoardDTO;
import dto.ReplyDTO;

public interface BoardRepository {
	final static String BOARD_LIST = "select * from board";
	final static String BOARD_WHERE_WRITER = "select * from board where memberNo = ?";
	final static String BOARD_WHERE_NUM = "select * from board where boardNo = ?";
	final static String BOARD_INSERT = "insert into board"
			+ "(title, regtime, upRegtime, hits, memberNo, content) "
			+ "values(?, now(), now(), 0, ?, ?)";
	final static String BOARD_UPDATE = "update board set title=?, content=? ,upRegtime = now() where boardNo=?";
	final static String BOARD_DELETE = "delete from board where boardNo=?";
	final static String BOARD_HITS_INCREMENT= "update board set hits = hits + 1 where boardNo=?";
	
	public BoardDTO getBoard(int no);
	boolean setInvisible(int no);
	List<BoardDTO> getBoardList();
	List<BoardDTO> getBoardList(int memberNo);
	void increaseHits(int no);
	boolean insertBoard(BoardDTO dto);
	void deleteBoard(int no);
	void updateBoard(int no, String title, String content);
	boolean isWriter(int bNo, int mNo);
}
