package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xiaoyou.bean.Activity;
import xiaoyou.biz.IActivity;
import xiaoyou.dao.DBHelper;
import xiaoyou.utils.SessionAttributeNames;

public class ActivityImpl implements IActivity{
	DBHelper db=new DBHelper();
	
	//插入数据到发起活动表中
	public int addActivity(Activity ac) {
		String sql="insert into activity values(?,?,seq_acid.nextval,?,?,?,?,?,?,?,?,?,?,default)";

		List<Object> params=new ArrayList<Object>();
		params.add(ac.getU_id());
		params.add(ac.getU_name());
		params.add(ac.getAname());
		params.add(ac.getAstarttime());
		params.add(ac.getAadd());
		params.add(ac.getAtype());
		params.add(ac.getAexpend());
		params.add(ac.getAcity());
		params.add(ac.getAperson());
		params.add(ac.getAdate());
		params.add(ac.getAcontent());
		if(ac.getAphoto()!=""){
			params.add(ac.getAphoto());
		}else if(ac.getAtype().equals("其他")){
			params.add("images/b1.jpg");
		}else if(ac.getAtype().equals("户外")){
			params.add("images/outside.jpg");
		}else if(ac.getAtype().equals("旅游")){
			params.add("images/travel.jpg");
		}else if(ac.getAtype().equals("舞会")){
			params.add("images/dance.jpg");
		}else if(ac.getAtype().equals("聚餐")){
			params.add("images/eat.jpeg");
		}
		
		System.out.println(ac.getAname());
		return db.update(sql, params);
	}

	
	/**
	 * 查询Activity表中的所有数据
	 */
	public List<Activity> find(int pageNo,int pageSize) {
		System.out.println(pageNo+"---"+pageSize);
//		String sql="select u_id,u_name,acid,aname,astarttime,aadd,atype,aexpend,acity,aperson,adate,acontent,aphoto from activity";
		String sql="select * from (select a.*,rownum rn from"+
					"(select * from activity where astatus=0 order by adate desc)a "+
					"where rownum<="+pageNo*pageSize+") b where rn>"+(pageNo-1)*pageSize;
		List<Object> params=new ArrayList<Object>();
		return db.find(sql, params, Activity.class);
	}


	/**
	 * 根据城市名模糊查询活动信息
	 */
	public List<Map<String, Object>> findCityActivity(Object obj,int pageNo,int pageSize) {
		String sql="select * from (select a.*,rownum rn from"+
					"(select * from activity where astatus=0 and acity like '%"+obj+"%' order by adate desc)a "+
					"where rownum<="+pageNo*pageSize+") b where rn>"+(pageNo-1)*pageSize;
		List<Object> params=new ArrayList<Object>();
		return db.select(sql, params);
	}
	
	/**
	 * 查询Activity表中数据行数
	 */
	public List<Map<String, Object>> findNum(){
		String sql="select count(*) from  activity where astatus=0";
		return db.select(sql, null);
	}
	
	public List<Map<String, Object>> findNum(Object obj){
		String sql="select count(*) from  activity where astatus=0 and acity like '%"+obj+"%'";
		return db.select(sql, null);
	}
	public List<Map<String, Object>> findCityPerson(Object obj) {
		String sql="select * from userInfo where u_city=?";
		List<Object> params=new ArrayList<Object>();
		params.add(obj);
		return db.select(sql, params);
	}
}
