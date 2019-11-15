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
<div id="content">
  
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
     

  

      <c:choose>
        <c:when test="${requestScope.Id_page eq 'ViewAllFormation' }">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
              <thead>
                <tr>
            <th>Image</th>
               <th>Title</th>
              <th>Descrription</th>
                  
               <th>Date_Debut</th>
               <th>Date_Fin</th>
               <th>Prix</th>
               <th>Edite</th>
                </tr>
              </thead>
              <tbody style="width:20%">
              			  	 <c:forEach var="item" items="${requestScope.listeformation}" >
                <tr class="gradeX">
                  <td><a href="Admin?Id_page=ViewUser&id_user=${item.id_user}"><img src="themes/images/products/${item.image}" alt="" /></a></td>
                  <td>${item.nom}</td>
                  <td>${item.descrription}</td>
                
                      <td class="center">${item.date_Debut}</td>
                                    <td class="center">${item.date_Fin}</td>
                                                            <td>${item.prix}</td>
    
                  <td class="center">
                  <form action="Admin" method="get">
                  <input type="submit" value="supprimer" />
                  <input type="hidden" name="Id_page" value="DELETETraining"/>
                  <input type="hidden" name="id" value="${item.id_formation}"/>
                  
                  </form>
                     <form action="Admin" method="get">
                  <input type="submit" value="Mis ajour" />
                     <input type="hidden" name="Id_page" value="Mis_A_jour"/>
                  <input type="hidden" name="id_formation" value="${item.id_formation}"/>
                  </form>
                   </td>
  
                </tr>
                </c:forEach>
               
              </tbody>
              <tr>
              <td>  <form action="" method="get">
                  <input type="submit" value="supprimer tout" />
                <input type="hidden" name="Id_page" value="DeleteAll"/>
                  
                  </form></td>
              
              </tr>
            </table>
 </div>
        </div>
        </c:when>
        <c:when test="${requestScope.Id_page eq 'ViewAllJob' }">
        
        
                <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
              <thead>
                <tr>
            <th>Image</th>
               <th>Title</th>
              <th>Descrription</th>
                  
      
                </tr>
              </thead>
              <tbody style="width:20%">
                <c:forEach var="itemJob" items="${requestScope.listeJob}" >
                <tr class="gradeX">
                  <td><a href="Admin?Id_page=ViewUser&id_user=${item.id_User}"><img src="themes/images/Job/${itemJob.image}" alt="" /></a></td>
                  <td>${itemJob.title }</td>
                  <td>${itemJob.description_détaillée }</td>
                                                    
                  <td class="center">
                  <form action="Admin" method="get">
                  <input type="submit" value="supprimer" />
                  <input type="hidden" name="Id_page" value="DELETEJob"/>
                  <input type="hidden" name="id_offre" value="${itemJob.id_offre}"/>
                  
                  </form>
                     <form action="Admin" method="get">
                  <input type="submit" value="Mis ajour" />
                     <input type="hidden" name="Id_page" value="UpdateJobOffer"/>
                  <input type="hidden" name="id_Job" value="${itemJob.id_offre}"/>
                  </form>
                   </td>
  
                </tr>
                </c:forEach>
               
              </tbody>
              <tr>
              <td>  <form action="" method="get">
                  <input type="submit" value="supprimer tout" />
                <input type="hidden" name="Id_page" value="DeleteAllJob"/>
                                  <input type="hidden" name="id_user" value="0"/>
                  
                  </form></td>
              
              </tr>
            </table>
 </div>
        </div>
        
        </c:when>
                <c:when test="${requestScope.Id_page eq 'TableCours' }">
                      <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
              <thead>
                <tr>
            <th>Image</th>
               <th>Title</th>
              <th>Descrription</th>
                  
      
                </tr>
              </thead>
              <tbody style="width:20%">
<c:forEach var="item" items="${requestScope.ListCours}" >
                <tr class="gradeX">
                		
                
                  <td><a  href="themes/Cours/${item.pdf}">	<img src="themes/Cours/${item.image}" alt=""/>   </a>   
