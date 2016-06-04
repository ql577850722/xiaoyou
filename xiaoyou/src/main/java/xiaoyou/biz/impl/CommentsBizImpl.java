package xiaoyou.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xiaoyou.biz.ICommentsBiz;
import xiaoyou.dao.DBHelper;
import xiaoyou.po.CommentsPO;
import xiaoyou.vo.CommentsVO;

public class CommentsBizImpl implements ICommentsBiz  {
	DBHelper db=new DBHelper();

	/**
	 * 根据说说编号查询评论
	 * 
	 */
	public List<CommentsVO> findByTid(CommentsVO vo) {
		System.out.println("说说号\t:"+vo.getTalk_id());
		String sql="select * from comments_view where talk_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(vo.getTalk_id());
		return db.find(sql, params, CommentsVO.class);
	}
	/**
	 * 添加评论
	 */
	
	
	public List<Map<String, Object>> addComments(CommentsPO po) {
		String sql="select seq_c_id.nextval as cid from dual";
		List<Object> params=new ArrayList<Object>();
		List<Map<String, Object>> list=db.select(sql, params);
//		System.out.println(list.get(0).get("CID"));
		String id=(String)list.get(0).get("CID");
		String sql1="insert into comments values(?,?,?,?,sysdate)";//说说编号，评论内容，评论者id
		params.add(id);
		params.add(po.getTalk_id());
		params.add(po.getC_text());
		params.add(po.getTalking_id());
		int i = 0;
		try {
			i = db.update(sql1, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2="select to_char(c_time,'yyyy-MM-dd HH24:mi:ss')c_time from comments where c_id=?"; 
//		System.out.println(sql2);
		params.clear();
		params.add(id);
		List<Map<String,Object>> l=db.select(sql2, params);
		return l;
	}

	/**
	 * 删除评论
	 * 
	 */
	public boolean delComments(CommentsPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	


	
}
