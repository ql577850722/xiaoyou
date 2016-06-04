package xiaoyou.po;

import java.util.List;

public class logPO {
	private int talk_id;//说说编号
	private int u_id;//用户编号
	private String talk_content;//说说内容
	private String talk_image_path;//图片路径
	private String talk_time;//发说说时间
	
	//添加一个字段(评论集合)
	private List<CommentsPO> comments;
	
	public int getTalk_id() {
		return talk_id;
	}
	public void setTalk_id(int talk_id) {
		this.talk_id = talk_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
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

	public List<CommentsPO> getComments() {
		return comments;
	}
	public void setComments(List<CommentsPO> comments) {
		this.comments = comments;
	}
	
	public logPO(int u_id, String talk_content, String talk_image_path) {
		this.u_id = u_id;
		this.talk_content = talk_content;
		this.talk_image_path = talk_image_path;
	}
	public logPO() {
	}
	@Override
	public String toString() {
		return "\nlogPO [talk_id=" + talk_id + ", u_id=" + u_id
				+ ", talk_content=" + talk_content + ", talk_image_path="
				+ talk_image_path + ", talk_time=" + talk_time + ", \ncomments="
				+ comments + "]";
	}
	
	
}
