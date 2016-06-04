package xiaoyou.po;

public class AdminInfoPO {
	private int admin_id;    //编号
	private String admin_name; //名字
	private String admin_pwd;  //密码
	private int  admin_status;   //状态
	private String admin_temp;   //备用字段
	private String admin_flag ;   //备用字段
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public int getAdmin_status() {
		return admin_status;
	}
	public void setAdmin_status(int admin_status) {
		this.admin_status = admin_status;
	}
	public String getAdmin_temp() {
		return admin_temp;
	}
	public void setAdmin_temp(String admin_temp) {
		this.admin_temp = admin_temp;
	}
	public String getAdmin_flag() {
		return admin_flag;
	}
	public void setAdmin_flag(String admin_flag) {
		this.admin_flag = admin_flag;
	}
	
	
	
}
