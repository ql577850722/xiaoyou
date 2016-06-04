package xiaoyou.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import xiaoyou.po.CommonPO;
import xiaoyou.po.logPO;
import xiaoyou.service.LogService;
import xiaoyou.vo.TalkCommentsVO;
@Controller("logAction")
public class LogAction implements ModelDriven<logPO>,SessionAware{
	@Autowired
	private LogService logService;
	private logPO po;
	private File image;
	private String imageFileName;
	private List<logPO> contents;//响应的数据
	private Map<String, Object> session;
	
	public List<logPO> getContents() {
		return contents;
	}
	public void setContents(List<logPO> contents) {
		this.contents = contents;
	}
	
	
	//添加说说到数据库
	public  String add(){
		po.setTalk_image_path(imageFileName);
		LogManager.getLogger().debug("图片名字："+ imageFileName);
		int result=logService.addTalk(po);
		
		if(result>0){
			LogManager.getLogger().debug("发说说啦啦。。。。。。。");
			return "addSuccess";			
		}
		return "addFail";
	}
	//发表说说（查看说说）
//	public String publish(){
//		LogManager.getLogger().debug("查看所有的说说！！！！！！！！！！！！");
//		contents= logService.findAllContents(po);
//		
//		return "success";
//	}
	
	public String publish(){
		LogManager.getLogger().debug("查看所有的说说！！！！！！！！！！！！");
		contents=logService.findLogById(po);
		
		return "success";
	}
	@Override
	public logPO getModel() {
		po=new logPO();
		return po;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session=session;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	

 
}
