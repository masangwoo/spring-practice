<%@page import="com.poscoict.emaillist03.dao.MysiteDao"%>
<%@page import="com.poscoict.mysite.vo.MysiteVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
                            	String firstName = request.getParameter("fn");
                            	String lastName = request.getParameter("ln");
                            	String email = request.getParameter("email");
                            	
                            	MysiteVo vo = new MysiteVo();
                        		vo.setFirstName(firstName);
                        		vo.setLastName(lastName);
                        		vo.setEmail(email);
                        		
                        		new MysiteDao().insert(vo);
                        		
                        		response.sendRedirect("/emaillist01");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>잘 들어갔습니다.</h1>
</body>
</html>