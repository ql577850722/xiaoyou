package xiaoyou.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xiaoyou.biz.ICommentsBiz;
import xiaoyou.biz.impl.CommentsBizImpl;
import xiaoyou.po.CommentsPO;
import xiaoyou.vo.CommentsVO;

@SuppressWarnings("serial")
public class CommentsServlet extends HttpServlet {
	ICommentsBiz biz=new CommentsBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从页面获取op
		String op=request.getParameter("op");
		System.out.println("op="+op);
		if(op.equals("findByTid")){//根据说说编号查看编号
			findByTid(request,response);
		}else if("addComments".equals(op)) {//添加评论
			addComments(request,response);
		}	
	}

	//添加评论
	private void addComments(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			String textarea=request.getParameter("textarea");
			int talk_id=Integer.parseInt(request.getParameter("hideid"));
			String talking_id=request.getParameter("talking_id");
			CommentsPO po=new CommentsPO();
			po.setC_text(textarea);
			po.setTalk_id(talk_id);
			po.setTalking_id(talking_id);
			List<Map<String, Object>> list=biz.addComments(po);
			String c_time=(String) list.get(0).get("C_TIME");
			po.setC_time(c_time);
			/*JSONArray json =JSONArray.fromObject(po);
			JSONObject  jb = new JSONObject();
			jb.put("Comments", json);
			PrintWriter out =response.getWriter();
			//评论成功
			out.print(jb.toString());
			out.flush();
			out.close();*/
			
			
		
	}

	//查看全部评论
	private void findByTid(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			String talk_id=request.getParameter("talk_id");
			CommentsVO vo=new CommentsVO();
			vo.setTalk_id(Integer.parseInt(talk_id));
			List<CommentsVO> list=biz.findByTid(vo);
			/*JSONArray json =JSONArray.fromObject(list);
			JSONObject  jb = new JSONObject();
			jb.put("commentsList", json);
			PrintWriter out =response.getWriter();
			out.print(jb.toString());
			out.flush();
			out.close();*/
	}

}
