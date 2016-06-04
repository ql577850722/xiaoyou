package xiaoyou.utils;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClearSession extends ActionSupport {

	private static final long serialVersionUID = -6215447091961378507L;

	public String exit() throws Exception{
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.remove("userInfo");
		return super.execute();
	}
	
	public String msg() throws Exception{
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.remove("loginMsg");
		return super.execute();
	}
}