</td>
                  <td> ${item.nom}</td>
                  <td>${item.desc}</td>
                                              
                  <td class="center">
                  <form action="Admin" method="get">
                  <input type="submit" value="supprimer" />
                  <input type="hidden" name="Id_page" value="DELETECours"/>
                  <input type="hidden" name="id_cours" value="${item.id_cours}"/>
                  
                  </form>
                     <form action="Admin" method="get">
                  <input type="submit" value="Mis ajour" />
                     <input type="hidden" name="Id_page" value="UpdateCours"/>
                  <input type="hidden" name="id_cours" value="${item.id_cours}"/>
                  </form>
                   </td>
  
                </tr>
                </c:forEach>
               
              </tbody>
              <tr>
              <td>  <form action="" method="get">
                  <input type="submit" value="supprimer tout" />
                <input type="hidden" name="Id_page" value="DeleteAllCours"/>
                                  <input type="hidden" name="id_user" value="0"/>
                  
                  </form></td>
              
              </tr>
            </table>
 </div>
        </div>
                
        </c:when>
        
         <c:when test="${requestScope.Id_page eq 'TableVideo' }">
                      <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
              <thead>
                <tr>
            <th>Image</th>
               <th>Title</th>
              <th>Descrription</th>
                  
      
                </tr>
              </thead>
              <tbody style="width:20%">
<c:forEach var="item" items="${requestScope.ListCours}" >
                <tr class="gradeX">
                		
                
                  <td><a  href=" themes/Video/${item.video}">	<img src="themes/Video/${item.image}" alt=""/>   </a>   
</td>
                  <td> ${item.titre}</td>
                                              
                  <td class="center">
                  <form action="Admin" method="get">
                  <input type="submit" value="supprimer" />
                  <input type="hidden" name="Id_page" value="DELETECoursVideo"/>
                  <input type="hidden" name="id_cours" value="${item.id_video}"/>
                  
                  </form>
                     <form action="Admin" method="get">
                  <input type="submit" value="Mis ajour" />
                     <input type="hidden" name="Id_page" value="UpdateCoursVideo"/>
                  <input type="hidden" name="id_cours" value="${item.id_video}"/>
                  </form>
                   </td>
  
                </tr>
                </c:forEach>
               
              </tbody>
              <tr>
              <td>  <form action="" method="get">
                  <input type="submit" value="supprimer tout" />
                <input type="hidden" name="Id_page" value="DeleteAllCours"/>
                                  <input type="hidden" name="id_user" value="0"/>
                  
                  </form></td>
              
              </tr>
            </table>
 </div>
        </div>
                
        </c:when>
         <c:when test="${requestScope.Id_page eq 'ViewTest' }">
                      <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
              <thead>
                <tr>
            <th>Image</th>
               <th>Title</th>
              <th>Descrription</th>
                  
      
                </tr>
              </thead>
              <tbody style="width:20%">
<c:forEach var="item" items="${requestScope.ListTest}" >
                <tr class="gradeX">
                		
                
                  <td>	<img src="themes/Test/${item.image}" alt=""/>    
</td>
                  <td> ${item.test}</td>
                  <td><p> ${item.description}</p></td>
                                              
                  <td class="center">
                  <form action="Admin" method="get">
                  <input type="submit" value="supprimer" />
                  <input type="hidden" name="Id_page" value="DELETETest"/>
                  <input type="hidden" name="id_Test" value="${item.id_test}"/>
                  
                  </form>
                     <form action="Admin" method="get">
                  <input type="submit" value="Mis ajour" />
                     <input type="hidden" name="Id_page" value="UpdateTest"/>
                  <input type="hidden" name="id_Test" value="${item.id_test}"/>
                  </form>
                   </td>
  
                </tr>
                </c:forEach>
               
              </tbody>
              <tr>
              <td>  <form action="" method="get">
                  <input type="submit" value="supprimer tout" />
                <input type="hidden" name="Id_page" value="DeleteAllCours"/>
                                  <input type="hidden" name="id_user" value="0"/>
                  
                  </form></td>
              
              </tr>
            </table>
 </div>
        </div>
                
        </c:when>
         <c:when test="${requestScope.Id_page eq 'ViewQuestion' }">
                      <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
              <thead>
                <tr>
            <th>Question</th>
             
                  
      
                </tr>
              </thead>
              <tbody style="width:20%">
