package aiello;
//classe utente: set e get
import java.sql.*;

public class Utente {
private int id;
private String nome;
private int punti;

public Utente(int i,String n,int p){
	id=i;
	nome=n;
	punti =p;
}

public int getId(){
	return id;
}

public String getNome(){
	return nome;
	}

public int getPunti(){
	return punti;
}

public void setPunti(int p){
	punti=p;
}

public void aggiungiPunti(int p){
	punti=punti+p;
}

public void rimuoviPunti(int p){
	punti=punti-p;
}

public void aggiornaDatabase(){
	

	try {
		DataSource data= new DataSource();
		Connection connessione = data.getConnection();
		String sql="update utenti set punti=? where id=?";
		PreparedStatement query = connessione.prepareStatement(sql);
		query.setInt(0, punti);
		query.setInt(1,id);
		query.executeQuery();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
