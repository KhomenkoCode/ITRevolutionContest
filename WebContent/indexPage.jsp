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
    <link rel="shortcut icon" type="image/png" href="static/favicon.ico"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div class="site-wrapper">

						<div class="site-wrapper-inner">

							<div class="cover-container">



								<div class="inner cover">
								
									<h1 class="cover-heading">Ratings for Spotify Artist</h1>
									<p >Simple way to discover new music and artists based on our revolutionary rating system</p>
									<p class="lead">Hey, we need to authenticate you through Spotify.</p>
									<p class="lead">
										<a
											href="
											https://accounts.spotify.com/authorize/?client_id=${clientID}&response_type=code&redirect_uri=${redirectLink}
											"
											class="btn btn-lg btn-secondary">Connect to Spotify</a>
									</p>
									
								</div>



							</div>

						</div>

					</div>
</body>
</html>