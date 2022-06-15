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
<title>Pagamento</title>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <link rel="stylesheet" href="css/paga.css">
</head>
<body>
<%Prenotazione p = (Prenotazione)request.getAttribute("prenotazione"); 
 Double tot= (Double)request.getAttribute("totale");
 Utente u = (Utente)session.getAttribute("utente");
%>

<div class="container">
<p>il totale per <%=p.getPostiPrenotati() %> posti è di <%=tot %></p>

  <div class="card-container">

      <div class="front">
          <div class="image">
              <img src="reg/chip.png" alt="">
              <img src="reg/visa.png" alt="">
          </div>
          <div class="card-number-box">################</div>
          <div class="flexbox">
              <div class="box">
                  <span>card holder</span>
                  <div class="card-holder-name">full name</div>
              </div>
              <div class="box">
                  <span>expires</span>
                  <div class="expiration">
                      <span class="exp-month">mm</span>
                      <span>/</span>
                      <span class="exp-year">yy</span>
                  </div>
              </div>
          </div>
      </div>

      <div class="back">
          <div class="stripe"></div>
          <div class="box">
              <span>cvv</span>
              <div class="cvv-box"></div>
              <img src="reg/visa.png" alt="">
          </div>
      </div>

  </div>

<div>
	 <form action="paga" method="POST">
      <div class="inputBox">
        <input type="hidden" name="postiPrenotati" value ="<%=p.getPostiPrenotati()%>">
        <input type="hidden" name="id_spettacolo" value ="<%=p.getSpettacolo().getId() %>">
        <input type="hidden" name="id_utente" value="<%=u.getId()%>">
          <input type="text" id="card" name="numeroCarta" maxlength="16" class="card-number-input" required>
          <label  for="card">Numero Carta</label>
      </div>
      <div class="inputBox">
          <input type="text" id="nome"  class="card-holder-input" required >
          <label  for="nome">Nome Carta</label>
      </div>
      <div class="flexbox">
          <div class="inputBox">
              <select name="" id="mese" class="month-input" >
                  <option value="month" selected disabled>--</option>
                  <option value="01">01</option>
                  <option value="02">02</option>
                  <option value="03">03</option>
                  <option value="04">04</option>
                  <option value="05">05</option>
                  <option value="06">06</option>
                  <option value="07">07</option>
                  <option value="08">08</option>
                  <option value="09">09</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
              </select>
              <label  for="mese">mese</label>
          </div>
          <div class="inputBox">
              <select name="" id="anno" class="year-input">
                  <option value="year" selected disabled>--</option>
                  <option value="2021">2021</option>
                  <option value="2022">2022</option>
                  <option value="2023">2023</option>
                  <option value="2024">2024</option>
                  <option value="2025">2025</option>
                  <option value="2026">2026</option>
                  <option value="2027">2027</option>
                  <option value="2028">2028</option>
                  <option value="2029">2029</option>
                  <option value="2030">2030</option>
              </select>
              <label  for="anno">anno</label>
          </div>
          <div class="inputBox">
              <input name ="cvv"type="text" id="cvv" maxlength="4" class="cvv-input" required pattern= "^(0*[1-9][0-9]*(\.[0-9]+)?|0+\.[0-9]*[1-9][0-9]*)$">
              <label  for="cvv">cvv</label>
          </div>
      </div>
      <input type="submit" value="submit" class="submit-btn">
  </form>

</div>    
  </div>

    <script src="js/paga.js"></script>
</body>
</html>