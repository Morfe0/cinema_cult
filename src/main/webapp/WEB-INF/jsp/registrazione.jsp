<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Registrazione</title>
      <link rel="stylesheet" href="css/logStyle.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <!-- Fav Icon -->
  <link rel="shortcut icon" href="reg/FaviconGruppo4.png" type="image/x-icon">
  <!-- Box Icons -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'rel='stylesheet'>
   </head>
   <body>
      <div class="wrapper" style="width: 600px;">
         <button><a class="torna-home" href = "Home"><i class='bx bx-x' ></i></a></button>
         <div class="title-text">
            <div class="title signup">
               Registrazione
            </div>
         </div>
         <div class="form-container">
            <div class="slide-controls">
               <a class="slide login"  href="Registrazione">Registrazione</a>
               
               <a class="slide login"  href="Login" style="color: #3D6D7B  ;">Login</a>
               <div class="slider-tab"></div>
            </div>
            <div class="form-inner" >
               <form action="Registrazione" method="POST" class="login">
                  <div class="allinea">
                     <div class="left">
                        <div class="field">
                           <input type="text" id="nome" name="nome" required >
                           <label for="nome">Digita il Nome...</label>
                        </div>
                        <div class="field">
                           <input type="text" id="email" name="email" required pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$">
                           <label for="email">Inserisci Email...</label>
                        </div>
                        <div class="field">
                           <input type="text" id="citta" name="citta"required >
                           <label for="citta">Inserisci Citta...</label>
                        </div>
                     </div>

                     <div class="right">
                        <div class="field">
                           <input type="text" id="cognome" name="cognome"required>
                           <label for="cognome">Digita il Cognome...</label>
                        </div>
                        <div class="field">
                           <input type="password" id="password" name="password" required pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
                           <label for="password">Inserisci Password....</label>
                        </div>
                        <div class="field">
                           <input type="date" id="date" name="dataNascita" placeholder="Inserisci Data di Nascita..." >
                           <label for="date">Inserisci Data....</label>    
                        </div>
                     </div>

                  </div>
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Registrati">
                  </div>
                  <div class="signup-link">
                    <p style="font-size: 20px; color:#9E2A2B ;">Come ci si registra?</p>
                    <p>La password richiede almeno 8 caratteri, un numero, un simbolo e una maiuscola </p>
                  </div>
               </form>
            </div>
         </div>
      </div>
   </body>
</html>