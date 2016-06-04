package xiaoyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xiaoyou.mapper.CommentsMapper;
import xiaoyou.po.CommentsPO;
import xiaoyou.service.CommentsService;
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	private CommentsMapper commentsMapper;

	@Override
	public int insertComments(CommentsPO po) {
		// TODO Auto-generated method stub
		return commentsMapper.getInsertComments(po);
	}
	
}
