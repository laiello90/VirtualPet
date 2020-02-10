package aiello;
//classe pet: set e get
public class Pet {
private int id;
private int tipo;
private String nome;
private int p1;
private int p2;
private int p3;
private int p4;

public Pet(){
	id=0; tipo=0; nome="null"; p1=0; p2=0; p3=0; p4=0;
}

public Pet(int i,int t,String n, int a, int b, int c, int d){
	id=i; tipo=t; nome=n; p1=a; p2=b; p3=c; p4=d;
}

public void setId(int i){
	id=i;
}

public void setTipo(int t){
	tipo=t;
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

public int getTipo(){
	return tipo;
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
