package model;

public class BoardDTO implements Board{
	private int boardNo;
	private String title;
	private String regtime;
	private String upRegtime;
	private int hits;
	private int memberNo;
	private String content;
	


	public BoardDTO(int boardNo, String title, String regtime, String upRegtime, int hits, int memberNo, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.regtime = regtime;
		this.upRegtime = upRegtime;
		this.hits = hits;
		this.setMemberNo(memberNo);
		this.content = content;
	}
	
	public BoardDTO(String title, String regtime, String upRegtime, int hits, int memberNo, String content) {
		this(0, title, regtime, upRegtime, hits, memberNo, content);
	}
	
	public BoardDTO(String title, String content) {
		this(0,title,"","",0,0,content);
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setNum(int num) {
		this.boardNo = num;
	}

	public String getUpRegtime() {
		return upRegtime;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setUpRegtime(String upRegtime) {
		this.upRegtime = upRegtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + boardNo + ", writer=" + ", title=" + title + ", content=" + content
			+ ", regtime=" + regtime + ", hits=" + hits + "]";
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	
}
