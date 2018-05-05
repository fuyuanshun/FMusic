<%@page isELIgnored="false"%>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%
    String json = "[{'rresult':'loginerror'}]";
    out.print(json);
%>
