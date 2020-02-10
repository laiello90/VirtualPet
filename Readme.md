# Virtual Pet
Repository per la tesina del corso di Architetture e progetto di sistemi web.

Luca Aiello <br/> Matricola: 0648193

Descrizione: Realizzazione di un applicazione web per la creazione e la gestione di un pet virtuale con log-in utenti, creazione di pet multipli (fino a 5 per utente), acquisto e utilizzo di strumenti per il proprio pet mediante l’utilizzo di punti, un minigioco per guadagnare i punti per acquistare gli strumenti, un area comune multi giocatore corredata di chat per fare interagire tra loro gli utenti connessi. (Progetto individuale)\
Linguaggi utilizzati: Front-end: HTML, CSS, JAVASCRIPT, Back-end: JAVA e Servlet JAVA, SQL\
Software utilizzati: Eclipse IDE, Tomcat, MySQL, MySQL Workbench
<br/>
!["Screenshot"](/screens/Screen.jpg)
<br/>
INSTALLAZIONE:

1. Inserire il file "virtualpet.war" nella cartella "webapps" di Tomcat.
2. Inserire la libreria mysql-connector-java-5.1.20-bin nella directory "lib" di Tomcat.
3. Importare il modello dei dati in MySQL dal file "virtalpet.sql" (N.B. nella classe DataSource.java è impostata la seguente password predefinita per l'accesso a MySQL: Username: root / Password: root), per modificarla, modificare le linee 7 e 8 della classe in questione)
4. Tramite browser collegarsi a http://localhost:8080/aiello/virtualpet.html per effettuare il login. (Account predefinito: user1 / Password: user1)

Ciascun utente dovrà avere la possibilità di effettuare login e quindi poter creare, selezionare o eliminare virtual pet dal proprio account. I virtual pet vengono gestiti dall'utente in base ad alcuni parametri (es. Salute, Morale, Sonno, Fame) tramite alcune funzioni base e strumenti (ovvero funzioni aggiuntive) acquistabili dall'utente con dei punti (valuta) memorizzati nel proprio account. Il pet può partecipare individualmente a un minigioco. Inoltre è presente un area multiutente comune dove i giocatori che vi accedono potranno muovere il loro virtual pet, in uno spazio 2D, visualizzare i virtual pet degli altri utenti presenti nell'area comune e comunicare tra di loro tramite una semplice chat testuale.

CARATTERISTICHE ARCHITETTURALI\
\
Per la realizzazione dell’applicazione web si è fatto uso:
1.	Classi Java servlet per la gestione di richieste http ed elaborare le risposte da inviare ai client.
2.	Classi Java tradizionali di supporto alle classi Java servlet per la gestione del gioco e dell'area comune multiutente al fine di distribuire in maniera ottimale il codice server-side.
3.	XML per il trasporto delle risposte del server ai client.
4.	HTML, CSS E JavaScript per la gestione dell'interfaccia utente per la parte front-end.
5.	HTML Canvas per gestire la parte grafica, relativa al virtual pet, dell'interfaccia utente nel client.
6.	Apache Tomcat, per il deployment e l'esecuzione del server.
7.	JDBC e Database MySQL per memorizzare i dati degli utenti.

REQUISITI FUNZIONALI\
\
L’applicazione web in generale:
1.	Dovrà presentare un interfaccia per il login dell'utente.
2.	Effettuato il login, l'utente potrà creare, selezionare o eliminare un virtual pet dal proprio account.
3.	Gestire il proprio pet selezionato dalla vista precedente, tramite funzioni predefinite (strumenti) e monitorare lo stato del proprio pet secondo alcuni parametri (es. fame, salute... sono identificati da numeri interi) e alcuni minigiochi.
4.	Avere la possibilità di interagire graficamente con altri giocatori, tramite un area comune dove l'utente potrà muovere il proprio pet e visualizzare i pet in tempo reale di qualunque giocatore che si trovi nell'area comune, inoltre è prevista una semplice chat di gruppo nello stesso ambito.


Funzionalità lato client:\
Pagina HTML singola che permette all'utente di:
1.	Effettuare Login.<br/>
!["Login"](/screens/Login.jpg)

2.	Creare un nuovo pet, selezionarne uno già esistente, eliminare i propri pet dall'account.<br/>
!["Menù Principale"](/screens/PetMain.jpg)

3.	Gestire e crescere il pet selezionato.
!["Gestione"](/screens/Gestione.jpg)

4.	Far partecipare il pet correntemente selezionato, ad un minigioco per guadagnare punti da utilizzare per acquistare nuovi strumenti.\
!["Minigioco"](/screens/Minigioco.jpg)

5. Acquistare strumenti nuovi con effetti differenti sul pet.\
!["Strumenti"](/screens/acquisto.jpg)

6.	Fare entrare il pet correntemente selezionato nell'area comune dove sarà possibile muovere il proprio pet, visualizzare i pet degli altri utenti nella stessa area e usufruire di una semplice chat testuale.<br/>
!["Giardino"](/screens/Testchat1.jpg)
<br/><br/>
  
Funzionalità lato server:
1.	Gestire le richieste dei client tramite due classi servlet: una per la gestione di ciascun giocatore per le proprie attività individuali, l'altra per la gestione dell'area comune e la relativa chat. Separate al fine di evitare l'appesantimento di una singola servlet.
2.	Sono inoltre state implementate alcune classi tradizionali Java che vengono istanziate dalle servlet.
3.	JDBC per la connessione al database su MySQL per memorizzare i dati e i progressi degli utenti.

MODELLO DEI DATI\
\
Per la web application è stata utilizzata una piccola base di dati su MySQL con il seguente schema.\
UTENTI:(id, username, password, punti)\
PET:(Id_pet, id_utente, tipo_pet 1, nome, parametri)\
STRUMENTI:(Id_strumento, nome, prezzo, parametri)\
ACQUISTI:(Id_giocatore, id_strumento)\
\
!["Modello dei dati"](/screens/dati.png)
