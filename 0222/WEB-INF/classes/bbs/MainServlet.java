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
	
	Executer executer = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		req.setCharacterEncoding("Windows-31J");
		res.setContentType("text/html; charset=Windows-31J");
		
		ServletRequest request = new ServletRequest(req);
		
		try{
			//スレかレスか判断
			if(req.getParameter("topic")!=null){
				//ThreadIDを取得
				request.setThid(req.getParameter("topic"));
				
				//レスのリスト
				executer = new readContentList();
				List<Bean> clist = executer.query(request);
				req.setAttribute("contentlist",clist);
				
				//レスのタイトル
				executer = new readContentTitle();
				List<Bean> tlist = executer.query(request);
				Topic title = (Topic)tlist.get(0);
				req.setAttribute("title",title);
				
			}else{
				String keyword = "";
				if(req.getParameter("keyword")!=null){
					String _key = new String(req.getParameter("keyword").getBytes("ISO-8859-1"), "Shift_JIS");
					keyword = "WHERE th_title LIKE '%"+_key+"%' OR th_id LIKE '%"+_key+"%' OR th_maker LIKE '%"+_key+"%'";
					request.setKeyword(keyword);
				}
				//スレのリスト
				executer = new readTopicList();
				List<Bean> tlist = executer.query(request);
				req.setAttribute("threadlist",tlist);
				
				//ページ数
				executer = new getTotal();
				int total = (executer.total("th_id", keyword)-1)/10+1;
				req.setAttribute("totalpages",total);
			}
			//左側の最近付けられたレス
			executer = new readRecent();
			List<Bean> recent = executer.query(request);
			req.setAttribute("recent",recent);
		}catch(Exception e){
			e.printStackTrace();
			res.sendRedirect("main?page=1");
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
		
		String url = "main?";
		if(req.getParameter("topic")!=null){
			url += "topic="+req.getParameter("topic")+"&";
		}
		if(req.getParameter("page")!=null){
			url += "page="+req.getParameter("page")+"&";
		}
		
		res.sendRedirect(url);
	}
}
