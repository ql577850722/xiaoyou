package xiaoyou.po;

public class chatInfoPO {

	private int u_id;
	private int friend_id;
	private String friend_name;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getfriend_id() {
		return friend_id;
	}
	public void setfriend_id(int friend_id) {
		this.friend_id = friend_id;
	}
	public String getfriend_name() {
		return friend_name;
	}
	public void setfriend_name(String friend_name) {
		this.friend_name = friend_name;
	}
	@Override
	public String toString() {
		return "chatInfoPO [u_id=" + u_id + ", friend_id=" + friend_id + ", friend_name="
				+ friend_name + "]";
	}
	
}
