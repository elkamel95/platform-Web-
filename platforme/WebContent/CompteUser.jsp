<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>
    
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Takwin</title>
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
<body>
<div id="header">
<div class="container">
<br>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
    <a class="brand" href="index.html"><img src="themes/images/logo.png" alt="Bootsshop"/></a>
	
    <ul id="topMenu" class="nav pull-left">
	 <li class=""><a href="ControleurFormation?page=index">Formation </a></li>
	 <li class=""><a href="ControleurFormation?page=cours">Apprentissage en ligne</a></li>
	 	 <li class=""><a href="ControleurFormation?page=Recrutement">Recrutement</a></li>
	 
	 <li class=""><a href="contact.html">Contact</a></li>
	 </ul>

                  <ul id="topMenu" class="nav pull-left">
  
   
    <li  class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">${requestScope.nb}</span> <b class="caret"></b></a>
      <ul  class="dropdown-menu" style="width: 250px; height: 200px; overflow: auto ;"  >
      				                	 <c:forEach var="item" items="${requestScope.ListMessage}" >
      				                	   <c:choose>
	       <c:when test="${item.notification eq '3' }">
        <li style="background-color: aliceblue"><a class="sAdd" title="" href="ControleurFormation?idMessage=${item.messageA}&&id_user=${item.id_user}&&page=reservation"><div class="alert alert-info" style="margin-left: -10%;margin-top: -10%;"><i class="icon-book"></i> Réservation</div></a></li>
          </c:when>
          				  <c:otherwise>
      <li ><a class="sAdd" title="" href="ControleurFormation?msg=${item.message}&&id_user=${item.id_user}&&page=messageRecu"><div class="alert alert-success"style="margin-left: -10%;margin-top: -10%;">
      <i class="icon-plus"></i> ${item.message}</div></a></li>
          				  
          </c:otherwise>
          </c:choose>
           </c:forEach>  
          
      </ul>
            <li class=""><a title="" href="ControleurFormation?id_user=${sessionScope.id_user}&&page=ViewUser"><i class="icon icon-cog"></i> </a></li>
      
    </li>
    	 <li class="">
	 <a href="ControleurFormation" role="button"  style="padding-right:0"><span class="label label-success">mon compte</span></a>
	</li>
	 <li class="">
	 
	 
	 <a href="ControleurFormation?page=deconnexion" role="button"  style="padding-right:0"><span class="label label-success">Déconnexion</span></a>
	
	</li>
  </ul>	
  </div>
</div>
</div>
</div>
<!-- Header End====================================================================== -->
<div id="carouselBlk">
	<div id="myCarousel" class="carousel slide">
		<div class="carousel-inner">
		<%int Z=0; %>
				                	 <c:forEach var="item" items="${requestScope.listeSlider}" >
				                	 <%if(Z<1){ %>
		
		  <div class="item active">
		  <div class="container">
			<a href="register.html"><img style="width:100%" src="themes/images/carousel/${item.image }" alt="special offers"/></a>
			<div class="carousel-caption">
				  <h4>Second Thumbnail label</h4>
				  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
		  </div>
		  </div>
		<% Z=1;%>  
		  <%}else{ %>
		  <div class="item">
		  <div class="container">
			<a href="register.html"><img style="width:100%" src="themes/images/carousel/${item.image }" alt=""/></a>
				<div class="carousel-caption">
				  <h4>LES PROFESSIONNELLE DE LA FORMATION</h4>
				  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
				</div>
		  </div>
		  </div>
		  <%} %>
		  </c:forEach>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
	  </div> 
</div>

<div id="mainBody">
	<div class="container">
	<div class="row">
<!-- Sidebar ================================================== -->
	<c:choose>
	<c:when test="${sessionScope.validation eq '1' }">
	<div id="sidebar" class="span3">
	</c:when>
	<c:otherwise>
		<div id="sidebar" class="span3" style="
    margin-top: 24%;
">
	
	</c:otherwise>
	</c:choose>
	<!-- Gerer formation ================================================== -->
	<c:choose>
	<c:when test="${sessionScope.validation eq '1' }">
	
	<c:choose>
      <c:when test="${sessionScope.id_role eq '1' }">
		<h4>Gérer Formation </h4>
		<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="InsertFormation"/>
		
