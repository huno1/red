<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List,bean.*" %>
	
<div class="wrapper">
<% 
	String servlet = "main";
	if(request.getQueryString()!=null){
		servlet += "?"+request.getQueryString();
	}
	try{
	Topic t=(Topic)request.getAttribute("topic"); %>
	<a href="<%=servlet %>" class="topic">
		<div class="tlist" id="t<%=t.getId() %>">
			<h2><%=t.getTitle() +"("+t.getCount()+")" %></h2>
			<div class="detail">
    			<%=t.getId() +" / "+ t.getMaker() +" / "+ t.getFdate() +" / "+ t.getLdate() %>
    		</div>
		</div>
	</a>
    <form name="writeContent" class="write" method="POST" action="<%=servlet %>" onsubmit="checkcontent();return false" enctype="multipart/form-data">
        <textarea rows="4" cols="50" name="content" placeholder="please enter..."></textarea>
        <div class="right"><input type="file" name="fileupload" /><input type="submit" value="投稿" /></div>
        <input type="hidden" name="action" value="writeContent" >
        <input type="hidden" name="thid" value="<%=t.getId() %>" >
    </form>
	<% List<Content> clist=(List<Content>)request.getAttribute("contentlist");
       for(Content c:clist){ %>
		<div class="clist">
    		 <%=c.getId() +" / "+ c.getUsername() +" / "+ c.getDate() %>
    		 <div class="cont"><%=c.getContent() %>
    		 	<% if(c.getFile()!=null && !c.getFile().equals("null")){ %>
    		 		<div><img src="<%=c.getFile() %>"></div>
    		 	<% } %></div>
		     <% if(session.getAttribute("s_id")!=null && session.getAttribute("s_id").equals(c.getUsername())){ %>
	    		 <form class="deletecontent" name="deletecontent" method="POST" action="<%=servlet %>" onsubmit="checkdeletecontent();return false">
					 <input type="submit" value="削除" >
		    		 <input type="hidden" name="cid" value="<%=c.getId() %>" >
		    		 <input type="hidden" name="thid" value="<%=t.getId() %>" >
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