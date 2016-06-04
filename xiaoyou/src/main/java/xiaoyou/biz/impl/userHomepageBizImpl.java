package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.List;

import xiaoyou.biz.IuserHomepageBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.chatInfoPO;

public class userHomepageBizImpl implements IuserHomepageBiz{

	DBHelper db = new DBHelper();
	//存储好友信息
	public int saveFriendInfo(chatInfoPO po){
		String sql = "insert into friend values(seq_f_id.nextval,?,?,?,1,sysdate,'null','null')";
		List<Object> params = new ArrayList<Object>();
		params.add(po.getU_id());
		params.add(po.getfriend_id());
		params.add(po.getfriend_name());
		int flag = db.update(sql, params);
		if(flag>0){
			return 1;
		}
		return 0;
	}
	
	//显示好友列表
	public List<chatInfoPO> showFriendInfo(int u_id){
		String sql = "select u_id, friend_id, friend_name from friend where u_id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(u_id);
		List<chatInfoPO> list = db.find(sql, params, chatInfoPO.class);
		return list;
	}
}
