/**
 *
 * @author ALUNO
 */

//LEMBRETE: Sempre cadaster um usuário ao entrar no código
//Você começará com a conta carregada com 4 reais

import java.util.ArrayList;
import java.util.Scanner;
import SISTEMA.Pessoa;
import SISTEMA.Conta;

public class Sistema_do_Banco {
    
    private static String nome, email, escolha;
    private static Long telefone, cpf;
    private static int data, senha;
    private static char sexo;
    private static ArrayList<Conta> contasBancarias;
    private static ArrayList<Pessoa> pessoas;
    
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        pessoas = new ArrayList<Pessoa>();
        telaDeLogin();

    }
    
    public static void telaDeLogin() {
        boolean controlador = true;
        do {
        Scanner sc = new Scanner (System.in);
        System.out.println("");
        System.out.println("\t \t Seja bem vindo ao BANCO AURORA");
        System.out.println("");
        
        System.out.println("Para começar:");
        System.out.println("| Digite 1 para realizar login \t  |");
        System.out.println("| Digite 2 para cadastrar usuário |");
        System.out.println("| Digite 3 para sair do sistema   |");
        System.out.println("");
        System.out.print("Digite a opção escolhida: ");
        int opcao = sc.nextByte();
        
        switch (opcao) {
            case 1 -> { 
                realizarLogin();
                controlador = false;
                }
            case 2 -> { 
                cadastrarUsuario();
                controlador = false;
                }
            case 3 -> {    
                System.out.print("Você saiu do sistema!");
                controlador = false;
                }
            default -> { 
                System.out.println("Opção inválida! Tente novamente escolhendo uma das duas opções!");
                System.out.println("");
                System.out.println("");
                }
        }
        } while (controlador == true);
    }
    
    public static void realizarLogin(){ 
        Scanner sc = new Scanner (System.in);
        boolean validar = false;
        
        while (validar != true) {
        System.out.println("");
        System.out.println(" \t \t Área de login");
        System.out.println("");
        
        System.out.print("Digite seu email: ");
        String verificarEmail = sc.next();
        System.out.print("Digite sua senha: ");
        int verificarSenha = sc.nextInt();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.login(verificarEmail, verificarSenha)) {
                System.out.println("Login bem-sucedido para " + pessoa.getNome());
                 validar = true;
                break;
            } else {
                System.out.println("CPF ou senha inválidos! Tente novamente");
            }
        }
        }
        telaPrincipal();
    }

    
    public static void cadastrarUsuario() {
        
        Scanner sc = new Scanner (System.in);
        System.out.println("");
        System.out.println(" \t \t Área de Cadastro");
        System.out.println("");
        
        System.out.print("Digite seu nome completo: ");
        nome = sc.nextLine();
        
        System.out.print("Digite seu email: ");
        email = sc.nextLine();
        
        System.out.print("Digite seu telefone (EX: (xx) xxxxx-xxxx - somente números): ");
        telefone = sc.nextLong();
        
        System.out.print("Digite sua data de nascimento (dd/mm/aaaa - somente números): ");
        data = sc.nextInt();
        
        System.out.print("Digite seu sexo (M - masculino; F - feminino; O - outro): ");
        sexo = sc.next().charAt(0);
        
        System.out.print("Digite seu CPF: ");
        cpf = sc.nextLong();
        
        System.out.print("Crie uma senha (6 números): ");
        senha = sc.nextInt();

        Pessoa cliente = new Pessoa (nome, email, telefone, data, sexo, cpf, senha);
        pessoas.add(cliente);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");
        System.out.println("");
        
        realizarLogin();
        
    }
    
    public static void telaPrincipal() {
        boolean controlador = true;
        do {
        Scanner sc = new Scanner (System.in);
        System.out.println("");
        System.out.println("\t \t TELA PRINCIPAL");
        System.out.println("Olá, " +nome+ ". Vamos começar! ");
        
        System.out.println("| Digite 1 para consultar saldo\t\t|");
        System.out.println("| Digite 2 para fazer depósito\t \t|");
        System.out.println("| Digite 3 para realizar saque\t\t|");
        System.out.println("| Digite 4 para apagar sua conta\t|");
        System.out.println("| Digite 5 para fazer transação\t\t|");
        System.out.println("| Digite 6 para sair do sistema\t\t|");
        System.out.println("");
        
        System.out.print("Digite a opção escolhida: ");
        int opcao = sc.nextByte();
        
        switch (opcao) {
            case 1 -> {
                consultarSaldo(contasBancarias.get(0));
            }
            case 2 -> {
                fazerDeposito(contasBancarias.get(0));
            }
            case 3 -> {
                fazerSaque(contasBancarias.get(0));
            }
            case 4 -> {
                apagarConta();
            }
            case 5 -> {
                fazerTransacao(contasBancarias.get(0));
            }
            case 6 -> {
                System.out.println("");
                System.out.println("Você deslogou do sistema!");
                controlador = false;
            }
            default -> {
                System.out.println("Opção inválida! Selecione uma existente!");
            }
        }
        
        } while (controlador == true);
        
    }

    public static void consultarSaldo(Conta conta) {
        System.out.println("Saldo atual da conta: R$ " + conta.getSaldo());
    }
    
    public static void fazerDeposito(Conta conta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual valor deseja depositar? ");
        Double valorDeposito = sc.nextDouble();

        conta.depositar(valorDeposito);       
    }
    
    public static void fazerSaque(Conta conta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual valor deseja sacar? ");
        Double valorSaque = sc.nextDouble();

        conta.sacar(valorSaque);
                
    }
    
    public static void apagarConta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tem certeza que quer apagar sua conta? (S - sim N - não)");
        escolha = sc.nextLine();

        if (escolha.equalsIgnoreCase("s")) {
            contasBancarias.clear();
            System.out.println("Você apagou sua conta.");
            System.exit(0);
        } else if (escolha.equalsIgnoreCase("n")) {
            System.out.println("Você não cancelou as contas!");
        } else {
        System.out.println("Opção inválida.");
        }
    }

    public static void fazerTransacao(Conta conta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número da conta do destinatário: ");
        int numeroContaDestinatario = sc.nextInt();
        System.out.println("Valor da transferência: ");
        Double valor = sc.nextDouble();

        conta.transferencia(valor);
    }

}
