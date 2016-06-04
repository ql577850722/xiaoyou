package xiaoyou.biz;

import java.util.List;

import xiaoyou.po.chatInfoPO;

public interface IuserHomepageBiz {

	public int saveFriendInfo(chatInfoPO po);
	
	public List<chatInfoPO> showFriendInfo(int u_id);
}
