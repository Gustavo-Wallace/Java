import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) throws Exception {
        Scanner texto = new Scanner(System.in);
        int num;
        double db;
        float flt;
        String str;
        char ch;

        System.out.println("Int: ");
        num = texto.nextInt();

        System.out.println("Double: ");
        db = texto.nextDouble();

        System.out.println("Float: ");
        flt = texto.nextFloat();

        System.out.println("Char: ");
        ch = texto.next().charAt(0);

        System.out.println("String: ");
        str = texto.next();

        System.out.println("------------");
        System.out.println("int: "+num);
        System.out.println("double: "+db);
        System.out.println("float: "+flt);
        System.out.println("char: "+ch);
        System.out.println("string: "+str);

        texto.close();
    }
}
