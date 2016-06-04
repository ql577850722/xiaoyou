package xiaoyou.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xiaoyou.biz.ILogBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.CommentsPO;
import xiaoyou.po.logPO;
import xiaoyou.vo.TalkCommentsVO;
import xiaoyou.vo.TalkVO;

public class LogBizImpl implements ILogBiz {
	DBHelper db=new DBHelper();
	
	/**
	 * 查看说说和评论
	 */
	public List<TalkCommentsVO> findByUid(TalkCommentsVO vo) {
		String sql="";
//		List<Object> params=new ArrayList<Object>();
		if(null==vo){
			sql="select *  from  talk t left join comments c on t.talk_id=c.talk_id left join userInfo u on t.u_id=u.u_id";
//		}else{
			
//			params.add(vo.getTalk_id());
		}
		List<CommentsPO> list=db.find(sql, null, CommentsPO.class);
		System.out.println(list.size());
		Map<Integer,TalkCommentsVO> map=new HashMap<Integer,TalkCommentsVO>();
		
		for(int i=0;i<list.size();i++){
			CommentsPO obj=list.get(i);
			System.out.println(obj.getTalking_id());
			int talk_id=obj.getTalk_id();
			if(map.containsKey(talk_id)){
				TalkCommentsVO talk=map.get(talk_id);
				CommentsPO po=new CommentsPO();
				po.setC_text(obj.getC_text());
				po.setTalking_id(obj.getTalking_id());
				po.setC_time(obj.getC_time());
				List commentList=talk.getList();
				commentList.add(po);
				talk.setList(commentList);
			}else{
				CommentsPO po=new CommentsPO();
				po.setC_text(obj.getC_text());
				po.setTalking_id(obj.getTalking_id());
				po.setC_time(obj.getC_time());
				List commentList=obj.getList();
				commentList.add(po);
				obj.setList(commentList);
				map.put(talk_id, obj);
			}
		}
		 List<TalkCommentsVO> talkList=new ArrayList<TalkCommentsVO>();
		for (Entry<Integer, TalkCommentsVO> entry : map.entrySet()) {
			talkList.add(entry.getValue());
		}
		return talkList;
	}

	/**
	 * 添加说说
	 * 
	 */
	public boolean add(logPO po) {
		String sql="insert into talk values(seq_talk_id.nextval,?,?,?,sysdate,null,null,null)";
		List<Object> params=new ArrayList<Object>();		 
		params.add(po.getU_id());
		params.add(po.getTalk_content());
		params.add(po.getTalk_image_path());
		int i=db.update(sql, params);
		if(i>0){
			return true;
		}
		return false;
	}

	/**
	 * 删除说说
	 * 
	 */
	public boolean delete(logPO po) {
		return false;

	}

	

}
