package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import xiaoyou.bean.ActivityContent;
import xiaoyou.biz.IActiveContent;
import xiaoyou.biz.impl.ActivityContentImpl;
import xiaoyou.utils.SessionAttributeNames;
import xiaoyou.utils.UploadUtil;

public class ActivityContentServlet extends CommonServlet{

	private static final long serialVersionUID = 1L;
	private static IActiveContent activity=new ActivityContentImpl();
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
		
		if("findActivity".equals(op)){
			findActivity(request,response);
		}else if("getActiveid".equals(op)){
			getActiveid(request,response);
		}
	}

	private void findActivity(HttpServletRequest request,
			HttpServletResponse response) {
		PageContext context=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);

		try {
			Map<String,String> map=UploadUtil.upload(context);
			ActivityContent ac=new ActivityContent();
			ac.setU_name(map.get("u_name"));
			ac.setAcid(Integer.parseInt((map.get("acid"))));
			ac.setAname(map.get("aname"));
			ac.setAstarttime(map.get("astarttime"));
			ac.setAadd(map.get("aadd"));
			ac.setAtype(map.get("atype"));
			ac.setAexpend(Double.valueOf(map.get("aexpend")));
			ac.setAcity(map.get("acity"));
			ac.setAperson(Integer.parseInt((map.get("aperson"))));
			ac.setAdate(map.get("adate"));
			ac.setAphoto(map.get("photo"));
//			System.out.println(map);
			out.print(activity.findActivity(ac));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	/**
//	 * 获取表中数据
//	 */
//	private void getAllactive(HttpServletRequest request, HttpServletResponse response) {
//		List<Activity> list=activity.find();
//		System.out.println(list+"-----id------");
//		json=JSONArray.fromObject(list);
//		jb=new JSONObject();
//		//将json存入JSONObject
//		jb.put("allactivity",json);
//		out.print(jb.toString());
//		out.flush();
//		out.close();
//	}
	
	
	private void getActiveContent(HttpServletRequest request, HttpServletResponse response) {
		String acid=(String)request.getParameter("acid");
		
		Object obj=session.getAttribute(SessionAttributeNames.ACID);
		String sql="select u_id,u_name,aname,acid,astarttime,aadd,atype,aexpend,acity,aperson,adate,acontent,aphoto,astatus from activity where acid?";
	}
	
	
	/**
	 * 获取活动id
	 */
	private void getActiveid(HttpServletRequest request, HttpServletResponse response) {
		Object obj=session.getAttribute(SessionAttributeNames.ACID);

		/*List<ActivityContent> list=activity.findOne(obj);
		System.out.println(list+"------获取活动id-----");
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		//将json存入JSONObject
		jb.put("activeid",json);
		out.print(jb.toString());
		out.flush();
		out.close();*/
	}
}
