package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.biz.IAdminInfo;
import xiaoyou.biz.impl.AdminInfoBizImpl;
import xiaoyou.commons.MD5Encryption;
import xiaoyou.po.AdminInfoPO;
import xiaoyou.utils.SessionAttributeNames;

public class AdminInfoServlet extends HttpServlet {
	private PrintWriter out ;
	private  IAdminInfo  biz=new AdminInfoBizImpl();
	private AdminInfoPO po=new AdminInfoPO();
	//private JSONArray json;
	//private JSONObject jb;
	private HttpSession session;
	private MD5Encryption md=new MD5Encryption();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out=response.getWriter();
		//璁剧疆缂栫爜闆�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op=request.getParameter("op");
		//璋冪敤绠＄悊鍛樼櫥褰�
		if("AdminLogin".equals(op)){
			AdminLogin(request,response);
		}
		if("findBypage".equals(op)){
			findBypage(request,response);
		}
		if("addAdmin".equals(op)){
			addAdmin(request,response);
		}
		if("removAdmin".equals(op)){
			removAdmin(request,response);
		}
		
	}

	//鍒犻櫎绠＄悊鍛�
	private void removAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		int admin_id=Integer.parseInt(request.getParameter("admin_id"));
		po.setAdmin_id(admin_id);
		boolean flag=biz.removAdmin(po);
		if(flag==true){
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}



	//娣诲姞绠＄悊鍛�
	private void addAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		String admin_name=request.getParameter("admin_name");
		String admin_pwd=request.getParameter("admin_pwd"); 
		admin_pwd=md.createPassword(admin_pwd);
		po.setAdmin_name(admin_name);
		po.setAdmin_pwd(admin_pwd);
		boolean flag=biz.addAdmin(po);
		if(flag==true){
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
	}



	//绠＄悊鍛樼櫥褰�
	public void AdminLogin(HttpServletRequest request, HttpServletResponse response){
		String admin_name=request.getParameter("admin_name");
		String admin_pwd=request.getParameter("admin_pwd");
		admin_pwd=md.createPassword(admin_pwd);
		po.setAdmin_name(admin_name);
		po.setAdmin_pwd(admin_pwd);
		boolean flag=biz.adminInfoLogin(po);
		if(flag==true){
			request.getSession().setAttribute(SessionAttributeNames.admin_name,admin_name);
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();		
	}
	
	//鏌ヨ鎵�鏈�
	public void findBypage(HttpServletRequest request, HttpServletResponse response){
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		List<AdminInfoPO> list=null;
		if(null==pageNo || ("").equals(pageNo) || null==pageSize || ("").equals(pageSize)){
			list=biz.findByPage(null,null);
		}else{
			list=biz.findByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		}
		/*json=JSONArray.fromObject(list);
		jb=new JSONObject();
		jb.put("total",(int)biz.getCount());
		jb.put("rows",json);
		out.print(jb.toString());*/
	}
	

}
