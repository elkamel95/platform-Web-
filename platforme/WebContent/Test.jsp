<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

     <script type="text/javascript">
  setTimeout(function() {
	 
	countDown(59,"status");}, 0);
  disableBack();
  
  </script>
  <script>
    
        function disableBack() { window.history.forward() }

        window.onload = disableBack();

        window.onpageshow = function(evt) { if (evt.persisted){ 
}
}
    

  function countDown(secs,elme){
   var timer;
  
	  var element=document.getElementById(elme);
	  var bar=document.getElementById("bar");
	  bar.style.width=(secs)+"%";
	  if(secs>=0){
	  clearTimeout(timer);
	  element.innerHTML="00:"+secs+" seconds";
	  }else{
		    document.querySelector('[id="test"]').click();

	  }
	  secs--;
	   timer=setTimeout('countDown('+secs+',"status")',1000);
	  
  }
  
  
  </script>
  

<script>
function myFunction() {
    document.getElementById("demo").innerHTML = "Hello World";
    
}
</script>
<script type="text/javascript">

</script>
    <meta charset="utf-8">
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
<body>
<div id="header">
<div class="container">

<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
    <a class="brand" href="index.html"><img src="themes/images/logo.png" alt="Bootsshop"/></a>
	
    <ul id="topMenu" class="nav pull-right">
	 <li class=""><a href="ControleurFormation?page=index">Formation </a></li>
	 <li class=""><a href="e_learning.jsp">Apprentissage en ligne</a></li>
	 	 <li class=""><a href="ControleurFormation?page=Recrutement">Recretement</a></li>
	 
	 <li class=""><a href="contact.html">Contact</a></li>
	 	 <c:choose>
                
                 <c:when test="${empty sessionScope.id_user }">
	 <li class="">

             
	 <a href="#login" role="button" data-toggle="modal" style="padding-right:0"><span class="label label-success">Identification</span></a>
	<div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false"  >
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">Ã</button>
			<h3>Login Block</h3>
		  </div>
		  <div class="modal-body">
			<form  action="ControleurFormation" method="post" class="form-horizontal loginFrm" enctype="multipart/form-data"  >
						  <input type="hidden" name="page" value="verification_compte" />
			
			  <div class="control-group">								
				<input type="text" id="inputEmail" name ="login" placeholder="Email">
			  </div>
			  <div class="control-group">
				<input type="password" id="inputPassword" placeholder="Password" name="password">
			  </div>
			  <div class="control-group">
				<label class="checkbox">
				<input type="checkbox"> Remember me
				</label>
			  </div>
			  <input type="hidden" name="loginUser" />
	<button type="submit" class="btn btn-success">se connecter</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Fermer</button>
			</form>		
			
		  </div>
	</div>
	</li>
	</c:when>
	  <c:otherwise>
	  	 <li class="">
	  
	  	 <a href="ControleurFormation" role="button"  style="padding-right:0"><span class="label label-success">mon compte</span></a>
	  </li>
    </c:otherwise>
	</c:choose>
		 <c:choose>
                
                 <c:when test="${empty sessionScope.id_user  }">
	 <li class="">
	 <a href="#Inscription" role="button" data-toggle="modal" style="padding-right:0"><span class="label label-success">Inscription</span></a>
	<div id="Inscription" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" >
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">Ã</button>
			<h3>Inscription</h3>
			<hr>
						<h4>Veuillez sÃ©lectionner le groupe d'utilisateur appropriÃ©</h4>
			
		  </div>

		  <div class="modal-body">
			  				<form  action="ControleurFormation" method="get" class="form-horizontal loginFrm">
			  							  	<input type="hidden" name="page" value="inscription"/>
			  						<input type="hidden" name="id_role" value="2"/>
			  				
			  <div class="control-group">								
<div class="well well-small"><button class="btn btn-success dropdown-toggle" type="submit"  style="width: 100%;">Employeur <span class="caret"></span></button></div>
			
			  </div>
			  	</form>	
			  				<form  action="ControleurFormation" method="get" class="form-horizontal loginFrm">
			  	<input type="hidden" name="page" value="inscription"/>
			  	<input type="hidden" name="id_role" value="1"/>
			  	
			  <div class="control-group">
			  
