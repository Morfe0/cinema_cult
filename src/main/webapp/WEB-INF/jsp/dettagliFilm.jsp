<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="com.azienda.webapp.entity.Attore" %>     
<%@page import ="com.azienda.webapp.entity.Utente" %>       
<%@page import ="com.azienda.webapp.entity.Film" %>
<%@page import ="com.azienda.webapp.entity.Spettacolo" %>
<%@page import="com.azienda.webapp.utility.Utilities" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<title>Scheda Film</title>
<meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/visualizzaFilm.css">

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
              <li class="purple">
                  <a href="Home">Home</a>
                </li>
              
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
                  <a href="Accedi">Accedi</a>
                </li>
                <%}%>
              </ul>
            </nav>

          </header>
<main class="main" style="margin-top:175px;">
<%Film f = (Film)request.getAttribute("film");%>
  <section id="slider-container up-container">
    <!-- Swiper -->
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <!-- slider-1------->
        
        <div class="swiper-slide">
          
          <!-- slider-box -->
          <div class=" slider-details">
            <!-- img ------>
              <div class="slider-img"> 
                <img src="reg/<%=f.getLocandina() %>" alt="poster">
                
              </div>
              <!-- details -->
              <div class="slider-p">
                <!-- title ---->
                <strong><%=f.getTitolo()%></strong>
                <br>
                <div class="movie-regista">
                  <p><%=f.getRegista().getNome()%> <%=f.getRegista().getCognome()%></p>
                </div>
                <br>
                <!-- movie-details ------>
                <p><%=f.getTrama()%></p>
                <% List<Attore> attori = f.getAttori();%>
                <!-- movie-cast ------>
                <div class="movie-cast">
                  <p>Cast-</p>
                  <%for(Attore a :attori){ %>
                  <p><%=a.getNome()%></p>
                  <p><%=a.getCognome()%></p>
                  <%}%>
                </div>
                
               
        
                  <!-- btns-->
                  <div class="card-btns">
                     <%List<Spettacolo>spettacoliControllo=Utilities.spettacoliAttivi(f);
			if(!spettacoliControllo.isEmpty()) {
			%>
          <form action="Prenota" method="GET">
            <input type="hidden" value="<%=f.getId() %>" name="id_film">
            <input class="btn btn-form" type="submit" value="prenota">
          </form>
			<% } %>
          <a href="Home" class="btn btn-form">Torna Alla Home</a>
                   

                  </div>
                </div>    
          </div> 
        </div>
        
      </div>
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