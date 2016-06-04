package xiaoyou.service;

import java.util.List;

import xiaoyou.po.CommentsPO;
import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;

public interface TalkService {


	List<logPO> findAllContents(int talk_id);
	

}
