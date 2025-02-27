<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="html" %>

<p>Hello, <html:property value="name" /> </p>

<html:form action="hello2" method="POST">
    <html:label for="name" value="New Name"/>
    <html:textfield name="name"/>
    <html:fielderror fieldName="name"/>
    <html:submit name="submitted" />
</html:form>