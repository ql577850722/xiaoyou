package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.biz.IuserHomepageBiz;
import xiaoyou.biz.impl.userHomepageBizImpl;
import xiaoyou.po.chatInfoPO;
import xiaoyou.utils.SessionAttributeNames;

public class userHomepageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PrintWriter out1;
	private IuserHomepageBiz biz = new userHomepageBizImpl();
	private chatInfoPO po = new chatInfoPO();
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		out1 = response.getWriter();
		// 璁剧疆缂栫爜闆�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		session = request.getSession();
		String op = request.getParameter("op");
		if("makeFriendInfo".equals(op)){
			makeFriendInfo(request,response);
			System.out.println(1);
		}else if(("showFriend").equals(op)){
			showFriend(request, response);
		}
	}

	//鏄剧ず濂藉弸鍒楄〃
	private void showFriend(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
		int u_id = Integer.parseInt(uid);
		List<chatInfoPO> list = biz.showFriendInfo(u_id);
		for(chatInfoPO cip : list) {
			System.out.println(cip.toString()+"锛侊紒锛�");
		}
		/*JSONArray json = JSONArray.fromObject(list);
		JSONObject jb = new JSONObject();
		response.setContentType("text/html;charset=UTF-8");
		jb.put("showFriend", list);
		if(list.size()>0){
			out1.print(jb.toString());
		}
		out1.flush();
		out1.close();*/
	}

	//娣诲姞濂藉弸
	private void makeFriendInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
		int u_id = Integer.parseInt(uid);
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		String f_name = request.getParameter("f_name");
		
		po.setU_id(u_id);
		po.setfriend_id(f_id);
		po.setfriend_name(f_name);
		out1 = response.getWriter();
		int flag = biz.saveFriendInfo(po);
		if(flag>0){
			out1.print(1);
		}
		out1.flush();
		out1.close();
	}
}
