package xiaoyou.po;

public class CommonPO {

	private int u_id;//用户编号
	private String u_name;//用户姓名
	private int talk_id;//说说编号
	private String talk_content;//说说内容
	private String talk_image_path;//图片路径
	private String talk_time;//发表说说时间
	private int c_id;//评论编号
	private String c_text;//评论内容
	private String c_time;//评论时间
	private int talking_id;//评论人
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
	public int getTalk_id() {
		return talk_id;
	}
	public void setTalk_id(int talk_id) {
		this.talk_id = talk_id;
	}
	public String getTalk_content() {
		return talk_content;
	}
	public void setTalk_content(String talk_content) {
		this.talk_content = talk_content;
	}
	public String getTalk_image_path() {
		return talk_image_path;
	}
	public void setTalk_image_path(String talk_image_path) {
		this.talk_image_path = talk_image_path;
	}
	public String getTalk_time() {
		return talk_time;
	}
	public void setTalk_time(String talk_time) {
		this.talk_time = talk_time;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_text() {
		return c_text;
	}
	public void setC_text(String c_text) {
		this.c_text = c_text;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	public int getTalking_id() {
		return talking_id;
	}
	public void setTalking_id(int talking_id) {
		this.talking_id = talking_id;
	}
	@Override
	public String toString() {
		return "\nCommonPO [u_id=" + u_id + ", u_name=" + u_name + ", talk_id="
				+ talk_id + ", talk_content=" + talk_content
				+ ", talk_image_path=" + talk_image_path + ", talk_time="
				+ talk_time + ", c_id=" + c_id + ", c_text=" + c_text
				+ ", c_time=" + c_time + ", talking_id=" + talking_id + "]";
	}
	public CommonPO() {
	}
	public CommonPO(int u_id, String talk_content, String talk_image_path) {
		this.u_id = u_id;
		this.talk_content = talk_content;
		this.talk_image_path = talk_image_path;
	}
	
	
	
	
}
