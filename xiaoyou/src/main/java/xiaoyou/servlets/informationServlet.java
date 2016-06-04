package xiaoyou.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import sun.misc.BASE64Decoder;
import xiaoyou.biz.IInformationBiz;
import xiaoyou.biz.impl.InformationBizImpl;
import xiaoyou.commons.FileUpload;
import xiaoyou.po.UserInfoPO;
import xiaoyou.po.photoPO;
import xiaoyou.utils.SessionAttributeNames;

public class informationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PrintWriter out1;
	private IInformationBiz biz = new InformationBizImpl();
	private UserInfoPO po = new UserInfoPO();
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
		if ("perfectUserinfo".equals(op)) {
			perfectUserinfo(request, response);
		} else if ("updateUserinfo".equals(op)) {
			updateUserinfo(request, response);
		} else if ("sentPhoto".equals(op)) {
			sentPhoto(request, response);
		} else if ("sentPortrait".equals(op)) {
			sentPortrait(request, response);
		} else if ("updateWrite".equals(op)) {
			updateWrite(request, response);
		}
	}

	// 淇敼涓汉淇℃伅
	private void updateUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
		int u_id = Integer.parseInt(uid);
		//System.out.println(u_id+"--------");
		String u_stature = request.getParameter("u_stature");
		String u_weight = request.getParameter("u_weight");
		String u_blood = request.getParameter("u_blood");
		String u_tel = request.getParameter("u_tel");
		String u_qq = request.getParameter("u_qq");
		String u_wechat = request.getParameter("u_wechat");

		po.setU_id(u_id);
		po.setU_stature(u_stature);
		po.setU_weight(u_weight);
		po.setU_blood(u_blood);
		po.setU_tel(u_tel);
		po.setU_qq(u_qq);
		po.setU_wechat(u_wechat);
		out1 = response.getWriter();
		int flag = biz.updateUserinfo(po);
		if (flag > 0) {
			out1.print(1);
		}
		out1.flush();
		out1.close();
	}

	// 瀹屽杽涓汉淇℃伅
	private void perfectUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
		int u_id = Integer.parseInt(uid);
		List<UserInfoPO> list = biz.perfectInfor(u_id);

		/*JSONArray json = JSONArray.fromObject(list);
		JSONObject jb = new JSONObject();*/
		response.setContentType("text/html;charset=UTF-8");
	/*	jb.put("userInfo", list);
		out1 = response.getWriter();
		if (list.size() > 0) {
			out1.print(jb.toString());
		}*/
		out1.flush();
		out1.close();
	}

	// 淇敼涓汉瀹ｈ█
	private void updateWrite(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
		int u_id = Integer.parseInt(uid);
		String u_text = request.getParameter("u_text");
		UserInfoPO po = new UserInfoPO();
		po.setU_id(u_id);
		po.setU_text(u_text);
		out1 = response.getWriter();
		int flag = biz.updateWrite(po);
		if (flag > 0) {
			out1.print(1);
		}
		out1.flush();
		out1.close();
	}

	// 涓婁紶鐓х墖
	private void sentPhoto(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
		int u_id = Integer.parseInt(uid);
		FileUpload upload = new FileUpload();
		PageContext context = JspFactory.getDefaultFactory().getPageContext(
				this, request, response, null, true, 1024, true);
		try {
			Map<String, String> map = upload.upload(context);
			photoPO po = new photoPO();
			po.setU_id(u_id);
			po.setPhoto_path(map.get("image"));
			int flag = biz.add(po);
			out1 = response.getWriter();
			if (flag > 0) {
				out1.print(1);
				out1.flush();
				out1.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// out.print(1);
	}

	// 涓婁紶澶村儚
	private void sentPortrait(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			FileUpload upload = new FileUpload();
			PageContext context = JspFactory.getDefaultFactory()
					.getPageContext(this, request, response, null, true, 1024,
							true);
			Map<String, String> map;
			map = upload.upload(context);
			String pic = map.get("pic");
			String uid = (String)session.getAttribute(SessionAttributeNames.u_id);
			int u_id = Integer.parseInt(uid);
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			if (pic == null) {
				return;
			}
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] b = decoder.decodeBuffer(pic);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			String imgPath = "images/basic1"+u_id+".png";
			String filePath = request.getRealPath("imgPath");
			//String imgFilePath = "D:\basic.png";// 鏂扮敓鎴愮殑鍥剧墖
			//TODO:瀛樻暟鎹簱
			System.out.println(filePath);
			OutputStream out = new FileOutputStream(filePath);
			out.write(b);
			out.flush();
			out.close();
			
			
			out1 = response.getWriter();
			out1.print(imgPath);
			out1.flush();
			out1.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
