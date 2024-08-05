<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
    </head>

    <body>
        <form action="doCalc" method="get">
            <p>Enter a <input type="number" name="a" id="a"></p>
            <p>Enter b <input type="number" name="b" id="b"></p>
            <p>
                Select operation:
                <select name="action" id="action">
                    <option value="+">Add</option>
                    <option value="-">Minus</option>
                    <option value="*">Multiply</option>
                    <option value="/">Divide</option>
                    <option value="lg">UCLN</option>
                    <option value="sm">BCNN</option>
                    <option value="prime">Prime</option>
                    <option value="perfect">Perfect</option>
                    <option value="square">Square</option>
                </select>
            </p>
            <br>
            <button type="submit">Calculate</button>
            <button type="reset">Reset</button>
        </form>
    </body>

    </html>