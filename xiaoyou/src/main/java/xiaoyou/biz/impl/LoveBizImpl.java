package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;

import xiaoyou.biz.ILoveBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.LovePO;

public class LoveBizImpl implements ILoveBiz{
	DBHelper db=new DBHelper();
	/**
	 * 
	 * 发表秀恩爱
	 */
	public boolean addLove(LovePO po) {
		String sql="insert into showlove values(seq_s_id.nextval,?,?,sysdate,?,null,null,null)";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getU_id());
		params.add(po.getS_partner());
		params.add(po.getS_content());
		int i=db.update(sql, params);
		if(i>0){
			return true;
			
		}
		return false;
	}
	/**
	 * 查看秀恩爱
	 * 
	 */
	public List<LovePO> selectLove(LovePO po) {
		String sql="";
		List<Object> params=new ArrayList<Object>();
		if(null==po){
			 sql="select * from showLove";
		
		}else{
			
			sql="select * from showLove where u_id=?";
			params.add(po.getU_id());
			
		} 
			
		return db.find(sql, params, LovePO.class);
		
		
	}

	
	
	
}
