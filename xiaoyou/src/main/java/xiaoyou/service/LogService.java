package xiaoyou.service;

import java.util.List;

import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;

public interface LogService {

	int addTalk(logPO po);

	//List<CommonPO> findAllContents(CommonPO po);
	//List<logPO> findAllContents(logPO po);
	List<logPO> findLogById(logPO po);

}
