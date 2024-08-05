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
            <p>
                Select operation:
                <br>
                <input type="checkbox" name="action" value="+"> Add
                <br>
                <input type="checkbox" name="action" value="-"> Minus
                <br>
                <input type="checkbox" name="action" value="*"> Multiply
                <br>
                <input type="checkbox" name="action" value="/"> Divide
                <br>
                <input type="checkbox" name="action" value="lg"> UCLN
                <br>
                <input type="checkbox" name="action" value="sm"> BCNN
            </p>
            <br>
            <button type="submit">Calculate</button>
            <button type="reset">Reset</button>
        </form>
    </body>

    </html>