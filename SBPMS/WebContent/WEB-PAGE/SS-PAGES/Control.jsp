<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
</head>
<body>
<div id="body-wrapper"><!-- Wrapper for the radial gradient background -->
<div id="sidebar">
<div id="sidebar-wrapper"><!-- Side bar with logo and menu -->
<h1 id="sidebar-title"><a href="#">Home Page</a></h1>
<!-- Side bar Profile links -->
<div id="profile-links">Welcome!
<a href="changePassword.action" target="main" title="ChangePassword">${user_login.name}</a><br />
<br />
<a href="http://hi.baidu.com/brinelee/" target="_parent">Home Page</a> | <a
    href="logout.action" title="Sign Out" target="_parent">Log out</a></div>
<ul id="main-nav">
    <!-- Accordion Menu -->
    <li><a href="#" class="nav-top-item">Manage User</a>
    <ul>
        <li><a href="./../ChangePassword.jsp" target="main">Change Password</a></li>
    </ul>
    </li>
    <li><a href="#" class="nav-top-item">Manage Request</a>
    <ul>
        <li>TODO</li>
    </ul>
    </li>
</ul>
</div>
<!-- End #main-nav --> <!-- Maybe some message here --></div>
<!-- End #sidebar --></div>
</body>
</html>