<div class="well well-small"><button   class="btn btn-success dropdown-toggle" style="width: 100%;" > Insérer  Formation</button></div>
</form>

	<div class="well well-small"><a href="ControleurFormation"><button class="btn btn-warning dropdown-toggle"  style="width: 100%;">Mise à jour  Formation<span class="caret"></span></button></a></div>	
	
	<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="DeleteAllFormationUser"/>
	
	<div class="well well-small"><button class="btn btn-danger dropdown-toggle"  style="width: 100%;">Supprimer tout les Formation <span class="caret"></span></button></div>	
	</form>
		<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="message"/>
	Message:<textarea rows="" cols="" name="msg"></textarea>
	<div class="well well-small"><button class="btn btn-danger dropdown-toggle"  style="width: 100%;">Envoyer <span class="caret"></span></button></div>	
	</form>
	</c:when>
	      <c:when test="${sessionScope.id_role eq '2' }">
	      <h4>Gérer Recretement </h4>
		<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="InsertJobOffer"/>
		
<div class="well well-small"><button   class="btn btn-success dropdown-toggle" style="width: 100%;" > Insérer  </button></div>
</form>
	<div class="well well-small"><a href="ControleurFormation"><button class="btn btn-warning dropdown-toggle"  style="width: 100%;">Mise à jour  </button></a></div>	
	<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="DeleteAllJob"/>
	
	<div class="well well-small"><button class="btn btn-danger dropdown-toggle"  style="width: 100%;">Supprimer tout </button></div>	
	</form>
	<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="UploadCV"/>
			<div class="well well-small"><button class="btn btn-warning dropdown-toggle"  style="width: 100%;">CV   [${ requestScope.nbCv}]</button></div>	
				<input type="hidden" name="Id_User" value="${sessionScope.id_user}"/>
		
	</form>
		<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="message"/>
	Message:<textarea rows="" cols="" name="msg"></textarea>
	<div class="well well-small"><button  class="btn btn-success dropdown-toggle" style="width: 100%;">Envoyer <span class="caret"></span></button></div>	
	</form>
	</c:when>
	
	
	</c:choose>
	</c:when>
	
	</c:choose>
		<br/>
						                	 <c:forEach var="item" items="${requestScope.listePub}" >
		
		  <div class="thumbnail">
			<img src="themes/images/Pub/${item.image }" alt="Bootshop panasonoc New camera"/>
			<div class="caption">
			  <h5>Panasonic</h5>
			</div>
		  </div><br/>
		  </c:forEach>
			<br/>
		
	</div>
<!-- Sidebar end=============================================== -->
<!-- InsertFormation=============================================== -->
<c:choose>
      <c:when test="${sessionScope.validation eq '0' }">
<div class="hero-unit">
        <h1 style="
    margin-left: 30%;
">Bon jour Monsieur</h1>
        <p style="
    margin-left: 10%;
"> Votre compte au cours de vérification . cette action peut prendre des minutes ou  quelques jours. merci </p>
<div style="
    margin-left: 50%;
">
<img src="img/lightbox-ico-loading.gif"/ ></div>
      </div>
      </c:when>
      </c:choose>
<c:choose>
      <c:when test="${sessionScope.id_role eq '1' }">
  <c:choose>
  
                              <c:when test="${requestScope.Action eq 'ViewUser' }">
                              		<div class="span9">
                              
                                <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          <form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="mis_a_jourUser"/>
          <c:forEach var="item" items="${requestScope.ListUserInfo}" >
          
          
            <table class="table table-bordered data-table">
          
             
<tr><td>nom:</td><td><input name="nom" value="${item.nomUser}"/></td></tr>     
<tr><td>prenom :</td><td><input name="pren" value="${item.pren}"/></td></tr>               
<tr><td>mot passe:</td><td><input name="motPasse" value="${item.motPasse}"/></td></tr>      
<tr><td>email:</td><td><input name="email" value="${item.email}"/></td></tr>               
         
