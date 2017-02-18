package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.Content;

class readRecent extends Executer {
	
	public List query(ServletRequest req) throws Exception{
		
		List<Content> recent = new ArrayList<Content>();
		String sql = "SELECT con_th_id, con_id, con_user_name, con_content, con_date, con_parent_id, con_deleted, con_file FROM content WHERE con_state=1 ORDER BY con_date DESC";
		
		ResultSet rs = stmt.executeQuery(sql);
		int i = 0;
		while (rs.next()) {
			Content c = new Content(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5).substring(0,rs.getString(5).length()-2), rs.getString(6), rs.getString(7),rs.getString(8));
			recent.add(c);
			i++;
			if(i>20) break;
		}
		return recent;
	}
}