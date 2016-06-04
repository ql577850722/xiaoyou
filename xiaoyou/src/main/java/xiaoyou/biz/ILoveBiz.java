package xiaoyou.biz;

import java.util.List;

import xiaoyou.po.LovePO;

public interface ILoveBiz {
	/**
	 * 查看秀恩爱
	 * 
	 */
	public List<LovePO> selectLove(LovePO po);
	/**
	 * 发表秀恩爱
	 * 
	 */
	public boolean addLove(LovePO po);
}
