package xiaoyou.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import xiaoyou.po.UserInfoPO;
import xiaoyou.service.UserInfoService;
import xiaoyou.utils.ClearSession;
@Controller("userInfoAction")
public class UserInfoAction implements ModelDriven<UserInfoPO>,SessionAware{
	@Autowired
	private UserInfoService userInfoService;
	private UserInfoPO userInfo;
	private Map<String, Object> session;
	private ClearSession cs = new ClearSession();
	
	//”√ªßµ«¬º≤Ÿ◊˜
	public String login(){
		userInfo = userInfoService.login(userInfo);
		if(userInfo != null){
			session.put("userInfo", userInfo);
			return "loginSuccess";
		}else{
			session.put("loginMsg", "’ ∫≈” œ‰ªÚ√‹¬Î¥ÌŒÛ!!!");
			return "loginFail";
		}
	}

	public String exit(){
		try {
			cs.exit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "successExit";
	}
	public UserInfoPO getModel() {
		userInfo = new UserInfoPO();
		return userInfo;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	} 
	
}
