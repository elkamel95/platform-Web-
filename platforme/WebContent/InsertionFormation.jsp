<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>
    
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

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
		<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
				<span>gérer utilisateur</span> </a>
			<ul>
				<li><a href="Admin?Id_page=ViewAllUser">gérer</a></li>
			</ul></li>
		</li>


		</ul>
</div>
<!--close-left-menu-stats-sidebar-->

<div id="content">
<div id="content-header">
</div>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span6">
     <c:choose>
    <c:when test="${requestScope.Id_page eq 'InsertFormation' }">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
        </div>
        <div class="widget-content nopadding">
        <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
       <input type="hidden" name="Id_page" value="InsertFormation"/>

          <div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required/>
                <span class="help-block">Title</span> </div>
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
              <label class="control-label">Prix:</label>
              <div class="controls">
                <input type="text" class="span11" name="Prix" required/>
                <span class="help-block">Prix</span> 
                </div>
            </div>
            <div class="control-group">
              <label class="control-label">Prix:</label>
              <div class="controls">
          <table class="selectDate" >
			<tr  >
				<td >
				<select id="d"  name="date">
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
				</td>
				<td>
					<select id="m"  name="dateMMM">
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
				</td>
				<td>
					<select  id="y"   name="yyyy">
						<option value="">yyyy</option>
						<option selected value="2005">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
					</select>
				</td>
			</tr>
			</table>
		   <span class="help-block">Prix</span> 
                </div>
            </div>
		</td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Select a date:</th>
		<td >
		       <div class="control-group">
              <label class="control-label">Prix:</label>
              <div class="controls">
			<table class="selectDate">
			<tr  >
				<td >
				
				<select id="d"  name="date2">
					<option value="">dd</option>
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
				</td>
				<td>
					<select id="m"  name="date2MMM">
						<option value="">mmm</option>
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
				</td>
				<td>
					<select  id="y"   name="yyyy2">
						<option  value="">yyyy</option>
						<option selected value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
					</select>
				</td>
			</tr>
			</table>
			   <span class="help-block">Prix</span> 
                </div>
            </div>
            <td >
				<div class="control-group">
		<label class="control-label">Ville <sup>*</sup></label>
		<div class="controls">
	  <select class="srchTxt" name="Ville">
			<option selected>Ville</option>
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
                <input type="text" class="span11" name="title" required/>
			   <span class="help-block">Adresse</span> 
                </div>
            </div>   
            <div class="control-group">
              <label class="control-label">Tel</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required/>
			   <span class="help-block">Tel</span> 
                </div>
            </div>
               <div class="control-group">
              <label class="control-label">File upload input</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="desc" required></textarea>
			   <span class="help-block">Prix</span> 
                </div>
            </div>
            <div class="control-group">
              <label class="control-label">File upload input</label>
              <div class="controls">
                <input type="file" name="file" required />
              </div>
            </div>
        
            <div class="form-actions">
            <input type="hidden" name="id_user" value="1"/>
              <button type="submit" class="btn btn-success">Save</button>
            </div>
          </form>
        </div>
      </div>
      </c:when>
                <c:when test="${requestScope.Id_page eq 'InsertCategoriesCours' }">
                  
                  <div class="widget-box">
     
        <div class="widget-content nopadding">                     
               
        <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
        
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="InsertCategoriApp" >
             <div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
           <input type="text" name="nom" value="" required/>
           </div>
           </div>
            <div class="control-group">
              <label class="control-label">image:</label>
              <div class="controls">
           <input type="file" name="image" value="" required/>
           </div>
           </div>
          
             <div class="control-group">
              <label class="control-label">Partie </label>
              <div class="controls">
<select name="part"  >
<option value="1"> Cours</option>
<option value="2">Cours par video </option>

</select>       
  </div>
           </div>
                  <button type="submit" class="btn btn-success">Save</button>
    
       
       </div>
       </div>
       </div>
       
             </form>
  </c:when>
          <c:when test="${requestScope.Id_page eq 'InsertJobOffer' }">
        <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
        <input type="hidden" name="InsertJobOffer" value="InsertJobOffer">
