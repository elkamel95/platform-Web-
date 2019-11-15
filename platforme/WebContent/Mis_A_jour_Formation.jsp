<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script type="text/javascript">
function addInput(){
	if(document.getElementById("pdf").value != "") {
	     var input = document.createElement("input");
	        input.setAttribute("name", "hidden");

	        input.setAttribute("value", "pdf");
	        var ajout = document.getElementById("ajout");
	        ajout.parentNode.insertBefore(input,ajout);
	        }
	if(document.getElementById("image").value != "") {
	     var input = document.createElement("input");
	        input.setAttribute("name", "hidden");

	        input.setAttribute("value", "image");
	        var ajout = document.getElementById("ajout");
	        ajout.parentNode.insertBefore(input,ajout);
	        ajout.appendChild(input);
	        }
	else{    

		
		var element = document.getElementById("image1"); // notice the change
		element.parentNode.removeChild(element);}
	
  
}
</script>
<title>Matrix Admin</title>
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

</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">

    <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important"> ${requestScope.nb}</span> <b class="caret"></b></a>
   <ul  class="dropdown-menu" style="width: 250px; height: 200px; overflow: auto ;background-color: #3f4a54 "  >
      				                	 <c:forEach var="item" items="${requestScope.ListMessage}" >
      
        <li style="background-color: aliceblue"><a class="sAdd" title="" href="Admin?msg=${item.message}&&id_user=${item.id_user}&&Id_page=message">
        <i class="icon-plus"></i> ${item.message}</a></li>
           </c:forEach>  
          
      
      </ul>
    </li>
    <li class="dropdown" id="menu-Invite"><a href="#" data-toggle="dropdown" data-target="#menu-Invite" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important"> ${requestScope.nbInvite}</span> <b class="caret"></b></a>
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
        Registre_commerce: ${item.registre_commerce}
        </td>
        <td>
         email: ${item.email}
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
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
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
        <li><a href="Admin?Id_page=InsertPub">Pub Slider</a></li>
      </ul>
    </li>
      <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Apprentissage en ligne</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=ViewAllCours">Edit Cours</a></li>
                <li><a href="Admin?Id_page=ViewAllVideo">Edit Cours par Video</a></li>
                        <li><a href="Admin?Id_page=ViewAllTest">Edit Test</a></li>
        
        <li><a href="Admin?Id_page=InsertCour">Insert Cours</a></li>
        
                <li><a href="Admin?Id_page=InsertCatCour">Insert Categorie Cours</a></li>
        
        </li>
                <li><a href="Admin?Id_page=InsertVideo">Insert Video</a></li>
                      <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Test</span> <span class="label label-important">3</span></a>
                
                      <ul>
                
                        <li><a href="Admin?Id_page=InsertTest">Insert Test</a></li>
                      <li><a href="Admin?Id_page=InsertQuestion">Insert Question</a></li>
                        </ul>
        </li>
      </ul>
       <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>gérer utilisateur</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="Admin?Id_page=ViewAllUser">gérer</a></li>
        </ul>
        </li>
    </li>
    
    <li class="content"> <span>Monthly Bandwidth Transfer</span>
      <div class="progress progress-mini progress-danger active progress-striped">
        <div style="width: 77%;" class="bar"></div>
      </div>
      <span class="percent">77%</span>
      <div class="stat">21419.94 / 14000 MB</div>
    </li>
    <li class="content"> <span>Disk Space Usage</span>
      <div class="progress progress-mini active progress-striped">
        <div style="width: 87%;" class="bar"></div>
      </div>
      <span class="percent">87%</span>
      <div class="stat">604.44 / 4000 MB</div>
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
      <div class="widget-box">
       
        <div class="widget-content nopadding">
        <c:choose>
                <c:when test="${requestScope.Action eq 'UpdateFormation' }">
        
        <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
         <input type="hidden" name="Id_page" value="UpdateFormation" >
                                   
         <c:forEach var="item" items= "${requestScope.formation}">
        
                   <div class="control-group">
                   
              <label class="control-label">Title</label>
              <div class="controls">
                <input type="text" class="span11" name="title" value="${item.nom }"/>
                <span class="help-block">Title</span> </div>
            </div>
            <div class="control-group">
              <label class="control-label">Select input</label>
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
              <label class="control-label">Select Sous</label>
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
              <label class="control-label">Prix:</label>
              <div class="controls">
                <input type="text" class="span11" name="Prix" value="${item.prix}"/>
                <span class="help-block">Prix</span> 
                </div>
            </div>
    <div class="control-group">
              <label class="control-label">Date debut:</label>
              <div class="controls">
                <input type="text" class="span11" name="Prix" value="${item.date_Fin}"/>
                <span class="help-block">Date debut</span> 
                </div>
            </div>    <div class="control-group">
              <label class="control-label">date fin</label>
              <div class="controls">
                <input type="text" class="span11" name="Prix" value="${item.date_Debut}"/>
                <span class="help-block">date fin </span> 
                </div>
            </div>
               <div class="control-group">
              <label class="control-label">Description</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="desc" ><c:out value="${item.descrription}" /></textarea>
			   <span class="help-block">Description</span> 
                </div>
            </div>
            <div class="control-group">
              <label class="control-label">Adresse</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required value="${item.adresse}"/>
			   <span class="help-block">Adresse</span> 
                </div>
            </div>   
            <div class="control-group">
              <label class="control-label">Tel</label>
              <div class="controls">
                <input type="text" class="span11" name="title" required value="${item.tel}"/>
			   <span class="help-block">Tel</span> 
                </div>
            </div>
            <tabe><tr>
                  <td><img src="themes/images/products/${item.image}" alt=""/></td>
            
            <td>
            <div class="control-group">
              <label class="control-label">File upload input</label>
              <div class="controls">
                            <input type="hidden" name="id_formation" value="${item.id_formation}"/>
                                                      <input type="hidden" name="id_User" value="1"/>
              
                <input type="file" name="file" />
              </div>
            </div>
                 
        </td></tr></tabe>
            <div class="form-actions">
            
            
                            <button type="submit" class="btn btn-success">Save</button>
              
            </div>
 </c:forEach >        
  </form>
        </c:when>
        <c:when test="${requestScope.Action eq 'UpdateJobOffer' }">
        <c:forEach var="itemJob" items="${requestScope.listeJob}" >
        
        <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
        <input type="hidden" name="UpdateJobOffer" value="UpdateJobOffer">
