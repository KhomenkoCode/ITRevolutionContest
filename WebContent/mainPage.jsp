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
<title>Title</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/cover.css" rel="stylesheet">
<link rel="shortcut icon" type="image/png" href="static/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div style="margin-top: 20pt;">
		<div class="col-lg-6" style="width: 100%;">
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
	</div>
	<div class="col-lg-12" style="margin-top: 20pt;">
		
		<c:forEach var="artist" items="${ratedArtists}">
		<div style="float:left;"><table  style="min-width:300pt;"><tr>
		<td>
 			<a href="artist?artist=${artists.get(numOfelem).getId()}"><br>
 			<div style="float:left; overflow:hidden; position:relative; width:60pt;
	height:60pt;">
				<c:if test="${artist.key.getImages().size() > 0}">	
				<img src="${artist.key.getImages().get(0).getUrl()}"style="height:60pt;">
				</c:if>
				<c:if test="${artist.key.getImages().size() == 0}">	
				<img src="static/img/noartistphoto.png"style="height:60pt;">
				</c:if>
				</div> </a>
 			</td>
 			<td style="width:20pt;"></td>
 			<td>
 			<table>
 			<tr><td>
 				<a href="artist?artist=${artist.key.getId()}" style="font-size:14pt;">${artist.key.getName()}</a>
 			</td></tr>
 			<tr><td>
 				Average Rate: ${artist.value}
 			</td></tr>
 			</table>
 			</td>	
 			<td style="width:40pt;"></td>
 			<td>
 			</tr>	</table>
 			</div>
		</c:forEach>
		
	</div>
</body>
</html>