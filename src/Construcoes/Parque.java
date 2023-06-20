package Construcoes;

public abstract class Parque implements Construcao{

    private int fatorFelic;
    private int precoAmpliarAtual;
    private static int contadorID;
    private final int ID;
    private int coordX;
    private int coordY;
    private final String PathImag;

    public Parque(int fatorFelic, int precoAmpliarAtual, int coordX, int coordY, String pathImag) {

        this.fatorFelic = fatorFelic;
        this.precoAmpliarAtual = precoAmpliarAtual;
        this.ID = contadorID;
        contadorID += 1;
        this.coordX = coordX;
        this.coordY = coordY;
        PathImag = pathImag;
    }


    //getters
    public int getFatorFelic() {
        return fatorFelic;
    }

    public int getPrecoAmpliarAtual() {
        return precoAmpliarAtual;
    }

    public int getID(){
        return this.ID;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String getPathImag() {
        return PathImag;
    }


    //setters
    public void setFatorFelic(int capacidadePop) {
        this.fatorFelic = capacidadePop;
    }

    public void setPrecoAmpliarAtual(int precoAmpliarAtual) {
        this.precoAmpliarAtual = precoAmpliarAtual;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }


}
