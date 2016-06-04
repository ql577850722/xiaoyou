package xiaoyou.service.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xiaoyou.po.CommentsPO;
import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;
import xiaoyou.service.CommentsService;
import xiaoyou.service.LogService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CommentsServiceImplTest {

	@Autowired
	private CommentsService commentsService;
	@Test
	public void testAddTalk() {
		CommentsPO po=new CommentsPO(1,"不管怎样","10002");
		int result=commentsService.insertComments(po);
		System.out.println(result);
		assertNotNull("����ʧ��!!!", result);
	}

	
}
