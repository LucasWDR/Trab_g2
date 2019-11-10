import java.util.Scanner;

public class Utils {

    public static Scanner tc  =new Scanner(System.in);

    public static int valid_num(String palavras){
        boolean valida=false;
        int num=0;
        while(valida !=true){
            System.out.println(palavras);
            try{
                num= Integer.parseInt(tc.next());
                return (num);
            }catch(NumberFormatException e){
                System.out.println("Digite apenas numeros!!");
                valida=false;
            }
        }
        return (num);
    }
    public static String lerTelefone() {
       String tel;
       boolean valid;
       int valor;
       do{
           valor=valid_num("Telefone:");
           tel= Integer.toString(valor);
           valid =tel.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d");
           if(valid){
               return (tel);
           }
           else{
               System.out.println("telefone está incorreto!!");
               valid=false;
           }

       }while(valid==false);
       return null;
    }

    public static String lerEmail(){
        String email;
        boolean valid;
        do{
            System.out.println("o Email:");
            email=tc.next();
            valid=email.matches(".*@.*");
            if(valid){
                return (email);
            }
            else{
                System.out.println("o Email esta incorreto !!");
                valid=false;
            }
        }while(valid==false);

        return null;
    }
}