<div class="well well-small"><button class="btn btn-success dropdown-toggle" type="submit" style="width: 100%;">Formateur
 <span class="caret"></span></button>
 </div>
			  </div>
			  	 </form>
			  
			  <div class="control-group">
				<label class="checkbox">
				<input type="checkbox"> Remember me
				</label>
			  </div>
			
					<button type="submit" class="btn btn-success">se connecter</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Fermer</button>
		  </div>
	</div>
	</li>
	</c:when>
	  <c:otherwise>
	  	 <li class="">
	  
	 <a href="ControleurFormation?page=deconnexion" role="button"  style="padding-right:0"><span class="label label-success">Déconnexion</span></a>
	  </li>
    </c:otherwise>
	</c:choose>
    </ul>
  </div>
</div>
</div>
</div>
</
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

	<div id="sidebar" class="span3">

		<br/>
						                	 <c:forEach var="item" items="${requestScope.listePub}" >
		
		  <div class="thumbnail" >
			<img src="themes/images/Pub/${item.image }" alt="Bootshop panasonoc New camera" >
			<div class="caption">
			  <h5>Panasonic</h5>
			</div>
		  </div><br/>
		  </c:forEach>
			<div class="thumbnail">
				<img src="themes/images/products/download.jpg" title="Bootshop New Kindel" alt="Bootshop Kindel">
				<div class="caption">
				  <h5>Kindle</h5>
				</div>
			  </div><br/>
			<div class="thumbnail">
				<img src="themes/images/payment_methods.png" title="Bootshop Payment Methods" alt="Payments Methods">
				<div class="caption">
				  <h5>Payment Methods</h5>
				</div>
			  </div>
	</div>
<!-- Sidebar end=============================================== -->
		<div class="span9">		
			<c:choose>
	<c:when test="${requestScope.Id_page eq 'ViewTest' }">
		<img src="themes/time.gif" alt="Bootshop panasonoc New camera" style="font-size:20px;margin-left:70%"/>
	
	
	
<div id="status" style="font-size:20px;margin-left:70%;margin-top:0%"> </div>
</c:when>
</c:choose>
	  <c:choose>
 <c:when test="${requestScope.Id_page eq 'Test' }">
       <div class="tab-pane" id="listView">


<c:forEach var="item" items="${requestScope.ListTest}" >

				<div class="row">	
				<form action="ControleurFormation" method="post" enctype="multipart/form-data" >
				<input type="hidden" name="Id_page" value="ViewTest"/>
								<input type="hidden" name="id_test" value="${item.id_test }"/>
				
					<div class="span2" >
		<input type="image"  src="themes/Test/${item.image}" border="0" alt="Submit" style="width: 200px;" />
					
			</form>
					</div>
					</a>
					<div class="span4">
						<h3>Teste | ${item.test}</h3>				
						<hr class="soft"/>
						<p>
						</p>
						<br class="clr"/>
					</div>
					<div class="span3 alignR">
					<form class="form-horizontal qtyFrm">
				<br/>
				
						</form>
					</div>
			</div>
		
			</c:forEach>
			</div>
    
</c:when>

<c:when test="${requestScope.Id_page eq 'ViewTest' }">

       <div class="tab-pane" id="listView" style="margin-left: 10%;margin-top: -10%;">
       <div class="progress progress-danger progress-striped
       active " style="
    width: 60%;
">
  <div  id="bar" class="bar"  style="width: 100%;"></div>
</div>
		<h2> Test :${ListTest.test} </h2>

				<div class="row">	
		<h4> 1)  ${ListQuestion} </h4>
		<table>
		        	<form  action="ControleurFormation" method="post" enctype="multipart/form-data" >
		<input type="hidden" name="id_page" value="test"/>
		<ul>
		<c:forEach var="item" items="${requestScope.ListReponce}" >
		<tr>
		<td>
		<h6><li> ${item.rep}</li></h6>
		</td>
		<td>
		<input type="checkbox" name="rep" value= "${item.id_rep}">
		</td>
		</tr>
		</c:forEach>
		</ul>

		<tr><td>
		
							<input class="btn btn-primary" id="test" type="submit"  value="suivant">
		</td></tr>
		
		</form>
			</table>	
				</div>
			</div>
		
    
</c:when>

</c:choose>
		</div>
		
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
	