<div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
                <input type="text" class="span11" name="title" value="${itemJob.title}" required/>
                <span class="help-block">Title</span> </div>
            </div>   
            <div class="control-group">
              <label class="control-label">nom Sociter:</label>
              <div class="controls">
                <input type="text" class="span11" name="nom_Sociter" value="${itemJob.nom_Sociter }" required/>
                <span class="help-block">nom Sociter</span> </div>
            </div>   
                 <div class="control-group">
              <label class="control-label">description détaillée:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="desc" required>${itemJob.description_détaillée }</textarea>
                <span class="help-block">description_détaillée</span> </div>
            </div>  
                    <div class="control-group">
              <label class="control-label">Exigences</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Exigences" required >${itemJob.exigences}</textarea>
			   <span class="help-block">Exigences</span> 
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">Secteur_activité</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required >${itemJob.secteur_activité }</textarea>
			   <span class="help-block">Secteur_activité</span> 
                </div>
            </div>
                    <div class="control-group">
              <label class="control-label">Lieu</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required >${itemJob.lieu }</textarea>
			   <span class="help-block">Lieu</span> 
                </div>
            </div>        <div class="control-group">
              <label class="control-label">Expire le:</label>
              <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required >${itemJob.expire }</textarea>
			   <span class="help-block">Expire le :</span> 
                </div>
            </div>
                       <div class="control-group">
              <label class="control-label">Select input</label>
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
              <label class="control-label">Select Sous</label>
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
              <label class="control-label">Logo</label>
              <div class="controls">
              <input  name="id_user" type="hidden" value="${itemJob.id_User }"/>
                            <input  name="id_Job" type="hidden" value="${itemJob.id_offre }"/>
              
