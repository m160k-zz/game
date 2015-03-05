<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<jsp:useBean id="questDao" type="org.game.db.dao.QuestionDao" scope="request" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
 
    <body>
        <form method="POST" action="guest.html">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> 
        <% for (org.game.db.domain.Question quest : questDao.getAllQuests()) { %>
            <li> <%= quest %> </li>
        <% } %>
        </ol><hr>
 
		<iframe src="http://www.objectdb.com/pw.html?spring-download"
            frameborder="0" scrolling="no" width="100%" height="30"></iframe>
	</body>
</html>