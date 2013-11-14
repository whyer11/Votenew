<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Manage User</title>
</head>

<body>
<div id="main-content"><!-- Main Content Section with everything -->
<!-- Page Head -->
<h2 id="total-intro">Welcome</h2>
<p id="page-intro">Manage User</p>
<div class="content-box">
<!-- Start Content Box -->
<div class="content-box-header">
<h3>Change Password</h3>
<ul class="content-box-tabs">
    <!-- href must be unique and match the id of target div -->
</ul>
<div class="clear"></div>
</div>
<!-- End .content-box-header -->
<div class="content-box-content">
<div class="tab-content default-tab" id="tab"><!-- This is the target div. id must match the HREF of this div's tab -->
<div class="notification attention png_bg">
<div>Default password is 123</div>
<div id="actionError"><s:actionerror /></div>
</div>
<!-- input use ismap to i18n -->
<form action="changePassword.action">
<table>
    <tbody>
        <tr>
            <td>Old password</td>
            <td><input type="password" name="passwordJudge" /></td>
        </tr>
        <tr>
            <td>New password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Repassword</td>
            <td><input type="password" name="rePassword" /></td>
        </tr>
        <tr>
            <td rowspan="1"><s:submit></s:submit></td>
        </tr>
    </tbody>
</table>
</form>
</div>
<!-- End #tab1 --></div>
<!-- End .content-box-content --></div>
<!-- End .content-box -->
<div class="clear"></div>
<div id="footer"><small> <!-- Remove this notice or replace it with whatever you want -->
&#169;company<a href="">Ian</a>SBPMS</small></div>
<!-- End #footer --></div>
<!-- End #main-content -->
</body>
</html>