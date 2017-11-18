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
    <br>
    <table class="tg" style="border: 0;">
        <tr>
            <th class="tg-yw4l"><a href="artist?artist=${artist.getId()}"><br>
                <div style="float:left; overflow:hidden; position:relative; width:200pt;
	height:200pt;"><img class="img-responsive img-rounded" src="${artist.getImages().get(0).getUrl()}"
                        style="height:200pt;"></div></a>
                <br>
                <br>
                <c:if test="${not empty rel_art}">
                    <br>
                    <br><b style="color: green">Related Artist:</b><br>
                    <c:forEach var="rel_art_el" items="${rel_art}">
                        <a href="artist?artist=${rel_art_el.getId()}">${rel_art_el.getName()}</a><br>
                    </c:forEach>
                </c:if>

            </th>
            <th class="tg-yw4l" valign="top" style="padding-left:25px">
                <h1 class="lead" align="center">${artist.getName()}</h1>
                <br>
                <c:if test="${not empty artist.getGenres()}"><b style="color: green">Artist`s genres: </b>
                    <c:forEach var="genre" items="${artist.getGenres()}">
                            <b style="color:goldenrod">  ${genre},</b>
                    </c:forEach>
                </c:if>
                <div align="center">
                <c:forEach var="numOfelem2" begin="0" end="5" step="1">
                    <br>
            <iframe
                    ${topTracksByArtists.get(numOfelem2).getUri()}
                    src="https://open.spotify.com/embed?uri=${topTracksByArtists.get(numOfelem2).getUri()}"
                    width="300" height="80" frameborder="0" allowtransparency="true" align="middle"></iframe><br>

        </c:forEach>
                </div>
            </th>
        </tr>
        <tr>
            <td class="tg-yw4l">

            <td class="tg-yw4l">

            </td>
        </tr>
    </table>

    <%--<div class="col-md-6"><p class="lead">${artist.getName()}</p></div>
        <div class="col-md-6"><img src="${artist.getImages().get(0).getUrl()}"  width="200" height="200">


            <c:if test="${not empty artist.getGenres()}">

                <c:forEach var="genre" items="${artist.getGenres()}">
                    <div>
                    <p>${genre}</p>
                    </div>
                </c:forEach>
            </c:if>

        </div>

    </div>--%>

<%--<c:forEach var="numOfelem2"  begin="0" end="2" step="1">
    <tr><td align="left">

        <iframe
                src="https://open.spotify.com/embed?uri=${topTracksByArtists.get(numOfelem).get(numOfelem2).getUri()}"
                width="300" height="80" frameborder="0" allowtransparency="true"></iframe><br>
    </td></tr>
</c:forEach>--%>




</div>

</body>
</html>
<html>

