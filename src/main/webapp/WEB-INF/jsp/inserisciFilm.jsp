<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.azienda.webapp.entity.Film" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/inserisciFilm.css">
    <link rel ="stylesheet"href="css/style.css"> 
    <title>Inserisci Film</title>
    <!-- Fav Icon -->
  <link rel="shortcut icon" href="reg/FaviconGruppo4.png" type="image/x-icon">
  <!-- Box Icons -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'rel='stylesheet'>

</head>
<body>
 <!--Heder-->
  <header class="header" >
   
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
             
                <li>
                  <a href="ProfiloAdmin">Area Personale</a>
                </li>
                <li class="green">
                  <a href="Home">Home</a>
                </li>
               
                <li class="yellow">
                  <a href="ListaSpettacoli">Visualizza Spettacoli</a>
                </li>
                <li class="red">
                  <a href="Login">LogOut</a>
                </li>

                
              </ul>
            </nav>

          </header>
    <main class="main">
    <div class="wrapper" >
        <div class="title-text">
           <div class="title login">
              Inserisci Film
           </div>
        </div>
        <div class="form-container">
           <div class="form-inner">
              <form action="InserisciFilm"method="POST" enctype="multipart/form-data" class="login" >
                <div class="allinea">
                    <div class="left">
                <div class="field">
                  <label for="titolo">Inserisci Titolo... </label>
                  <input type="text" id="titolo" name="titolo" required >
                </div>
                <div class="field">
                  <label for="file">Inserisci Locandina..</label>
                  <input type="file"  id ="file"class="custom-file" id="file" name="file">

                </div>
                <div class="field">
                  <label for="durata">Inserisci Durata... </label>
                  <input type="number" id="durata" name="durata" required pattern="^(0*[1-9][0-9]*(\.[0-9]+)?|0+\.[0-9]*[1-9][0-9]*)$" >

                </div>
                <div class="field">
                  <label for="prezzo">Inserisci il Prezzo...</label>
                  <input type="number" id="prezzo" name="prezzo" step="any" required pattern="^(0*[1-9][0-9]*(\.[0-9]+)?|0+\.[0-9]*[1-9][0-9]*)$">

                </div>
                <div class="field">
                  <label for="registaNome">Nome del Regista...</label>
                  <input type="text" id="registaNome" name="registaNome" required >
                </div>

                <div class="field">
                  <label for="registaCognome">Cognome del Regista...</label>
                  <input type="text" id="registaCognome" name="registaCognome" required >
                </div>

              </div>



              <div class="right">
                <div class="field">
                  <label for="attoreUnoNome">Nome del Protagonista...</label>
                  <input type="text" id="attorueUnoNome" name="attoreUnoNome" required >
                </div>

                <div class="field">
                  <label for="attoreUnoCognome">Cognome del Protagonista...</label>
                  <input type="text" id="attoreUnoCognome" name="attoreUnoCognome" required >
                </div>
                <div class="field">
                  <label for="attoreDueNome"> Inserisci il Nome del Coprotagonista...</label>
                  <input type="text" id="attoreDueNome" name="attoreDueNome" required >
                </div>
                <div class="field">
                  <label for="attoreDueCognome"> Inserisci il Cognome del Coprotagonista...</label>
                  <input type="text" id="attoreDueCognome" name="attoreDueCognome" required >
                </div>
                <div class="field">
                  <label for="attoreTreNome"> Inserisci il Nome dell'Attore Secondario...</label>
                  <input type="text" id="attoreTreNome" name="attoreTreNome" required >
                </div>

                <div class="field">
                  <label for="attoreTreCognome"> Inserisci il Cognome dell'Attore Secondario...</label>
                  <input type="text" id="attoreTreCognome" name="attoreTreCognome" required >
                </div>
              </div>

                 </div>
                 <div class="field">
                    <textarea class="input" placeholder="Inserisci la Trama..." name="trama" required></textarea>
                    </div>

                 <div class="field btn">
                    <input type="submit" value="Inserisci Film">
                 </div>
              </form>
           </div>
        </div>
     </div>
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
       <!--Link to JS-->
  <script src="js/main.js"></script>

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