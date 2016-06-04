package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.bean.Activity;
import xiaoyou.biz.IBack_ActiveBiz;
import xiaoyou.biz.impl.Back_ActiveBizImpl;

/**
 * 鍚庡彴瀵规椿鍔ㄨ〃鎿嶄綔
 */
public class Back_ActiveServlet extends CommonsServlet {
	private PrintWriter out ;
	private  IBack_ActiveBiz  biz=new Back_ActiveBizImpl();
	private Activity po=new Activity();
	//private JSONArray json;
	//private JSONObject jb;
	private HttpSession session;
	
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
		if("findBypage_ok".equals(op)){
			findBypage_ok(request,response);
		}
		if("findBypage_no".equals(op)){
			findBypage_no(request,response);
		}
		//瀹℃牳閫氳繃
		if("okActive".equals(op)){
			okActive(request,response);
		}
		//瀹℃牳閫氳繃
		if("noActive".equals(op)){
			noActive(request,response);
		}
		//鏌ョ湅娲诲姩璇︽儏
		if("findActive".equals(op)){
			findActive(request,response);
		}
		
	}
	//鏌ヨ娲诲姩璇︾粏鍐呭
	public void findActive(HttpServletRequest request,
			HttpServletResponse response){
		int acid=Integer.parseInt(request.getParameter("acid"));
		po.setAcid(acid);
		List<Activity> list=null;
		list=biz.findActive(po);
		
	/*	json=JSONArray.fromObject(list);
		jb=new JSONObject();
		jb.put("back_active", json);*/
		if(null!=list && list.size()>0){
			//out.print(jb.toString());
		}else{
			out.print(0);
		}
		
	}
	
	//瀹℃牳閫氳繃
	public void okActive(HttpServletRequest request,
			HttpServletResponse response) {
		int acid=Integer.parseInt(request.getParameter("acid")); 
		po.setAcid(acid);
		boolean falg=biz.okActive(po);
		if(falg==true){
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}

	//瀹℃牳鏈�氳繃
	public void noActive(HttpServletRequest request,
			HttpServletResponse response) {
		int acid=Integer.parseInt(request.getParameter("acid")); 
		
		po.setAcid(acid);
	
		boolean falg=biz.noActive(po);
		if(falg==true){
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}


	public void findBypage(HttpServletRequest request, HttpServletResponse response){
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		List<Activity> list=null;
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

	public void findBypage_ok(HttpServletRequest request, HttpServletResponse response){
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		List<Activity> list=null;
		if(null==pageNo || ("").equals(pageNo) || null==pageSize || ("").equals(pageSize)){
			list=biz.findByPage_ok(null,null);
		}else{
			list=biz.findByPage_ok(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		}
		/*json=JSONArray.fromObject(list);
		jb=new JSONObject();
		jb.put("total",(int)biz.getCount_ok());
		jb.put("rows",json);
		out.print(jb.toString());*/
	}

	public void findBypage_no(HttpServletRequest request, HttpServletResponse response){
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		List<Activity> list=null;
		if(null==pageNo || ("").equals(pageNo) || null==pageSize || ("").equals(pageSize)){
			list=biz.findByPage_no(null,null);
		}else{
			list=biz.findByPage_no(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		}
		/*json=JSONArray.fromObject(list);
		jb=new JSONObject();
		jb.put("total",(int)biz.getCount_no());
		jb.put("rows",json);
		out.print(jb.toString());*/
	}

}
