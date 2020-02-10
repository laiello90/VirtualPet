package aiello;
//classe strumento: set e get
public class Strumento {

private int id;
private int prezzo;
private String nome;
private int p1;
private int p2;
private int p3;
private int p4;

public Strumento(){
	id=0; prezzo=0; nome="null"; p1=0; p2=0; p3=0; p4=0;
}

public Strumento(int i,String n,int t, int a, int b, int c, int d){
	id=i; prezzo=t; nome=n; p1=a; p2=b; p3=c; p4=d;
}

public void setId(int i){
	id=i;
}

public void setPrezzo(int t){
	prezzo=t;
}

public void setNome(String n){
	nome=n;
}

public void setParametri(int a, int b, int c,int d){
	p1=a; p2=b; p3=c; p4=d;
}

public int getId(){
	return id;
}

public int getPrezzo(){
	return prezzo;
}

public String getNome(){
	return nome;
}

public int getP1(){
	return p1;
}

public int getP2(){
	return p2;
}


public int getP3(){
	return p3;
}


public int getP4(){
	return p4;
}


	
}
