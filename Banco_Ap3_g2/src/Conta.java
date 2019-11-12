import java.util.ArrayList;

public class Conta {

    private int nConta;
    private String senha;
    private double saldo;
    private double limite;
    public Cliente cliente;
    public static int gerarNumero = 1;

    boolean vf = true, tf = true;
    int j = 0;


    public Conta(int nConta) {
        this.nConta = nConta;
    }


    public Conta() {
    }

    public Conta(String senha, Cliente cliente) {
        if (cliente.idade < 18) {
            this.limite = 100;
        }
        if (cliente.idade > 60) {
            this.limite = 1000;
        }
        if (cliente.idade >= 18 && cliente.idade <= 60) {
            this.limite = 300;
        }
        this.cliente = cliente;
        this.nConta = gerarNumero++;
        this.senha = senha;
    }


    public static Conta get(int n) {
        Conta c = new Conta(n);
        if (Main.contas.contains(c)) {
            int posicao = Main.contas.indexOf(c);
            return Main.contas.get(posicao);
        } else {
            return null;
        }
    }

    public boolean login(String senhaInformada) {
        if (this.senha.equals(senhaInformada)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean depositar(Double valor) {
        this.saldo = saldo + valor;
        return true;
    }


    public boolean sacar(double valor) {

        if (this.saldo + this.limite > valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }

    }

    public void verSaldo(ArrayList<Conta> contas) {


        String u = Teclado.lerString("Digite a senha");
        j = 0;
        do {
            if (u.equals(contas.get(j).senha))
                System.out.println(contas.get(j).saldo);
            else {
                System.out.println("Senha incorreta");
            }
            j++;
        } while (j < contas.size() - 1);
    }

    public boolean transferencia(Conta contaDestino, Double valor) {

        if (this.sacar(valor)) {
            return contaDestino.depositar(valor);
        } else {
            return false;
        }

    }

    public void verExtrato(ArrayList<Conta> contas) {

        String pass = Teclado.lerString("Digite a senha");
        j = 0;
        do {
            if (pass.equals(contas.get(j).senha)) {
                System.out.println(" " + contas.get(j).cliente + " Saldo= " + contas.get(j).saldo);
            } else {
                System.out.println("Senha incorreta");
            }
            j++;
        } while (j < contas.size() - 1);
    }

    public static void mostrar() {
        for (int j = 0; j < Main.contas.size(); j++) {
            System.out.println(" Numero da conta =" + Main.contas.get(j).nConta +
                    " saldo= " + Main.contas.get(j).saldo);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta that = (Conta) o;
        return nConta == that.nConta;
    }


    public void remover(ArrayList<Conta> contas) {

        int u = Teclado.lerInt("Digite o númeor da conta que deseja remover");
        Conta contaRemove = new Conta(u);
        contas.remove(u);
    }
}

