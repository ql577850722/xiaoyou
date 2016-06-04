package xiaoyou.po;

import java.io.Serializable;

/**
 * 用户表
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserInfoPO implements Serializable {
	private int u_id; // 用户ID
	private String u_name; // 用户名
	private String u_email; // 邮箱
	private String u_pwd; // 密码
	private String u_sex; // 性别
	private String u_birth; // 出生日期
	private String u_province; // 省份
	private String u_city; // 城市
	private String u_area; // 地区
	private String u_school; // 学校
	private String u_academy; // 学院
	private String u_grade; // 入学时间
	private String u_photo; // 头像
	private String u_stature; // 身高
	private String u_weight; // 体重
	private String u_blood; // 血型
	private String u_qq; // qq号
	private String u_tel; // 手机号码
	private String u_wechat; // 微信号
	private String u_text; // 交友宣言
	private String u_status; // 状态
	private String u_temp; // 备用字段
	private String u_flag; // 备用字段

	private String message;

	public UserInfoPO() {
	}

	public UserInfoPO(String u_email, String u_pwd) {
		this.u_email = u_email;
		this.u_pwd = u_pwd;
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

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public String getU_birth() {
		return u_birth;
	}

	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}

	public String getU_province() {
		return u_province;
	}

	public void setU_province(String u_province) {
		this.u_province = u_province;
	}

	public String getU_city() {
		return u_city;
	}

	public void setU_city(String u_city) {
		this.u_city = u_city;
	}

	public String getU_area() {
		return u_area;
	}

	public void setU_area(String u_area) {
		this.u_area = u_area;
	}

	public String getU_school() {
		return u_school;
	}

	public void setU_school(String u_school) {
		this.u_school = u_school;
	}

	public String getU_academy() {
		return u_academy;
	}

	public void setU_academy(String u_academy) {
		this.u_academy = u_academy;
	}

	public String getU_grade() {
		return u_grade;
	}

	public void setU_grade(String u_grade) {
		this.u_grade = u_grade;
	}

	public String getU_photo() {
		return u_photo;
	}

	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}

	public String getU_stature() {
		return u_stature;
	}

	public void setU_stature(String u_stature) {
		this.u_stature = u_stature;
	}

	public String getU_weight() {
		return u_weight;
	}

	public void setU_weight(String u_weight) {
		this.u_weight = u_weight;
	}

	public String getU_blood() {
		return u_blood;
	}

	public void setU_blood(String u_blood) {
		this.u_blood = u_blood;
	}

	public String getU_qq() {
		return u_qq;
	}

	public void setU_qq(String u_qq) {
		this.u_qq = u_qq;
	}

	public String getU_tel() {
		return u_tel;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	public String getU_wechat() {
		return u_wechat;
	}

	public void setU_wechat(String u_wechat) {
		this.u_wechat = u_wechat;
	}

	public String getU_text() {
		return u_text;
	}

	public void setU_text(String u_text) {
		this.u_text = u_text;
	}

	public String getU_status() {
		return u_status;
	}

	public void setU_status(String u_status) {
		this.u_status = u_status;
	}

	public String getU_temp() {
		return u_temp;
	}

	public void setU_temp(String u_temp) {
		this.u_temp = u_temp;
	}

	public String getU_flag() {
		return u_flag;
	}

	public void setU_flag(String u_flag) {
		this.u_flag = u_flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserInfoPO [u_id=" + u_id + ", u_name=" + u_name + ", u_email="
				+ u_email + ", u_pwd=" + u_pwd + ", u_sex=" + u_sex
				+ ", u_birth=" + u_birth + ", u_province=" + u_province
				+ ", u_city=" + u_city + ", u_area=" + u_area + ", u_school="
				+ u_school + ", u_academy=" + u_academy + ", u_grade="
				+ u_grade + ", u_photo=" + u_photo + ", u_stature=" + u_stature
				+ ", u_weight=" + u_weight + ", u_blood=" + u_blood + ", u_qq="
				+ u_qq + ", u_tel=" + u_tel + ", u_wechat=" + u_wechat
				+ ", u_text=" + u_text + ", u_status=" + u_status + ", u_temp="
				+ u_temp + ", u_flag=" + u_flag + "]";
	}

}
