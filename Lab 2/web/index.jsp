<html>
    <head>
        <title>User Entry Form</title>
    </head>
    <body>
        <form method="post" action="entry">
            <h3>User Entry Form</h3>
            <p>
                Username: <input type="text" name="username"> <br><br>
                Password: <input type="password" name="user-password"> <br><br>
                Gender: 
                <input type="radio" name="sex" value="male"> Male
                <input type="radio" name="sex" value="female"> Female <br><br>
                Hobbies:
                <input type="checkbox" name="soccer"> Soccer
                <input type="checkbox" name="cricket"> Cricket
                <input type="checkbox" name="baseball"> Baseball <br><br>
                Address: <textarea rows="3" cols="30"></textarea> <br><br>
                Select Your City:
                <select name="city">
                    <option value="sydney">Sydney</option>
                    <option value="melbourne">Melbourne</option>
                    <option value="cromwell">Cromwell</option>
                </select> <br><br>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </p>
        </form>
    </body>
</html>