<c:forEach var="item" items="${requestScope.ListQuestion}" >
                <tr class="gradeX">
                	 
                  <td><p> ${item.question}</p></td>
                                              
                  <td class="center">
                  <form action="Admin" method="get">
                  <input type="submit" value="supprimer" />
                  <input type="hidden" name="Id_page" value="DELETEQuestion"/>
                  <input type="hidden" name="id_Q" value="${item.id_Q}"/>
                  <input type="hidden" name="id_Test" value="${item.id_test}"/>
                  
                  </form>
                     <form action="Admin" method="get">
                  <input type="submit" value="Mis ajour" />
                     <input type="hidden" name="Id_page" value="UpdateQuestion"/>
                  <input type="hidden" name="id_Q" value="${item.id_Q}"/>
                  
                  </form>
                   </td>
  
                </tr>
                </c:forEach>
               
              </tbody>
              <tr>
              <td>  <form action="" method="get">
                  <input type="submit" value="supprimer tout" />
                <input type="hidden" name="Id_page" value="DeleteAllCours"/>
                                  <input type="hidden" name="id_user" value="0"/>
                  
                  </form></td>
              
              </tr>
            </table>
 </div>
        </div>
                
        </c:when>
        
        <c:when test="${requestScope.Id_page eq 'ViewUserAdmin' }">
                              		<div class="span9">
                              
                                <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          <form action="Admin" method="get">
		<input type="hidden" name="Id_page" value="mis_a_jourUser"/>
          <c:forEach var="item" items="${requestScope.ListUser}" >
          
          
            <table class="table table-bordered data-table">
          
             
<tr><td>nom:</td><td><input name="email" value="${item.nom}"/></td></tr>     
<tr><td>mot passe:</td><td><input name="motPasse" value="${item.motpasse}"/></td></tr>      
         
              
           
               
           
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
                 <c:when test="${requestScope.Id_page eq 'ViewAllUser' }">
                      <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
          
             
<c:forEach var="item" items="${requestScope.ListUser}" >


              <tr><td> ${item.nomUser} </td>
                      <td>  <form action="" method="get">
<button class="btn btn-danger dropdown-toggle" type="submit">supprimer </button>                
<input type="hidden" name="Id_page" value="DeleteUser"/>
                          <input type="hidden" name="id_user" value="${item.id_User }"/>
                  
                  </form>
                  
                  </td>
                          <td>  <form action="" method="get">
<button class="btn btn-success dropdown-toggle" >Voir </button> 
               <input type="hidden" name="Id_page" value="ViewUser"/>
                                  <input type="hidden" name="id_user" value="${item.id_User }"/>
                  
                  </form></td>
                  <td style="margin-bottom: 2px;width: 30%">
                  <c:choose>
	<c:when test="${item.validation eq '1' }">
<span class="label label-success">Vérifier</span>
</c:when>
<c:otherwise>

	<img src="img/lightbox-ico-loading.gif"/ ></div>
		<img src="img/cadenas.png"/ style="
    width: 15%;
" > <span class="label label-important">Non Vérifier </span></div>
	
</c:otherwise>
</c:choose>
                  
                  </td>
              </tr>
             
                </c:forEach>
               
          
           
            </table>
 </div>
        </div>
                
        </c:when>
         <c:when test="${requestScope.Id_page eq 'ViewUser' }">
                      <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          <c:forEach var="item" items="${requestScope.ListUserInfo}" >
          
          
            <table class="table table-bordered data-table">
          
             
