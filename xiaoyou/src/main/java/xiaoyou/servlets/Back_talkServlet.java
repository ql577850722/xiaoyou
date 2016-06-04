package xiaoyou.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xiaoyou.biz.IBack_TalkBiz;
import xiaoyou.biz.impl.Back_TalkBizImpl;
import xiaoyou.po.logPO;

/**
 * 鍚庡彴瀵硅璇磋〃鎿嶄綔
 * 
 * @author Administrator
 *
 */
public class Back_talkServlet extends HttpServlet {
	private PrintWriter out;
	private IBack_TalkBiz biz = new Back_TalkBizImpl();
	private logPO po = new logPO();
	// private JSONArray json;
	// private JSONObject jb;
	private HttpSession session;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out = response.getWriter();
		// 璁剧疆缂栫爜闆�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op = request.getParameter("op");
		if ("findBypage".equals(op)) {
			findBypage(request, response);
		}
	}

	public void findBypage(HttpServletRequest request,
			HttpServletResponse response) {
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		List<logPO> list = null;
		if (null == pageNo || ("").equals(pageNo) || null == pageSize
				|| ("").equals(pageSize)) {
			list = biz.findByPage(null, null);
		} else {
			list = biz.findByPage(Integer.parseInt(pageNo),
					Integer.parseInt(pageSize));
		}
		/*
		 * json=JSONArray.fromObject(list); jb=new JSONObject();
		 * jb.put("total",(int)biz.getCount()); jb.put("rows",json);
		 * out.print(jb.toString());
		 */
	}

}
