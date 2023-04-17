import java.util.Scanner;

public class ex2 {
    public static void main(String[] args){
        Scanner dia = new Scanner(System.in);
        int diaSemana;

        System.out.println("Digite o dia da semana(numero): ");
        diaSemana = dia.nextInt();

        switch(diaSemana){
            case 1:
            System.out.println("Domingo");
            break;
            case 2:
            System.out.println("Segunda-feira");
            break;
            case 3:
            System.out.println("Terça-feira");
            break;
            case 4:
            System.out.println("Quarta-feira");
            break;
            case 5:
            System.out.println("Quinta-feira");
            break;
            case 6:
            System.out.println("Sexta-feira");
            break;
            case 7:
            System.out.println("Sabado");
            break;
            default:
            System.out.println("Dia inexistente");
        }
        dia.close();
    }
}