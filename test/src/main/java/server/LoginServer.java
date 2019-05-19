package server;
/**
 * 登录界面
 * **/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy.dao.Dao;

public class LoginServer extends HttpServlet{
	
	private Dao dao = new Dao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		String admin = req.getParameter("admin"); //获得传递的用户名
		String pass = req.getParameter("pass"); //获得密码
		if (dao.isRight(admin, pass)){	//通过数据库验证用户与密码
			resp.sendRedirect("success.jsp"); //跳转至登录成功
		}else{
			out.print("<script>alert('账号或密码错误!');window.location.href='index.jsp'</script>"); //跳出提示弹窗并跳转到登录界面
		}
		
	}
	
	
}
