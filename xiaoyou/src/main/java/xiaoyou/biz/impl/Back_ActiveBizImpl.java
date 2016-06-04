package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;

import xiaoyou.bean.Activity;
import xiaoyou.biz.IBack_ActiveBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.UserInfoPO;

public class Back_ActiveBizImpl implements IBack_ActiveBiz {
	DBHelper db=new DBHelper();
	
	
	public List<Activity> findByPage(Integer pageNo,Integer pageSize) {
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		if(null==pageNo&&null==pageSize){
			String sql="select * from activity where astatus=2 order by u_id desc";
			sb.append(sql);
		}else if(null!=pageNo&&null!=pageSize){
			String sql="select * from(select a .*,rownum rn from"+"(select * from activity where astatus=2 order by acid desc)a"+
						" where rownum<="+pageSize*pageNo+")b where rn>"+pageSize*(pageNo-1);			
			sb.append(sql);
		 }
		return db.find(sb.toString(),params,Activity.class);
	}
	
	
	public List<Activity> findByPage_ok(Integer pageNo,Integer pageSize) {
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		if(null==pageNo&&null==pageSize){
			String sql="select * from activity where astatus=0 order by u_id desc";
			sb.append(sql);
		}else if(null!=pageNo&&null!=pageSize){
			String sql="select * from(select a .*,rownum rn from"+"(select * from activity where astatus=0 order by acid desc)a"+
						" where rownum<="+pageSize*pageNo+")b where rn>"+pageSize*(pageNo-1);			
			sb.append(sql);
		 }
		return db.find(sb.toString(),params,Activity.class);
	}
	
	
	public List<Activity> findByPage_no(Integer pageNo,Integer pageSize) {
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		if(null==pageNo&&null==pageSize){
			String sql="select * from activity where astatus=1 order by u_id desc";
			sb.append(sql);
		}else if(null!=pageNo&&null!=pageSize){
			String sql="select * from(select a .*,rownum rn from"+"(select * from activity where astatus=1 order by acid desc)a"+
						" where rownum<="+pageSize*pageNo+")b where rn>"+pageSize*(pageNo-1);			
			sb.append(sql);
		 }
		return db.find(sb.toString(),params,Activity.class);
	}
	
	//待审核
	public int getCount() {
		String sql="select count(*) from activity where astatus=2";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}
	//审核通过
	public int getCount_ok() {
		String sql="select count(*) from activity where astatus=0";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}
	//审核未通过
	public int getCount_no() {
		String sql="select count(*) from activity where astatus=1";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}

	//活动审核通过
	public boolean okActive(Activity po) {
		String sql="update activity set astatus=0 where acid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAcid());
		int flag=db.update(sql, params);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}
	
	//活动审核未通过
	public boolean noActive(Activity po) {
		String sql="update activity set astatus=1 where acid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAcid());
		int flag=db.update(sql, params);
		if(flag==0){
			return false;
		}else{
			return true;
		}
	}

	//查询活动详细内容
	public List<Activity> findActive(Activity po) {
		String sql="select * from activity where acid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getAcid());
		List<Activity> list=db.find(sql, params, Activity.class);
		if(null!=list&&list.size()>0){
			return list;
		}else{
			return null;
		}
	}


}
