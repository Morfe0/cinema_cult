<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="com.azienda.webapp.entity.Ruolo" %>
<%@page import ="com.azienda.webapp.entity.Utente" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/modificaUtente.css">
<title>Modifica Utente</title>
 <!-- Fav Icon -->
 <link rel="shortcut icon" href="reg/FaviconGruppo4.png" type="image/x-icon">
 <!-- Box Icons -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'rel='stylesheet'>
</head>

<body>
<header class="header" >
    <% try{Utente u = (Utente)session.getAttribute("utente");%>
          <!--Logo-->
          <a href="Home" class="header__logo">
            <img src="reg/FaviconGruppo4.png" alt="Logo" class="logo__image">
          </a>
          <!--Menu-->
          <a  class="header__menu flux"> Premiere Cinema Cult </a>
           
          <!--Button login-->
          <div id="menu-tendina">
            <div id="burger">
                    <div class="bun top"></div>
                    <div class="filling"></div>
                    <div class="bun bottom"></div>
            </div>
          </div>
          

          <nav>
              <ul>
                <%if(u.getRuolo().getRuolo().equals("admin")){ %>	
                <li>
                  <a href="ProfiloAdmin">Area Personale</a>
                </li>
                <li class="green">
                  <a href="InserisciFilm">Inserisci Film</a>
                </li>
               
                <li class="yellow">
                  <a href="ListaSpettacoli">Visualizza Spettacoli</a>
                </li>
                <li class="red">
                  <a href="Login">LogOut</a>
                </li>
                <%}if(u.getRuolo().getRuolo().equals("user")){ %>
                  <li>
                    <a href="ProfiloUtente">Area Personale</a>
                  </li>
                  <li class="red">
                    <a href="Login">LogOut</a>
                  </li>
                  <%}if(u.getRuolo().getRuolo().equals("staff")){ %>
                    <li>
                      <a href="ListaSpettacoli">Area Personale</a>
                    </li>
                    <li class="red">
                      <a href="Login">LogOut</a>
                    </li> 
                    <%}}catch(NullPointerException e){ %>
                <li class="purple">
                  <a href="Login">Accedi</a>
                </li>
                <%}%>
              </ul>
            </nav>

          </header>
<%Utente u = (Utente)request.getAttribute("utente");
Ruolo ruolo = u.getRuolo();
Utente utenteLoggato = (Utente)session.getAttribute("utente");
%>
<main class="main"> 
<div class="morfeo">
  <img src="reg/pngegg.png" alt="morfeo">
</div>

  <div class="wrapper" >
    <div class="title-text">
      <div class="title login">
        Modifica
        <%=u.getNome() %> <%=u.getCognome()%>
      </div>
    </div>
    <div class="form-container">
      <div class="form-inner">
        <form action="ModificaUtente" method ="POST" class="login">
          <div class="field">
            <input type="text" name ="email" id="mail" pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$">
            <label for="mail">Modifica  E-Mail</label>
          </div>
          <div class="field">
            <input type="password" name="password" id ="password" pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
            <label for="password">Modifica Password...</label>
          </div>
          <%if(utenteLoggato.getRuolo().getRuolo().equals("admin")){
            List<Ruolo> ruoli = (List<Ruolo>)request.getAttribute("ruoli");%>
            <select class="input" name="ruolo">
            <% 
            for(Ruolo r : ruoli){
              %>
              <option value="<%=r.getId() %>"><%=r.getRuolo() %></option>
            <% 
            }
            %>
            </select>
            <%} %>

          <input type="hidden" value="<%=u.getId() %>" name="id_utente">
          
          <div class="field btn">
            <div class="btn-layer"></div>
            <input type="submit" value="Modifica">
          </div>
          <div class="signup-link">
            <strong>Fai la tua scelta</strong>
          </div>
        </form>
      </div>
    </div>
  </div>
</main>
<footer class="stiky-footer">
    
    <div class="footer-top">
      <div class="container">

        <div class="divider"></div>

        <div class="quicklink-wrapper">

          <ul class="quicklink-list">

            <li>
              <a href="#" class="quicklink-link">Forum</a>
            </li>

            <li>
              <a href="#" class="quicklink-link">Ringraziamenti</a>
            </li>

          </ul>

          <ul class="social-list">

            <li>
              <a href="https://www.facebook.com/Premiere-Cinema-Cult-100590939338962/" class="social-link">
                <ion-icon name="logo-facebook"></ion-icon>
              </a>
            </li>

            <li>
              <a href="https://twitter.com/CultPremiere
              " class="social-link">
                <ion-icon name="logo-twitter"></ion-icon>
              </a>
            </li>

            <li>
              <a href="https://www.instagram.com/premierecinemacult/
              " class="social-link">
                <ion-icon name="logo-instagram"></ion-icon>
              </a>
            </li>

          </ul>

        </div>

      </div>
    </div>

    <div class="footer-bottom">
      <div class="footer-metodi">
     
          <p >
            Metodi di pagamento
          </p>

          <img class="footer-pagamenti" src="css/img/footer-bottom-img.png" alt="Online banking companies logo" >
      
      </div>
    </div>

  </footer>
  <!--  Menu a tendina -->
<script>  
const nav = document.querySelector('nav')

document.querySelector('#burger').addEventListener('click',(e) => {
  e.currentTarget.classList.toggle("active")
  nav.classList.toggle('show')
})
</script>
  <!-- 
    - ionicon link
  -->
  <script src="https://kit.fontawesome.com/5a47681717.js" crossorigin="anonymous"></script>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</body>
</html>