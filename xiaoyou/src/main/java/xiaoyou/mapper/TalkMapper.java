package xiaoyou.mapper;

import java.util.List;

import xiaoyou.po.CommentsPO;
import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;

public interface TalkMapper {

	
	List<logPO> getAllContents(int  talk_id);
	

}
