import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tc=new Scanner(System.in);
        Lista list =new Lista();
        Metodos metodos= new Metodos();

        int resp;

        do{
            System.out.println("--------Operaçoes-------");
            System.out.println("1 - Incluir no final");
            System.out.println("2 - Incluir no início");
            System.out.println("3 - Incluir após um nome");
            System.out.println("4 - Consultar por nome");
            System.out.println("5 - Excluir do início");
            System.out.println("6 - Excluir do fim");
            System.out.println("7 - Excluir por código");
            System.out.println("8 - Listar todos os registros");
            System.out.println("9 - Listar com médias finais ");
            System.out.println("10 - Sair");
            System.out.println("-------------------------");
            resp = tc.nextInt();

            switch (resp){
                case 1:
                    metodos.adc_direita(list);
                    break;
                case 2:
                    metodos.adc_esquerda(list);
                    break;
                case 3:
                    metodos.adc_apos_nome(list);
                    break;
                case 4:
                    metodos.consulta_Nome(list);
                    break;
                case 5:
                    metodos.Excluir_Esquerda(list);
                    break;
                case 6:
                    metodos.ExcluiDireita(list);
                    break;
                case 7:
                    metodos.Excluir_por_codigo(list);
                case 8:
                    metodos.listar_Registro(list);
                    break;
                case 9:
                    metodos.listar_mediasfinais(list);
                    break;
                case 10:
                    System.out.println("Sistema Encerrado!");
                    break;

            }

        }while (resp !=10);
    }
}
