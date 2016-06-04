package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.biz.IBack_UserInfoBiz;
import xiaoyou.biz.impl.Back_UserInfoBizImpl;
import xiaoyou.po.UserInfoPO;

@SuppressWarnings("serial")
public class Back_userInfoSerlvet extends HttpServlet {
	private PrintWriter out ;
	private  IBack_UserInfoBiz  biz=new Back_UserInfoBizImpl();
	private UserInfoPO po=new UserInfoPO();
	//private JSONArray json;
	//private JSONObject jb;
	private HttpSession session;
	
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				out=response.getWriter();
				//璁剧疆缂栫爜闆�
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				String op=request.getParameter("op");
		
			if("findBypage".equals(op)){
				findBypage(request, response);
			}
			if("findByID".equals(op)){
				findByID(request,response);
			}
	
	}

		//鏍规嵁鐢ㄦ埛ID鏌ヨ鐢ㄦ埛鎵�鏈変俊鎭�
		public void findByID(HttpServletRequest request, HttpServletResponse response){
			String u_email=request.getParameter("u_email");
			po.setU_email(u_email);
			List<UserInfoPO> list=null;
			list=biz.findByID(po);

		/*	json=JSONArray.fromObject(list);
			jb=new JSONObject();
			jb.put("back_userinfo", json);
			if(null!=list && list.size()>0){
				out.print(jb.toString());
			}else{
				out.print(0);
			}*/
		}
		//鏌ヨ鎵�鏈�
		public void findBypage(HttpServletRequest request, HttpServletResponse response){
			String pageNo=request.getParameter("page");
			String pageSize=request.getParameter("rows");
			List<UserInfoPO> list=null;
			if(null==pageNo || ("").equals(pageNo) || null==pageSize || ("").equals(pageSize)){
				list=biz.findByPage(null,null);
			}else{
				list=biz.findByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
			}
		/*	json=JSONArray.fromObject(list);
			jb=new JSONObject();
			jb.put("total",(int)biz.getCount());
			jb.put("rows",json);
			out.print(jb.toString());*/
		}
	
}
