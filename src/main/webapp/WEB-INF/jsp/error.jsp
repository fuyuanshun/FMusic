<%@page isELIgnored="false"%>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%
    String json = "[{'rresult':'用户名已经存在'}]";
    out.print(json);
%>