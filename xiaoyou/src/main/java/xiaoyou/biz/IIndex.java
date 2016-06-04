package xiaoyou.biz;

import java.util.List;
import java.util.Map;

public interface IIndex {

	public List<Map<String, Object>> snameFind(Object sname);
	
	public List<Map<String,Object>> findAll(Object u_id);
}
