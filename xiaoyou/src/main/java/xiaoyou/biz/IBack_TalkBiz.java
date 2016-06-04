package xiaoyou.biz;

import java.util.List;

import xiaoyou.po.logPO;

public interface IBack_TalkBiz {
		//用户说说信息查找分页
		public List<logPO> findByPage(Integer pageNo,Integer pageSize);
		
		public int getCount();
		
		
}
