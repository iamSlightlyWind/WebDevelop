<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Add</h1>
        
        <form action="add" method="post">
            ID: <input type="number" name="id"><br>
            First Name: <input type="text" name="first"><br>
            Last Name: <input type="text" name="last"><br>
            Age: <input type="number" name="age"><br>
            <input type="submit" value="Add Employee">
        </form>
    </body>
</html>