<tr><td>Tel:</td><td><input name="tel" value="${item.tel}"/></td></tr>               
<tr><td>Nom_de_lentreprise:</td><td><input name="Nom_de_lentreprise" value="${item.nom_de_lentreprise}"/></td></tr>               
<tr><td>Adresse:</td><td><input name="Adresse" value="${item.adresse}"/></td></tr>               
<tr><td>Ville:</td><td>${item.ville}</td></tr>               
<tr><td>Pays:</td><td>${item.pays}</td></tr>               
<tr><td>Registre_commerce:</td><td>${item.registre_commerce}</td></tr>               
           
               
           
            </table>
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
          </div>
       
        </div>
 </div>
                       </c:forEach>
                                 <button type="Submit"class="btn btn-warning dropdown-toggle" >Mis a jour </button>
                       
                       </form>
        </div>
             </c:when>   
                 <c:when test="${requestScope.Action eq 'InsertFormation' }">
                 
             <p>${ requestScope.id_User}</p>
		<div class="span9">
    <ul class="breadcrumb">
                 <div class="alert alert-success">${requestScope.msg}</div>
    </ul>
	<div class="well">
	<!--
	<div class="alert alert-info fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	<div class="alert fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	 <div class="alert alert-block alert-error fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div> -->
	<form class="form-horizontal" action="ControleurFormation" method="post" enctype="multipart/form-data">
	       <input type="hidden" name="Action" value="InsertFormation"/>
	
	
		<div class="control-group">
			<label class="control-label" for="inputFname1">Title <sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="inputFname1" placeholder="Title" name="title" required>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="country">Categories<sup>*</sup></label>
			<div class="controls">
		 <select name="Categ" required>
                  <c:forEach var="itemCat" items= "${requestScope.Cat}">
                
                  <option  value="${itemCat.id}"> ${itemCat.nom} </option>
                </c:forEach>
                </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="country">Sous Categories<sup>*</sup></label>
			<div class="controls">
		  <select name="SousCateg" required>
                  <c:forEach var="itemSousCat" items= "${requestScope.SousCat}">
                
                  <option  value="${itemSousCat.id}"> ${itemSousCat.nom} </option>
                </c:forEach>
                </select>
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label" for="inputLnam">Prix <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="prix" placeholder="Prix" required>
			</div>
		 </div>
	  
		<div class="control-group">
		<label class="control-label">date débute <sup>*</sup></label>
		<div class="controls">
		  <select class="span1" name="days" required>
					<option  value="">dd</option>
					<option selected value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
			</select>
			<select class="span1" name="mmm" required>
				<option value="">-</option>
							<option  value="">mmm</option>
						<option selected value="1">Jan</option>
						<option value="2">Feb</option>
						<option value="3">Mar</option>
						<option value="4">Apr</option>
						<option value="5">May</option>
						<option value="6">Jun</option>
						<option value="7">Jul</option>
						<option value="8">Aug</option>
						<option value="9">Sep</option>
						<option value="10">Oct</option>
						<option value="11">Nov</option>
						<option value="12">Dec</option>
			</select>
			<select class="span1" name="yyyy" required>
				<option value="">-</option>
				<option value="">yyyy</option>
						<option selected value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
			</select>
		</div>
	  </div>

		<div class="control-group">
		<label class="control-label">date fin  <sup>*</sup></label>
		<div class="controls">
		  <select class="span1" name="days2" required>
					<option  value="">dd</option>
					<option selected value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
			</select>
			<select class="span1" name="mmmFin" required>
				<option value="">-</option>
							<option  value="">mmm</option>
						<option selected value="1">Jan</option>
						<option value="2">Feb</option>
						<option value="3">Mar</option>
						<option value="4">Apr</option>
						<option value="5">May</option>
						<option value="6">Jun</option>
						<option value="7">Jul</option>
						<option value="8">Aug</option>
						<option value="9">Sep</option>
						<option value="10">Oct</option>
						<option value="11">Nov</option>
						<option value="12">Dec</option>
			</select>
			<select class="span1" name="yyyyfin" required>
				<option value="">-</option>
				<option value="">yyyy</option>
						<option selected value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
			</select>
		</div>
	  </div>
	  	<div class="control-group">
		<label class="control-label">Ville <sup>*</sup></label>
		<div class="controls">
	 <select id="ville"  name="Ville"> 
					<option  value="Tunis" selected>Tunis</option>
					<option value="Sfax">Sfax</option>
					<option value="Kairouan">Kairouan</option>
					<option value="Sousse">Sousse</option>
					<option value="Monastir">Monastir</option>
					<option value="Nabeul">Nabeul</option>
					<option value="Ariana">Ariana</option>
					<option value="Béja">Béja</option>
					<option value="Bizerte">Bizerte</option>
					<option value="Gabes">Gabes</option>
					<option value="Gafsa">Gafsa</option>
					<option value="Jendouba">Jendouba</option>
					<option value="Manouba">Manouba</option>
					<option value="Kasserine">Kasserine</option>
					<option value="Zaghouan">Zaghouan</option>
					<option value="Tozeur">Tozeur</option>
					<option value="Tataouine">Tataouine</option>
					<option value="Siliana">Siliana</option>
					<option value="Sidi Bouzid">Sidi Bouzid</option>
					<option value="Kebili">Kebili</option>
					<option value="Nabeul">Nabeul</option>
					<option value="Ben Arous">Ben Arous</option>
					<option value="Médenine">Médenine</option>
					<option value="Le Kef">Le Kef</option>
				
				</select>
				</div>
				</div>
	     <div class="control-group">
              <label class="control-label">Adresse</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required style="width: 40%;"/>
			   <span class="help-block">Adresse</span> 
                </div>
            </div>   
            <div class="control-group">
              <label class="control-label">Tel</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required style="width: 40%;"/>
			   <span class="help-block">Tel</span> 
                </div>
            </div>
	
		
		<div class="control-group">
			<label class="control-label" for="aditionalInfo"> Déscription</label>
			<div class="controls">
