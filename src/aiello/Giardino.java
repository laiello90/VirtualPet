package aiello;
//classe per il giardino.
//contiene l'elenco degli utenti connessi,
//la loro posizione e l'ultimo messaggio inviato.
//il funzionamento della chat si basa sul seguente meccanismo:
//ogni messaggio viene numerato e rispedito con ogni risposta get a tutti i client
//I client tengono traccia del numero dell'ultimo messaggio ricevuto.
//se il numero del messaggio che arriva con la get è superiore a quello in memoria nel client
//allora il messaggio viene letto.


public class Giardino {
public PetGiardino[] pet=new PetGiardino[100];
private int npet=0;
private String messaggio="";
private int numeromessaggio=0;

public Giardino(){
	for(int i=0;i<100;i++)
		pet[i]=null;
	npet=0;
	numeromessaggio=0;
	messaggio="";
}

public String getMessaggio(){
	return messaggio;
}

public int getNumMessaggio(){
	return numeromessaggio;
}

public void aggiungiMessaggio(String a){
	messaggio=a;
	numeromessaggio++;
	}

public void aggiungi(String n,int t){
	npet++;
	for(int i=0;i<100;i++)
		if(pet[i]==null){
			pet[i]=new PetGiardino(n,t);npet++;break;}
}

public int nlista(){
return npet;
}

public String[] lista(){

	String[] listapet=new String[npet];
	for(int l=0;l<100;l++)
		if(pet[l]!=null){
		listapet[l]=pet[l].getNome();
		}
	return listapet;
	}
public int[] listatipi(){
	int[] listatipi=new int[npet];
	for(int l=0;l<100;l++)
		if(pet[l]!=null){
		listatipi[l]=pet[l].getTipo();
		}
	return listatipi;
	
}

//faccio muovere il pet in base al tasto premuto dall'utente
public void evento(String nome, String evento){
	int npet=0;
	for(int i=0;i<100;i++)
		if(pet[i]!=null)
		if(pet[i].getNome().equals(nome)){
			npet=i;break;}
	switch(evento) {
	case "37": if(pet[npet].getPosX()>40)pet[npet].setPosX(pet[npet].getPosX()-20);break;
	case "38":if(pet[npet].getPosY()>140)pet[npet].setPosY(pet[npet].getPosY()-20);break;
	case "39":if(pet[npet].getPosX()<700)pet[npet].setPosX(pet[npet].getPosX()+20);break;
	case "40":if(pet[npet].getPosY()<500)pet[npet].setPosY(pet[npet].getPosY()+20);break;
	default: break;
	}
	

}
public void logout(String nome){
	for(int i=0;i<100;i++)
		if(pet[i]!=null)
		if(pet[i].getNome().equals(nome)){
			
	pet[i]=null;
	npet--;break;}
}


}
