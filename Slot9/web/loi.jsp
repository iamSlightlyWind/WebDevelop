<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page import="java.io.StringWriter, java.io.PrintWriter" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error Page</title>
</head>

<body>
    <h2>An error occurred!</h2>
    <hr />
    <p><strong>Error details:</strong></p>
    <pre><%= exception.toString() %></pre>

    <%-- Displaying the stack trace, if available --%>
        <% StringWriter sw=new StringWriter(); PrintWriter pw=new PrintWriter(sw); exception.printStackTrace(pw); String
            stackTrace=sw.toString(); %>
            <p><strong>Stack Trace:</strong></p>
            <pre><%= stackTrace %></pre>
</body>

</html>