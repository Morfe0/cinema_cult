<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@page import="com.azienda.webapp.entity.Film"%>
<%@page import="com.azienda.webapp.entity.Spettacolo"%>
<%@page import="com.azienda.webapp.entity.Utente" %>
<%@page import="com.azienda.webapp.entity.Prenotazione"%>
<%@page import="java.util.List" %>
<%@page import="java.sql.Date" %>
<%@page import="java.sql.Time" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Film</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/modificaFilm.css">
    <link rel="stylesheet" href="css/style.css">
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
                    <a href="ProfiloUser">Area Personale</a>
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
	<main class ="main">
    <div class="wrapper" style="margin-top:250px;">
       
        <div class="title-text">
           <div class="title login">
<%Film film = (Film)request.getAttribute("film"); %>
            Modifica Film: <%=film.getTitolo() %>
            
           </div>
        </div>
        <div class="form-container">
           <div class="form-inner">
              <form action="ModificaFilm" method ="POST" enctype="multipart/form-data" class="login" >
                <input type="hidden" name ="id" value="<%=film.getId() %>">
                  <div class="field">
                    <input type="file" class="custom-file" id="file" name="file" required>
                    <label for="file">Inserisci Locandina..</label>
                 </div>
                 <div class="field">
                    <input type="number" id="prezzo" name ="prezzo" required pattern="^(0*[1-9][0-9]*(\.[0-9]+)?|0+\.[0-9]*[1-9][0-9]*)$">
                    <label for="prezzo">Modifica Prezzo...</label>
                 </div>
                  <div class="field">
                    <input type="text" id="titolo" name ="titolo" required>
                    <label for="prezzo">Modifica Titolo...</label>
                 </div>
                 
                 <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Modifica Film">
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
  <!--Link to JS-->
  <script src="js/main.js"></script>

  <!-- Swiper JS -->
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

  
 


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