<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="com.azienda.webapp.entity.Ruolo" %>
<%@page import ="com.azienda.webapp.entity.Utente" %>
  <%@page import ="com.azienda.webapp.entity.Film" %>
<%@page import ="com.azienda.webapp.entity.Spettacolo" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Profilo</title>
 <link rel="shortcut icon" href="reg/FaviconGruppo4.png" type="image/x-icon">
  <!-- Box Icons -->
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'rel='stylesheet'>
  <link rel="stylesheet" href ="css/profiloAdmin.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/deLorean.css">
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
<main class="main">
    <%Utente u =  (Utente)session.getAttribute("utente");
	List<Film> films =(List<Film>)request.getAttribute("listafilm");
	List<Utente> utenti = (List<Utente>)request.getAttribute("utenti");
	try{Boolean aggiunta = (Boolean)request.getAttribute("f");
	%>
	<%if(aggiunta) {%>
	<div class="boxPopup" id="popup">
	 <div id="loader">
        <div id="loader-wrapper">
            <div class="icon iconEnter">
                <!-- SVG illustration + markup has been modified for better manipulation -->
                <svg version="1.1" id="loader-icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                    width="600px" height="240" viewBox="0 0 600 240"
                    style="enable-background:new 0 0 600 240;" xml:space="preserve">
                    
                    <g class="car">
                        <g class="body">
                            <!-- other details: behind body -->
                            <polygon class="stroke-normal stroke-filled" points="357.4,99.2 399.9,74.9 407.1,95.3 406,113.3 402.9,116.8 404.6,129.2 409.8,134.5 408,145.9 403.4,146.1 393.6,151.7"/>
                            <line class="stroke-bold" x1="344.5" y1="95" x2="348.4" y2="79.1"/>
                            
                            <!-- body outline-->
                            <path class="stroke-normal stroke-filled" d="M151.6,166h9.9l-2.4,7.3h143.1l-5-9.5H309h51.4l32.3-9.2c2.9-8.7,5-30.5-1.1-47.5l-89.3-20.7h-69.8 l-55.2,22.3l-81,10.8l-30.9,11.3l-3.2,9.7l-6,6.7l0.8,6.2h7.7l11.3,6.2h24.5L151.6,166z"/>
                            <!-- door -->
                            <polyline class="stroke-normal" points="177.3,108.7 189.8,163.2 256.1,163.2 291.6,121.9 291.6,86.4"/>

                            <!-- back windshield -->
                            <polyline class="stroke-normal"  points="302.4,86.4 302.4,114.5 373.6,114.5 370.1,102.1"/>
                            <polyline class="stroke-light" points="317.1,89.8 317.1,105.1 323.3,114.5"/>
                            <polyline class="stroke-light" points="328.7,92.5 328.7,105.1 334.9,114.5"/>
                            <polyline class="stroke-light" points="339.4,95 339.4,105.1 345.6,114.5"/>

                            <!-- top part -->
                            <line class="stroke-lighter" x1="285.3" y1="82.7" x2="298" y2="82.7"/>
                            <line class="stroke-lighter" x1="292.6" y1="76.6" x2="292.6" y2="82.7"/>
                            <line class="stroke-lighter" x1="283.2" y1="75.9" x2="299.4" y2="77.3"/>

                            <!-- window -->
                            <polygon class="stroke-normal" points="282.3,96.1 282.3,118.1 192.2,120.7 236.8,96.1"/>
                            <polyline class="stroke-normal" points="217.5,120 239.8,106.3 263.7,106.3 270.6,118.4"/>

                            <!-- body stroke -->
                            <line class="stroke-lighter" x1="184.6" y1="140.5" x2="62.2" y2="140.5"/>
                            <line class="stroke-lighter" x1="184.1" y1="138.5" x2="277.3" y2="138.5"/>
                            <line class="stroke-lighter" x1="395.3" y1="140.5" x2="275.5" y2="140.5"/>
                            
                            <!-- other details: on body -->
                            <line class="stroke-lighter" x1="274.6" y1="126.5" x2="274.6" y2="126.5"/>
                            <line class="stroke-normal" x1="253.8" y1="144.5" x2="262.1" y2="144.5"/>
                            <line class="stroke-normal" x1="84.5" y1="147.6" x2="91.1" y2="147.6"/>
                            <line class="stroke-normal" x1="78.1" y1="146.8" x2="78.1" y2="150.7"/>

                            <g class="pole">
                                <line class="stroke-normal" x1="307.9" y1="87.7" x2="365.3" y2="30.3"/>
                                <path class="stroke-lighter" d="M365.3,30.3l4.9-4.9c0.9-0.9,2.4-1,3.4-0.2l1.3,1c1.5,1.3,3.8,1.1,5.1-0.3l6.1-6.5c2.1-2.2,1.9-5.7-0.4-7.7 l-1.7-1.4c-2.5-2.1-6.2-2-8.5,0.2l-0.2,0.2"/>
                            </g>
                        </g>


                        <g class="wheels">
                            <g class="wheel">
                                <circle class="stroke-normal stroke-filled" cx="126.3" cy="160.7" r="25.9"/>
                                <circle class="stroke-normal" cx="126.3" cy="160.5" r="16"/>
                            </g>
                            <g class="wheel">
                                <circle class="stroke-normal stroke-filled" cx="334.8" cy="160.7" r="25.9"/>
                                <circle class="stroke-normal" cx="334.8" cy="160.5" r="16"/>
                            </g>
                        </g>
                    </g>
                    <g class="stripes">
                        <line class="stripe" x1="587.6" y1="168.6" x2="370.7" y2="168.6"/>
                        <line class="stripe" x1="533.3" y1="151.7" x2="443.2" y2="151.7"/>
                        <line class="stripe" x1="450" y1="176.5" x2="359.9" y2="176.5"/>
                        <line class="stripe" x1="472.3" y1="138.5" x2="425" y2="138.5"/>
                    </g>


                    <g class="glows">
                        <!-- alt -->
                        <!-- <path class="glow accent" d="M222.7,61.1c26.6-11.5,47.4-9.6,51.6,7.2c5.6,23-22.4,65.3-62.6,94.4c-37.1,26.8-71.6,33.1-81.2,16"/>
                        <path class="glow accent" d="M136.7,103.3c-7.3-13.4-10.4-25.8-8.2-35c5.6-23,42.9-18.1,83.1,11s68.3,71.4,62.6,94.4 c-4.1,16.8-25,18.7-51.6,7.2"/>
                        <path class="glow accent" d="M146.8,85.4c-4.8-17.4-5.8-32.8-2-43.3c9.5-26.1,45.3-12.5,79.9,30.5s54.8,99.1,45.3,125.2 c-7,19.1-27.8,17-52.1-2.2"/>
                        <path class="glow accent" d="M218,44.4c24.2-19.2,45-21.3,52.1-2.2c9.5,26.1-10.7,82.2-45.3,125.2s-70.4,56.6-79.9,30.5"/> -->


                        <path class="glow accent" d="M42.7,130.4L42.7,130.4L42.7,130.4c0-40,32.4-72.4,72.4-72.4h62.4"/>
                        <path class="glow accent" d="M42.7,130.4L42.7,130.4L42.7,130.4c0-26.6,21.6-48.2,48.2-48.2h14.6"/>
                        <path class="glow accent" d="M42.6,130.5L42.6,130.5L42.6,130.5c0-11.1,9-20.1,20.1-20.1h92.7"/>
                        <path class="glow accent" d="M42.6,130.4L42.6,130.4L42.6,130.4c0,11.1,9,20.1,20.1,20.1h22.7"/>
                        <path class="glow accent" d="M42.7,130.4L42.7,130.4L42.7,130.4c0,40,32.4,72.4,72.4,72.4h82.4"/>
                        <path class="glow accent" d="M42.7,130.4L42.7,130.4L42.7,130.4c0,26.6,21.6,48.2,48.2,48.2h94.6"/>
                        <line class="glow accent" x1="174.5" y1="165.4" x2="297" y2="165.4"/>
                        <line class="glow accent" x1="175.9" y1="193.8" x2="332.8" y2="193.8"/>
                        <line class="glow accent" x1="114.7" y1="66.4" x2="292.5" y2="66.4"/>
                        <line class="glow accent" x1="184.3" y1="119" x2="379.9" y2="119"/>
                    </g>
                </svg>

            <!-- END SVG CODE -->
            </div>


            
	<div class="message">
  <h1>Congratulazioni </h1>
  <p>Il Film è stato aggiunto con successo!
  </div>
            <div class="number">
                0
            </div>
        </div>
        
	
	</div>
    </div>
    <section id="slider-container up-container">
    <div class="wrapper-list">
      
      <h3 class="table-title ">Lista Film</h3>
      <div class="table">
        
        <div class="row header-row">
          <div class="cell">
            Titolo
                        </div>
                        <div class="cell">
                            Durata
                        </div>
                        <div class="cell">
                            Prezzo
                        </div>
                        <div class="cell">
                            Regista
                          </div>
                        <div class="cell">
                            Inserisci Spettacolo
                        </div>
                        <div class="cell">
                          Gestisci Spettacoli
                        </div>
                        <div class="cell">
                          Modifica Film
                        </div>
                        <div class="cell">
                          Rimuovi Film
                        </div>
                    </div>
                    <%for(Film f :films){%>
                    <div class="row">
                      <div class="cell" data-title="Titolo">
                        <%=f.getTitolo() %>
                      </div>
                      <div class="cell" data-title="Durata">
                        <%=f.getDurata() %>
                      </div>
                        <div class="cell" data-title="Prezzo">
                            <%=f.getPrezzo() %>
                        </div>
                        <div class="cell" data-title="Regista">
                           <%= f.getRegista().getCognome()%>
                        </div>
                        <div class="cell" data-title="-">
                            <form action="InserisciSpettacolo" method="GET">
                              <input type="hidden" value="<%=f.getId() %>" name="id_film">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Inserisci Spettacolo">
                            </form>
                        </div>
                        <div class="cell" data-title="-">
                            <form action="ListaSpettacoli" method="GET">
                              <input type="hidden" value="<%=f.getId() %>" name="id_film">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Gestisci Spettacoli">
                            </form>
                          </div>
                          <div class="cell" data-title="-">
                            <form action="ModificaFilm" method="GET">
                                <input type="hidden" value="<%=f.getId() %>" name="id">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Modifica Film">
                            </form>
                        </div>
                        <div class="cell" data-title="-">
                            <form action="RimuoviFilm" method="POST">
                                <input type="hidden" value="<%=f.getId() %>" name="id_rfilm">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Rimuovi Film">
                            </form>
                        </div>
                    </div>
                        <%}%>

                </div>
			</div>
			<div class="wrapper-list">
                <h3 class="table-title">Lista Utenti</h3>
                <div class="table">
                    <div class="row header-row blue">
                      <div class="cell">
                        Nome
                        </div>
                        <div class="cell">
                          Cognome
                        </div>
                        <div class="cell">
                          Email
                        </div>
                        <div class="cell">
                          Ruolo
                        </div>
                     
                        <div class="cell">
                          Modifica Utente
                        </div>
                        <div class="cell">
                            Disabilita/Attiva Utente
                        </div>
                      </div>
                      <%for(Utente p :utenti){%>
                    <div class="row">
                        <div class="cell" data-title="Nome">
                            <%=p.getNome() %>
                        </div>
                        <div class="cell" data-title="Cognome">
                            <%=p.getCognome()%>
                        </div>
                        <div class="cell" data-title="Email">
                            <%=p.getEmail() %>
                        </div>
                        <div class="cell" data-title="Ruolo">
                            <%=p.getRuolo().getRuolo()%>
                          </div>
                           
                        <div class="cell" data-title="Modifica Utente">
                            <form action="ModificaUtente" method="GET">
                                <input type="hidden" value="<%=p.getId() %>" name="id_utente">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Modifica Utente">
                            </form>
                        </div>
                        <div class="cell" data-title="Disabilita/Attiva Utente">
                        <%if(!p.isAbilitato()){ %>
                            <form action="AbilitaDisabilita" method="POST">
                              <input type="hidden" value="<%=p.getId() %>" name="id_utente">
                                <input type="hidden" value=false name="stato">
                                <input style="font-size: 14px" class="btn btn-form1" type="submit" value="Abilita Utente">
                            </form>
                            <%}else{ %> 
                            <form action="AbilitaDisabilita" method="POST">
                              <input type="hidden" value="<%=p.getId() %>" name="id_utente">
                                <input type="hidden" value=true name="stato">
                                <input style="font-size: 14px" class="btn btn-form2" type="submit" value="Disabilita Utente">
                            </form>
                            <%} %>
                        </div>
                      </div>
                    <%}%>

                    </div>
                </div>
        </section>
	<%} 
	}
	catch(NullPointerException e){
		%>	
	

  <section id="slider-container up-container">
    <div class="wrapper-list">
      
      <h3 class="table-title ">Lista Film</h3>
      <div class="table">
        
        <div class="row header-row">
          <div class="cell">
            Titolo
                        </div>
                        <div class="cell">
                            Durata
                        </div>
                        <div class="cell">
                            Prezzo
                        </div>
                        <div class="cell">
                            Regista
                          </div>
                        <div class="cell">
                            Inserisci Spettacolo
                        </div>
                        <div class="cell">
                          Gestisci Spettacoli
                        </div>
                        <div class="cell">
                          Modifica Film
                        </div>
                        <div class="cell">
                        Rimuovi Film
                        </div>
                    </div>
                    <%for(Film f :films){%>
                    <div class="row">
                      <div class="cell" data-title="Titolo">
                        <%=f.getTitolo() %>
                      </div>
                      <div class="cell" data-title="Durata">
                        <%=f.getDurata() %>
                      </div>
                        <div class="cell" data-title="Prezzo">
                            <%=f.getPrezzo() %>
                        </div>
                        <div class="cell" data-title="Regista">
                           <%= f.getRegista().getCognome()%>
                        </div>
                        <div class="cell" data-title="-">
                            <form action="InserisciSpettacolo" method="GET">
                              <input type="hidden" value="<%=f.getId() %>" name="id_film">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Inserisci Spettacolo">
                            </form>
                        </div>
                        <div class="cell" data-title="-">
                            <form action="ListaSpettacoli" method="GET">
                              <input type="hidden" value="<%=f.getId() %>" name="id_film">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Gestisci Spettacoli">
                            </form>
                          </div>
                          <div class="cell" data-title="-">
                            <form action="ModificaFilm" method="GET">
                                <input type="hidden" value="<%=f.getId() %>" name="id">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Modifica Film">
                            </form>
                        </div>
                        <div class="cell" data-title="-">
                            <form action="RimuoviFilm" method="POST">
                                <input type="hidden" value="<%=f.getId() %>" name="id_film">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Rimuovi Film">
                            </form>
                        </div>
                    </div>
                   
                        <%}%>

                </div>
			</div>
			<div class="wrapper-list">
                <h3 class="table-title">Lista Utenti</h3>
                <div class="table">
                    <div class="row header-row blue">
                      <div class="cell">
                        Nome
                        </div>
                        <div class="cell">
                          Cognome
                        </div>
                        <div class="cell">
                          Email
                        </div>
                        <div class="cell">
                          Ruolo
                        </div>
                     
                        <div class="cell">
                          Modifica Utente
                        </div>
                        <div class="cell">
                            Disabilita/Attiva Utente
                        </div>
                      </div>
                      <%for(Utente p :utenti){%>
                    <div class="row">
                        <div class="cell" data-title="Nome">
                            <%=p.getNome() %>
                        </div>
                        <div class="cell" data-title="Cognome">
                            <%=p.getCognome()%>
                        </div>
                        <div class="cell" data-title="Email">
                            <%=p.getEmail() %>
                        </div>
                        <div class="cell" data-title="Ruolo">
                            <%=p.getRuolo().getRuolo()%>
                          </div>
                           
                        <div class="cell" data-title="Modifica Utente">
                            <form action="ModificaUtente" method="GET">
                                <input type="hidden" value="<%=p.getId() %>" name="id_utente">
                                <input style="font-size: 14px" class="btn btn-form" type="submit" value="Modifica Utente">
                            </form>
                        </div>
                        <div class="cell" data-title="Disabilita/Attiva Utente">
                        <%if(!p.isAbilitato()){ %>
                            <form action="AbilitaDisabilita" method="POST">
                              <input type="hidden" value="<%=p.getId() %>" name="id_utente">
                                <input type="hidden" value=false name="stato">
                                <input style="font-size: 14px" class="btn btn-form1" type="submit" value="Abilita Utente">
                            </form>
                            <%}else{ %> 
                            <form action="AbilitaDisabilita" method="POST">
                              <input type="hidden" value="<%=p.getId() %>" name="id_utente">
                                <input type="hidden" value=true name="stato">
                                <input style="font-size: 14px" class="btn btn-form2" type="submit" value="Disabilita Utente">
                            </form>
                            <%} %>
                        </div>
                      </div>
                    <%}}%>

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

  <!--Link to JS-->
  <script src="js/main.js"></script>
  <script > 
  btnClose.addEventListener("click", ()=>{
	  popup.classList.add("hidePopup");
	});
  </script>

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
  <script src="js/deLorean.js"></script>
  <script src="https://kit.fontawesome.com/5a47681717.js" crossorigin="anonymous"></script>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>