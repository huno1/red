package bbs;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import java.util.List;

import java.io.IOException;
import java.io.File;

import bean.*;

import com.oreilly.servlet.MultipartRequest;

public class MainServlet extends HttpServlet{
	
	//Commander=ExecuterÇ…éwé¶ÇèoÇ∑Ç‡ÇÃ
	//Executer=éÛÇØÇΩéwé¶í ÇËÇÃçÏã∆ÇÇ∑ÇÈÇ‡ÇÃ
	Executer executer = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		res.setContentType("text/html; charset=Windows-31J");
		String action = req.getParameter("do");
		ServletRequest request = new ServletRequest(req);
		
		try{
			if(req.getParameter("topic")!=null){
				request.setThid(req.getParameter("topic"));
				readContentList c = new readContentList();
				List<Content> clist = c.getContentList(request);
				Topic title = c.getContentTitle(request);
				req.setAttribute("contentlist",clist);
				req.setAttribute("title",title);
			}else{
				readTopicList t = new readTopicList();
				List<Topic> tlist = t.getTopicList(request);
				req.setAttribute("threadlist",tlist);
			}
			executer = new readRecent();
			List<Content> recent = executer.query(request);
			req.setAttribute("recent",recent);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/index.jsp").include(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		req.setCharacterEncoding("Windows-31J");
		Commander commander = new Commander();
		String action = req.getParameter("do");
		ServletRequest request = new ServletRequest(req);
		
		try{
			executer = commander.getCommand(action);
			executer.execute(request);
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