<textarea class="textarea_editor span12" rows="6" name="desc" required="" width="20%" style="width: 40%;"></textarea>			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="phone">select image <sup>*</sup></label>
			<div class="controls">
                <input type="file" name="file" required />
			</div>
		</div>
	<div class="control-group">
			<div class="controls">
			            <input type="hidden" name="id_user" value="${sessionScope.id_user}"/>

				<input class="btn btn-large btn-success" type="submit" value="enregistrer">
			</div>
		</div>		
	</form>
</div>

</div>
    </c:when>
                     <c:when test="${requestScope.Action eq 'message' }">
                     <div class="row-fluid">
      <div class="widget-box">
       

    <hr/>
    <div class="row-fluid">
      <div class="span6">
     
   <div class="widget-box">
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
          </div>
          <div class="widget-content nopadding collapse in" id="collapseG2">
            <ul class="recent-posts">
           
           
              <li>
                <div class="user-thumb"> <img width="40" height="40" alt="User" src="img/demo/av4.jpg"> </div>
                <div class="article-post"> <span class="user-info"> By: ${requestScope.nom } /  ${ requestScope.email } /  </span>
                  <p><a href="#">${requestScope.msg}.</a> </p>
                </div>
              <li>
<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="message"/>
				<input type="hidden" name="id_user" value="${requestScope.id_user}"/>
					
		
	Message:<textarea rows="" cols="" name="msg"></textarea>
	<div class="well well-small"><button  class="btn btn-success dropdown-toggle" style="width: 100%;">Envoyer <span class="caret"></span></button></div>	
	</form>              </li>
            </ul>
          </div>
        </div>

 
        
      </div>
     
    </div>
  </div>
</div>
                     </c:when>
     <c:when test="${requestScope.Action eq 'R' }">
                     
                     <div class="row-fluid">
      <div class="widget-box">
       

    <hr/>
    <div class="row-fluid">
      <div class="span6">
     
   <div class="widget-box">
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
          </div>
          <div class="well well-small" style="
    margin-left: 10%;
">
          <div class="widget-content nopadding collapse in" id="collapseG2">
            <ul class="recent-posts">
           
        
              <div>
              
              ${requestScope.ListRéservation}
              </div>
<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="message"/>
		
	</form>              </li>
            </ul>
          </div>
        </div>

 
        
      </div>
     
    </div>
  </div>
</div>
                     </c:when>
                 <c:when test="${requestScope.Action eq 'Mis_A_jourFormationUser' }">
                            <p>${ requestScope.id_User}</p>
		<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
    </ul>
	<div class="well">
	<!--
	<div class="alert alert-info fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	<div class="alert fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	 <div class="alert alert-block alert-error fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div> -->
	<form class="form-horizontal" action="ControleurFormation" method="post" enctype="multipart/form-data">
<input type="hidden" name="Id_page" value="UpdateFormation" >
                                   
         <c:forEach var="item" items= "${requestScope.formation}">
	
		<div class="control-group">
			<label class="control-label" for="inputFname1">Title <sup>*</sup></label>
			<div class="controls">
                <input type="text" class="span11" name="title" value="${item.nom }" style="width:25%"/>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="country">Categories<sup>*</sup></label>
			<div class="controls">
		 <select name="Categ" >
  <c:forEach var="itemCat" items= "${requestScope.Cat}">
                <c:choose>
  <c:when test="${itemCat.id eq item.id_cat}">
                  <option selected value="${itemCat.id}"> ${itemCat.nom} </option>
                    </c:when>
                  <c:otherwise>
                  <option  value="${itemCat.id}"> ${itemCat.nom} </option>
  </c:otherwise>
</c:choose>
           </c:forEach>
                </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="country">Sous Categories<sup>*</sup></label>
			<div class="controls">
		  <select name="SousCateg" >
  <c:forEach var="itemSousCat" items= "${requestScope.SousCat}">
                <c:choose>
  <c:when test="${itemSousCat.id eq item.id_Souscat}">
                  <option selected value="${itemSousCat.id}"> ${itemSousCat.nom} </option>
                    </c:when>
                  <c:otherwise>
                  <option  value="${itemSousCat.id}"> ${itemSousCat.nom} </option>
  </c:otherwise>
