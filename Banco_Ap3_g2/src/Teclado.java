import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Teclado {

    public static int lerInt() {
        Scanner sc = new Scanner(System.in);

        return lerInt("Digite um numero");

    }

    public static int lerInt(String msg) {
        String n ;
        boolean i=false;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(msg);
            n=sc.next();
            i= isInt(n);
        }while(i==false);
        return Integer.valueOf(n);
    }

    public static boolean isInt (String v) {

        try {
            Integer.parseInt(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Double lerDouble() {
        Scanner sc = new Scanner(System.in);

        return lerDouble("Digite um numero");

    }

    public static Double lerDouble(String msg) {
        String n ;
        boolean i=false;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(msg);
            n=sc.next();
            i= isDouble(n);
        }while(i==false);
        return Double.valueOf(n);
    }

    public static boolean isDouble (String v) {

        try {
            Double.parseDouble(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Float LerFloat() {
        Scanner sc = new Scanner(System.in);

        return LerFloat("Digite um numero");

    }

    public static Float LerFloat(String msg) {
        String n ;
        boolean i=false;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(msg);
            n=sc.next();
            i= isFloat(n);
        }while(i==false);
        return Float.valueOf(n);
    }

    public static boolean isFloat (String v) {

        try {
            Float.parseFloat(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String lerString (){
        String msg= "Digite uma string";
        return lerString(msg);

    }
    public static String lerString (String msg){
        Scanner sc = new Scanner(System.in);
        String a;
        System.out.println(msg);
        a=sc.next();
        return a;
    }
    public  static  String lerEmail() {
        int validarEmail;
        System.out.println("Digite o email: ");
        Scanner sc = new Scanner(System.in);
        String email = sc.next();
        validarEmail=email.indexOf("@");
        if(validarEmail>0){
            return email;
        }else{
            System.out.println("email invalido");
            return  null;
        }
    }
    public static String validarTelefone() {
        System.out.println("Digite o seu numero: ");
        Scanner sc = new Scanner(System.in);
        String tel = sc.next();
        String formato = "([0-9]{2})[0-9]{4}-[0-9]{4}";

        if((tel == null) || (tel.length()<13) || (tel.matches(formato)))
            return null;

        else
            return tel;
    }
    public static String validarData() {
        System.out.println("Digite a data: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        String formato = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        if((data == null) || (data.length()<10) || (!data.matches(formato)))
            return null;
        else
            return data;
    }
    public  static String formatarData() throws ParseException {
        //Primeiro converte de String para Date
        System.out.println("Digite a data: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");
        Date date = formatUS.parse(data);

//Depois formata data
        DateFormat formatBR = new SimpleDateFormat("dd-mm-yyyy");
        String dateFormated = formatBR.format(date);
        return dateFormated;
    }
    public  static boolean lerNumero(){
        boolean y=false;
        System.out.println("Digite os numeros: ");
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        for(int i=0;i<n.length();i++){
            if(Character.isDigit(n.charAt(i))){
                y= true;
            }
            else{
                System.out.println("Voce deve digitar apenas numeros: ");
                y=false;
                break;
            }
        }
        return y;
    }
}