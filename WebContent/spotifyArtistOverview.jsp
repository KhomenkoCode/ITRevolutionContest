<%--@elvariable id="artist" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: danil
  Date: 2017-11-18
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${artist.getName()}</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/cover.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/png" href="static/favicon.ico" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body >
<div class="container">
    <div class="col-lg-6">
        <div class="input-group">
            <form method="post">
					<span class="input-group-btn"> <input type="text"
                                                          name="artist" placeholder="Search artist" class="form-control"
                                                          style="width: 250%;"> <input type="submit"
                                                                                       class="btn btn-default" value="Submit">
					</span>
            </form>
        </div>

    </div>
    <div class="row">
        <div class="col-md-6"><p class="lead">${artist.getName()}</p></div>
        <div class="col-md-6"><img src="${artist.getImages().get(0).getUrl()}"  width="200" height="200">
           <%-- <c:if test="${not empty artist.getGenres()}">--%>
                <c:forEach var="genre" items="${artist.getGenres()}">
                    <div>
                    <p>${genre}</p>
                    </div>
                </c:forEach>
         <%--   </c:if>--%>

        </div>

    </div>






</div>

</body>
</html>
<html>

