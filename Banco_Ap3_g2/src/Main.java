import java.util.ArrayList;

public class Main {
    public static ArrayList<Conta> contas;

    public static void main(String[] args) {
        int  j = 0;
        int op;
        contas = new ArrayList<Conta>();

        do {
            op = Teclado.lerInt("---Operações----" +
                    "\n 1 - Para add " +
                    "\n 2- Para listar contas " +
                    "\n 3- Saque " +
                    "\n 4- Para Depositar " +
                    "\n 5- Para Transferir" +
                    "\n -------------");
            switch (op) {
                case 1: {
                    Cliente cliente = new Cliente();
                    cliente.ler();
                    Conta conta = new Conta(Teclado.lerString("Digite a senha"), cliente);
                    contas.add(conta);
                    break;
                }
                case 2: {

                    Conta.mostrar();
                    break;
                }
                case 3: {
                    int contaSaque = Teclado.lerInt("Digite a conta");
                    double valor = Teclado.lerDouble("Digite o valor");
                    String senha = Teclado.lerString("Digite a senha");
                    Conta c = Conta.get(contaSaque);
                    if (c != null) {
                        if (c.login(senha)) {
                            if (c.sacar(valor)) {
                                System.out.println("Saque efetuado");
                            } else {
                                System.out.println("Sem saldo");
                            }
                        }

                    } else {
                        System.out.println("Não possui conta!");
                    }
                    break;
                }
                case 4: {
                    int contaDeposito = Teclado.lerInt("Digite a conta");
                    double valor = Teclado.lerDouble("Digite o valor");
                    Conta c = Conta.get(contaDeposito);
                    if (c != null) {
                        if (c.depositar(valor)) {
                            System.out.println("Deposito efeutado");
                        }


                    } else {
                        System.out.println("Conta inexsitent");
                    }
                    break;
                }
                case 5: {
                    int contaSaque = Teclado.lerInt("Digite a conta");
                    double valor = Teclado.lerDouble("Digite o valor");
                    String senha = Teclado.lerString("Digite a senha");
                    Conta contaOrigem = Conta.get(contaSaque);
                    int contaDeposito = Teclado.lerInt("Digite a conta");
                    Conta contaDestino = Conta.get(contaDeposito);
                    if (contaDestino != null && contaOrigem != null) {
                        if (contaOrigem.transferencia(contaDestino, valor)) {
                            System.out.println("transferencia realizada");
                        } else {
                            System.out.println("Erro ao realizar");
                        }
                    }
                }

            }
        } while (j != 59);


    }
}
