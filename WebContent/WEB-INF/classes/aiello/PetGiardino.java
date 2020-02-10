package aiello;
//classe per i pet del giardino
//avrei potuto fare una "extend" della classe pet normale
//tuttavia non volevo riportare dati superflui quali i parametri del pet.
public class PetGiardino {
private String Nome;
private int x;
private int y;
private int tipo;
public PetGiardino(){
	Nome="";
	x=400;y=300;
	tipo=0;
}

public PetGiardino(String nome,int t){
	Nome=nome;
	x=400;y=300;
	tipo=t;
}

public int getTipo(){
	return tipo;
}

public void setTipo(int t){
	tipo=t;
}
public int getPosX(){
	return x;
}
public int getPosY(){
	return y;
}
public String getNome(){
	return Nome;
}
public void setNome(String a){
	Nome=a;	
}

public void setPosX(int nx){
	x=nx;
}
public void setPosY(int ny){
	y=ny;
}

}
