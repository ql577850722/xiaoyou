package xiaoyou.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {
	private String encoding="UTF-8";
	public void destroy() {
		System.out.println("销毁过滤器。。。。");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		//修改完成后，调用下一个过滤器
		chain.doFilter(request,response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化过滤器");
		encoding=arg0.getInitParameter("encoding");
	}
}
