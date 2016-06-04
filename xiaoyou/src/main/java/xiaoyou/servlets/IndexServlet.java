package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.biz.IIndex;
import xiaoyou.biz.impl.IndexImpl;
import xiaoyou.utils.SessionAttributeNames;

public class IndexServlet extends CommonServlet{
	private static final long serialVersionUID = 1L;
	private static IIndex index=new IndexImpl();
	private PrintWriter out;
	//private JSONArray json;
	//private JSONObject jb;
	private HttpSession session;
	@SuppressWarnings("unused")
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request,response);
		
		String op=request.getParameter("op");
		out=response.getWriter();
		session=request.getSession();
		
		if("snamefind".equals(op)){
			snamefind(request,response);
		}else if("snamefind1".equals(op)){
			snamefind1(request,response);
		}
	}
	
	
	//根据用户昵称模糊查询
	private void snamefind(HttpServletRequest request,
			HttpServletResponse response) {
		String s_name=request.getParameter("s_name");
		System.out.println(s_name);
		session=request.getSession();
		session.setAttribute(SessionAttributeNames.S_NAME, s_name);
	}
	private void snamefind1(HttpServletRequest request,
			HttpServletResponse response) {
		
	/*	Object obj=session.getAttribute(SessionAttributeNames.S_NAME);
		List<Map<String, Object>> list=index.snameFind(obj);
		System.out.println(list+"---snamelist");
		
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		//将json存入JSONObject
		jb.put("sname",json);
		out.print(jb.toString());
		out.flush();
		out.close();*/
	}
	
}
