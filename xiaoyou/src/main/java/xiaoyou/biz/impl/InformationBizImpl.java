package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xiaoyou.biz.IInformationBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.UserInfoPO;
import xiaoyou.po.photoPO;

public class InformationBizImpl implements IInformationBiz{

	DBHelper db = new DBHelper();
	//存储聊天记录
	public int sent(String chat_user_id,String chat_friend_id,String chat_text) {
		String sql = "insert into chat values(chat_id.nextval,?,?,?,sysdate,null,null)";
		List<Object> params = new ArrayList<Object>();
		params.add(chat_user_id);
		params.add(chat_friend_id);
		params.add(chat_text);
		int flag = db.update(sql, params);
		if(flag>0){
			return 1;
		}
		return 0;
	}
	
	//查询用户信息
	public List<UserInfoPO> perfectInfor(int u_id){
		String sql = "select u_name,u_email,u_sex,u_birth,u_province,u_city,u_area,u_school,u_academy,u_grade,u_stature,u_weight,u_blood,u_qq,u_tel,u_wechat from userInfo where u_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(u_id);
		List<UserInfoPO> list = db.find(sql, params, UserInfoPO.class);
		return list;
	}
	
	//修改用户信息
	public int updateUserinfo(UserInfoPO po){
		String sql = "update userInfo set u_stature=?,u_weight=?,u_blood=?,u_tel=?,u_qq=?,u_wechat=? where u_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_stature());
		params.add(po.getU_weight());
		params.add(po.getU_blood());
		params.add(po.getU_tel());
		params.add(po.getU_qq());
		params.add(po.getU_wechat());
		params.add(po.getU_id());
		int flag = db.update(sql, params);
		return flag;
	}
	
	//修改交友宣言
	public int updateWrite(UserInfoPO po){
		String sql ="update userInfo set u_text=? where u_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_text());
		params.add(po.getU_id());
		int flag = db.update(sql, params);
		return flag;
	}

	//上传图片
	public int add(photoPO po) {
		String sql = "insert into photo values(seq_photo_id.nextval,?,?,default,default,null,null)";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_id());
		params.add(po.getPhoto_path());
		int flag = db.update(sql, params);
		return flag;
	}
	
	//上传头像
	public int sentPortrait(UserInfoPO po){
		String sql = "update userInfo set u_photo=? where u_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_photo());
		params.add(po.getU_id());
		int flag = db.update(sql, params);
		return flag;
	}
	
	//查询图片
	public List<photoPO> searchPhoto(int u_id){
		photoPO po = new photoPO();
			String sql = "select photo_path from photo where u_id = ?";
			List<Object> params = new ArrayList<Object>();
			params.add(u_id);
			List<photoPO> list = db.find(sql, params, photoPO.class);
		return list;
	} 
}
