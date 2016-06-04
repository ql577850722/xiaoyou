package xiaoyou.mapper;

import java.util.List;

import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;

public interface LogMapper {

	int getTalk(logPO po);

	//List<CommonPO> getAllContents(CommonPO po);
	//List<logPO> getAllContents(logPO po);
	List<logPO> getLogById(logPO po);
}
