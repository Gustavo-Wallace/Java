import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) throws Exception {
        Scanner notasAluno = new Scanner(System.in);
        String aluno;
        float n1, n2, n3, n4, media, notaExame, mediaFinal;

        System.out.println("Digite o nome do aluno:");
        aluno = notasAluno.nextLine();

        System.out.println("Digite a nota 1:");
        n1 = notasAluno.nextFloat();

        System.out.println("Digite a nota 2:");
        n2 = notasAluno.nextFloat();

        System.out.println("Digite a nota 3:");
        n3 = notasAluno.nextFloat();
        
        System.out.println("Digite a nota 4:");
        n4 = notasAluno.nextFloat();

        media = (n1*0.2f) + (n2*0.3f) + (n3*0.4f) + (n4*0.1f);

        System.out.println("Aluno: "+aluno);
        System.out.println("Media: "+media);
        if(media >= 7)

            System.out.println("Aluno Aprovado.");

        if(media < 5)

            System.out.println("Aluno Reprovado.");

        else{ System.out.println("Aluno em exame.");

            System.out.println("Digite a nota do exame:");
            notaExame = notasAluno.nextFloat();

            mediaFinal = (media + notaExame) / 2;

            System.out.println("Media final: "+mediaFinal);

            if(mediaFinal >= 5)
            System.out.println("Aluno Aprovado.");
            else System.out.println("Aluno reprovado.");
        }
        
        notasAluno.close();
    }
}
