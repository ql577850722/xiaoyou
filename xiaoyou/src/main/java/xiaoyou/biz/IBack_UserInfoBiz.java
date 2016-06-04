package xiaoyou.biz;

import java.util.List;
import java.util.Map;

import xiaoyou.po.UserInfoPO;

public interface IBack_UserInfoBiz {
	
			public List<UserInfoPO> findByID(UserInfoPO po);
			//用户信息查找分页
			public List<UserInfoPO> findByPage(Integer pageNo,Integer pageSize);
			
			public int getCount();
}
