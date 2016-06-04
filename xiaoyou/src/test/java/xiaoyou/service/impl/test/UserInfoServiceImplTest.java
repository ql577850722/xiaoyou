package xiaoyou.service.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xiaoyou.po.UserInfoPO;
import xiaoyou.service.UserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserInfoServiceImplTest {

	@Autowired
	private UserInfoService userInfoService;
	@Test
	public void testLogin() {
		UserInfoPO userInfo = new UserInfoPO("577850722@qq.com","aaaaaa");
		userInfo = userInfoService.login(userInfo);
		System.out.println(userInfo);
		assertNotNull("µÇÂ¼Ê§°Ü!!!", userInfo);
	}

}
