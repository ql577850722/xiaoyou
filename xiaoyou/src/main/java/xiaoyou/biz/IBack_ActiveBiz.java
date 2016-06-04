package xiaoyou.biz;

import java.util.List;

import xiaoyou.bean.Activity;

public interface IBack_ActiveBiz {
	//柚子活动信息查找分页
	public List<Activity> findByPage(Integer pageNo,Integer pageSize);
	//柚子活动信息查找分页
	public List<Activity> findByPage_ok(Integer pageNo,Integer pageSize);
	//柚子活动信息查找分页
	public List<Activity> findByPage_no(Integer pageNo,Integer pageSize);
	//活动审核通过
	public boolean okActive(Activity po);
	//活动审核未通过
	public boolean noActive(Activity po);
	//查询活动详细内容
	public List<Activity> findActive(Activity po);
	
	public int getCount();
	public int getCount_ok();
	public int getCount_no();
}
