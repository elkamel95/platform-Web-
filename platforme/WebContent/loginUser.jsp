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
<body style=" background-color: #f7f7f7;">

             
	<div   style="
    margin-left: 35%;
    margin-top: 10%;
" >
		  <div class="modal-header">
			<h3>Bloc de connexion</h3>
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
						</form>		
			
		  </div>
	</div>

</body>
</html>