</c:choose>
           </c:forEach>
                </select>
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label" for="inputLnam">Prix <sup>*</sup></label>
			<div class="controls">
                <input type="text" class="span11" name="Prix" value="${item.prix}" style="width:10%"/>
			</div>
		 </div>
	  
		<div class="control-group">
		<label class="control-label">date débute <sup>*</sup></label>
		<div class="controls">

			                <input type="text" class="span11" name="Prix" value="${item.date_Debut}" style="width:20%"/>

			
		</div>
	  </div>

		<div class="control-group">
		<label class="control-label">date fin <sup>*</sup></label>
		<div class="controls">
		                 <input type="text" class="span11" name="Prix" value="${item.date_Fin}"style="width:20%"/>
		 
		</div>
	  </div>
			 <div class="control-group">
              <label class="control-label">Adresse</label>
              <div class="controls">
                <input type="text" class="span11" name="title" value="${item.adresse}" required style="
    width: 40%;
"/>
			   <span class="help-block">Adresse</span> 
                </div>
            </div>   
            <div class="control-group">
              <label class="control-label">Tel</label>
              <div class="controls">
                <input type="text" class="span11" name="title" value="${item.tel}"required style="
    width: 40%;
"/>
			   <span class="help-block">Tel</span> 
                </div>
            </div>
	
		
		<div class="control-group">
			<label class="control-label" for="aditionalInfo">déscription</label>
			<div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="desc" style="width:50%"><c:out value="${item.descrription}" /></textarea>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="phone">select image <sup>*</sup></label>
			<div class="controls">
			 <input type="hidden" name="id_formation" value="${item.id_formation}"/>
			            <input type="hidden" name="id_user" value="${sessionScope.id_user}"/>
                <input type="file" name="file" />
			</div>
		</div>

	
	<div class="control-group">
			<div class="controls">

				<input class="btn btn-large btn-success" type="submit" value="enregistrer">
			</div>
		</div>	
		                 </c:forEach>	
			
	</form>
</div>

</div>
                 
    </c:when>
    
                 </c:choose>
                 </c:when>
        <c:when test="${sessionScope.id_role eq '2' }">
          <c:choose>
                <c:when test="${requestScope.Action eq 'ViewUser' }">
                              		<div class="span9">
                              
                                <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          <form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="mis_a_jourUser"/>
          <c:forEach var="item" items="${requestScope.ListUserInfo}" >
          
          
            <table class="table table-bordered data-table">
          
             
<tr><td>nom:</td><td><input name="nom" value="${item.nomUser}"/></td></tr>     
<tr><td>prenom :</td><td><input name="pren" value="${item.pren}"/></td></tr>               
<tr><td>mot passe:</td><td><input name="motPasse" value="${item.motPasse}"/></td></tr>      
<tr><td>email:</td><td><input name="email" value="${item.email}"/></td></tr>               
         
<tr><td>Tel:</td><td><input name="tel" value="${item.tel}"/></td></tr>               
<tr><td>Nom_de_lentreprise:</td><td><input name="Nom_de_lentreprise" value="${item.nom_de_lentreprise}"/></td></tr>               
<tr><td>Adresse:</td><td><input name="Adresse" value="${item.adresse}"/></td></tr>               
<tr><td>Ville:</td><td>${item.ville}</td></tr>               
<tr><td>Pays:</td><td>${item.pays}</td></tr>               
<tr><td>Registre_commerce:</td><td>${item.registre_commerce}</td></tr>               
           
               
           
            </table>
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
          </div>
       
        </div>
 </div>
                       </c:forEach>
                                 <button type="Submit"class="btn btn-warning dropdown-toggle" >Mis a jour </button>
                       
                       </form>
        </div>
             </c:when>   
                 <c:when test="${requestScope.Action eq 'InsertJobOffer' }">
        		<div class="span9">
        
        <div class="well">
        	<form class="form-horizontal" action="ControleurFormation" method="post" enctype="multipart/form-data">
        	 <input type="hidden" name="InsertJobOffer" value="InsertJobOffer">
<div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
                <input type="text"  name="title" required style="width:60%"/>
            </div>   
            </div>
            <div class="control-group">
              <label class="control-label">nom de la société :</label>
              <div class="controls">
                <input type="text"  name="title" required style="width:60%"/>
            </div>   
            </div>
                 <div class="control-group">
              <label class="control-label">description_détaillée:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="desc" required style="width:60%"></textarea>
            </div>  
            </div>
                    <div class="control-group">
              <label class="control-label">Exigences</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Exigences" required style="width:60%"></textarea>
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">secteur d’activité </label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required style="width:60%"></textarea>
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">Lieu</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required style="width:60%"></textarea>
                </div>
            </div>        <div class="control-group">
              <label class="control-label">Expire le:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required style="width:60%"></textarea>
                </div>
            </div>
               <div class="control-group">
              <label class="control-label">Select Catégori</label>
              <div class="controls">
                <select name="Categ" >
                  <c:forEach var="itemCat" items= "${requestScope.Cat}">
                
                  <option  value="${itemCat.id}"> ${itemCat.nom} </option>
                </c:forEach>
                </select>
              </div>
            </div>
                <div class="control-group">
              <label class="control-label">Select sous Catégori</label>
              <div class="controls">
                <select name="SousCateg" >
                  <c:forEach var="itemCat" items= "${requestScope.SousCat}">
                
                  <option  value="${itemCat.id}"> ${itemCat.nom} </option>
                </c:forEach>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Logo</label>
              <div class="controls">
              
