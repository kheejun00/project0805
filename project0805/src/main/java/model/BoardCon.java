package model;

import java.util.List;

public interface BoardCon {
	final static String BOARD_LIST = "select * from board";
	final static String BOARD_WHERE_WRITER = "select * from board where memberNo = ?";
	final static String BOARD_WHERE_NUM = "select * from board where boardNo = ?";
	final static String BOARD_INSERT = "insert into board"
			+ "(title, regtime, upRegtime, hits, memberNo, content) "
			+ "values(?, now(), now(), 0, ?, ?)";
	final static String BOARD_UPDATE = "update board set title=?, content=? ,upRegtime = now() where boardNo=?";
	final static String BOARD_DELETE = "delete from board where boardNo=?";
	final static String BOARD_HITS_INCREMENT= "update board set hits = hits + 1 where boardNo=?";
	
	public Board getBoard(int no);
	boolean setInvisible(int no);
	List<Board> getBoardList();
	List<Board> getBoardList(int memberNo);
	void increaseHits(int no);
	boolean isUpdatable(int bNo, int mNo);
	boolean insertBoard(Board board);
	void deleteBoard(int boardNo);
	void updateBoard(int boardNo, String title, String content);
	
}
