package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import xiaoyou.bean.Activity;
import xiaoyou.biz.IActiveContent;
import xiaoyou.biz.IActivity;
import xiaoyou.biz.impl.ActivityContentImpl;
import xiaoyou.biz.impl.ActivityImpl;
import xiaoyou.utils.SessionAttributeNames;
import xiaoyou.utils.UploadUtil;

public class ActiveServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	private static IActivity activity=new ActivityImpl();
	private static IActiveContent  activityContent=new ActivityContentImpl();
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
		
		if("addActive".equals(op)){
			addActive(request,response);
		}else if("getAllactive".equals(op)){
			getAllactive(request,response);
		}else if("getActiveid".equals(op)){
			getActiveid(request,response);
		}else if("getCityChoice".equals(op)){
			getCityChoice(request,response);
		}else if("getAllactive1".equals(op)){
			getAllactive1(request,response);
		}else if("getCityName".equals(op)){
			getCityName(request,response);
		}else if("cityFind".equals(op)){
			cityFind(request,response);
		}else if("getPages".equals(op)){
			getPages(request,response);
		}else if("getPages1".equals(op)){
			getPages1(request,response);
		}
	}
	
	private void addActive(HttpServletRequest request, HttpServletResponse response) {
		PageContext context=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 8192, true);
		try {
			Map<String,String> map=UploadUtil.upload(context);
			Activity ac=new Activity();
			String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
			String u_name = (String)session.getAttribute(SessionAttributeNames.u_name);
			int u_id = Integer.parseInt(uid);
			ac.setU_id(u_id);
			ac.setU_name(u_name);
			ac.setAname(map.get("aname"));
			ac.setAstarttime(map.get("astarttime"));
			ac.setAadd(map.get("aadd"));
			ac.setAtype(map.get("atype"));
			ac.setAexpend(Double.valueOf(map.get("aexpend")));
			ac.setAcity(map.get("acity"));
			ac.setAperson(Integer.parseInt((map.get("aperson"))));
			ac.setAdate(map.get("adate"));
			ac.setAcontent(map.get("acontent"));
			ac.setAphoto(map.get("photo"));
//			System.out.println(map);
			out.print(activity.addActivity(ac));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 鑾峰彇琛ㄤ腑鏁版嵁
	 */
	private void getAllactive(HttpServletRequest request, HttpServletResponse response) {
		/*int pageNo=1;
		
		PageUtil pu=new PageUtil();
		pu.setPageNo(pageNo);
		pu.setPageSize(9);
		List<Activity> list=activity.find(pu.getPageNo(),pu.getPageSize());
//		System.out.println(list+"-----------");
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		//灏唈son瀛樺叆JSONObject
		jb.put("allactivity",json);
		out.print(jb.toString());
		out.flush();
		out.close(); */
	}
	
	//鍒嗛〉鏌ヨ
	private void getAllactive1(HttpServletRequest request, HttpServletResponse response) {
		/*int pageNo=Integer.parseInt(request.getParameter("new_current_page"));
		System.out.println(pageNo+"---pageNo---");
		System.out.println(pageNo+"--椤垫暟");
//		int page=(Integer) obj;
//		System.out.println("---椤电爜--"+page);
		PageUtil pu=new PageUtil();
		pu.setPageNo(pageNo);
		pu.setPageSize(9);
		List<Activity> list=activity.find(pu.getPageNo(),pu.getPageSize());
		System.out.println(list+"-----------");
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		//灏唈son瀛樺叆JSONObject
		jb.put("allactivity1",json);
		out.print(jb.toString());
		out.flush();
		out.close(); */
	}
	
	//鑾峰彇鎬婚〉鏁�
	private void getPages(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> pages=activity.findNum();
		System.out.println(pages);
		out.print(pages.get(0).get("COUNT(*)"));
		out.flush();
		out.close();
	}
	
	
	
	/**
	 * 鑾峰彇娲诲姩id
	 */
	private void getActiveid(HttpServletRequest request, HttpServletResponse response) {
		String acid=request.getParameter("acid");
		session.setAttribute(SessionAttributeNames.ACID, acid);
//		Object obj=session.getAttribute(SessionAttributeNames.ACID);
//		System.out.println(obj+"--obj--");
//		List<ActivityContent> list=activityContent.findOne(obj);
//		System.out.println(list+"------鑾峰彇娲诲姩id-----");
//		json=JSONArray.fromObject(list);
//		jb=new JSONObject();
//		//灏唈son瀛樺叆JSONObject
//		jb.put("activeid",json);
//		out.print(jb.toString());
//		out.flush();
//		out.close();
	}
	
	/**
	 * 鑾峰彇鍩庡競鏌ヨ娲诲姩淇℃伅
	 */
	private void getCityChoice(HttpServletRequest request, HttpServletResponse response) {
		/*String cityChoice=request.getParameter("cityChoice");
		int pageNo=1;
		session=request.getSession();
		session.setAttribute(SessionAttributeNames.CITYCHOICE, cityChoice);
		Object obj=session.getAttribute(SessionAttributeNames.CITYCHOICE);
		PageUtil pu=new PageUtil();
		pu.setPageNo(pageNo);
		pu.setPageSize(9);
		List<Map<String, Object>> list=activity.findCityActivity(obj,pu.getPageNo(),pu.getPageSize());
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		//灏唈son瀛樺叆JSONObject
		jb.put("cityActivity",json);
		out.print(jb.toString());
		out.flush();
		out.close();*/
	}
	
	
	//鑾峰彇鎬婚〉鏁�--city
	private void getPages1(HttpServletRequest request, HttpServletResponse response) {
		Object obj=session.getAttribute(SessionAttributeNames.CITYCHOICE);
		List<Map<String, Object>> pages1=activity.findNum(obj);
		System.out.println(pages1);
		out.print(pages1.get(0).get("COUNT(*)"));
		out.flush();
		out.close();
	}
	/**
	 * 鑾峰彇瀹氫綅鍒扮殑鍩庡競
	 */
	private void getCityName(HttpServletRequest request, HttpServletResponse response) {
		String ncity=request.getParameter("ncity");
		session=request.getSession();
		session.setAttribute(SessionAttributeNames.NCITY, ncity);
	}
	
	/**
	 * 鏍规嵁瀹氫綅鍒扮殑鍩庡競鍚嶆悳绱㈢敤鎴�
	 */
	private void cityFind(HttpServletRequest request, HttpServletResponse response) {
	/*	Object obj=session.getAttribute(SessionAttributeNames.NCITY);

		List<Map<String, Object>> list=activity.findCityPerson(obj);
		System.out.println(list+"-----------");
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		//灏唈son瀛樺叆JSONObject
		jb.put("cityPerson",json);
		out.print(jb.toString());
		out.flush();
		out.close();*/
	}
	
//	private void getCityActivity(HttpServletRequest request, HttpServletResponse response) {
//		Object obj=session.getAttribute(SessionAttributeNames.CITYCHOICE);
//		System.out.println(obj+"----obj");
//		List<Map<String, Object>> list=activity.findCityActivity(obj);
//		System.out.println(list+"-----------");
//		json=JSONArray.fromObject(list);
//		jb=new JSONObject();
//		//灏唈son瀛樺叆JSONObject
//		jb.put("cityActivity",json);
//		out.print(jb.toString());
//		out.flush();
//		out.close();
//	}
}
