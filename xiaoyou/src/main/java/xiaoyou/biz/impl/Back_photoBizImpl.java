package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;

import xiaoyou.biz.IBack_photoBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.photoPO;

public class Back_photoBizImpl implements IBack_photoBiz {
	DBHelper db=new DBHelper();
	
	
	public List<photoPO> findByPage(Integer pageNo,Integer pageSize) {
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		if(null==pageNo&&null==pageSize){
			String sql="select * from photo where photo_check=0 order by photo_id desc";
			sb.append(sql);
		}else if(null!=pageNo&&null!=pageSize){
			String sql="select * from(select a .*,rownum rn from"+"(select * from photo where photo_check=0 order by photo_id desc)a"+
						" where rownum<="+pageSize*pageNo+")b where rn>"+pageSize*(pageNo-1);			
			sb.append(sql);
		 }
		return db.find(sb.toString(),params,photoPO.class);
	}

	public int getCount() {
		String sql="select count(*) from photo where photo_check=0";
		int num=(int)db.selectPloymer(sql, null);
		return num;
	}

	public boolean noPhoto(photoPO po) {
		String sql="update photo set photo_check=2 where photo_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getPhoto_id());
		int flag=db.update(sql, params);
		if(flag!=0){
			return true;
		}
		return false;
	}

	public boolean okPhoto(photoPO po) {
		String sql="update photo set photo_check=1 where photo_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getPhoto_id()); 
		int flag=db.update(sql, params);
		if(flag!=0){
			return true;
		}
		return false;
	}
}
