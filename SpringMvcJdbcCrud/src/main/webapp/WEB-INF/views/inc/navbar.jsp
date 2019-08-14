<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav
			class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
				<a class="navbar-brand brand-logo" href='<s:url value="/dashboard"></s:url>'> <img
					src='<s:url value="/resources/assets/images/logo.svg"></s:url>'
					alt="logo" />
				</a> <a class="navbar-brand brand-logo-mini" href="../../index.html">
					<img src="/resources/assets/images/logo-mini.svg" alt="logo" />
				</a>
			</div>
			<div class="navbar-menu-wrapper d-flex align-items-center">
				<ul class="navbar-nav">
					<li class="nav-item font-weight-semibold d-none d-lg-block">Help
						: +050 2992 709</li>
				</ul>
				<form class="ml-auto search-form d-none d-md-block" action="#">
					<div class="form-group">
						<input type="search" class="form-control"
							placeholder="Search Here">
					</div>
				</form>
				<ul class="navbar-nav ml-auto">
					<li
						class="nav-item dropdown d-none d-xl-inline-block user-dropdown">
						<a class="nav-link dropdown-toggle" id="UserDropdown" href="#"
						data-toggle="dropdown" aria-expanded="false"> <img
							class="img-xs rounded-circle"
							src='<s:url value="/resources/assets/images/faces/face8.jpg"></s:url>'
							alt="Profile image">
					</a>
						<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
							aria-labelledby="UserDropdown">
							<div class="dropdown-header text-center">
								<img class="img-md rounded-circle"
									src='<s:url value="/resources/assets/images/faces/face8.jpg"></s:url>'
									alt="Profile image">
								<p class="mb-1 mt-3 font-weight-semibold">${userName }</p>
								<!-- <p class="font-weight-light text-muted mb-0">allenmoreno@gmail.com</p> -->
								
								<p class="font-weight-light text-muted mb-0">${userMail }</p>
								
							</div>
							<a class="dropdown-item">My Profile <span
								class="badge badge-pill badge-danger">1</span><i
								class="dropdown-item-icon ti-dashboard"></i></a> <a
								class="dropdown-item">Messages<i
								class="dropdown-item-icon ti-comment-alt"></i></a> <a
								class="dropdown-item">Activity<i
								class="dropdown-item-icon ti-location-arrow"></i></a> <a
								class="dropdown-item">FAQ<i
								class="dropdown-item-icon ti-help-alt"></i></a> 
								<a class="dropdown-item" href='<s:url value="/exit"></s:url>' >Sign Out<i class="dropdown-item-icon ti-power-off"></i></a>
						</div>
					</li>
				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="mdi mdi-menu"></span>
				</button>
			</div>
		</nav>

		