import entidade.*;
import enums.TipoRefeicaoEnum;
import exception.ErroRefeicaoDuplicadaException;
import negocio.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppDietas {

    private static Usuario usuarioLogado = null;
    private static UsuarioService usuarioService;

    static {
        try {
            usuarioService = new UsuarioService();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public AppDietas() throws ParseException {
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema");

        boolean sair = false;
        while (!sair) {
            imprimirMenuUsuarioPrincipal();
            var index = scanner.nextInt();

            switch (index) {
                case 1:
                    usuarioService.cadastrarUsuario(scanner);
                    break;
                case 2:
                    System.out.print("Digite o e-mail do usuário ou digite 'V' para voltar: ");
                    scanner.nextLine();
                    var input = scanner.nextLine();
                    if (input.equalsIgnoreCase("V")) {
                        System.out.println();
                        break;
                    }
                    usuarioLogado = usuarioService.entrarComUsuario(input);
                    if (usuarioLogado != null) {
                        System.out.println("Usuário encontrado. Bem-vindo, " + usuarioLogado.getNome() + "!");
                        System.out.println();
                        mostrarOpcoesUsuarioLogado(scanner);
                    } else {
                        System.out.println("Usuário não encontrado. Verifique o e-mail e tente novamente.");
                        System.out.println();
                    }
                    break;
                case 3:
                    usuarioService.mostrarUsuarios();
                    if (desejaSair(scanner)) {
                        System.out.println("Saindo do sistema.");
                        return;
                    }
                    break;
                case 4:
                    usuarioService.removerUsuario(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void mostrarOpcoesUsuarioLogado(Scanner scanner) throws Exception {
        boolean sair = false; // Variável para controlar o retorno ao menu anterior

        while (!sair) {
            imprimirMenuUsuarioLogado();
            var opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    mostrarOpcoesMenuAtividades(scanner);
                    break;
                case 2:
                    mostrarOpcoesMenuAlimento(scanner);
                    break;
                case 3:
                    mostrarOpcoesMenuExercicios(scanner);
                    break;
                case 4:
                    mostrarOpcoesMenuRefeicao(scanner);
                    break;
                case 5:
                    sair = true;
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        }
    }

    private static void mostrarOpcoesMenuAtividades(Scanner scanner) throws Exception {
        AtividadeService atividadeService = new AtividadeService();
        boolean sair = false; // Variável para controlar o retorno ao menu anterior
        while (!sair) {
            imprimirMenuDeAtividade();
            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da Atividade: ");
                    var nomeNovaAtividade = scanner.nextLine();

                    System.out.println("Digite o MET da Atividade: ");
                    var metNovaAtividade = scanner.nextFloat();

                    try {
                        atividadeService.criarAtividade(nomeNovaAtividade, metNovaAtividade);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome da Atividade: ");
                    var removerAtividade = scanner.nextLine();
                    atividadeService.removerAtividade(removerAtividade);
                    break;
                case 3:
                    atividadeService.listarAtividades();
                    System.out.println();
                    break;

                case 4:
                    sair = true;
                    System.out.println("Saindo do sistema.");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void mostrarOpcoesMenuExercicios(Scanner scanner) throws Exception {
        DiarioExercicioService diarioExercicioService = new DiarioExercicioService();
        ExercicioService exercicioService = new ExercicioService();
        AtividadeService atividadeService = new AtividadeService();
        boolean sair = false; // Variável para controlar o retorno ao menu anterior
        while (!sair) {
            imprimirMenuDeExercicio();
            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    diarioExercicioService.mostrarResumoDeExercicios(usuarioLogado);
                    break;
                case 2:

                    System.out.println("Digite o tempo do exercicio em minutos: ");
                    var tempo = scanner.nextInt();

                    Exercicio exercicio = new Exercicio();
                    exercicio.setTempo(tempo);

                    atividadeService.listarAtividades();

                    var nome = scanner.nextLine();
                    Atividade atividade = atividadeService.buscarAtividadePorNome(nome);
                    exercicio.setAtividade(atividade);

                    var gastoCaloricoDoExercicio = exercicioService.calcularGastoCalorico(atividade.getMet(), usuarioLogado.getPeso(), tempo);
                    exercicio.setCaloria(gastoCaloricoDoExercicio);

                    diarioExercicioService.adicionarExercicio(usuarioLogado, exercicio);
                    break;
                case 3:
//                    diarioExercicioService.removerExercicio(usuarioLogado, exercicio);
                    break;
                case 4:
                    diarioExercicioService.listarDiarioExercicios(usuarioLogado);
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    sair = true;
                    System.out.println();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void mostrarOpcoesMenuAlimento(Scanner scanner) throws Exception {
        AlimentoService alimentoService = new AlimentoService();
        boolean sair = false; // Variável para controlar o retorno ao menu anterior
        while (!sair) {
            imprimirMenuDeAlimento();
            var opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha deixada pela leitura do número

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do Alimento: ");
                    var nome = scanner.nextLine();

                    System.out.println("Digite o peso do Alimento: ");
                    var quantidade = scanner.nextFloat();

                    System.out.println("Digite a quantidade de carboidrato do Alimento: ");
                    var carboidrato = scanner.nextFloat();

                    System.out.println("Digite a quantidade de proteina do Alimento: ");
                    var proteina = scanner.nextFloat();

                    System.out.println("Digite a quantidade de gordura do Alimento: ");
                    var gordura = scanner.nextFloat();

                    Alimento alimento = new Alimento(nome, quantidade, carboidrato, proteina, gordura);
                    alimentoService.adicionarAlimento(alimento);
                    break;
                case 2:
                    System.out.println("Digite o nome do alimento: ");
                    var alimentoDeletar = scanner.nextLine();
                    alimentoService.removerAlimento(alimentoDeletar);
                    break;
                case 3:
                    alimentoService.mostrarAlimentos();
                    break;
                case 4:
                    sair = true;
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void mostrarOpcoesMenuRefeicao(Scanner scanner) throws Exception {
        RefeicaoService refeicaoService = new RefeicaoService();
        AlimentoService alimentoService = new AlimentoService();
        boolean sair = false; // Variável para controlar o retorno ao menu anterior
        while (!sair) {
            imprimirMenuDeRefeicao();
            var opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha deixada pela leitura do número

            switch (opcao) {
                case 1:
                    refeicaoService.mostrarRefeicoes(usuarioLogado, LocalDate.now());
                    break;
                case 2:
                    Refeicao refeicao = new Refeicao();
                    System.out.println("Digite o nome da refeicao " + Arrays.stream(TipoRefeicaoEnum.values()).toList() + ":");
                    var tipoRefeicao = scanner.nextLine();

                    TipoRefeicaoEnum tipoRefeicaoEnum = null;

                    try {
                        tipoRefeicaoEnum = TipoRefeicaoEnum.valueOf(tipoRefeicao);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo de refeição inválido. Opções válidas são: " + Arrays.toString(TipoRefeicaoEnum.values()));
                    }

                    if (tipoRefeicaoEnum != null) {
                        refeicao.setNome(tipoRefeicaoEnum.getTipo());
                        Integer saida = 0;
                        alimentoService.mostrarAlimentos();
                        List<Alimento> alimentos = new ArrayList<>();
                        while (saida != 2) {

                            System.out.println("Digite o nome do alimento(um de cada vez): ");
                            var nomeAlimento = scanner.nextLine();
                            Alimento alimento = alimentoService.buscarAlimentoPeloNome(nomeAlimento);
                            alimentos.add(alimento);

                            System.out.println("Digite 1 para continuar e 2 para sair");
                            saida = scanner.nextInt();
                            scanner.nextLine();
                        }
                        refeicao.setAlimentos(alimentos);
                        refeicao.setNome(tipoRefeicao);
                        refeicao.setDataRefeicao(LocalDate.now());
                        refeicaoService.adicionarRefeicao(refeicao, usuarioLogado);
                    }
                    break;
                case 3:
                    Refeicao refeicao1 = null;
                    try {
                        refeicao1 = refeicaoService.buscarRefeicoesPorDia(usuarioLogado, LocalDate.now());
                        refeicaoService.buscarRefeicoesPorDia(usuarioLogado, LocalDate.now());
                    } catch (ErroRefeicaoDuplicadaException e) {
                        refeicaoService.excluirRefeicao(refeicao1, usuarioLogado);
                    }
                    break;
                case 4:
                    sair = true;
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void imprimirMenuUsuarioPrincipal() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- Criar novo usuário");
        System.out.println("2- Entrar com usuário já cadastrado");
        System.out.println("3- Listar usuários cadastrados");
        System.out.println("4- Remover usuário");
        System.out.println("5- Sair");
    }

    private static void imprimirMenuUsuarioLogado() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- Atividade");
        System.out.println("2- Alimento");
        System.out.println("3- Exercicio");
        System.out.println("4- Refeicao");
        System.out.println("5- Sair");
    }


    private static void imprimirMenuDeAtividade() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- Criar Atividade");
        System.out.println("2- Remover Atividade");
        System.out.println("3- Listar Atividades");
        System.out.println("4- Sair");
    }

    private static void imprimirMenuDeAlimento() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- Criar Alimento");
        System.out.println("2- Remover Alimento");
        System.out.println("3- Listar Alimentos");
        System.out.println("4- Sair");
    }

    private static void imprimirMenuDeExercicio() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- Mostrar Resumo de Exercicios realizados hoje");
        System.out.println("2- Adicionar Exercicio");
        System.out.println("3- Remover Exercicio");
        System.out.println("4- Listar Exercicios");
        System.out.println("5- Sair");
    }

    private static void imprimirMenuDeRefeicao() {
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- Listar Refeicoes realizados hoje");
        System.out.println("2- Adicionar Refeicao");
        System.out.println("3- Remover Refeicao");
        System.out.println("4- Sair");
    }

    private static boolean desejaSair(Scanner scanner) {
        System.out.println("Deseja sair? (S para sair, qualquer outra tecla para continuar)");
        String resposta = scanner.next();
        return resposta.equalsIgnoreCase("S");
    }
}