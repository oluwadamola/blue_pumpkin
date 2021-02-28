<%@page import="javax.inject.Inject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="com.bluepumpkin.entity.Event"%>
<%@page import="com.bluepumpkin.entity.Event"%>
<%@page import="com.bluepumpkin.dao.EventDaoLocal"%>
<%@page import="javax.ejb.EJB"%>
<%!
    @Inject
    EventDaoLocal eventdao;
    int count;
%>
<%
    count = eventdao.count();
%>