<input type="file"		name="file1"/>	   
<span class="help-block">Logo</span> 
<input  name="id_user" type="hidden" value="${sessionScope.id_user}"/>
                </div>
            </div>
                          <button type="submit" class="btn btn-success">enregistrer </button>
           
            </form>
            </div>
            </div>
            </c:when>
                <c:when test="${requestScope.Action eq 'message' }">
                     <div class="row-fluid">
      <div class="widget-box">
       

    <hr/>
    <div class="row-fluid">
      <div class="span6">
     
   <div class="widget-box">
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
          </div>
          <div class="widget-content nopadding collapse in" id="collapseG2">
            <ul class="recent-posts">
           
           
              <li>
                <div class="user-thumb"> <img width="40" height="40" alt="User" src="img/demo/av4.jpg"> </div>
                <div class="article-post"> <span class="user-info"> By:Administrateur </span>
                  <p><a href="#">${requestScope.msg}.</a> </p>
                </div>
              <li>
<form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="message"/>
				<input type="hidden" name="id_user" value="${requestScope.id_user}"/>
						<input type="hidden" name="nom" value=" ${requestScope.nom } }"/>
						<input type="hidden" name="email" value=" ${ requestScope.email }"/>
		
	Message:<textarea rows="" cols="" name="msg"></textarea>
	<div class="well well-small"><button  class="btn btn-success dropdown-toggle" style="width: 100%;">Envoyer <span class="caret"></span></button></div>	
	</form>              </li>
            </ul>
          </div>
        </div>

 
        
      </div>
     
    </div>
  </div>
</div>
                     </c:when>
                    
                 <c:when test="${requestScope.Action eq 'UpdateJobOffer' }">
        <c:forEach var="itemJob" items="${requestScope.listeJob}" >
        	<div class="span9">
        
        <div class="well">
        <form action="ControleurFormation" method="post" enctype="multipart/form-data" class="form-horizontal">
        <input type="hidden" name="UpdateJobOffer" value="UpdateJobOffer">
<div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
                <input type="text" class="span11" name="title" value="${itemJob.title}" required style="
    width: 50%;
"/>
                <span class="help-block">Title</span> </div>
            </div>   
            <div class="control-group">
              <label class="control-label">nom de la société :</label>
              <div class="controls">
                <input type="text" class="span11" name="nom_Sociter" value="${itemJob.nom_Sociter }" required style="
    width: 50%;
"/>
                <span class="help-block">nom de la société </span> </div>
            </div>   
                 <div class="control-group">
              <label class="control-label">description détaillée:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="desc" required style="
    width: 50%;
">${itemJob.description_détaillée }</textarea>
                <span class="help-block">description_détaillée</span> </div>
            </div>  
                    <div class="control-group">
              <label class="control-label">Exigences</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Exigences" required style="
    width: 50%;
">${itemJob.exigences}</textarea>
			   <span class="help-block">Exigences</span> 
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">Secteur d’activité</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required style="
    width: 50%;
">${itemJob.secteur_activité }</textarea>
			   <span class="help-block">Secteur d’activité</span> 
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">Lieu</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required style="
    width: 50%;
">${itemJob.lieu }</textarea>
			   <span class="help-block">Lieu</span> 
                </div>
            </div>        <div class="control-group">
              <label class="control-label">Expire le:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required style="
    width: 50%;
">${itemJob.expire }</textarea>
			   <span class="help-block">Expire le :</span> 
                </div>
            </div>
               <div class="control-group">
              <label class="control-label">Select Catégori</label>
              <div class="controls">
                <select name="Categ" style="
    width: 50%;
" >
                  <c:forEach var="itemCat" items= "${requestScope.Cat}">
                
                  <option  value="${itemCat.id}"> ${itemCat.nom} </option>
                </c:forEach>
                </select>
              </div>
            </div>
                <div class="control-group">
              <label class="control-label">Select sous Catégori</label>
              <div class="controls">
                <select name="SousCateg" style="
    width: 50%;
">
                  <c:forEach var="itemCat" items= "${requestScope.SousCat}">
                
                  <option  value="${itemCat.id}"> ${itemCat.nom} </option>
                </c:forEach>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Logo</label>
              <div class="controls">
              <input  name="id_user" type="hidden" value="${itemJob.id_User }"/>
                            <input  name="id_Job" type="hidden" value="${itemJob.id_offre }"/>
              
