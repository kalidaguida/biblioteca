 public final class Passeio extends Veiculo implements Calc {
    private int qtdPassageiros;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    public Passeio(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia, int qtdPassageiros) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia);
        setQtdPassageiros(qtdPassageiros);
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    @Override
    public void printVeiculo() {

        super.printVeiculo();
        System.out.println("Quantidade de passageiros: " + this.qtdPassageiros);
        System.out.println("Velocidade Maxima (M/h) " + String.format("%.3f", this.calcVel(this.getVelocMax())) + " m/h");
        System.out.println("Valor calculado (Interface): " + this.calcular());
        System.out.println("--------------------------------------------------\n");
    }

    @Override
    public float calcVel(float velocMax) {
        float vel = (getVelocMax() * 1000);
        return (vel);
    }

    public int calcular(){
        int somaLetras = 0;
        somaLetras+= getPlaca().length();
        somaLetras+= getMarca().length();
        somaLetras+= getModelo().length();
        somaLetras+= getCor().length();

        return somaLetras;
    }

}
