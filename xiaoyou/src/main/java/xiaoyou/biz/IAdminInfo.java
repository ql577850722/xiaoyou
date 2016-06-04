package xiaoyou.biz;

import java.util.List;

import xiaoyou.po.AdminInfoPO;

public interface IAdminInfo {
		//管理员登录
		public boolean adminInfoLogin(AdminInfoPO po);
		//管理员登录
		public boolean addAdmin(AdminInfoPO po);
		
		//管理员登录
		public boolean removAdmin(AdminInfoPO po);
				
		//变更管理员状态
		public List<AdminInfoPO> updataAdmin(AdminInfoPO po);
		//管理员信息查找分页
		public List<AdminInfoPO> findByPage(Integer pageNo,Integer pageSize);
		
		public int getCount();
}
