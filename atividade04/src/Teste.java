public class Teste {
    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();

    private static Passeio vetPasseio[] = new Passeio[5];
    private static Carga vetCarga[] = new Carga[5];

    private static Leitura leitura = new Leitura();

    public static void main(String args[]) {

        boolean continua = true;
        int opcao = 0;

        while (continua) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("Sistema de Gestão de Veículos - Menu Inicial");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Cadastrar Veiculo de Passeio");
            System.out.println("2. Cadastrar Veiculo de Carga");
            System.out.println("3. Imprimir Todos os Veiculos de Passeio");
            System.out.println("4. Imprimir Todos os Veiculos de Carga");
            System.out.println("5. Imprimir Veiculo de Passeio pela Placa");
            System.out.println("6. Imprimir Veiculo de Carga pela Placa");
            System.out.println("7. Sair do Sistema");
            System.out.println("--------------------------------------------------");

            try {
                opcao = Integer.parseInt(leitura.entDados("\nEscolha uma opcao: "));
            } catch (NumberFormatException nfe) {
                System.out.println("A opcao informada deve ser um valor inteiro - Pressione <ENTER> para continuar...");
                leitura.entDados("");

                continue;
            }

            switch (opcao) {
                case 1:
                    for (int i = encontraVagoPasseio(); i < vetPasseio.length; i++) {
                        if (i == -1) {
                            leitura.entDados("O limite de cadastro de 5 veiculos de passeio foi atingido! - Pressione <ENTER> para continuar...");
                            break;
                        }

                        passeio = new Passeio();

                        vetPasseio[i] = cadastrarPasseio(passeio);

                        if (vetPasseio[i] != null) {
                            leitura.entDados("\nVeiculo cadastrado! Pressione <ENTER> para continuar...");
                            String respostaPasseio = leitura.entDados("Deseja cadastrar outro veiculo de passeio? <S/N>");
                            if (respostaPasseio.equalsIgnoreCase("n")) {
                                break;
                            }

                        } else {
                            break;
                        }


                        if (encontraVagoPasseio() == -1) {
                            leitura.entDados("O limite de cadastro de 5 veiculos de passeio foi atingido! Pressione <ENTER> para continuar...");
                            break;
                        }
                    }
                    break;

                case 2:
                    for (int i = encontraVagoCarga(); i < vetCarga.length; i++) {
                        if (i == -1) {
                            leitura.entDados("O limite de cadastro de 5 veiculos de passeio foi atingido! - Pressione <ENTER> para continuar...");
                            break;
                        }

                        carga = new Carga();

                        vetCarga[i] = cadastrarCarga(carga);

                        if (vetCarga[i] != null) {
                            leitura.entDados("\nVeiculo cadastrado! Pressione <ENTER> para continuar...");
                            String respostaCarga = leitura.entDados("Deseja cadastrar outro veiculo de carga? <S/N>");
                            if (respostaCarga.equalsIgnoreCase("n")) {
                                break;
                            }

                        } else {
                            break;
                        }


                        if (encontraVagoCarga() == -1) {
                            leitura.entDados("O limite de cadastro de 5 veiculos de passeio foi atingido! Pressione <ENTER> para continuar...");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Impressao de todos os veiculos de passeio");
                    System.out.println("--------------------------------------------------");

                    for (int i = 0; i < vetPasseio.length; i++) {
                        if (vetPasseio[i] != null) {
                            printPasseio(vetPasseio[i]);
                        }

                    }
                    leitura.entDados("Impresso todos os veiculos de passeio cadastrados! Pressione <ENTER> para continuar...");
                    System.out.println("******************************************************************************");
                    break;

                case 4:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Impressao de todos os veiculos de carga");
                    System.out.println("--------------------------------------------------");

                    for (int i = 0; i < vetCarga.length; i++) {
                        if (vetCarga[i] != null) {
                            printCarga(vetCarga[i]);
                        } else {
                            leitura.entDados("Impresso todos os veiculos de carga cadastrados! Pressione <ENTER> para continuar...");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Consulta pela placa - Veiculos de passeio");
                    System.out.println("--------------------------------------------------");

                    passeio = new Passeio();

                    boolean existePlacaPasseio = false;

                    String placaPasseio = leitura.entDados("Informe a placa a ser pesquisada: ");

                    passeio.setPlaca(placaPasseio);

                    for (int i = 0; i < vetPasseio.length; i++) {
                        if (vetPasseio[i] != null && vetPasseio[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                            printPasseio(vetPasseio[i]);
                            existePlacaPasseio = true;
                            leitura.entDados("\nPressione <ENTER> para continuar...");
                        }
                    }
                    if (!existePlacaPasseio) {
                        leitura.entDados("\nNão existe veiculo de passeio cadastrado com esta placa. Pressione <ENTER> para continuar...");
                    }
                    break;

                case 6:
                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Consulta pela placa - Veiculos de carga");
                    System.out.println("--------------------------------------------------");

                    carga = new Carga();

                    boolean existePlacaCarga = false;

                    String placaCarga = leitura.entDados("Informe a placa a ser pesquisada: ");

                    carga.setPlaca(placaCarga);

                    for (int i = 0; i < vetCarga.length; i++) {
                        if (vetCarga[i] != null && vetCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                            printCarga(vetCarga[i]);
                            existePlacaCarga = true;
                            leitura.entDados("\nPressione <ENTER> para continuar...");
                        }
                    }
                    if (!existePlacaCarga) {
                        leitura.entDados("Não existe veiculo de carga cadastrado com esta placa. Pressione <ENTER> para continuar...");
                    }
                    break;

                case 7:
                    continua = false;
                    break;

                default:
                    leitura.entDados("\nO valor deve ser de 1 a 7. Pressione <ENTER> para continuar...");
                    break;

            }
        }

    }

    public static int encontraVagoPasseio() {
        for (int i = 0; i < vetPasseio.length; i++) {
            if (vetPasseio[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int encontraVagoCarga() {
        for (int i = 0; i < vetCarga.length; i++) {
            if (vetCarga[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static Passeio cadastrarPasseio(Passeio passeio) {

        System.out.println("\n--------------------------------------------------");
        System.out.println("Cadastro de Veiculos de Passeio");
        System.out.println("--------------------------------------------------");
        System.out.println("\nInsira os dados solicitados abaixo");

        passeio.setPlaca(leitura.entDados("Placa: "));

        if (validaPlaca(passeio.getPlaca())) {
            passeio.setMarca(leitura.entDados("Marca: "));
            passeio.setModelo(leitura.entDados("Modelo: "));
            passeio.setCor(leitura.entDados("Cor: "));
            passeio.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de rodas: ")));
            passeio.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade Maxima: ")));
            passeio.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistoes do motor: ")));
            passeio.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potencia do motor: ")));
            passeio.setQtdPassageiros(Integer.parseInt(leitura.entDados("Quantidade de Passageiros: ")));

            return passeio;
        }
        return null;
    }

    public static Carga cadastrarCarga(Carga carga) {

        System.out.println("\n--------------------------------------------------");
        System.out.println("Cadastro de Veiculos de Carga");
        System.out.println("--------------------------------------------------");
        System.out.println("\nInsira os dados solicitados abaixo");

        carga.setPlaca(leitura.entDados("Placa: "));

        if (validaPlaca(carga.getPlaca())) {
            carga.setMarca(leitura.entDados("Marca: "));
            carga.setModelo(leitura.entDados("Modelo: "));
            carga.setCor(leitura.entDados("Cor: "));
            carga.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de rodas: ")));
            carga.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade Maxima: ")));
            carga.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistoes do motor: ")));
            carga.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potencia do motor: ")));
            carga.setTara(Integer.parseInt(leitura.entDados("Tara: ")));
            carga.setCargaMax(Integer.parseInt(leitura.entDados("Carga Maxima: ")));

            return carga;
        }
        return null;
    }

    public static void printPasseio(Passeio passeio) {
        passeio.printVeiculo();
    }

    public static void printCarga(Carga carga) {
        carga.printVeiculo();
    }
    public static boolean validaPlaca(String placa) {
        boolean permitido = true;
        for (int i = 0; i < vetPasseio.length; i++) {
            if (vetPasseio[i] != null && vetPasseio[i].getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("\n************************** ATENCAO ****************************");
                System.out.println("Ja existe um veiculo (passeio) cadastrado com a placa " + placa + "!");
                System.out.println("***************************************************************");
                permitido = false;
                break;
            }
        }
        for (int x = 0; x < vetCarga.length; x++) {
            if (vetCarga[x] != null && vetCarga[x].getPlaca().equalsIgnoreCase(placa)){

                System.out.println("\n************************** ATENCAO ****************************");
                System.out.println("Ja existe um veiculo (carga) cadastrado com a placa " + placa + "!");
                System.out.println("***************************************************************");
                permitido = false;
                break;

            }
        }
        return permitido;
    }
}



