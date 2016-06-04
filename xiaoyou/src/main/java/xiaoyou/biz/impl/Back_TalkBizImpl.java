package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;

import xiaoyou.biz.IBack_TalkBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.logPO;

public class Back_TalkBizImpl implements IBack_TalkBiz {
	DBHelper db=new DBHelper();
	
	
	public List<logPO> findByPage(Integer pageNo,Integer pageSize) {
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		if(null==pageNo&&null==pageSize){
			String sql="select * from talk order by talk_id desc";
			sb.append(sql);
		}else if(null!=pageNo&&null!=pageSize){
			String sql="select * from(select a .*,rownum rn from"+"(select * from talk order by talk_id desc)a"+
						" where rownum<="+pageSize*pageNo+")b where rn>"+pageSize*(pageNo-1);			
			sb.append(sql);
		 }
		return db.find(sb.toString(),params,logPO.class);
	}
	
	
	public int getCount() {
		String sql="select count(*) from talk";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}
}
