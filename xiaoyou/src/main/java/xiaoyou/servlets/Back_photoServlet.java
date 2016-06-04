package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.biz.IBack_photoBiz;
import xiaoyou.biz.impl.Back_photoBizImpl;
import xiaoyou.po.photoPO;

public class Back_photoServlet extends HttpServlet {
	private PrintWriter out ;
	private  IBack_photoBiz  biz=new Back_photoBizImpl();
	private photoPO po=new photoPO();
	//private JSONArray json;
	//private JSONObject jb;
	private HttpSession session;
	
	
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
		if("findBypage".equals(op)){
			findBypage(request,response);
		}
		if("okPhoto".equals(op)){
			okPhoto(request,response);
		}
		if("noPhoto".equals(op)){
			noPhoto(request,response);
		}
		
	}
	
	
	//鐓х墖瀹℃牳鏈�氳繃
	private void noPhoto(HttpServletRequest request,
			HttpServletResponse response) {
		int photo_id=Integer.parseInt(request.getParameter("photo_id"));
		po.setPhoto_id(photo_id);
		boolean falg=biz.noPhoto(po);
		if(falg==true){
			out.print(1);
		}else{
			out.print(0);
		}
		out.flush();
		out.close();
		
	}

	//鐓х墖瀹℃牳閫氳繃
	private void okPhoto(HttpServletRequest request,
			HttpServletResponse response) {
		int photo_id=Integer.parseInt(request.getParameter("photo_id"));
		po.setPhoto_id(photo_id);
		boolean falg=biz.okPhoto(po);
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
		List<photoPO> list=null;
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
