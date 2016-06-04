package xiaoyou.biz;

import java.util.List;
import java.util.Map;

import xiaoyou.bean.Activity;

public interface IActivity {
	/**
	 * 插入数据到数据库
	 * @param ac
	 * @return
	 */
	public int addActivity(Activity ac);
	
	/**
	 * 查询Activity表中的所有数据
	 */
	public List<Activity> find(int pageNo,int pageSize);

	public List<Map<String, Object>> findCityActivity(Object obj,int pageNo,int pageSize);

//	public List<Activity> findOne(Object obj);
	
	/**
	 * 查询Activity表中数据行数
	 */
	public List<Map<String, Object>> findNum();

	public List<Map<String, Object>> findCityPerson(Object obj);

	public List<Map<String, Object>> findNum(Object obj);
	
	
}
