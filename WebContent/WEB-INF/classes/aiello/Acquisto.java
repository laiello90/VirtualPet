package aiello;
//classe acquisto: set e get
public class Acquisto {
private int idutente;
private int idstrumento;

public Acquisto(){
	idutente=0;
	idstrumento=0;
}

public Acquisto(int utente,int strumento){
	idutente=utente;
	idstrumento=strumento;
}

public void setIdUtente(int id){
	idutente=id;
}

public void setIdStrumento(int id){
	idstrumento=id;
}

public int getIdUtente(){
	return idutente;
}

public int getIdStrumento(){
	return idstrumento;
}

}