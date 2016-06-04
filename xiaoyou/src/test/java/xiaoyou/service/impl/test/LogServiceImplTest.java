package xiaoyou.service.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;
import xiaoyou.service.LogService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class LogServiceImplTest {

	@Autowired
	private LogService logService;
	@Test
	public void testAddTalk() {
		logPO po=new logPO(10002,"不不不","6.jpg");
		int result=logService.addTalk(po);
		System.out.println(result);
		assertNotNull("����ʧ��!!!", result);
	}

//	@Test
//	public void testFindAllContents() {
//		CommonPO po=new CommonPO();
//		List<CommonPO> contents=logService.findAllContents(po);
//		System.out.println(contents);
//		assertNotNull("����ʧ��!!!", contents);
//	}
	
	@Test
	public void testFindAllContents() {
		logPO po=new logPO();
		List<logPO> talks=logService.findLogById(po);
		System.out.println(talks);
		assertNotNull("!!!", talks);
	}
}
