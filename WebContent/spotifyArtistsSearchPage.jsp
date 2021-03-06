<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Daniel Nikulin/Nikita Khomenko
  Date: 2017-11-18
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SearchResults</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/cover.css" rel="stylesheet">
<link rel="shortcut icon" type="image/png" href="static/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div style="margin-top: 20pt;margin-left: 25%; margin-right: 30% ">
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
	<br>
	<div style="margin-top: 20pt; margin-left: 20%; margin-right: 25%;" >
		
		<c:choose>
         <c:when test = "${empty artists}">
            Sorry, no artists found.
         </c:when>
         <c:otherwise>
            <table style="margin-left:10%;">
			
			<c:forEach var="numOfelem" begin="0" end="${artists.size()-1}"
				step="1">
				<tr style="margin:10pt;">
				<td><a href="artist?artist=${artists.get(numOfelem).getId()}"><br>
					<div style="float:left; overflow:hidden; position:relative; width:200pt;
	height:200pt;">
				<c:if test="${artists.get(numOfelem).getImages().size() > 0}">	
				<img src="${artists.get(numOfelem).getImages().get(0).getUrl()}"style="height:200pt;">
				</c:if>
				<c:if test="${artists.get(numOfelem).getImages().size() == 0}">	
				<img src="static/img/noartistphoto.png"style="height:200pt;">
				</c:if>
				
				</div> </a>
				</td>
				<td style="width:20pt"> </td>
				<td>
				<table style="margin: 5%;">
					<tr style="height:30pt;">
					<td align="left">
				<a class="lead" href="artist?artist=${artists.get(numOfelem).getId()}">${artists.get(numOfelem).getName()}</a>
				</td></tr>
				
				<c:choose>
         <c:when test = "${topTracksByArtists.get(numOfelem).size() > 2}">
				<c:forEach var="numOfelem2" begin="0" end="2" step="1">
					<tr><td align="left">
					
					<iframe
						src="https://open.spotify.com/embed?uri=${topTracksByArtists.get(numOfelem).get(numOfelem2).getUri()}"
						width="300" height="80" frameborder="0" allowtransparency="true"></iframe><br>
					</td></tr>
				</c:forEach>
				
				</c:when>
				<c:when test = "${topTracksByArtists.get(numOfelem).size() == 0}">
						<tr><td align="left">
						<div class="alert alert-warning" role="alert">Sorry, but there no tracks released yet.</div></td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="numOfelem2" begin="0" end="${topTracksByArtists.get(numOfelem).size()-1}" step="1">
					<tr><td align="left">
					
					<iframe
						src="https://open.spotify.com/embed?uri=${topTracksByArtists.get(numOfelem).get(numOfelem2).getUri()}"
						width="300" height="80" frameborder="0" allowtransparency="true"></iframe><br>
					
				</c:forEach>
				</c:otherwise>
				</c:choose>
				</td></tr>
					</table>
				</td>
				</tr>
			</c:forEach>
		</table>
         </c:otherwise>
      </c:choose>
		
		
	</div>

</body>
</html>