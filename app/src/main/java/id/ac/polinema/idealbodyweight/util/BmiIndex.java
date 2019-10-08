package id.ac.polinema.idealbodyweight.util;

public class BmiIndex {
    private float index;
    private float tinggi;
    private float berat;

    public BmiIndex(float tinggi, float berat) {
        this.index = calculate();
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public float getIndex(){
        return index;
    }

    private float calculate() {
        float bmi = berat / (tinggi * tinggi);
        return bmi;
    }
}
