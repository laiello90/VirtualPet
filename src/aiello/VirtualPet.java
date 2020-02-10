package aiello;
//Classe Java che interfaccia la servlet di gestione del pet con il database.
import java.sql.*;

public class VirtualPet {
	public Strumento[] getStrumenti(){
		try {
			
			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="select * from strumenti";
			Statement query = connessione.prepareStatement(sql);
			ResultSet risultato=query.executeQuery(sql);
			int i=0;
			while (risultato.next()){
			i++;
			}
			risultato.beforeFirst();
			Strumento[] strumenti=new Strumento[i];
		int j=0;
			while (risultato.next()){
		
					strumenti[j]=new Strumento(risultato.getInt(1),risultato.getString(2),risultato.getInt(3),risultato.getInt(4),risultato.getInt(5),risultato.getInt(6),risultato.getInt(7));
			j++;
			}
			connessione.close();
			return strumenti;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Acquisto[] getAcquisti(int idutente){
		try {

			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="select * from acquisti where idutente = ?";
			PreparedStatement query = connessione.prepareStatement(sql);
			query.setInt(1, idutente);

			ResultSet risultato=query.executeQuery();
			int i=0;
			while (risultato.next()){
				i++;
			}
			risultato.beforeFirst();
			Acquisto[] acquisti=new Acquisto[i];
			int j=0;
			while (risultato.next()){
			
					acquisti[j]=new Acquisto(risultato.getInt(1),risultato.getInt(2));
			j++;
			}
			connessione.close();
			return acquisti;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void acquistaStrumento(int idutente,int idstrumento){
		try{
			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="insert into acquisti(idutente,idstrumento) values (?,?)";
			PreparedStatement query = connessione.prepareStatement(sql);
			query.setInt(1,idutente);
			query.setInt(2,idstrumento);
			query.executeUpdate();
			connessione.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void aggiornaPet(int idpet,int p1,int p2,int p3,int p4){
		try{
			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="update pet set p1 =?,p2=?,p3=?,p4=? where idpet = ?";
			PreparedStatement query = connessione.prepareStatement(sql);
			query.setInt(1,p1);
			query.setInt(2,p2);
			query.setInt(3,p3);
			query.setInt(4, p4);
			query.setInt(5,idpet);
			query.executeUpdate();
			connessione.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void aggiornaPunti(int idutente,int punti){
		try{
			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="update utenti set punti =? where id = ?";
			PreparedStatement query = connessione.prepareStatement(sql);
			query.setInt(1,punti);
			query.setInt(2,idutente);
			query.executeUpdate();
			connessione.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void eliminaPet(int idpet){
		try{
			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="delete from pet where idpet=?";
			PreparedStatement query = connessione.prepareStatement(sql);
			query.setInt(1,idpet);
			query.executeUpdate();
			connessione.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void nuovoPet(String nome, int tipo,int idutente){
		try{
			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="insert into pet(idutente,tipo_pet,nome,P1,P2,P3,P4) values(?,?,?,50,50,50,50)";
			PreparedStatement query = connessione.prepareStatement(sql);
			query.setInt(1,tipo);
			query.setInt(2,idutente);
			query.setString(3,nome);
			query.executeUpdate();
			connessione.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public Utente Login(String username, String password){
			Utente utente;
		try {
		
			DataSource data= new DataSource();
			Connection connessione= data.getConnection();
			String sql="select * from utenti where username = ? AND password = ?";
			PreparedStatement query = connessione.prepareStatement(sql);
			query.setString(1, username);
			query.setString(2,password);
			ResultSet risultato=query.executeQuery();
			while (risultato.next()){
			utente=new Utente(risultato.getInt(1),risultato.getString(2),risultato.getInt(4));
			
				return utente;
			}
			utente=new Utente(0,"Null",0);
			connessione.close();
			return utente;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			utente=new Utente(0,"Null",0);
			return utente;
		}
		}
	
	public Pet[] getPet(int id){
	try {
	
		DataSource data= new DataSource();
		Connection connessione= data.getConnection();
		String sql="select * from pet where idutente = ?";
		PreparedStatement query = connessione.prepareStatement(sql);
		query.setInt(1, id);
		
		ResultSet risultato=query.executeQuery();
		Pet[] petutente=new Pet[5];
		for (int i =0;i<5;i++)
			petutente[i]=new Pet();
		int i=0;
		while (risultato.next()){
		
			petutente[i]=new Pet(risultato.getInt(1),risultato.getInt(3),risultato.getString(4),risultato.getInt(5),risultato.getInt(6),risultato.getInt(7),risultato.getInt(8));
			i++;
		
		}
		connessione.close();
		return petutente;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}
}
