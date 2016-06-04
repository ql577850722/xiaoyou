package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;


import xiaoyou.biz.IAdminInfo;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.AdminInfoPO;

public class AdminInfoBizImpl implements IAdminInfo {
	DBHelper  db=new DBHelper();
	
	//管理员登录
	public boolean adminInfoLogin(AdminInfoPO po) {
		String sql="select * from adminInfo where admin_name=? and admin_pwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAdmin_name());
		params.add(po.getAdmin_pwd());
		List<AdminInfoPO> list=db.find(sql, params,AdminInfoPO.class);
		
		if(list.size()>0){
			String sql1="update admininfo set admin_status=1 where admin_name=?";
			List<Object> params1=new ArrayList<Object>();
			params1.add(po.getAdmin_name());
			db.update(sql1, params1);
			return true;			
		}else{
			return false;
		}
	}
	
	public List<AdminInfoPO> findByPage(Integer pageNo,Integer pageSize) {
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		if(null==pageNo&&null==pageSize){
			String sql="select * from admininfo order by admin_id desc";
			sb.append(sql);
		}else if(null!=pageNo&&null!=pageSize){
			String sql="select * from(select a .*,rownum rn from"+"(select * from adminInfo order by admin_id desc)a"+
						" where rownum<="+pageSize*pageNo+")b where rn>"+pageSize*(pageNo-1);
			sb.append(sql);
		 }
		return db.find(sb.toString(),params,AdminInfoPO.class);
	}
	
	public int getCount() {
		String sql="select count(*) from adminInfo";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}

	/**
	 * 登录后，变更管理员状态
	 */
	public List<AdminInfoPO> updataAdmin(AdminInfoPO po) {
		String sql="update admininfo set admin_status=1 where admin_name=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAdmin_name());
		db.update(sql, params);
		return null;
	}

	//添加管理员
	public boolean addAdmin(AdminInfoPO po) {
		String sql="insert into adminInfo values(seq_admin_id.nextval,?,?,0,null,null)";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAdmin_name());
		params.add(po.getAdmin_pwd());
		int flag=db.update(sql, params);
		if(flag!=0){
			return true;
		}
		return false;
	}

	//删除管理员信息
	public boolean removAdmin(AdminInfoPO po) {
		String sql="delete from adminInfo where admin_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAdmin_id());
		int flag=db.update(sql, params);
		if(flag!=0){
			return true;
		}
		return false;
	}

}
