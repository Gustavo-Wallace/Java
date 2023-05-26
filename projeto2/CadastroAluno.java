package projeto2;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAluno {
    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        boolean continua = true;
        
        while (continua) {
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int opcao = input.nextInt();
            
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    
    public static void cadastrarAluno() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o nome do aluno: ");
        String nome = input.nextLine();
        
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = input.nextLine();
        
        Aluno aluno = new Aluno(nome, matricula);
        listaAlunos.add(aluno);
        
        System.out.println("Aluno cadastrado com sucesso!");
    }
    
    public static void listarAlunos() {
        if (listaAlunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : listaAlunos) {
                System.out.println("Nome: " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
            }
        }
    }
}