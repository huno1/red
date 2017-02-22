package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

class writeContent extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		HttpServletRequest servletReq = req.getRequest();
		MultipartRequest multi = new MultipartRequest(servletReq, "c:\\webapps\\red\\upload", 1024*1024*20, "Windows-31J");
			
		String filename = multi.getFilesystemName("fileupload");
		
		HttpSession session = servletReq.getSession();
		
		String thid = multi.getParameter("thid");
		String username = (String)session.getAttribute("s_id");
		
		String sql = "SELECT COUNT(*)+1 FROM content WHERE con_th_id = " + thid;
		
		String conid = dba.getString(sql);
		
		if(username == null){
			username = servletReq.getRemoteAddr();
		}
		//â¸çsèàóù
		String content = multi.getParameter("title").replaceAll("\n","<br>");
		
		sql = "INSERT INTO content VALUES("+thid+", "+conid+",'"+username+"', '"+content+"', default, '', '', '"+filename+"', 1)";
		
		int i = dba.executeUpdate(sql);
		if(i>0){
			sql = "update thread set th_ldate=sysdate where th_id="+thid;
			dba.executeUpdate(sql);
		}
		dba.commit();
	}
}