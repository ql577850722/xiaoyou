package xiaoyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xiaoyou.mapper.LogMapper;
import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;
import xiaoyou.service.LogService;
@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;


	public int addTalk(logPO po) {
		return logMapper.getTalk(po);
	}


	@Override
	public List<logPO> findLogById(logPO po) {
		// TODO Auto-generated method stub
		return logMapper.getLogById(po);
	}


//	public List<CommonPO> findAllContents(CommonPO po) {
//		return logMapper.getAllContents(po);
//	}
}