<div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required/>
                <span class="help-block">Title</span> </div>
            </div>   
            <div class="control-group">
              <label class="control-label">nom_Sociter:</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required/>
                <span class="help-block">nom_Sociter</span> </div>
            </div>   
                 <div class="control-group">
              <label class="control-label">description_détaillée:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="desc" required></textarea>
                <span class="help-block">description_détaillée</span> </div>
            </div>  
                    <div class="control-group">
              <label class="control-label">Exigences</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Exigences" required></textarea>
			   <span class="help-block">Exigences</span> 
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">Secteur_activité</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required></textarea>
			   <span class="help-block">Secteur_activité</span> 
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">Lieu</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required></textarea>
			   <span class="help-block">Lieu</span> 
                </div>
            </div>        <div class="control-group">
              <label class="control-label">Expire le:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required></textarea>
			   <span class="help-block">Expire le :</span> 
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
<input  name="id_user" type="hidden" value="0"/>
                </div>
            </div>
                          <button type="submit" class="btn btn-success">Save</button>
            
            </form>
            
            
            
            
            
             </c:when>
          <c:when test="${requestScope.Id_page eq 'InsertCour' }">
                  <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Form Elements</h5>
        </div>
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="InsertCour" >
             <div class="control-group">
              <label class="control-label">Nom:</label>
              <div class="controls">
           <input type="text" name="nom" value="" required/>
           </div>
           </div>
            <div class="control-group">
              <label class="control-label">image:</label>
              <div class="controls">
           <input type="file" name="image" value="" required/>
           </div>
           </div>
            <div class="control-group">
              <label class="control-label">Fichier PDF:</label>
              <div class="controls">
           <input type="file" name="pdf" value="" required/>
           </div>
           </div>
           <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required></textarea>
			   <span class="help-block">Dscription:</span> 
                </div>
       
                  <div class="control-group">
              <label class="control-label">Select Catégori</label>
              <div class="controls">
                <select name="Categ" >
                  <c:forEach var="itemCat" items= "${requestScope.Cat}">
                
                  <option  value="${itemCat.idCours}"> ${itemCat.title} </option>
                </c:forEach>
                </select>
              </div>
            </div>
       <button type="submit" class="btn btn-success">Save</button>
       </div>
       </div>
       </div>
       </div>
       
             </form>
             </c:when>
              <c:when test="${requestScope.Id_page eq 'InsertVideo' }">
               <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Form Elements</h5>
        </div>
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="InsertVideo" >
             <div class="control-group">
              <label class="control-label">Titre:</label>
              <div class="controls">
           <input type="text" name="nom" value="" required/>
           </div>
           </div>
           
            <div class="control-group">
              <label class="control-label">image:</label>
              <div class="controls">
           <input type="file" name="image" value="" required/>
           </div>
           </div>
           <div class="controls">
           <input type="file" name="video" value="" required/>
			   <span class="help-block">Video:</span> 
                </div>
                              <div class="control-group">
              <label class="control-label">Select Catégori</label>
              <div class="controls">
                <select name="Categ" >
                  <c:forEach var="itemCat" items= "${requestScope.Cat}">
                
                  <option  value="${itemCat.idCours}"> ${itemCat.title} </option>
                </c:forEach>
                </select>
              </div>
            </div>
       <button type="submit" class="btn btn-success">Save</button>
       </div>
       </div>
       </div>
       </div>
       
             </form>
             </c:when>
                       <c:when test="${requestScope.Id_page eq 'InsertTest' }">
               <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Form Elements</h5>
        </div>
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="InsertTest" >
             <div class="control-group">
              <label class="control-label">test:</label>
              <div class="controls">
           <input type="text" name="test" value="" required/>
           </div>
           </div>
             <div class="control-group">
              <label class="control-label">Description:</label>
              <div class="controls">
           <input type="text" name="Description" value="" required/>
           </div>
           </div>
           
            <div class="control-group">
              <label class="control-label">image:</label>
              <div class="controls">
           <input type="file" name="image"  />
           </div>
           </div>
         
       <button type="submit" class="btn btn-success">Save</button>
       </div>
       </div>
       </div>
       </div>
       
             </form>
             </c:when>
      </c:choose>
  
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
