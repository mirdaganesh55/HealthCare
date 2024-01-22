<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
<h:head>
    <title>Your Page Title</title>
    <!-- Add your CSS and JS dependencies here -->
    <style>
      @import "compass/css3";

$navHeight: 26px;

@mixin badge($color: #67c1ef) {
  background: $color;
  border-color: darken($color, 12%);
  @include background-image(linear-gradient(top, lighten($color, 15%), $color));
}

body {
  font: 13px/20px 'Lucida Grande', Tahoma, Verdana, sans-serif;
  color: #404040;
  background: #ecedef;
}

.container {
  margin: 80px auto 120px;
  width: 640px;
}

nav {
  height: $navHeight;
  text-align: center;

  ul {
    border-width: 1px;
    border-style: solid;
    border-color: #d5d5d5 #d2d2d2 #cdcdcd;
    border-radius: 3px;
    list-style: none;
    padding: 0;
    margin: 0;
    @include inline-block;
    @include box-shadow(0 1px 1px rgba(black, .04));
  }

  li {
    float: left;
    border-left: 1px solid #d2d2d2;

    &:first-child {
      border-left: 0;
      a { border-radius: 3px 0 0 3px; }
    }

    &:last-child a { border-radius: 0 3px 3px 0; }
  }

  a {
    display: block;
    position: relative;
    padding: 0 14px;
    height: $navHeight;
    line-height: $navHeight;
    font-size: 11px;
    font-weight: bold;
    color: #666;
    text-decoration: none;
    text-shadow: 0 1px white;
    background: #fafafa;
    @include background-image(linear-gradient(top, #fcfcfc, #f0f0f0));
    @include box-shadow(inset 0 0 0 1px #fafafa);

    &:hover {
      color: #333;
      z-index: 2;
      @include box-shadow(inset 0 0 0 1px #fafafa, 0 0 3px rgba(black, .3));
    }
  }

  li.active a, a:active {
    color: #333;
    background: white;
    @include box-shadow(inset 0 0 3px rgba(black, .1));
  }

  .badge {
    display: block;
    position: absolute;
    top: -12px;
    right: 3px;
    line-height: 16px;
    height: 16px;
    padding: 0 5px;
    font-family: Arial, sans-serif;
    color: white;
    text-shadow: 0 1px rgba(black, .25);
    border: 1px solid;
    border-radius: 10px;
    @include box-shadow(inset 0 1px rgba(white, .3), 0 1px 1px rgba(black, .08));

    & {
      @include badge;
    }

    &.green {
      @include badge(#77cc51);
    }

    &.yellow {
      @include badge(#faba3e);
    }

    &.red {
      @include badge(#fa623f);
    }
  }
}
    </style>
</h:head>
<h:body>
        <div class="containe	r">
    <nav>
      <ul>
        <li class="active"><a href="#">Dashboard</a></li>
        <li><a href="#">Tasks<span class="badge">4</span></a></li>
        <li><a href="#">Messages<span class="badge green">8</span></a></li>
        
<div class="dropdown">
			<button class="dropbtn">
				Appointment <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="makeAppointment.jsf">Book An Appointment</a> <a
					href="appointmentDetails.jsf">Appointment Details</a>
			</div>
			
		</div>        
        <li><a href="#">Notifications<span class="badge red">16</span></a></li>
        <li><a href="#">Logout</a></li>
      </ul>
    </nav>
  </div>
</h:body>
</html>
