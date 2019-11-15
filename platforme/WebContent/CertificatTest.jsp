<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
   <script>
    
        function disableBack() { window.history.forward() }

        window.onload = disableBack();

        window.onpageshow = function(evt) { if (evt.persisted){ 
}}
        </script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Bootshop online Shopping cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--Less styles -->
   <!-- Other Less css file //different less files has different color scheam
	<link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
	-->
	<!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
	<script src="themes/js/less.js" type="text/javascript"></script> -->
	
<!-- Bootstrap style --> 
    <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
    <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
<!-- Bootstrap style responsive -->	
	<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
	<link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->	
	<link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
<!-- fav and touch icons -->
    <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
	<style type="text/css" id="enject"></style>
  </head>
<body >

<div class="hero-unit" >
        <h1 style="
    font-style: italic;
    text-align: center;
">Bonjour, ${requestScope.resultmsg}!</h1>
      </div>
<hr>

<div class="progress progress-danger progress-striped" style="margin-bottom: 9px;margin-left: 25%; width: 50%;">
      <div class="bar" style="width: ${requestScope.resultpourcentage }%"></div>
       
      </div>
      <p style="margin-left: 50%;">${requestScope.resultpourcentage}%</p>
<div class="span6" style="margin-bottom: 9px;margin-left: 25%;">
		<table class="table table-striped">
        <thead>
          <tr>
            <th>Numero Question</th>
            <th>Resultat</th>
            <th>Resultat</th>
          </tr>
        </thead>
        <tbody>
        <%int i=0;
	%>
	<c:forEach var="item" items="${requestScope.ListResultat}" >
	<div >
	<%
	i++;
	%>
          <tr>
            <td><%out.print(i) ; %>)</td>
            <td>		${item.rep}</td>
            <td><img src="img/${item.res}.png" style=" width: 10%;" alt=""/></td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      	      			<form  action="ControleurFormation" method="get" class="form-horizontal loginFrm"  >
      	      					  <input type="hidden" name="page" value="TestFinal" />
			      	              <input type="hidden" name="id_user" value="${ sessionScope.id_user}" />
						      	  <input type="hidden" name="id_test" value="${sessionScope.id_test }" />
			
<div class="hero-unit" >

			 
			 <table>
			 <tr><td>
			 			Nom et prénom:  <input name="nom" />
			 </td>
			 </tr>
			 <tr>
			 <td>
			Adresse postale:  <textarea name="Registre_commerce" id="aditionalInfo" cols="26" rows="3" placeholder="adresse postale"></textarea>
		</td>
		</tr>
			  <tr>
			  <td>
            <button type="submit" class="btn btn-primary">Save</button>
            </td>
            </tr>
          			</div>
          
      	      </form>
    
      			 </table>
      
	</div>


</body>
</html>