package view;

import entities.Atleta;
import entities.Pessoa;
import entities.Treinador;
import entities.Treino;
import enums.PerfilUsuario;
import exception.DataNascimentoException;
import exception.DataTreinoisBeforeException;
import services.GerenciadoTreinador;
import services.GerenciadorAtleta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorAtleta gerenciadorAtleta = new GerenciadorAtleta();
        GerenciadoTreinador gerenciadoTreinador = new GerenciadoTreinador();

        try {
            while (true){
                System.out.println("1.Cadastro");
                System.out.println("2.Prescrever Treino");
                System.out.println("3.Prescrever Treino");
                System.out.println("4.");
                int n = sc.nextInt();
                sc.nextLine();
                switch (n){
                    case 1:
                        System.out.println("Name: ");
                        String nameA = sc.nextLine();
                        System.out.println("email: ");
                        String emailA = sc.nextLine();
                        System.out.println("dataNascimento: ");
                        LocalDate dataA = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.println("perfil: ");
                        PerfilUsuario perfilUsuario = PerfilUsuario.valueOf(sc.nextLine().toUpperCase());
                        if(PerfilUsuario.ATLETA.equals(perfilUsuario)){
                            System.out.println("peso: ");
                            double peso = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("altura: ");
                            double altura = sc.nextDouble();
                            sc.nextLine();
                            Atleta novoAtleta = new Atleta(nameA,emailA,dataA, perfilUsuario, peso, altura);
                            gerenciadorAtleta.addAtleta(novoAtleta);
                            break;
                        }
                        Treinador novoTreinador = new Treinador(nameA,emailA,dataA,perfilUsuario);
                        gerenciadoTreinador.addTreinador(novoTreinador);
                        break;

                    case 2:
                        System.out.println("Coloque seus dados treinador:");
                        System.out.println("Email: ");
                        String emailT = sc.nextLine();
                        Treinador pesquisaTreiandor;
                        if( gerenciadoTreinador.procurarTreinador(emailT) != null){
                            pesquisaTreiandor = gerenciadoTreinador.procurarTreinador(emailT);
                            System.out.println("Bem vindo " + pesquisaTreiandor.getName() );
                        }else{
                           return;
                        }
                        System.out.println("Ajude a localizar o atleta: ");
                        System.out.println("Email: ");
                        String emailP = sc.nextLine();
                        Atleta pesquisaAtleta;

                       if(gerenciadorAtleta.procurarAtleta(emailP) != null){
                           pesquisaAtleta = gerenciadorAtleta.procurarAtleta(emailP);
                       }else{
                           return;
                       }
                       System.out.println("Cração do Treino");
                       
                       


                    case 3:
                    case 4:
                }

            }
        } catch (DataNascimentoException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (DateTimeParseException e){
            System.out.println("Error: insira uma data Valida");
        }
        catch (DataTreinoisBeforeException e){
            System.out.println(e.getMessage());
        }

    }
}