package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import java.io.File;

import com.oreilly.servlet.MultipartRequest;

class writeContent extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		MultipartRequest multi = new MultipartRequest(req, "c:\\webapps\\red\\upload", 1024*1024*20, "Windows-31J");
			
		String filename = multi.getFilesystemName("fileupload");
		
		HttpSession session = req.getSession();
		
		String thid = multi.getParameter("thid");
		String username = (String)session.getAttribute("s_id");
		
		String sql = "SELECT COUNT(*)+1 FROM content WHERE con_th_id = " + thid;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String conid = rs.getString(1);
		
		if(username == null){
			username = req.getRemoteAddr();
		}
		//���s����
		String content = multi.getParameter("content").replaceAll("\n","<br>");
		
		sql = "INSERT INTO content VALUES("+thid+", "+conid+",'"+username+"', '"+content+"', default, '', '', '"+filename+"', 1)";
		
		int i = stmt.executeUpdate(sql);
		if(i>0){
			sql = "update thread set th_ldate=sysdate where th_id="+thid;
			stmt.executeUpdate(sql);
		}
		con.commit();
	}
}