<input type="file"		name="file1"/>	   
<span class="help-block">Logo</span> 
                </div>
            </div>
                          <button type="submit" class="btn btn-success">Save</button>
            
            </form>
            
            
            
            
            </c:forEach>
             </c:when>
    <c:when test="${requestScope.Action eq 'UpdateCours' }">
                     <c:forEach var="item" items="${requestScope.ListCours}" >
                     
                     <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                     
                <div class="widget-box">
       
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="UpdateCours" >
                        <input type="hidden" name="Id" value="${item.id_cours}" >
            
             <div class="control-group">
              <label class="control-label">Nom:</label>
              <div class="controls">
           <input type="text" name="nom" value="${item.nom}" required/>
           </div>
           </div>

           <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required> ${item.desc}</textarea>
			   <span class="help-block">Dscription:</span> 
                </div>
                     <div class="control-group">
              <label class="control-label">Select Catégori</label>
              <div class="controls">
             
              </div>
            </div>
                    <div id="ajout"> </div>
                    
            <div class="control-group">
              <label class="control-label">image:</label>
              <div  id="image1" class="controls">
           <input id="image" type="file" name="image" />
           </div>
           </div>
            <div class="control-group">
              <label class="control-label">Fichier PDF:</label>
              <div class="controls">
           <input id="pdf" type="file" name="pdf" value="${item.pdf}" />
           </div>
           </div>            
       <input onclick="addInput()" type="submit" class="btn btn-success" value="Save" />
       </div>
       </div>
       </div>
       </div>
       
             </form>
        </c:forEach>
             
             </c:when>
              <c:when test="${requestScope.Action eq 'UpdateCoursVideo' }">
                     <c:forEach var="item" items="${requestScope.ListCours}" >
                     
                     <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                     
                <div class="widget-box">
       
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="UpdateCoursVideo" >
                        <input type="hidden" name="Id" value="${item.id_video}" >
            
             <div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
           <input type="text" name="nom" value="${item.titre}" required/>
           </div>
           </div>

          
                    <div id="ajout"> </div>
                    
            <div class="control-group">
              <label class="control-label">image:</label>
              <div  id="image1" class="controls">
           <input id="image" type="file" name="image" value=""/>
           </div>
           </div>
            <div class="control-group">
              <label class="control-label">Fichier Video:</label>
              <div class="controls">
           <input id="pdf" type="file" name="pdf" value="" />
           </div>
           </div>            
       <input onclick="addInput()" type="submit" class="btn btn-success" value="Save"/>
       </div>
       </div>
       </div>
       </div>
       
             </form>
        </c:forEach>
             
             </c:when>
             <c:when test="${requestScope.Action eq 'UpdateTest' }">
                     <c:forEach var="item" items="${requestScope.ListTest}" >
                     
                     <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                     
                <div class="widget-box">
       
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="UpdateTest" >
                        <input type="hidden" name="Id" value="${item.id_test}" >
            
             <div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
           <input type="text" name="nom" value="${item.test}" required/>
           </div>
           </div>
    <div class="controls">
              <textarea class="textarea_editor span12" rows="6" name="Secteur_activité" required> ${item.description}</textarea>
			   <span class="help-block">Dscription:</span> 
                </div>
          
                    <div id="ajout"> </div>
                    
            <div class="control-group">
              <label class="control-label">image:</label>
              <div  id="image1" class="controls">
           <input type="file" name="image" value=""/>
           </div>
           </div>
            <table>    
            <tr>
            <td> 
       <input  type="submit" class="btn btn-success" value="Save"/> 
       </td>
       <td>
       <a href="Admin?Id_page=ViewAllTestQuestion&id_Test=${item.id_test}"><span class="label label-info">Mis a jour Question</span></a>
       </td>
       </tr>
       </table> 
       </div>
       </div>
       </div>
       </div>
       
             </form>
        </c:forEach>
             
             </c:when>
             <c:when test="${requestScope.Action eq 'UpdateQuestion' }">
                     <c:forEach var="item" items="${requestScope.ListQuestion}" >
                     
                     <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                     
                <div class="widget-box">
       
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="UpdateQuestion" >
                        <input type="hidden" name="id_Q" value="${item.id_Q}" >
            
             <div class="control-group">
              <label class="control-label">Question:</label>
              <div class="controls">
           <input type="text" name="nom" value="${item.question}" />
           </div>
           </div>
  <table border="0.5" Style="width: 100%;">
  <tr>
  <td>Reponse</td><td>Resultat</td>
  <td>Supprimer</td>
  </tr>
                       <c:forEach var="item" items="${requestScope.ListReponce}" >
  
  <tr>
  <td><textarea class="textarea_editor span12" rows="6" name="Secteur_activité" > ${item.rep}</textarea>
  </td><td><select name="result">
  <option></option>
    <option value="false" selected>vrai</option>
      <option value="true">incorrect</option>
  
  </select></td>
  <td>
              <input type="hidden" name="id_rep" value="${item.id_rep}"/>
            </form>  
  
        <form action="Admin" method="get">
                  <input type="hidden" name="Id_page" value="Delletereponse"/>
                  <input type="hidden" name="id_rep" value="${item.id_rep}"/>
                                          <input type="hidden" name="id_Q" value="${item.id_Q}" >
                                    <input type="submit" value="supprimer" />
                  </form>
                
  </td>
  </tr>
  
  </c:forEach>
  </table>
                    
          
        
       <input  type="submit" class="btn btn-success" value="Save"/> 
   
       </div>
       </div>
    
       
             </form>
        </c:forEach>
             
             </c:when>
              <c:when test="${requestScope.Action eq 'UpdateCatCours' }">
                     <c:forEach var="item" items="${requestScope.ListCatCours}" >
                     
                     <form action="Admin" method="post" enctype="multipart/form-data" class="form-horizontal">
                     
                <div class="widget-box">
       
        <div class="widget-content nopadding">
            <input type="hidden" name="Id_page" value="Mis_A_jourCatCours" >
            
             <div class="control-group">
              <label class="control-label">Title:</label>
              <div class="controls">
           <input type="text" name="nom" value="${item.title}" required/>
           </div>
           </div>

       
                         
            <div class="control-group">
              <label class="control-label">image:</label>
              <div  id="image1" class="controls">
           <input id="image" type="file" name="image" />
           </div>
           </div>
                        <input type="hidden" name="Id" value="${item.idCours}" >
                      
       <input  type="submit" class="btn btn-success" value="Save" />
       </div>
       </div>
             </div>
             </div>
      
       
             </form>
        </c:forEach>
             
             </c:when>
      </c:choose>
    
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


</body>
</html>
