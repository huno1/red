<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List,bean.*" %>
	
<% 
	String servlet = "main";
	if(request.getQueryString()!=null){
		servlet += "?"+request.getQueryString();
	}
	try{
	Topic t=(Topic)request.getAttribute("title"); %>
	<a href="<%=servlet %>" class="topic">
		<div class="tlist" id="t<%=t.getId() %>">
			<h2><%=t.getTitle() +"("+t.getCount()+")" %></h2>
			<div class="detail">
    			<%=t.getId() +" / "+ t.getMaker() +" / "+ t.getFdate() +" / "+ t.getLdate() %>
    		</div>
		</div>
	</a>
    <form name="writeContent" class="write" method="POST" action="<%=servlet %>&do=writeContent" onsubmit="checkcontent();return false" enctype="multipart/form-data" >
        <textarea rows="4" cols="50" name="title" placeholder="please enter..."></textarea>
        <div class="right"><input type="file" name="fileupload" /><input type="submit" value="���e" /></div>
        <input type="hidden" name="thid" value="<%=t.getId() %>" >
    </form>
	<% List<Content> clist=(List<Content>)request.getAttribute("contentlist");
       for(Content c:clist){ %>
		<div id="<%=c.getId() %>" class="clist">
    		 <%=c.getId() +" / "+ c.getUsername() +" / "+ c.getDate() %>
    		 <div class="cont"><%=c.getContent() %>
    		 	<% if(c.getFile()!=null && !c.getFile().equals("null")){
    		 		if(c.getFile().indexOf(".jpg")>0 || c.getFile().indexOf(".jpeg")>0 || c.getFile().indexOf(".png")>0 || c.getFile().indexOf(".bmp")>0 || c.getFile().indexOf(".gif")>0 ){ %>
    		 			<div><img src="upload/<%=c.getFile() %>"></div>
    		 		<% }else if(c.getFile().indexOf(".webm")>0 || c.getFile().indexOf(".avi")>0 || c.getFile().indexOf(".mp4")>0 || c.getFile().indexOf(".wmv")>0){ %>
    		 			<div><video src="upload/<%=c.getFile() %>" controls></video></div>
    		 		<% }else if(c.getFile().indexOf(".mp3")>0 || c.getFile().indexOf(".ogg")>0){ %>
    		 			<div><audio src="upload/<%=c.getFile() %>" controls></audio></div>
    		 		<% } %>
    		 	<% } %></div>
		     <% if(session.getAttribute("s_id")!=null && session.getAttribute("s_id").equals(c.getUsername())){ %>
	    		 <form class="deletecontent" name="deletecontent" method="POST" action="<%=servlet %>" onsubmit="checkdeletecontent();return false">
					 <input type="submit" value="�폜" >
		    		 <input type="hidden" name="conid" value="<%=c.getId() %>" >
		    		 <input type="hidden" name="thid" value="<%=t.getId() %>" >
		    		 <input type="hidden" name="do" value="deleteContent" >
	    		 </form>
    		 <% } %>
    	</div>
	<% }
	}catch(Exception e){
		response.sendRedirect("main?page=1");
	}
%>