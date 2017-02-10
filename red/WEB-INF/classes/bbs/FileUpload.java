package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;
import java.sql.Connection;
import java.io.File;

import com.oreilly.servlet.MultipartRequest;

class FileUpload {
	
	Connection con;
	Statement stmt;
	
	public FileUpload(){
		try{
			DBAccessor dba = new DBAccessor();
			con = dba.getConnection();
			stmt = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/* 普通のexecuteメソッドが使えない。
	MultipartRequest <-> HttpServletRequest <-> jspのmultiform(enctype) */
	public void uploadfile(MultipartRequest multi, HttpServletRequest req) throws Exception{
		
		String file = multi.getFilesystemName("fileupload");
		
		System.out.println(file);
		
		HttpSession session = req.getSession();
		
		String thid = multi.getParameter("thid");
		String username = (String)session.getAttribute("s_id");
		if(username == null){
			username = req.getRemoteAddr();
		}
		//改行処理
		String content = multi.getParameter("content").replaceAll("\n","<br>");
		
		String sql = "INSERT INTO content VALUES('"+thid+"', content_seq"+thid+".nextval,'"+username+"', '"+content+"', default, '', '', '"+file+"')";
		
		System.out.println(sql);
		
		int rs = stmt.executeUpdate(sql);
		if(rs>0){
			sql = "update thread set th_ldate=sysdate where th_id="+thid;
			stmt.executeUpdate(sql);
		}
		con.commit();
	}
}