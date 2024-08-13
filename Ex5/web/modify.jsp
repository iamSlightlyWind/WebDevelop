<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>${student != null ? 'Edit Student' : 'Create New Student'}</title>
        </head>

        <body>
            <h1>${student != null ? 'Edit Student' : 'Create New Student'}</h1>
            <form action="${student != null ? 'update' : 'create'}" method="post">
                <input type="hidden" name="rollNo" value="${student != null ? student.rollNo : ''}" />
                <div>
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" value="${student != null ? student.name : ''}" required />
                </div>
                <div>
                    <label for="mark">Mark:</label>
                    <input type="text" id="mark" name="mark" value="${student != null ? student.mark : ''}"
                        required />
                </div>
                <div>
                    <button type="submit" name="action" value="update">${student != null ? 'Update' : 'Create'}</button>
                </div>
            </form>
            <a href="students">Back to Student List</a>
        </body>

        </html>