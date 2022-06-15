<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="com.azienda.webapp.entity.Ruolo" %>
<%@page import ="com.azienda.webapp.entity.Prenotazione" %>
<%@page import ="com.azienda.webapp.entity.Utente" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profilo</title>
    <link rel="stylesheet" href="css/profiloUtente.css">
    <!-- Fav Icon -->
  <link rel="shortcut icon" href="reg/FaviconGruppo4.png" type="image/x-icon">
  <!-- Box Icons -->
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'rel='stylesheet'>
</head>
<body>
     <!--Heder-->
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
                  <a href="Home">Home</a>
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
                    <a href="Home">Home</a>
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
          <main class="main">
          <%Utente utenteLoggato = (Utente)session.getAttribute("utente"); %>
          
           <%List<Prenotazione> prenotazioni = (List<Prenotazione>)request.getAttribute("prenotazioniAttive");
           %>  
<section class="biglietto">
  <div class="cardWrap">
          <h3>Benvenutp <%=utenteLoggato.getNome() %></h3>
           <form action="ModificaUtente" method="GET">
            <input type="hidden" value="<%=utenteLoggato.getId() %>" name="id_utente">
            <input class="btn btn-form" type="submit" value="Modifica Dati">
        </form>
    
    <%for(Prenotazione p :prenotazioni){%>
    <div class="cardContainer">
            <div class="card-biglietto cardLeft">
            <h1>Premiere Cinema <span>Cult</span></h1>
            <div class="title">
                <h2><%=p.getSpettacolo().getFilm().getTitolo()%></h2>
                <span>Titolo</span>
            </div>
            <div class="name">
                <h2><%=p.getSpettacolo().getSala().getNome() %></h2>
                <span>sala</span>
            </div>
            <div class="seat">
                <h2><%=p.getSpettacolo().getData()%></h2>
                <span>Data</span>
            </div>
            <div class="time">
                <h2><%=p.getSpettacolo().getOra()%></h2>
                <span>Ora</span>
            </div>
            
            </div>
            <div class="card-biglietto cardRight">
            <div class="eye">
                <img src="reg/FaviconGruppo4.png" alt="Logo" class="logo__image">
            </div>
            <div class="number">
                <h3><%=p.getId() %></h3>
                <span>Codice Prenotazione</span>
            </div>

            <form action="ProfiloUtente" method="POST">
                <input type="hidden" value="<%=p.getId() %>" name="id_prenotazione">
                <input class="btn btn-form" type="submit" value="Elimina Prenotazione">
            </form>
            </div>
        </div>
        <%}%>
    </div>    
    
</section>

</main>
<!-- 
    - #FOOTER
  -->

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
</html>