<tr><td>nom:</td><td>${item.nomUser}</td></tr>     
<tr><td>prenom :</td><td>${item.pren}</td></tr>               
<tr><td>email:</td><td>${item.email}</td></tr>               
<tr><td>Tel:</td><td>${item.tel}</td></tr>               
<tr><td>Nom_de_lentreprise:</td><td>${item.nom_de_lentreprise}</td></tr>               
<tr><td>Adresse:</td><td>${item.adresse}</td></tr>               
<tr><td>Ville:</td><td>${item.ville}</td></tr>               
<tr><td>Pays:</td><td>${item.pays}</td></tr>               
<tr><td>Registre_commerce:</td><td>${item.registre_commerce}</td></tr>               
           
          
               
           
            </table>
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
          </div>
          <div class="widget-content nopadding collapse in" id="collapseG2">
            <ul class="recent-posts">
           
           
            <li>
<form action="Admin" method="get">
		<input type="hidden" name="Id_page" value="EnvoyermessageUser">
				<input type="hidden" name="id_user" value="${item.id_User }">
						<input type="hidden" name="nom" value=" ${item.nomUser} }">
						<input type="hidden" name="email" value="${item.email}">
		
	Message:<textarea rows="" cols="" name="msg"></textarea>
	<div class="well well-small"><button class="btn btn-success dropdown-toggle" style="width: 100%;">Envoyer <span class="caret"></span></button></div>	
	</form>              </li>
            </ul>
          </div>
        </div>
 </div>
                       </c:forEach>
        
                
        </c:when>
         <c:when test="${requestScope.Id_page eq 'CertficaUser' }">
                      <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
        <tr><td>  <div style="margin-left: 50%;color: mediumvioletred;font-style: italic;" >  <h1> Certification :  ${requestScope.Test}</h1></div></td></tr>     
          
   <tr><td><img src="themes/Test/${requestScope.TestImage}" style="
    margin-left: 50%;
    height: 300px;
" ></td></tr>     
     
<tr><td>Adresse postal:</td><td> ${requestScope.Adresse}</td></tr>     
    <tr><td>email:</td><td> ${requestScope.ListUser}</td></tr>     
           
            <tr><td>nom et prénom:</td><td> ${requestScope.nom}</td></tr>     
           
          
               
           
            </table>
          <div class="widget-title bg_ly" data-toggle="collapse" href="#collapseG2"><span class="icon"><i class="icon-chevron-down"></i></span>
          </div>
          <div class="widget-content nopadding collapse in" id="collapseG2">
            <ul class="recent-posts">
           
           
            <li>
           </li>
            </ul>
          </div>
        </div>
 </div>
                       
        
                
        </c:when>
         <c:when test="${requestScope.Id_page eq 'ViewAllCategoriesCours' }">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
          </div>
          <div class="widget-content nopadding">
          
          
            <table class="table table-bordered data-table">
              <thead>
                <tr>
            <th>Image</th>
               <th>Title</th>
                  
            
                </tr>
              </thead>
              <tbody style="width:20%">
              			  	 <c:forEach var="item" items="${requestScope.ListeCatCours}" >
                <tr class="gradeX">
                  <td><img src="themes/e_learning/${item.image}" alt="" /></td>
                  <td>${item.title}</td>
           
    
                  <td class="center">
                  <form action="Admin" method="get">
                  <input type="submit" value="supprimer" />
                  <input type="hidden" name="Id_page" value="DELETECatCours"/>
                  <input type="hidden" name="id" value="${item.idCours}"/>
                  
                  </form>
                     <form action="Admin" method="get">
                  <input type="submit" value="Mis ajour" />
                     <input type="hidden" name="Id_page" value="Mis_A_jourCatCours"/>
                  <input type="hidden" name="id_Cat" value="${item.idCours}"/>
                  </form>
                   </td>
  
                </tr>
                </c:forEach>
               
              </tbody>
              <tr>
              <td>  <form action="" method="get">
                  <input type="submit" value="supprimer tout" />
                <input type="hidden" name="Id_page" value="DeleteAll"/>
                  
                  </form>
                  </td>
                  </tr>
                  </table>
                  </div>
                  </div>
                  </c:when>
        </c:choose>
      </div>
    </div>
  </div>
</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
</body>
</html>
