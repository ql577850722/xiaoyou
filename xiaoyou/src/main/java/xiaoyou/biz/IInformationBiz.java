package xiaoyou.biz;

import java.util.List;
import java.util.Map;

import xiaoyou.po.UserInfoPO;
import xiaoyou.po.photoPO;

public interface IInformationBiz {

	public int sent(String chat_user_id,String chat_friend_id,String chat_text); 
	
	public List<UserInfoPO> perfectInfor(int u_id);
	
	public int updateUserinfo(UserInfoPO po);

	public int add(photoPO po);
	
	public List<photoPO> searchPhoto(int u_id);
	
	public int sentPortrait(UserInfoPO po);
	
	public int updateWrite(UserInfoPO po);
}
