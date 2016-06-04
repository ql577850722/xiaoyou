package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xiaoyou.biz.IIndex;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.UserInfoPO;

public class IndexImpl implements IIndex{
	DBHelper db=new DBHelper();
	public List<Map<String, Object>> snameFind(Object sname) {
		String sql="select * from userInfo u where u.u_name like '%"+sname+"%' "
		+"or u.u_id like '%"+sname+"%' "
		+"or u.u_sex like '%"+sname+"%' "
		+"or u_province like '%"+sname+"%' "
		+"or u_city like '%"+sname+"%' "
		+"or u_area like '%"+sname+"%' "
		+"or u_school like '%"+sname+"%' "
		+"or u_grade like '%"+sname+"%'";
		
		
		List<Object> params=new ArrayList<Object>();
		return db.select(sql, params);
	}
	
	/**
	 * 查询所有用户信息
	 */
	public List<Map<String,Object>> findAll(Object u_id) {	
		System.out.println(u_id+"---uid");
		String sql="select * from userInfo where u_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(u_id);
		return db.select(sql, params);
	}

}
