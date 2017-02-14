package bbs;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.File;

import com.oreilly.servlet.MultipartRequest;

public class MainServlet extends HttpServlet{
	
	//Commander=Executer�Ɏw�����o������
	//Executer=�󂯂��w���ʂ�̍�Ƃ��������
	Commander commander = new Commander();
	Executer executer = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		res.setContentType("text/html; charset=Windows-31J");
		
		try{
			executer = commander.getQuery(req);
			executer.execute(req);
			executer = new readRecent();
			executer.execute(req);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/index.jsp").include(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		req.setCharacterEncoding("Windows-31J");
		
		try{
			executer = commander.getCommand(req);
			executer.execute(req);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String url = "main";
		if(req.getParameter("topic")!=null){
			url += "?topic="+req.getParameter("topic");
		}
		
		res.sendRedirect(url);
	}
}
