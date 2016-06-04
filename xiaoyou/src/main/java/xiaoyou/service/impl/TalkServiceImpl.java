package xiaoyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xiaoyou.mapper.LogMapper;
import xiaoyou.mapper.TalkMapper;
import xiaoyou.po.CommentsPO;
import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;
import xiaoyou.service.LogService;
import xiaoyou.service.TalkService;
@Service("talkService")
public class TalkServiceImpl implements TalkService {
	@Autowired
	private TalkMapper talkMapper;

	@Override
	public List<logPO> findAllContents(int talk_id) {
		// TODO Auto-generated method stub
		return talkMapper.getAllContents(talk_id);
	}


}
