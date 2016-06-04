package xiaoyou.vo;

import java.util.ArrayList;
import java.util.List;

import xiaoyou.po.CommentsPO;

public class TalkCommentsVO  {
//	u.u_id,u.u_name,u.u_photo,u.u_temp,t.talk_id,t.talk_content,t.talk_image_path
//	 ,to_char(t.talk_time,'yyyy-MM-dd HH24:mi:ss') talk_time ,t.talk_flag,c.c_id,c.c_text
//	 ,c.talking_id,to_char(c.c_time,'yyyy-MM-dd HH24:mi:ss') c_time from talk t inner join userinfo u  on u.u_id=t.u_id inner join 
//	 comments c on c.talk_id=t.talk_id
	private int u_id;//用户id 
	private String u_name;//用户姓名
	private String u_photo;//用户图像
	private String u_temp;//备用字段
	private int talk_id;//说说编号
	private String talk_content;//说说内容
	private String talk_image_path;//发表的图片路径
	private String talk_time;//发说说的时间
	private String talk_flag;//备用字段
	
	private List<CommentsPO> list=new ArrayList<CommentsPO>();
	
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
	public String getU_temp() {
		return u_temp;
	}
	public void setU_temp(String u_temp) {
		this.u_temp = u_temp;
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
	public String getTalk_flag() {
		return talk_flag;
	}
	public void setTalk_flag(String talk_flag) {
		this.talk_flag = talk_flag;
	}
	public List<CommentsPO> getList() {
		return list;
	}
	public void setList(List<CommentsPO> list) {
		this.list = list;
	}
	
	
}
