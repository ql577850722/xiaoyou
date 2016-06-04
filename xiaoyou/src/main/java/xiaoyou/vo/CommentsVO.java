package xiaoyou.vo;

public class CommentsVO {
//	c.c_id,c.talk_id,c.c_text,c.talking_id,c.c_flag
//	 ,t.u_id,u.u_name,u.u_photo
	private int c_id;//评论编号
	private int talk_id;//说说编号
	private String c_text;//评论内容
	private int talking_id;//评论者编号
	private int u_id;//用户编号
	private String u_name;//用户姓名
	private String u_photo;//用户图像
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
	public int getTalking_id() {
		return talking_id;
	}
	public void setTalking_id(int talking_id) {
		this.talking_id = talking_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_photo() {
		return u_photo;
	}
	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}
	
	
}
