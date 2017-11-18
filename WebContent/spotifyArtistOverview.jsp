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
    <link href="static/css/stars.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/png" href="static/favicon.ico" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="static/js/rating_ajax.js"></script>

</head>
<body >
<div class="container">
    <div style="margin-top: 20pt;">
        <div class="col-lg-6" style="width: 100%;">
            <div class="input-group">
                <form method="post">
					<span class="input-group-btn"> <input type="text"
                                                          name="artist_post" placeholder="Search artist" class="form-control"
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
	height:200pt;"><img class="img-responsive img-rounded" src=
    <c:choose>
    <c:when test="${artist.getImages().size() == 0}">
       "static/img/noartistphoto.png"
    </c:when>
    <c:otherwise>
                    ${artist.getImages().get(0).getUrl()}
    </c:otherwise>
</c:choose>
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
                <h1 class="lead" align="center" style="padding-left:25px">${artist.getName()}</h1>
                <form method="post" accept-charset="utf-8">
                    <table>
                        <tr style="vertical-align: middle;">
                            <td>
                                <div class="stars" class="form-group" align="center" >
                                    <input class="star star-5" id="star-5" type="radio" required
                                           name="star" value="5" /> <label class="star star-5" for="star-5"></label>
                                    <input class="star star-4" id="star-4" type="radio" required
                                           name="star" value="4" /> <label class="star star-4" for="star-4"></label>
                                    <input class="star star-3" id="star-3" type="radio" required
                                           name="star" value="3" /> <label class="star star-3" for="star-3"></label>
                                    <input class="star star-2" id="star-2" type="radio" required
                                           name="star" value="2" /> <label class="star star-2" for="star-2"></label>
                                    <input class="star star-1" id="star-1" type="radio" required
                                           name="star" value="1" /> <label class="star star-1" for="star-1"></label>
                                </div>
                            </td>
                            <td>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input class="btn btn-primary" type="submit" value="Post Review" />
                            </td>
                        </tr>
                    </table>
                </form>

                <h2 class="lead" align="center" style="padding-left:25px">${artist.getPopularity()}</h2>
                <br>
                <c:if test="${not empty artist.getGenres()}"><b style="color: green">Artist`s genres: </b>
                    <c:forEach var="genre" items="${artist.getGenres()}">
                            <b style="color:goldenrod">,  ${genre}</b>
                    </c:forEach>
                </c:if>
                    <c:choose>
                        <c:when test="${topTracksByArtists.size()<5}">
                            <p align="center"> Sorry this user does not have enough tracks to create Top 5.</p>
                        </c:when>
                        <c:when  test="${topTracksByArtists.size()>=10}">
                            <table class="tg">
                                <tr>
                                    <th class="tg-yw4l" style="padding-left:25px">
                                        <c:forEach var="numOfelem2" begin="0" end="4" step="1">
                                            <div align="center">
                                                <br>
                                                <iframe
                                                    ${topTracksByArtists.get(numOfelem2).getUri()}
                                                        src="https://open.spotify.com/embed?uri=${topTracksByArtists.get(numOfelem2).getUri()}"
                                                        width="300" height="80" frameborder="0" allowtransparency="true" align="middle"></iframe><br>
                                            </div>
                                        </c:forEach>
                                    </th>
                                    <th class="tg-yw4l" style="padding-left:25px">
                                        <c:forEach var="numOfelem2" begin="5" end="9" step="1">
                                            <div align="center">
                                                <br>
                                                <iframe
                                                    ${topTracksByArtists.get(numOfelem2).getUri()}
                                                        src="https://open.spotify.com/embed?uri=${topTracksByArtists.get(numOfelem2).getUri()}"
                                                        width="300" height="80" frameborder="0" allowtransparency="true" align="middle"></iframe><br>
                                            </div>
                                        </c:forEach>
                                    </th>
                                </tr>
                            </table>

                        </c:when>
                        <c:otherwise>
                            <c:forEach var="numOfelem2" begin="0" end="4" step="1">
                                <div align="center">
                                    <br>
                                    <iframe
                                        ${topTracksByArtists.get(numOfelem2).getUri()}
                                            src="https://open.spotify.com/embed?uri=${topTracksByArtists.get(numOfelem2).getUri()}"
                                            width="300" height="80" frameborder="0" allowtransparency="true" align="middle"></iframe><br>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>



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

