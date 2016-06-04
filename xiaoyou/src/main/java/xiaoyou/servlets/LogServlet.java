package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import xiaoyou.biz.ILogBiz;
import xiaoyou.biz.impl.LogBizImpl;
import xiaoyou.po.logPO;
import xiaoyou.utils.UploadUtil;

public class LogServlet extends HttpServlet {
	ILogBiz biz=new LogBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text.html;charset=utf-8");
		//浠庨〉闈㈣幏鍙杘p
		String op=request.getParameter("op");
		//System.out.println(request.getParameter("textarea"));
		//System.out.println("op="+op);
		if(op==null){
			Map<String,String> pvalues=commonUpload(request,response);
			op=pvalues.get("op");
			if(op!=null){
				if("addTalk".equals(op)){
					addTalk(pvalues,request,response);
				}
			}
			
		}else if(op.equals("findByUid")){//鏍规嵁鐢ㄦ埛id鏌ョ湅璇磋鍜岃瘎璁�
			findByUid(request,response);
		}

	}
	
	//閫氱敤涓婁紶灏佽
		private Map<String, String> commonUpload(HttpServletRequest request,
				HttpServletResponse response) {
			//杩欐槸鍟嗗搧鍥剧墖涓婁紶鏂囦欢鏃�,鐢ㄥ緱鏂规硶鏄湪http瀹炰綋涓寘瑁呭弬鏁�,request宸茬粡娌℃湁鐢ㄤ簡,鍙兘鐢╯martupload鍙栧��
			//涓婁紶鏂囦欢鏃�,request宸茬粡娌℃湁鐢ㄤ簡
			Map<String, String> pvalues=null;
			PageContext pagecontext=javax.servlet.jsp.JspFactory.getDefaultFactory().
					getPageContext(this, request, response, null, true, 8192, true);
			try {
				pvalues=UploadUtil.upload(pagecontext);//閫氳繃浼犻�掕繃鏉ョ殑鍙傛暟 淇濆瓨鐩稿簲鐨勬枃浠朵綅缃�
			} catch (Exception e) {
				e.printStackTrace();
			}//瀹屾垚鍥剧墖涓婁紶
			return pvalues;
		}

	
//	//鍙戣璇�
//	private void addTalk(HttpServletRequest request,
//			HttpServletResponse response) throws IOException{
//		String text = request.getParameter("textarea");
//		String userId=request.getParameter("u_id");
//		logPO po=new logPO();
//		po.setU_id(Integer.parseInt(userId));
//		po.setTalk_content(text);
//		boolean flag =biz.add(po);
//		PrintWriter out =response.getWriter();
//		if(flag){
//			out.print(1);//鍙戝竷鎴愬姛
//		}
//		
//	}
	//鍙戣璇�
	private void addTalk(Map<String,String> pvalues,HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		//String text = request.getParameter("textarea");
		//String userId=request.getParameter("u_id");
		
		String text=pvalues.get("textarea");
		String userId=pvalues.get("u_id");
		
		try {
			logPO po=new logPO();
			po.setU_id(Integer.parseInt(userId));
			po.setTalk_content(text);
			po.setTalk_image_path(pvalues.get("photo"));

			boolean flag =biz.add(po);
			PrintWriter out =response.getWriter();
			if(flag){
				out.print(1);//鍙戝竷鎴愬姛
				out.flush();
				out.close();
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	//鏌ヨ鐧诲綍鐢ㄦ埛鑷繁鐨勮璇村拰璇勮
	private void findByUid(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		//鐢ㄦ埛鐧诲綍鎴愬姛鍚庡璞″瓨鍏ession   //String userId=()request.getSession().getAttribute("user");
		//String userId=request.getParameter("u_id");
//		TalkCommentsVO vo=new TalkCommentsVO();
		//po.setU_id(Integer.parseInt(userId));
//		int talk_id=Integer.parseInt(request.getParameter("talk_id"));
//		vo.setTalk_id(talk_id);
	/*	List<TalkCommentsVO> list=biz.findByUid(null);
		JSONArray json =JSONArray.fromObject(list);
		JSONObject  jb = new JSONObject();
		jb.put("TalkCommentsList", json);
		PrintWriter out =response.getWriter();
		out.print(jb.toString());
		out.flush();
		out.close();*/
		 
	}

}
