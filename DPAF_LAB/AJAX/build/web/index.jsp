<%-- 
    Document   : index
    Created on : Mar 2, 2020, 9:12:22 PM
    Author     : Yash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="checkuserid.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body onload="init()">
        <h1>Kindly fill up details for your registration</h1>
        <form name="registrationForm" action="register">
            <table border="0" cellpadding="5">
                <tr>
                    <td>User Id:</td>
                    <td><input type="textfield" name="userid" id="userid" onchange="doChecking()"/></td>
                    <td><div id="status"></div></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="textfield" name="name"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Semester:</td>
                    <td><input type="textfield" name="sem"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="submit"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
