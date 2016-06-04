package xiaoyou.biz;

import java.util.List;
import java.util.Map;

import xiaoyou.po.CommentsPO;
import xiaoyou.vo.CommentsVO;

public interface ICommentsBiz {
/**
 * 查询评论
 * 
 */
public List<CommentsVO> findByTid(CommentsVO po);

/**
 * 添加评论
 * 
 */
public List<Map<String, Object>> addComments(CommentsPO po);

/**
 * 
 * 删除评论
 */
public boolean delComments(CommentsPO po);


}
