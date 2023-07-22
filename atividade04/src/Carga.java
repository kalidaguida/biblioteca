 public final class Carga extends Veiculo implements Calc {
     private int tara;
     private int cargaMax;

    public Carga() {
        this.tara = 0;
        this.cargaMax = 0;
    }

    public Carga(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia, int tara, int cargaMax) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia);
        setTara(tara);
        setCargaMax(cargaMax);
    }

     public int getTara() {
         return tara;
     }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setTara(int tara) {
         this.tara = tara;
     }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public void printVeiculo() {
        super.printVeiculo();
        System.out.println("Tara: " + this.tara);
        System.out.println("Carga maxima: " + this.cargaMax + "");
        System.out.println("Velocidade Maxima (Cm/h) " + String.format("%.3f", this.calcVel(this.getVelocMax())) + " cm/h");
        System.out.println("Soma total de numeros (Interface): " + this.calcular());
        System.out.println("--------------------------------------------------\n");
    }

    @Override
    public float calcVel(float velocMax) {
        float vel = (getVelocMax() * 100000);
        return (vel);
    }

    public int calcular(){
        int somaNumero = 0;
        somaNumero+= getMotor().getQtdPist();
        somaNumero+= getMotor().getPotencia();
        somaNumero+= getQtdRodas();
        somaNumero+= getVelocMax();
        somaNumero+= getTara();
        somaNumero+= getCargaMax();

        return somaNumero;
    }

}
