<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ringraziamenti</title>
<link rel="stylesheet" href="css/ringraziamenti.css">

  <!-- Fav Icon -->
  <link rel="shortcut icon" href="reg/FaviconGruppo4.png" type="image/x-icon">
</head>
<section class="intro">
  A long time ago, in a galaxy far,<br> far away....
</section>
<section class="logo">
  <img src="reg/logo.png" alt="DevDrawer Star Wars Scroll Screen Mockup">
</section>
<div id="scroller">
  <div id="content">
    <p id="title">Episosio XIV</p>
    <p id="subtitle">La fine di un viaggio</p>
    <br>
    <p>In una galassia lontana lontana, al tempo della festa degli innamorati, iniziava un viaggio. Un gruppo di Jedi a bordo
      della nave spaziale Generation si dirigeva verso il pianeta Projectwork. Durante il viaggio, durato alcuni mesi,
      molte sono state le sfide e le avventure che i nostri eroi si sono trovati ad affrontare, ma
      con la mente sempre salda e fissa sull'obiettivo finale.</p>

    <p>Java, Database, Front-end sono solo alcuni dei nemici affrontati e sconfitti durante il viaggio.
      Siamo quasi giunti al mese del Sole, e i nostri eroi dovranno fronteggiare l'ultima grande sfida, lo sbarco su
      Projectwork e la sua conquista. Riusciranno i nostri eroi a completare tutti i task impartiti dai clienti e ad
      impressionare la grande giuria giunta per l'evento? A voi l'ardua sentenza</p>

    <p style="text-align:center">UN GRAZIE SENTITO A GENERATION ITALY E A TUTTO LO STAFF ELIS PER LA GRANDE OPPORTUNITA' CONCESSA.</p>
    <p id="subtitle">GRAZIE A:</p>
    <div class="allinea">
      <div style="text-align:center ;">

        <p>DAVID PELUSI</p>
        <p>GIULIO RAIMONDI</p>
        <p>ANTONIO GRILLO</p>
        <p>ROBERTO SANTORO</p>
        <p>MASSIMILIANO PUGLIATTI</p>
        <p>OSCAR PASQUALI</p>
        <p>MATTEO LUCCHETTA</p>
        <p>MICHELA MAIONI</p>
        <p>MARIUS MINIA</p>
      </div>
      <div style="text-align:center ;">

        <p>TIZIANO SERRITELLA</p>
        <p>MATIAS ASIS</p>
        <p>VALENTINA TOSTI</p>
        <p>EMILIANA SODANO</p>
        <p>COSTANZA SCIACCALUGA</p>
        <p>CLAUDIA CAPASSO</p>
        <p>YURI PARENTE</p>
        <p>CRISTIANO GALMACCI</p>
        <P>DOMENICO TUOZZI</P>
      </div>
    </div>
  </div>
</div>
<script>
  const stars = 400

for (let i =0; i < stars; i++) {
    let star = document.createElement("div")
    star.className = 'stars'
    var xy = randomPosition();
    star.style.top = xy[0] + 'px'
    star.style.left = xy[1] + 'px'
    document.body.append(star)
}

function randomPosition() {
    var y = window.innerWidth
    var x = window.innerHeight
    var randomX = Math.floor(Math.random() * x)
    var randomY = Math.floor(Math.random() * y)
    return [randomX, randomY]
}
</script>
</body>
</html>