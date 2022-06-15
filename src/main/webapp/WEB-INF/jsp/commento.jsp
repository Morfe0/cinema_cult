<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.azienda.webapp.entity.Film"%>
<%@page import="com.azienda.webapp.entity.Utente"%>
<%@page import="com.azienda.webapp.entity.Commento" %>
<%@page import="java.util.List"%>
<!doctype html>
<html>

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=Ddevice-width, initial-scale=1.0">
  <title>Forum Commenti</title>
  <!-- Link To CSS -->
  <link rel="stylesheet" href="css/commenti.css">
  <link rel="stylesheet" href="css/style.css">
  <!-- Link Swiper's CSS -->
  <link
  rel="stylesheet"
  href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
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
                      <a href="Login" >Logout</a>
                    </li> 
                    <%}}catch(NullPointerException e){ %>
                <li class="purple">
                  <a href="Login">Accedi</a>
                </li>
                <%}%>
              </ul>
            </nav>

          </header>
  <!--sliders-->
  <main class="main">
  <section id="slider-container up-container">
    <div class="upper-container">
      <div class="container"> 
        <h2 class="h2 section-title">Benvenuto nella sezione Forum.<br>La tua opinione per noi è importante!</h2>
        <div class="divider"></div>
      </div>
    </div>
    <div id="zona_commenenti">
       <form action = "Commento" method = "Post">
      <div id="header_commenti">
  			<select id = "tendina" name="Id_Film">
  			<option id="slider-bottom" default>Scegli un film!</option>
 		 		<% Utente utenteLoggato = (Utente)session.getAttribute("utente");
 		 		List<Film> films = (List<Film>)request.getAttribute("films");
      			for(Film f:films) {     
				%>               
 				<option id="slider-bottom" value= "<%= f.getId()%>" > <%= f.getTitolo()%> </option>
  				<% } %>
			</select>
        </div>
        <div id="lista_commenti"></div>
        <div><img id = "account_img" src = "reg/account_anonimo.png" alt = "Profilo"></div>
        <div id="account_nome" style = "margin-left: 150px;"><%= utenteLoggato.getNome()%></div>
        <div id="zona_scrittura">
      
      			
          <label for="comment">Commento:</label><br>
          <input type="text"  id="scrivi_commento" name = "commento" id="commento" placeholder="Scrivi qui...">
          <input type= "hidden" name = "utenteLoggato" value="<%= utenteLoggato.getId() %>">
          <input type="submit"  id="bottone_pubblica" value="pubblica commento">
        </div>
		</form>
      </div>
      <div id="zona_commenenti">
       <%List<Commento> commenti = (List<Commento>)request.getAttribute("commenti");
    	  for(Commento c: commenti){
    	  %>
      
      	<div id="header_commenti"> <h2 class="h2-section-title"><%=c.getFilm().getTitolo() %></h2>
      	</div>
      	<div id="lista_commenti"></div>
       <div><img id = "account_img" src = "reg/account_anonimo.png" alt = "Profilo"></div>
        <div id="account_nome" style = "margin-left: 150px;"><%= c.getUtente().getNome()%></div>
        <div id="zona_scrittura">
        <label for="comment">Commento:</label><br>
        <textarea id="scrivi_commento" id="commento" ><%=c.getTesto() %></textarea>
      </div>
      
      <%} %>
      </div>
  </section>
  </main>
      
      
  <!--Card film-->
  
  

  <!-- 
    - #FOOTER
  -->

  <footer class="footer">

    <div class="footer-top">
      <div class="container">

        <div class="divider"></div>

        <div class="quicklink-wrapper">

          <ul class="quicklink-list">

            <li>
              <a href="Commento" class="quicklink-link">Forum</a>
            </li>

            <li>
              <a href="Ringraziamenti" class="quicklink-link">Ringraziamenti</a>
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






  <!--Link to JS-->
  <script src="js/main.js"></script>
  <script src="js/commenti.js"></script>
   <script src="js/script.js"></script>

  <!-- Swiper JS -->
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper(".mySwiper", {
      spaceBetween: 30,
      centeredSlides: true,
      autoplay: {
        delay: 3800,
        disableOnInteraction: false,
      },
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });
  </script>
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



