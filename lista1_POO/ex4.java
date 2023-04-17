import java.util.Random;
import java.util.Scanner;


public class ex4 {
    public static void main(String[] args) throws Exception {
        Scanner ex = new Scanner(System.in);
        int novaRolagem;

        do{
           novaRolagem = 0;
           Random gerador = new Random();
           int numero = gerador.nextInt(6) + 1;
           System.out.println("Numero gerado: " +numero); 

           System.out.println("Deseja ralizar uma nova rolagem? Digite 1 caso sim: ");
           novaRolagem = ex.nextInt();
        }while (novaRolagem == 1);

        ex.close();
    }
}
