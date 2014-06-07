<%@page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<portlet:defineObjects />
<form action="<portlet:actionURL />" method="post">
	<p>editページ.</p>
	<table>
		<tr>
			<td><input type="submit"></td>
		</tr>
		<tr>
			<td><textarea name="html" rows="10" cols="40">${requestScope.html }</textarea></td>
		</tr>
		<tr>
			<td>${requestScope.html }</td>
		</tr>
	</table>
</form>
