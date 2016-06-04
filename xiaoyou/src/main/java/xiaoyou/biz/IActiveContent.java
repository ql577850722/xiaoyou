package xiaoyou.biz;

import java.util.List;

import xiaoyou.bean.Activity;
import xiaoyou.bean.ActivityContent;

public interface IActiveContent {
	/**
	 * 从数据库中查询数据
	 * @param ac
	 * @return
	 */
	public <T> List<T>  findActivity(ActivityContent ac);
	
	
	/**
	 * 根据acid查询Activity表中的所有数据
	 */
	public List<ActivityContent> findOne(Object obj);
}
