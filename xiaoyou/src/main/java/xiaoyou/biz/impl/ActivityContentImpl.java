package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;

import xiaoyou.bean.Activity;
import xiaoyou.bean.ActivityContent;
import xiaoyou.biz.IActiveContent;
import xiaoyou.dao.DBHelper;
import xiaoyou.utils.SessionAttributeNames;

public class ActivityContentImpl implements IActiveContent {

	DBHelper db=new DBHelper();
	public <T> List<T> findActivity(ActivityContent ac) {
		String sql="select from activity where acid="+SessionAttributeNames.ACID;
		List<Object> params=new ArrayList<Object>();
		System.out.println("123");
		return db.find(sql, params, ActivityContent.class);
	}


	/**
	 * 根据acid查询Activity表中的所有数据
	 */
	public List<ActivityContent> findOne(Object obj) {
		String sql="select u_id,u_name,acid,aname,astarttime,aadd,atype,aexpend,acity,aperson,adate,acontent,aphoto from activity where acid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(obj);
		
		return db.find(sql, params, Activity.class);
	}
}
