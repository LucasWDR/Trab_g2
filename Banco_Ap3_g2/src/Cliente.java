import java.util.Scanner;
public class Cliente {
        public String nome;
        String CPF;
        public int idade;
        String data;
        double limiteCliente;

        Scanner sc = new Scanner(System.in);

        public void ler() {
            int testeIdade = 0;
            do {
                nome = Teclado.lerString("Digite o nome");
                idade = Teclado.lerInt("Digite a idade");
                if (idade < 16) {
                    do {
                        testeIdade = Teclado.lerInt("Para criar uma conta a idade deve ser maior que 16 anos " +
                                "\nDeseja incerir uma idade maior ou encerrar o programa? 1-inserir novamente 2-Encerrar");

                        if (testeIdade == 2) {
                            System.exit(testeIdade);
                        }
                        if (testeIdade < 0 || testeIdade > 2) {
                            System.out.println("Escolha entre 1 ou 2");
                        }
                    } while (testeIdade < 0 || testeIdade > 2);
                }
            } while (idade < 16 && testeIdade == 1);
            System.out.println("Digite a data de nascimento");
            Data novaData = new Data();
            data = novaData.ler();
            do {
                CPF = Teclado.lerString("Digite cpf");
            }while (!verificar(CPF));

        }
        public boolean verificar(String CPF){
            if(Main.contas.size()==0){
                return true;
            }
            for (int i=0;i<Main.contas.size();i++){
                if(Main.contas.get(i).cliente.CPF.equals(CPF)){
                    return false;
                }
            }
            return true;
        }


        public String mostar() {
            return
                    " Nome='" + nome + '\'' +
                            ", Idade=" + idade +
                            ", " + data + '\'' + ", limite=" + limiteCliente;
        }
    }

