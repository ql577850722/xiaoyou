package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.biz.IIndex;
import xiaoyou.biz.IUserInfoBiz;
import xiaoyou.biz.impl.IndexImpl;
import xiaoyou.biz.impl.UserInfoBizImpl;
import xiaoyou.commons.MD5Encryption;
import xiaoyou.po.UserInfoPO;
import xiaoyou.utils.SessionAttributeNames;

public class UserInfoServlet extends CommonsServlet {
		private PrintWriter  out;
		private IUserInfoBiz  biz=new UserInfoBizImpl();
		private UserInfoPO  po=new UserInfoPO();
		private static IIndex index=new IndexImpl();
		//private JSONArray json;
		//private JSONObject jb;
		private HttpSession session;
		private MD5Encryption md=new MD5Encryption();
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {		
			out=response.getWriter();
			//璁剧疆缂栫爜闆�
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String op=request.getParameter("op");
			//璋冪敤鐢ㄦ埛鐧诲綍鏂规硶
			if("userLogin".equals(op)){
				userLogin(request,response);
			}else
			//璋冪敤鐢ㄦ埛娉ㄥ唽鏂规硶
			if("userRegister".equals(op)){
				userRegister(request,response);
			}else
			//鍒ゆ柇鍛㈢О
			if("userNameReg".equals(op)){
				userNameReg(request,response);				
			}else
			//閭楠岃瘉
			if("userEmailReg".equals(op)){
				userEmailReg(request,response);
			}else
			//鎵惧洖瀵嗙爜
			if("userPwdBack".equals(op)){
				userPwdBack(request,response);
			}else
			if("exit".equals(op)){
				exit(request, response);
			}else
			if("getUid".equals(op)){
				getUid(request, response);
			}else
			if("uidFindall".equals(op)){
				uidFindall(request, response);
			}
			
	}
	
	
	/**
	 * 鐢ㄦ埛鐧诲綍
	 * @throws IOException 
	 */
	public void userLogin(HttpServletRequest request, HttpServletResponse response){
				/*String u_email=request.getParameter("u_email");		
				String u_pwd=request.getParameter("u_pwd");		
				String l_code=request.getParameter("l_code");
				String code=(String) request.getSession().getAttribute("code");
				u_pwd=md.createPassword(u_pwd);
				po.setU_email(u_email);				
				po.setU_pwd(u_pwd);	
				

				List<Map<String,Object>> list=biz.findAll(po);
				json=JSONArray.fromObject(list);
				jb=new JSONObject();
				int num=0;
				
				if(code.equals(l_code)){
					UserInfoPO  user=biz.login(po);
					if(user!=null){
						num=1;
						String u_id=(String) list.get(0).get("U_ID");
						String u_name=(String) list.get(0).get("U_NAME");
						session=request.getSession();
						session.setAttribute(SessionAttributeNames.u_id,u_id);
						session.setAttribute(SessionAttributeNames.u_name, u_name);
					}else{
						num=2;	
					}												
				}
				//灏唈son瀛樺叆JSONObject
				jb.put("uid",json);
				jb.put("num",num);
				out.print(jb.toString());
				out.flush();
				out.close();			*/
	}
	/**
	 * 鐢ㄦ埛娉ㄥ唽
	 */
	@SuppressWarnings("static-access")
	public void   userRegister(HttpServletRequest request, HttpServletResponse response){
	
		String u_name=request.getParameter("u_name");
		String u_email=request.getParameter("u_email");
		String u_pwd=request.getParameter("u_pwd");
		String u_sex=request.getParameter("u_sex");
		String u_birth=request.getParameter("u_birth");
		String u_province=request.getParameter("u_province");
		String u_city=request.getParameter("u_city");
		String u_area=request.getParameter("u_area");
		String u_school=request.getParameter("u_school");
		String u_academy=request.getParameter("u_academy");
		String u_grade=request.getParameter("u_grade");
		String l_code=request.getParameter("l_code");
		String code=(String) request.getSession().getAttribute("code");
		u_pwd=md.createPassword(u_pwd);
		po.setU_name(u_name);
		po.setU_email(u_email);
		po.setU_pwd(u_pwd);
		po.setU_sex(u_sex);
		po.setU_birth(u_birth);
		po.setU_province(u_province);
		po.setU_city(u_city);
		po.setU_area(u_area);
		po.setU_school(u_school);
		po.setU_academy(u_academy);
		po.setU_grade(u_grade);
		if(po.getU_sex().equals("鐢�")){
			po.setU_photo("images/touxiang/moren1.jpg");
		}else{
			po.setU_photo("images/touxiang/moren2.jpg");
		}
		
		if(code.equals(l_code)){
			boolean flag=biz.register(po);
			if(flag==true){
				out.print(1);
			}else{
				out.print(0);
			}
		}else{
			out.print(2);
		}
		out.flush();
		out.close();	
	}

