package xiaoyou.po;

import xiaoyou.vo.TalkCommentsVO;

public class CommentsPO extends TalkCommentsVO{

	
	private int c_id;//评论编号
	private int talk_id;//说说编号  外键
	private String c_text;//评论内容
	private String talking_id;//评论者 id
	private String c_time;//评论时间

	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public int getTalk_id() {
		return talk_id;
	}


	public void setTalk_id(int talk_id) {
		this.talk_id = talk_id;
	}


	public String getC_text() {
		return c_text;
	}


	public void setC_text(String c_text) {
		this.c_text = c_text;
	}


	public String getTalking_id() {
		return talking_id;
	}


	public void setTalking_id(String talking_id) {
		this.talking_id = talking_id;
	}


	public String getC_time() {
		return c_time;
	}


	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	
	
	@Override
	public String toString() {
		return "\nCommentsPO [c_id=" + c_id + ", talk_id=" + talk_id
				+ ", c_text=" + c_text + ", talking_id=" + talking_id
				+ ", c_time=" + c_time + "]";
	}


	public CommentsPO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CommentsPO(int talk_id, String c_text, String talking_id) {
		super();
		this.talk_id = talk_id;
		this.c_text = c_text;
		this.talking_id = talking_id;
	}




	
	
}
