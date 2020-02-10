package aiello;
//Servlet per la gestione del giardino condiviso
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GiardinoServlet
 */
@WebServlet("/GiardinoServlet")
public class GiardinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Classe Giardino condivisa tra tutti i thread;
	Giardino G1;
	public GiardinoServlet() {
		super();
		G1=new Giardino();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");


		//rispondo alle richieste di tipo get per comunicare lo stato di tutti i giocatori e dell'ultimo messaggio.
		PrintWriter out = response.getWriter();
		int n =G1.nlista();

		out.println( "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" );
		out.println("<giardino>");
		for (int i=0;i<n;i++){
			if(G1.pet[i]!=null){
				out.println("<pet>");
				out.println("<nome>"+G1.pet[i].getNome()+"</nome>");
				out.println("<x>"+G1.pet[i].getPosX()+"</x>");
				out.println("<y>"+G1.pet[i].getPosY()+"</y>");
				out.println("<tipo>"+G1.pet[i].getTipo()+"</tipo>");
				out.println("</pet>");
			}
		}
		out.println("<messaggio><testo>"+G1.getMessaggio()+"</testo><numero>"+G1.getNumMessaggio()+"</numero></messaggio>");

		out.println("</giardino>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		//HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		switch(request.getParameter("Tipo").toString()){
		case "login":

			G1.aggiungi(request.getParameter("Nome").toString(),Integer.parseInt(request.getParameter("TipoPet")));
			G1.aggiungiMessaggio(request.getParameter("Nome")+" è entrato nel giardino.");
			int n =G1.nlista();
			out.println(n);
			break;
		case "evento":

			G1.evento(request.getParameter("Nome"),request.getParameter("Tasto"));
			break;

		case "messaggio":

			G1.aggiungiMessaggio(request.getParameter("Messaggio"));
			break;
		case "logout":


			G1.logout(request.getParameter("Nome").toString());
			G1.aggiungiMessaggio(request.getParameter("Nome")+" è uscito.");
			break;
		default:
			break;
		}
	}

}
