
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Premiere Cinema Cult</title>
<link rel="stylesheet" href="css/error403.css">
<link rel="stylesheet" href="css/r2d2.css">
      <link rel="stylesheet" href="css/logStyle.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Fav Icon -->
  <link rel="shortcut icon" href="reg/FaviconGruppo4.png" type="image/x-icon">
      <!-- Box Icons -->
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'rel='stylesheet'>
   </head>
   <body>
   <%session.invalidate(); %>
  

   
       <%if(request.getAttribute("abilitato")!=null) {%>
   		
  <div class="boxPopup" id="popup">
    
    <div class="gandalf">
    <div class="fireball"></div>
    <div class="skirt"></div>
    <div class="sleeves"></div>
    <div class="shoulders">
      <div class="hand left"></div>
      <div class="hand right"></div>
    </div>
    <div class="head">
      <div class="hair"></div>
      <div class="beard"></div>
    </div>
  </div>
  <div class="message">
  <h1>403 - You Shall Not Pass</h1>
  <p>Uh oh, Gandalf Ti sta bloccando !<br/>Forse il tuo account è stato bloccato da Sauron, non puoi più continuare con queste credenziali.</p>
  	 <button id="btnClose">Chiudi</button>
  </div>
  </div>

   <%} %>
   <%if(request.getAttribute("verifica")!=null){ %>
  <div class="boxPopup2" id="popup">
  <div class="r2d2">
   <div class="head">
      <div class="eye">
         <div class="circle-1">
            <div class="circle-2"></div>
            <div class="circle-3"></div>
         </div>
      </div>
      <div class="list">
         <div class="item"></div>
         <div class="item"></div>
         <div class="item"></div>
         <div class="item">
            <div class="circle"></div>
         </div>
         <div class="item"></div>
      </div>
   </div>
   <div class="body">
      <div class="list">
         <div class="item"></div>
         <div class="item"></div>
         <div class="item"></div>
      </div>
      <div class="oval"></div>
   </div>
   <div class="arm-1">
      <div class="divisor"></div>
   </div>
   <div class="arm-2">
      <div class="divisor"></div>
   </div>
   <div class="leg"></div>
   <div class="shadow"></div>
</div>
  <div class="message">
  <h1>Login non Riuscito</h1>
  <p>Uh no, Avrai sbagliato email o password <br/>O forse non sei Registrato?</p>
  	 <button id="btnClose">Chiudi</button>
  </div>
  </div> 
   <%} %>
      <div class="wrapper" style=" width: 400px;">
         <button><a class="torna-home" href = "Home"><i class='bx bx-x' ></i></a></button>
         <div class="title-text">
         
            <div class="title login">
               Login
            </div>
         </div>
         <div class="form-container">
            <div class="slide-controls">
                <a class="slide login"  href="Login">Login</a>
               
                <a class="slide login"  href="Registrazione" style="color: #3D6D7B ;">Registrazione</a>
               <div class="slider-tab"></div>
            </div>
            <div class="form-inner">
               <form action="Login" class="login" method="POST" >
                  <div class="field">
                     <input type="text" id="email" required name="email" pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$">
                     <label for="email">Inserisci Email...</label>
                  </div>
                  <div class="field">
                     <input type="password" id="password" required name="password" pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
                     <label for="password">Inserisci Password...</label>
                  </div>
                  
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Login">
                  </div>
                  <div class="signup-link">
                     Non sei cliente? <a href="Registrazione">Registrati ora</a>
                  </div>
                   <div class="signup-link">
                     Password dimenticata? <a href="PasswordDimenticata">Premi qui!</a>
                  </div>
               </form>
            </div>
         </div>
      </div>
      <script type="text/javascript">
      btnClose.addEventListener("click", ()=>{
    	  popup.classList.add("hidePopup");
    	});
      </script>
   </body>
</html>