package xiaoyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xiaoyou.mapper.UserInfoMapper;
import xiaoyou.po.UserInfoPO;
import xiaoyou.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	public UserInfoPO login(UserInfoPO userInfoPO) {
		UserInfoPO userInfo = userInfoMapper.login(userInfoPO);
		return  userInfo;
	}

}
