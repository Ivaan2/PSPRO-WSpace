package Unidad02.HilosSimples;

public class Contador {
    private int c = 0;

    public Contador(int c){
        this.c = c;
    }

    public int getValor() {
        return c;
    }

    public void incrementa(){
        this.c++;
    }

    public void decrementa(){
        this.c--;
    }
}
