<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>
    
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/colorpicker.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link rel="stylesheet" href="css/bootstrap-wysihtml5.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
<script src="js/jquery/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
 function createXHR()
{
	var request = false;
	try { request = new ActiveXObject('Msxml2.XMLHTTP'); }
	catch (err2)
	{ try { request = new ActiveXObject('Microsoft.XMLHTTP'); }
	catch (err3)
	{ try {request = new XMLHttpRequest();}
	catch (err1) { request = false; }
	}
	}

	return request;}
rafraichirTmembers();
rafraichirNBInvite();
function rafraichirTmembers()
{
var xhr=createXHR();
tmembers=document.getElementById("message");
xhr.open("GET", "autoDiv?type=2", true);
xhr.onreadystatechange = function() { {
if(xhr.readyState == 4 && xhr.status == 200)
{ 	tmembers.innerHTML = xhr.responseText;
}
} };
xhr.send(null);
}
function rafraichirCertifica()
{
var xhr=createXHR();
tmembers=document.getElementById("certifica");
xhr.open("GET", "autoDiv?type=3", true);
xhr.onreadystatechange = function() { {
if(xhr.readyState == 4 && xhr.status == 200)
{ 	tmembers.innerHTML = xhr.responseText;
}
} };
xhr.send(null);
}
function rafraichirNBInvite()
{
var xhr=createXHR();
tmembers=document.getElementById("invite");
xhr.open("GET", "autoDiv?type=1", true);
xhr.onreadystatechange = function() { {
if(xhr.readyState == 4 && xhr.status == 200)
{ 	tmembers.innerHTML = xhr.responseText;
}
} };
xhr.send(null);
}


 setInterval(rafraichirNBInvite, 9000);
 setInterval(rafraichirTmembers, 8500);
 setInterval(rafraichirCertifica, 7500);

</script>


</head>
<body>

<!--Header-part-->
<div id="header">
<a href="Admin">
  <img src="themes/images/logo.png" alt="" /></a>
