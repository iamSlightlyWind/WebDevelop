<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
        </head>

        <body>
            <form action="doCheck" method="get">
                <p>Ho ten: <input type="text" name="fullName" value="Pham Thanh Phong"></p>
                <p>Gioi tinh:
                    <input type="radio" name="gender" value="male"> nam
                    <input type="radio" name="gender" value="female"> nu
                </p>
                <p>Diem <input type="text" name="mark"></p>
                <p>
                    Mon hoc
                    <select name="subject">
                        <option value="prf192">PRF192</option>
                        <option value="prj301">PRJ301</option>
                        <option value="swp391">SWP391</option>
                    </select>
                </p>
                <button type="submit" name="action" value="doCheck">Submit</button>
            </form>

            <c:if test="${not empty result}">
                <p>${result}</p>
            </c:if>
        </body>

        </html>