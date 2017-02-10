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
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/index.jsp").include(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		req.setCharacterEncoding("Windows-31J");
		
	/*	�t�@�C���A�b�v���[�h�����B(�Վ�)
		1�Ԗڂ�try�͖��Ȃ����A
		2�Ԗڂ�try��form��enctype�����ɂȂ�̂Œ����K�v */
		
		MultipartRequest multi = null;
		try{
			multi = new MultipartRequest(req, "c:\\webapps\\red", 1024*1024*20, "Windows-31J");
			
			FileUpload upload = new FileUpload();
			upload.uploadfile(multi, req);
			
		}catch(Exception e){
			e.printStackTrace();
		}

		
		try{
			executer = commander.getCommand(req);
			executer.execute(req);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String url = "main";
		if(req.getQueryString()!=null){
			url += "?"+req.getQueryString();
		}
		
		res.sendRedirect(url);
	}
}
