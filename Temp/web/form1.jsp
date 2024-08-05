<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <form action="doCalc" method="get">
            <p>Enter a <input type="number" name="a" id="a"></p>
            <p>Enter b <input type="number" name="b" id="b"></p>
            <br>
            <button type="submit" name="action" value="+">a+b</button>
            <button type="submit" name="action" value="-">a-b</button>
            <button type="submit" name="action" value="*">a*b</button>
            <button type="submit" name="action" value="/">a/b</button>
            <button type="submit" name="action" value="ld">UCLN</button>
            <button type="submit" name="action" value="sm">BCNN</button>
        </form>
    </body>

    </html>