	/**
	 * 鎵惧洖瀵嗙爜
	 * @param request
	 * @param response
	 */
	public void userPwdBack(HttpServletRequest request, HttpServletResponse response){
		String u_pwd=request.getParameter("u_pwd");
		String u_email=request.getParameter("u_email");
		String l_code=request.getParameter("l_code");
		String code=(String) request.getSession().getAttribute("code");
		po.setU_pwd(u_pwd);
		po.setU_email(u_email);
		if(code.equals(l_code)){
			boolean user=biz.userPwdBack(po);
			if(user==true){
				out.print(1);
			}else{
				out.print(0);
			}
		}else{
			out.print(2);
		}
		 out.flush();
		 out.close();		
	}
	
	
	//鍒ゆ柇鐢ㄦ埛娉ㄥ唽鏃讹紝鍛㈢О鏄惁閲嶅
	public  void userNameReg(HttpServletRequest request, HttpServletResponse response){
				String u_name=request.getParameter("u_name");
				po.setU_name(u_name);
				boolean flag=biz.userNameReg(po);
				if(flag==true){
					out.print(1);
				}else{
					out.print(0);					
				}
				out.flush();
				out.close();
	}
	
	//閭楠岃瘉
	public  void userEmailReg(HttpServletRequest request, HttpServletResponse response){
					String u_email=request.getParameter("u_email");
					po.setU_email(u_email);
					boolean flag=biz.userEmailReg(po);
					if(flag==true){
						out.print(1);
					}else{
						out.print(0);					
					}
					out.flush();
					out.close();
		}
		
	/**
	 * 鐢ㄦ埛閫�鍑�
	 */
	public void exit(HttpServletRequest request, HttpServletResponse response){
		String u_name=request.getParameter("u_name");
		if(u_name==""){
			out.print(1);
		}else{
			session=request.getSession();
			session.setAttribute(SessionAttributeNames.u_id,null);
			session.setAttribute(SessionAttributeNames.u_name, null);
			out.print(0);
		}
		out.flush();
		out.close();
	}
	
	
	/**
	 * 鏌ヨ鎵�鏈�
	 */
	
	public void userFindAll(HttpServletRequest request, HttpServletResponse response){
		String u_email=request.getParameter("u_email");
		po.setU_email(u_email);
		List<Map<String,Object>> list=biz.findAll(po);
	}
	/**
	 * 鑾峰彇鐢ㄦ埛id瀛樺埌session
	 */
	public void getUid(HttpServletRequest request, HttpServletResponse response){
		String u_id=request.getParameter("u_id");
		session=request.getSession();
		session.setAttribute(SessionAttributeNames.u_id, u_id);
//		Object obj=session.getAttribute(SessionAttributeNames.u_id);
//		System.out.println(obj);
	}
	
	
	public void uidFindall(HttpServletRequest request, HttpServletResponse response){
//		System.out.println("123");
	/*	Object obj=session.getAttribute(SessionAttributeNames.u_id);
		List<Map<String, Object>> list=index.findAll(obj);
		
		json=JSONArray.fromObject(list);
		jb=new JSONObject();
		//灏唈son瀛樺叆JSONObject
		jb.put("uid",json);
		out.print(jb.toString());
		out.flush();
		out.close();*/
	}

	
 	
}
	
	
	
	
	
	
	


