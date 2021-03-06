
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password dimenticata Premiere Cinema Cult</title>
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
  <p>Uh oh, Gandalf Ti sta bloccando !<br/>Forse il tuo account ? stato bloccato da Sauron, non puoi pi? continuare con queste credenziali.</p>
  	 <button id="btnClose">Chiudi</button>
  </div>
  </div>

   <%} %>
   <%if(request.getAttribute("errore")!=null){ %>
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
  <h1>Email non trovata</h1>
  <p>Uh no, Avrai sbagliato a digitare l'email<br/>O forse non sei Registrato?</p>
  	 <button id="btnClose">Chiudi</button>
  </div>
  </div> 
   <%} %>
      <div class="wrapper" style=" width: 400px;">
         <button><a class="torna-home" href = "Login"><i class='bx bx-x' ></i></a></button>
         <div class="title-text">
         
            <div class="title login">
               Password dimenticata
            </div>
         </div>
         <div class="form-container">
            
            <div class="form-inner">
               <form action="PasswordDimenticata" class="login" method="POST" >
                  <div class="field">
                     <input type="text" id="email" required name="email" pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$">
                     <label for="email">Inserisci Email...</label>
                  </div>
                  
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Recupera password">
                  </div>
                  <div class="signup-link">
                     Se hai dimenticato la password, inserisci l'email e ti verr? mandata per posta.
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