<input type="file"		name="file1"/>	   
<span class="help-block">Logo</span> 
                </div>
            </div>
                          <button type="submit" class="btn btn-success">enregistrer </button>
            
            </form>
            </div>
            </div>
            
            
            
            </c:forEach>
             </c:when>
                
                
            </c:choose>
                 </c:when>
                 </c:choose>
		<!-- endInsert -->
		<c:choose>
		<c:when test="${requestScope.RepCV eq 'CV' }">
			    			<div class="span9">		
	
<div class="tab-pane" id="listView">
<c:forEach var="item" items="${requestScope.listCV}" >

				<div class="row">	
		<a  href="themes/CV/${item.CV}">
				 
					<div class="span2">
					
						<img src="themes/CV/CV.png" alt=""/>
					</div>
					</a>
					<div class="span4">
						<hr class="soft"/>
					
						&nbsp;&nbsp;
					    <a class="btn btn-small pull-left" href="ControleurFormation?page=Delete_CV&ID_CV=${item.id_cv}">Supprimer</a>
						
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
				
					</div>
			</div>
			</c:forEach>
			</div>
</div>
</c:when>
		        <c:when test="${sessionScope.id_role eq '1' }">
		<hr/>
			  <ul class="thumbnails">
			  	 <c:forEach var="item" items="${requestScope.listeformation}" >
			  
				<li class="span3">
				  <div class="thumbnail">
					<a  href="ControleurFormation?page=View&&id=${item.id_formation}">
					<div class="image_resize">
					<img src="themes/images/products/${item.image}" alt="" class="image_resize"/>
					</div></a>
					<div class="caption">
					  <h5>${itemJob.nom}</h5>
					
					 
					  <h4 style="text-align:center"><a class="btn" href="ControleurFormation?page=View&&id=${item.id_formation}"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Réserver <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">prix: $ ${item.prix}</a></h4>
					  <form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="Mis_A_jourFormationUser"/>
		<input type="hidden" name="id_formation" value= "${item.id_formation }">
	<div class="well well-small"><button class="btn btn-warning dropdown-toggle"  style="width: 80%;">Mis a Jour <span class="caret"></span></button></div>	
	</form>
				  <form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="DELETETraining"/>
		<input type="hidden" name="id_formation" value= "${item.id_formation }">
	<div class="well well-small"><button class="btn btn-danger dropdown-toggle"  style="width: 80%;">Supprimer  <span class="caret"></span></button></div>	
	</form>
					</div>
				  </div>
				</li>
				</c:forEach>
			  </ul>	
</c:when>
		        <c:when test="${sessionScope.id_role eq '2' }">
		
<hr/>
			  <ul class="thumbnails">
			  	 <c:forEach var="itemJob" items="${requestScope.listJob}" >
			  
				<li class="span3">
				  <div class="thumbnail">
					<a  href="ControleurFormation?page=Recrutement_details&&id_Job=${itemJob.id_offre }">
					<div class="image_resize">
					<img src="themes/images/Job/${itemJob.image}" alt="" class="image_resize"/>
					</div></a>
					<div class="caption">
					  <h5>${itemJob.title}</h5>
					 
					 
					  <form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="UpdateJobOffer"/>
		<input type="hidden" name="id_Job"  value= "${itemJob.id_offre}">
	<div class="well well-small"><button class="btn btn-warning dropdown-toggle"  style="width: 80%;">Mise à jour  Formation<span class="caret"></span></button></div>	
	</form>
				  <form action="ControleurFormation" method="get">
		<input type="hidden" name="page" value="DELETEJob"/>
		<input type="hidden" name="id_offre" value= "${itemJob.id_offre }">
	<div class="well well-small"><button class="btn btn-danger dropdown-toggle"  style="width: 80%;">Supprimer  <span class="caret"></span></button></div>	
	</form>
					</div>
				  </div>
				</li>
				</c:forEach>
			  </ul>	
</c:when>
		        
</c:choose>
		</div>
		</div>
	</div>
