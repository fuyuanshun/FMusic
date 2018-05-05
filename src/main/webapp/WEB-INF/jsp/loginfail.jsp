<%@page isELIgnored="false"%>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%
    String json = "[{'rresult':'loginfail'}]";
    out.print(json);
%>
