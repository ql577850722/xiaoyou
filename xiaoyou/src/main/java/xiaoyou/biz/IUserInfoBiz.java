package xiaoyou.biz;

import java.util.List;
import java.util.Map;

import xiaoyou.po.UserInfoPO;

public interface IUserInfoBiz {
		//登录方法
		public  UserInfoPO  login(UserInfoPO po);
		
		//用户注册
		public boolean  register(UserInfoPO  po);
		
		//查看用户信息
		public List<Map<String,Object>> findAll(UserInfoPO  po);
		
		//验证呢称是否重复
		public boolean userNameReg(UserInfoPO po);
		
		//邮箱验证
		public boolean userEmailReg(UserInfoPO po);
		
		//找回密码
		public boolean userPwdBack(UserInfoPO po);
		
}
