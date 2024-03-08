<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test JSP Page</title>
</head>
<body>
    <h1>GET/POST 요청 데이터 출력</h1>
    
    <%-- 요청 방식 확인 --%>
    <%
        String requestMethod = request.getMethod();
        out.println("<p>현재 페이지 요청 방식: " + requestMethod + "</p>");

        // GET 방식으로 호출되었을 때
        if ("GET".equalsIgnoreCase(requestMethod)) {
            // 현재 페이지에 GET 방식으로 전달된 데이터 확인
            String requestData = request.getParameter("data");
            if (requestData != null && !requestData.isEmpty()) {
                out.println("<p>현재 페이지에 GET 방식으로 전달된 데이터: " + requestData + "</p>");
            }
        }

        // POST 방식으로 호출되었을 때
        if ("POST".equalsIgnoreCase(requestMethod)) {
            // 현재 페이지에 POST 방식으로 전달된 데이터 확인
            String requestData = request.getParameter("data");
            if (requestData != null && !requestData.isEmpty()) {
                out.println("<p>현재 페이지에 POST 방식으로 전달된 데이터: " + requestData + "</p>");
            }
        }
    %>

    <%-- url.jsp 호출 --%>
    <jsp:include page="url.jsp">
        <jsp:param name="requestMethod" value="<%= requestMethod %>" />
    </jsp:include>

    <%-- 폼 데이터를 입력할 간단한 HTML 폼 --%>
    <form method="post" action="">
        <label for="dataInput">데이터 입력:</label>
        <input type="text" id="dataInput" name="data" />
        <input type="submit" value="전송" />
    </form>

    <%-- 폼 데이터를 입력할 간단한 HTML 폼 (GET) --%>
    <form method="get" action="">
        <label for="dataInputGet">데이터 입력 (GET):</label>
        <input type="text" id="dataInputGet" name="data" />
        <input type="submit" value="전송 (GET)" />
    </form>

</body>
</html>
