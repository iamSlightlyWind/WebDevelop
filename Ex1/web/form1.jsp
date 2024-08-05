<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
    </head>

    <body>
        <form action="doCalc" method="get">
            <p>Enter a <input type="text" name="a" id="a"></p>
            <p>Enter b <input type="text" name="b" id="b"></p>
            <br>
            <button type="submit" name="action" value="+">a+b</button>
            <button type="submit" name="action" value="-">a-b</button>
            <button type="submit" name="action" value="*">a*b</button>
            <button type="submit" name="action" value="/">a/b</button>
            <button type="submit" name="action" value="ld">UCLN</button>
            <button type="submit" name="action" value="sm">BCNN</button>
            <button type="submit" name="action" value="prime">Prime</button>
            <button type="submit" name="action" value="perfect">Perfect</button>
            <button type="submit" name="action" value="square">Square</button>
        </form>
    </body>

    </html>