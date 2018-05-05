<%@ page import="java.util.regex.Pattern" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<jsp:include page="header.jsp"></jsp:include>

<%--数据格式化标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--输出，条件，迭代标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<%
    int currentPage;

    if(null != request.getParameter("currentPage")) {
        if (Pattern.matches("^[0-9]+$", request.getParameter("currentPage"))) {
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
        } else {
        currentPage = 1;
        }
    } else {
        currentPage = 1;
    }


    if(currentPage < 1) {
        currentPage = 1;
    }
%>
<html>
<head>
    <title>福利</title>
</head>

<script type="text/javascript">
    $(function () {
        $(".container tr:even").css("background", "#3333");
    })
</script>

<body>
<table class="container">
    <tr>
        <td>链接id</td>
        <td></td>
        <td></td>
        <td>链接地址</td>
    </tr>
    <c:forEach items="${resources}" var="resource">
        <tr class="table">
            <td>${resource.id}</td>
            <td></td>
            <td></td>
            <td>${resource.magnet}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>总页数:${totalPage}</td>&nbsp;&nbsp;
        <td>当前页:${currentPage}</td>&nbsp;&nbsp;
        <td><a href="${pageContext.request.contextPath}/resource.action?currentPage=1" >首页</a></td>&nbsp;&nbsp;
        <td><a href="${pageContext.request.contextPath}/resource.action?currentPage=<%=currentPage-1%>" >上一页</a></td>&nbsp;&nbsp;
        <td><a href="${pageContext.request.contextPath}/resource.action?currentPage=<%=currentPage+1%>">下一页</a></td>&nbsp;&nbsp;
        <td><a href="${pageContext.request.contextPath}/resource.action?currentPage=${totalPage}" >尾页</a></td>&nbsp;&nbsp;
    </tr>
    <span>注:链接后的空格不要复制</span>
</table>
</body>
</html>
