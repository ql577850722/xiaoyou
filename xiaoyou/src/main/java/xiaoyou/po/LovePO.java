package xiaoyou.po;

public class LovePO {
//	s_id int,--编号
//	u_id int,--用户id
//	s_partner int,--配对对象id
//	s_time date,--秀恩爱时间
//	s_content varchar2(1000),--秀恩爱内容
//	s_image_path varchar2(500),--秀恩爱照片路径
//	s_temp varchar2(400),--备用字段
//	s_flag varchar2(400)--备用字段
	private int s_id;//编号
	private int u_id;//用户id
	private int s_partner;//配对对象id
	private String s_time;//秀恩爱时间
	private String s_content;//秀恩爱内容
	private String s_image_path;//秀恩爱照片路径
	private String s_temp;//备用字段
	private String s_flag;//备用字段
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getS_partner() {
		return s_partner;
	}
	public void setS_partner(int s_partner) {
		this.s_partner = s_partner;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public String getS_image_path() {
		return s_image_path;
	}
	public void setS_image_path(String s_image_path) {
		this.s_image_path = s_image_path;
	}
	public String getS_temp() {
		return s_temp;
	}
	public void setS_temp(String s_temp) {
		this.s_temp = s_temp;
	}
	public String getS_flag() {
		return s_flag;
	}
	public void setS_flag(String s_flag) {
		this.s_flag = s_flag;
	}
	
}
