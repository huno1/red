<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List" %>
	
<div class="searchform">
	<form name="search" method="GET" onsubmit="searchform(); return false">
		<input type="text" name="keyword" >
		<input type="submit" value="����" >
		<input type="hidden" name="page" value="1" >
	</form>
</div>

<div class="recent">
	<% try{
		List<Content> rlist=(List<Content>)request.getAttribute("recent");
       for(Content r:rlist){ %>
		<div class="rlist">
    		 	<a href="main?topic=<%=r.getThid() %>#<%=r.getId() %>">
    		 	<div class="rcont">
    		 	<% if(r.getFile()!=null && !r.getFile().equals("null")){ %>
    		 		<img src="upload/<%=r.getFile() %>">
    		 	<% } %><%=r.getContent() %></div>
    		 	<div class="rdate"><%=r.getDate().substring(5,16) %></div>
    		 	</a>
    	</div>
	<% }
	}catch(Exception e){
		out.println("�f�[�^�x�[�X�ɃA�N�Z�X�ł��܂���B");
	} %>
</div>

<div class="loginwrap">
    <% if(session.getAttribute("s_id")==null){%>
   	<form name="login" method="POST" action="main?<%=request.getQueryString() %>">
        <input type="text" name="username" placeholder="�����Ń��O�C��">
        <input type="password" name="userpass" placeholder="password">
        <input type="submit" value="���O�C��" />
        <input type="hidden" name="do" value="login" />
    </form>
        <a class="openpage" href="javascript:openaccount()">
        �_�񂷂�
        </a>
        <div id="newaccountwrap">
		   	<form name="newaccount" method="POST" action="main" onsubmit="check();return false">
		        <input type="text" id="nID" name="username" placeholder="�Ȃ܂�">
		        <input type="password" id="nPW" name="userpass" placeholder="�p�X���[�h">
		        <input type="password" id="nPWPW" name="userpasspass" placeholder="�������">
		        <input type="submit" value="�m�F" />
		        <input type="hidden" name="do" value="newAccount" />
		    </form>
		</div>
    <% }else{ %>
   	<form name="logout" method="POST" action="main?<%=request.getQueryString() %>">
    	����ɂ��́A<%=session.getAttribute("s_id") %> ����
        <input type="submit" value="���O�A�E�g" />
        <input type="hidden" name="do" value="logout" />
    </form>
    <% }
    if(session.getAttribute("message")!=null){ %>
    	<div class="message"><%=session.getAttribute("message") %></div>
    <% session.setAttribute("message",null);
    }
    if(request.getAttribute("message")!=null){ %>
    	<div class="message"><%=request.getAttribute("message") %></div>
    <% request.setAttribute("message",null);
    } %>
</div>
<div id="totop">
	<a href="#top"><div class="btn">Top��</div></a>
</div>