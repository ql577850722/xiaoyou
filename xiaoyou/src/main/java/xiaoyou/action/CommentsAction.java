package xiaoyou.action;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import xiaoyou.po.CommentsPO;
import xiaoyou.service.CommentsService;
@Controller("commentsAction")
public class CommentsAction implements ModelDriven<CommentsPO>{
	@Autowired
	private CommentsService commentsService;
	private CommentsPO po;
	//添加评论到数据库
	public String insert(){
		LogManager.getLogger().debug("insert -------CommentsPO:"+po);
		
		int result=commentsService.insertComments(po);
		if(result>0){
		/*	LogManager.getLogger().debug("评论说说");*/
			return "insertSuccess";
			
		}
		return "insertFail";
		
	}
	
	
	@Override
	public CommentsPO getModel() {
		po=new CommentsPO();
		return po;
	}
}
