<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List,bean.*" %>
	
<div class="wrapper">
<% try{
	Topic t=(Topic)request.getAttribute("topic"); %>
	<div><%=t.getId() +" / "+ t.getTitle() +" / "+ t.getFdate() +" / "+ t.getLdate() +" / "+ t.getCount() %></div>
    <form name="writeContent" class="write" method="POST" action="main?<%=request.getQueryString() %>" onsubmit="checkcontent();return false">
        <textarea rows="4" cols="50" name="content" placeholder="please enter..."></textarea>
        <div class="right"><input type="submit" value="投稿" /></div>
        <input type="hidden" name="action" value="writeContent" >
        <input type="hidden" name="thid" value="<%=t.getId() %>" >
    </form>
	<% List<Content> clist=(List<Content>)request.getAttribute("contentlist");
       for(Content c:clist){ %>
		<div class="clist">
    		 <%=c.getId() +" / "+ c.getUsername() +" / "+ c.getDate() %>
    		 <div class="cont"><%=c.getContent() %></div>
		     <% if(session.getAttribute("s_id")!=null && session.getAttribute("s_id").equals(c.getUsername())){ %>
	    		 <form class="deletecontent" name="deletecontent" method="POST" action="main?<%=request.getQueryString() %>" onsubmit="checkdeletecontent();return false">
					 <input type="submit" value="削除" >
		    		 <input type="hidden" name="cid" value="<%=c.getId() %>" >
		    		 <input type="hidden" name="action" value="deleteContent" >
	    		 </form>
    		 <% } %>
    	</div>
	<% }
	}catch(Exception e){
		out.println("データベースにアクセスできません。");
	}
%>
</div>