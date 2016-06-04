package xiaoyou.biz;

import java.util.List;
import xiaoyou.po.logPO;
import xiaoyou.vo.TalkCommentsVO;
import xiaoyou.vo.TalkVO;

public interface ILogBiz {

	/**
	 * 查询说说和评论
	 * 
	 */
	public List<TalkCommentsVO> findByUid(TalkCommentsVO vo);
//	public List<TalkVO> findByUid(TalkVO vo) ;
	
	/**
	 * 添加说说上传图片
	 * 
	 */
	public boolean add(logPO po);
	/**
	 * 删除说说
	 * 
	 */
	public boolean delete(logPO po);

}