<!-- Footer ================================================================== -->
	<div  id="footerSection">
	<div class="container">
		<div class="row">
			<div class="span3">
				<h5>ACCOUNT</h5>
				<a href="login.html">YOUR ACCOUNT</a>
				<a href="login.html">PERSONAL INFORMATION</a> 
				<a href="login.html">ADDRESSES</a> 
				<a href="login.html">DISCOUNT</a>  
				<a href="login.html">ORDER HISTORY</a>
			 </div>
			<div class="span3">
				<h5>INFORMATION</h5>
				<a href="contact.html">CONTACT</a>  
				<a href="register.html">REGISTRATION</a>  
				<a href="legal_notice.html">LEGAL NOTICE</a>  
				<a href="tac.html">TERMS AND CONDITIONS</a> 
				<a href="faq.html">FAQ</a>
			 </div>
			<div class="span3">
				<h5>OUR OFFERS</h5>
				<a href="#">NEW PRODUCTS</a> 
				<a href="#">TOP SELLERS</a>  
				<a href="special_offer.html">SPECIAL OFFERS</a>  
				<a href="#">MANUFACTURERS</a> 
				<a href="#">SUPPLIERS</a> 
			 </div>
			<div id="socialMedia" class="span3 pull-right">
				<h5>SOCIAL MEDIA </h5>
				<a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"/></a>
			 </div> 
		 </div>
		<p class="pull-right">&copy; Bootshop</p>
	</div><!-- Container End -->
	</div>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	
	<script src="themes/js/bootshop.js"></script>
    <script src="themes/js/jquery.lightbox-0.5.js"></script>
	
	<!-- Themes switcher section ============================================================================================= -->
<div id="secectionBox">
<link rel="stylesheet" href="themes/switch/themeswitch.css" type="text/css" media="screen" />
<script src="themes/switch/theamswitcher.js" type="text/javascript" charset="utf-8"></script>
	<div id="themeContainer">
	<div id="hideme" class="themeTitle">Style Selector</div>
	<div class="themeName">Oregional Skin</div>
	<div class="images style">
	<a href="themes/css/#" name="bootshop"><img src="themes/switch/images/clr/bootshop.png" alt="bootstrap business templates" class="active"></a>
	<a href="themes/css/#" name="businessltd"><img src="themes/switch/images/clr/businessltd.png" alt="bootstrap business templates" class="active"></a>
	</div>
	<div class="themeName">Bootswatch Skins (11)</div>
	<div class="images style">
		<a href="themes/css/#" name="amelia" title="Amelia"><img src="themes/switch/images/clr/amelia.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="spruce" title="Spruce"><img src="themes/switch/images/clr/spruce.png" alt="bootstrap business templates" ></a>
		<a href="themes/css/#" name="superhero" title="Superhero"><img src="themes/switch/images/clr/superhero.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="cyborg"><img src="themes/switch/images/clr/cyborg.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="cerulean"><img src="themes/switch/images/clr/cerulean.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="journal"><img src="themes/switch/images/clr/journal.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="readable"><img src="themes/switch/images/clr/readable.png" alt="bootstrap business templates"></a>	
		<a href="themes/css/#" name="simplex"><img src="themes/switch/images/clr/simplex.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="slate"><img src="themes/switch/images/clr/slate.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="spacelab"><img src="themes/switch/images/clr/spacelab.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="united"><img src="themes/switch/images/clr/united.png" alt="bootstrap business templates"></a>
		<p style="margin:0;line-height:normal;margin-left:-10px;display:none;"><small>These are just examples and you can build your own color scheme in the backend.</small></p>
	</div>
	<div class="themeName">Background Patterns </div>
	<div class="images patterns">
		<a href="themes/css/#" name="pattern1"><img src="themes/switch/images/pattern/pattern1.png" alt="bootstrap business templates" class="active"></a>
		<a href="themes/css/#" name="pattern2"><img src="themes/switch/images/pattern/pattern2.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern3"><img src="themes/switch/images/pattern/pattern3.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern4"><img src="themes/switch/images/pattern/pattern4.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern5"><img src="themes/switch/images/pattern/pattern5.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern6"><img src="themes/switch/images/pattern/pattern6.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern7"><img src="themes/switch/images/pattern/pattern7.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern8"><img src="themes/switch/images/pattern/pattern8.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern9"><img src="themes/switch/images/pattern/pattern9.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern10"><img src="themes/switch/images/pattern/pattern10.png" alt="bootstrap business templates"></a>
		
		<a href="themes/css/#" name="pattern11"><img src="themes/switch/images/pattern/pattern11.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern12"><img src="themes/switch/images/pattern/pattern12.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern13"><img src="themes/switch/images/pattern/pattern13.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern14"><img src="themes/switch/images/pattern/pattern14.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern15"><img src="themes/switch/images/pattern/pattern15.png" alt="bootstrap business templates"></a>
		
		<a href="themes/css/#" name="pattern16"><img src="themes/switch/images/pattern/pattern16.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern17"><img src="themes/switch/images/pattern/pattern17.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern18"><img src="themes/switch/images/pattern/pattern18.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern19"><img src="themes/switch/images/pattern/pattern19.png" alt="bootstrap business templates"></a>
		<a href="themes/css/#" name="pattern20"><img src="themes/switch/images/pattern/pattern20.png" alt="bootstrap business templates"></a>
		 
	</div>
	</div>
</div>
<span id="themesBtn"></span>
</body>
</html>