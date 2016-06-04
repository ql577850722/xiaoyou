package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xiaoyou.biz.IBack_UserInfoBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.UserInfoPO;

public class Back_UserInfoBizImpl implements IBack_UserInfoBiz {
	DBHelper db=new DBHelper();
	
	
	public List<UserInfoPO> findByID(UserInfoPO po){
		String sql="select * from userInfo where u_email=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getU_email());
		List<UserInfoPO> list=db.find(sql, params, UserInfoPO.class);
//		System.out.println(list);
		if(null!=list&&list.size()>0){
			return list;
		}else{
			return null;
		}
		
	}
	
	
	public List<UserInfoPO> findByPage(Integer pageNo,Integer pageSize) {
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		if(null==pageNo&&null==pageSize){
			String sql="select * from userInfo order by u_id desc";
			sb.append(sql);
		}else if(null!=pageNo&&null!=pageSize){
			String sql="select * from(select a .*,rownum rn from"+"(select * from userInfo order by u_id desc)a"+
						" where rownum<="+pageSize*pageNo+")b where rn>"+pageSize*(pageNo-1);			
			sb.append(sql);
		 }
		return db.find(sb.toString(),params,UserInfoPO.class);
	}
	
	public int getCount() {
		String sql="select count(*) from userInfo";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}

}
