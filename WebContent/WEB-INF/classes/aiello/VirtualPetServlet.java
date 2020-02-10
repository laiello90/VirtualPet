package aiello;
/*Servlet principale che smista al database le varie richieste
tramite la classe VirtualPet che contiene le query e le altre classi
utilizzate per rappresentare gli oggetti.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VirtualPetServlet
 */
@WebServlet("/VirtualPetServlet")
public class VirtualPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VirtualPetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//inutilizzato
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//ogni richeista viene smistata tramite il primo parametro (Tipo) con uno switch
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		VirtualPet petManager=new VirtualPet();
		switch(request.getParameter("Tipo").toString()){
		case "login":	//Login

			Utente u=petManager.Login(request.getParameter("Username").toString(), request.getParameter("Password").toString());
			out.print("{\"id\":"+u.getId() +",\"nome\":\""+ u.getNome() +"\",\"punti\":"+ u.getPunti() +"}");
			break;
		case "listapet": //ottengo una lista di 5 elementi per utente (pet o null per gli spazi vuoti)
			Pet[] pet=petManager.getPet(Integer.parseInt(request.getParameter("UserId")));
			out.print("{\"listapet\":[");
			int pieno=0;
			for(int i=0;i<4;i++){
				if (pet[i].getNome()!="null"){
					if (pieno==1) out.print(",");
					pieno=1;
					out.print("{\"id\":"+pet[i].getId()+",\"nome\":\""+pet[i].getNome()+"\",\"tipo\":"+pet[i].getTipo()+",\"p1\":"+pet[i].getP1()+",\"p2\":"+pet[i].getP2()+",\"p3\":"+pet[i].getP3()+",\"p4\":"+pet[i].getP4()+"}");
				} else {pieno=0;}
			}
			if (pet[4].getNome()!="null"){
				if (pieno==1) out.print(",");
				out.print("{\"id\":"+pet[4].getId()+",\"nome\":\""+pet[4].getNome()+"\",\"tipo\":"+pet[4].getTipo()+",\"p1\":"+pet[4].getP1()+",\"p2\":"+pet[4].getP2()+",\"p3\":"+pet[4].getP3()+",\"p4\":"+pet[4].getP4()+"}");
			}
			out.print(" ] }");
			break;
		case "nuovopet": //creo un nuovo pet sul db
			petManager.nuovoPet(request.getParameter("Nome"),Integer.parseInt(request.getParameter("UserId")),Integer.parseInt(request.getParameter("TipoPet")));
			break;
		case "eliminapet": //elimino un pet dal db
			petManager.eliminaPet(Integer.parseInt(request.getParameter("IdPet")));
			break;
		case "aggiornapunti": //commit dei punti dell'utente sul db
			petManager.aggiornaPunti(Integer.parseInt(request.getParameter("IdUtente")),Integer.parseInt(request.getParameter("Punti")));
			break;

		case "aggiornapet": //eseguo il commit sul db dei parametri del pet
			petManager.aggiornaPet(Integer.parseInt(request.getParameter("IdPet")), Integer.parseInt(request.getParameter("P1")), Integer.parseInt(request.getParameter("P2")), Integer.parseInt(request.getParameter("P3")), Integer.parseInt(request.getParameter("P4")));
			break;
		case "listastrumenti": //lista degli strumenti presenti nel database (JSON)
			Strumento[] strumenti = petManager.getStrumenti();
			out.print("{\"listastrumenti\":[");
			for (int i=0;i<strumenti.length;i++)
				if(i==strumenti.length-1)
					out.print("{\"id\":"+strumenti[i].getId()+",\"nome\":\""+strumenti[i].getNome()+"\",\"prezzo\":"+strumenti[i].getPrezzo()+",\"p1\":"+strumenti[i].getP1()+",\"p2\":"+strumenti[i].getP2()+",\"p3\":"+strumenti[i].getP3()+",\"p4\":"+strumenti[i].getP4()+"}");
				else
					out.print("{\"id\":"+strumenti[i].getId()+",\"nome\":\""+strumenti[i].getNome()+"\",\"prezzo\":"+strumenti[i].getPrezzo()+",\"p1\":"+strumenti[i].getP1()+",\"p2\":"+strumenti[i].getP2()+",\"p3\":"+strumenti[i].getP3()+",\"p4\":"+strumenti[i].getP4()+"},");

			out.print(" ] }");

			break;
		case "listaacquisti": //lista degli acquisti effettuati (JSON)
			Acquisto[] acquisti = petManager.getAcquisti(Integer.parseInt(request.getParameter("IdUtente")));
			out.print("{\"listaacquisti\":[");
			for (int i=0;i<acquisti.length;i++)
				if(i==(acquisti.length-1))
					out.print("{\"idutente\":"+acquisti[i].getIdUtente()+",\"idstrumento\":"+acquisti[i].getIdStrumento()+"}");
				else
					out.print("{\"idutente\":"+acquisti[i].getIdUtente()+",\"idstrumento\":"+acquisti[i].getIdStrumento()+"},");

			out.print(" ] }");
			break;

		case "acquistastrumento": //eseguo il commit sul db per l'acquisto dello strumento
			petManager.acquistaStrumento(Integer.parseInt(request.getParameter("IdUtente")), Integer.parseInt(request.getParameter("IdStrumento")));
			break;

		default:
			//out.println("null");
		};
	}
}