</div>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">

    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important"> <div id="message">${requestScope.nb}</div></span> <b class="caret"></b></a>
   <ul  class="dropdown-menu" style="width: 250px; height: 200px; overflow: auto ;background-color: #3f4a54 "  >
      				                	 <c:forEach var="item" items="${requestScope.ListMessage}" >
      
        <li style="background-color: aliceblue"><a class="sAdd" title="" href="Admin?msg=${item.message}&&id_user=${item.id_user}&&Id_page=message">
        <i class="icon-plus"><div id="listmessage"></i> ${item.message}</div></a></li>
           </c:forEach>  
          
      
      </ul>
    </li>
     <li class="dropdown" id="menu-cert"><a href="#" data-toggle="dropdown" data-target="#menu-cert" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">certificat</span> <span class="label label-important"> <div id="certifica"></div></span> <b class="caret"></b></a>
   <ul  class="dropdown-menu" style="width: 250px; height: 200px; overflow: auto ;background-color: #3f4a54 "  >
      				                	 <c:forEach var="item" items="${requestScope.listCertificat}" >
      
        <li style="background-color: aliceblue"><a class="sAdd" title="" href="Admin?id_user=${item.id_user}&&id_test=${item.id_test}&&Id_page=CertificaUser">
        <i class="icon-plus"><div id="listmessage"></i> ${item.nom}</div></a></li>
           </c:forEach>  
          
      
      </ul>
    </li>
    <li class="dropdown" id="menu-Invite"><a href="#" data-toggle="dropdown" data-target="#menu-Invite" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Invitations</span> <span class="label label-important"> <div id="invite">${requestScope.nbInvite}</div></span> <b class="caret"></b></a>
   <ul  class="dropdown-menu" style="width: 500px; height: 300px; overflow: auto ;background-color: #3f4a54 "  >
         <table style="background-color: aliceblue">
   
      				                	 <c:forEach var="item" items="${requestScope.ListUserInfo}" >
           	<li >
      				                	    <tr>
      				                	    
      				                	    <td>
 
                	<a class="sAdd" title="" href="Admin?msg=&&id_user=&&Id_page=message">     				                	 
     
        <i class="icon-plus"></i>
        </td>
        <td>
        <div id="inviteR">
        Registre_commerce: ${item.registre_commerce}
        </div>
        </td>
        <td>
                <div id="inviteE">
        
         email: ${item.email}
         </div>
         </td>
         <td>
     <a href="Admin?Id_page=Activation&&id_user=${item.id_User}">   <span class="label label-success">Activer</span> </a></td>
        <td>
       <a href="Admin?Id_page=DELETEUserV&&id_user=${item.id_User}">   <span class="label label-important">Supprimer</span> </a>
          </td>
       
        
                </a></li>
     
        </tr>
           </c:forEach>  
          
      </table>
      </ul>
    </li>
    <li class=""><a title="" href="Admin?id_user=${sessionScope.id_User}&&Id_page=ViewAdmin"><i class="icon icon-cog"></i> </a></li>
        <li class="">  <form action="Admin" method="post" enctype="multipart/form-data">
    <input type="hidden" name="page" value="deconnexion"/>
    <button class="btn btn-danger" type="submit">Logout</button>
 </form>
 </li>
    
 
  </ul>
   
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch-->
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Admin</a>
  <ul>
    <li class="active"><a href="Admin"><i class="icon icon-home"></i> <span>Admin</span></a> </li>

    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Formation</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=ViewAll">Suivi Formation</a></li>
        <li><a href="Admin?Id_page=InsertFormation">Inser Formation</a></li>
                <li><a href="Admin?Id_page=InsertPub">Inser Pub</a></li>
        
      </ul>
    </li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Catégories</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=ViewCategories&&id_role=1">Catégories</a></li>
        <li><a href="Admin?Id_page=ViewSousCategories">SousCatégories</a></li>
        <li><a href="Admin?Id_page=InsertSousCategories&&id_role=1">InsertSousCatégoriesFormation</a></li>
        <li><a href="Admin?Id_page=InsertSousCategories&&id_role=2">InsertSousCatégoriesRecretement</a></li>
        
      </ul>
    </li>
        <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Recretement</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=InsertJobOffer">Insert</a></li>
        <li><a href="Admin?Id_page=ViewAllJob">Suivi</a></li>
        
      </ul>
    </li>
    
   <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Slider</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=ViewAllSlider">Edit</a></li>
        <li><a href="Admin?Id_page=InsertSlider">Inser Slider</a></li>
      </ul>
    </li>
    
      <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Pub</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=ViewAllPub">Edit</a></li>
        <li><a href="Admin?Id_page=InsertPub">Pub </a></li>
      </ul>
    </li>
      <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Apprentissage en ligne</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=ViewAllCours">Edit Cours</a></li>
                <li><a href="Admin?Id_page=ViewAllVideo">Edit Cours par Video</a></li>
                        <li><a href="Admin?Id_page=ViewAllTest">Edit Test</a></li>
                        <li><a href="Admin?Id_page=ViewAllCategorieCours&&IdRole=1">Edit Categories Cours Text</a></li>
                                <li><a href="Admin?Id_page=ViewAllCategorieCours&&IdRole=2">Edit Categories Cours Video</a></li>
        
        <li><a href="Admin?Id_page=InsertCour">Insert Cours</a></li>
        
                <li><a href="Admin?Id_page=InsertCatCour">Insert Categorie Cours</a></li>
        
        </li>
                <li><a href="Admin?Id_page=InsertVideo">Insert Video</a></li>
                      <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Test</span> </a>
                
                      <ul>
                
                        <li><a href="Admin?Id_page=InsertTest">Insert Test</a></li>
                      <li><a href="Admin?Id_page=InsertQuestion">Insert Question</a></li>
                        </ul>
        </li>
      </ul>
       <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>gérer utilisateur</span> </a>
      <ul>
        <li><a href="Admin?Id_page=ViewAllUser">gérer</a></li>
        </ul>
        </li>
    </li>
    
 
  </ul>
</div>
<!--close-left-menu-stats-sidebar-->

<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
  <h1>Common Form Elements</h1>
</div>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Form Elements</h5>
        </div>
        <div class="widget-content nopadding">
        <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
        <c:choose>
  <c:when test="${requestScope.Id_page eq 'InsertSlider' }">
                                  <input type="hidden" name="Id_page" value="InsertSlider" >
               
  </c:when>
  <c:when test="${requestScope.Id_page eq 'InsertPub' }">
   <input type="hidden" name="Id_page" value="InsertPub" >
              
  </c:when>
     </c:choose> 

                                <div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required/>
                <span class="help-block">Title</span> </div>
            </div>
            <div class="control-group">
              <label class="control-label">image upload input</label>
              <div class="controls">
                <input type="file" name="file" required />
              </div>
            </div>
        
            <div class="form-actions">
            
              <button type="submit" class="btn btn-success">Save</button>
            </div>
          </form>
        </div>
      </div>
      
  
    </div>
  </div>
</div></div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part--> 
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/bootstrap-colorpicker.js"></script> 
<script src="js/bootstrap-datepicker.js"></script> 
<script src="js/jquery.toggle.buttons.js"></script> 
<script src="js/masked.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.form_common.js"></script> 
<script src="js/wysihtml5-0.3.0.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/bootstrap-wysihtml5.js"></script> 

<script>
</script>
</body>
</html>
