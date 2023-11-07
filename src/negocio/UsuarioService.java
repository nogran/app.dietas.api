package negocio;

import entidade.Usuario;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UsuarioService {

    private final List<Usuario> usuariosCadastrados;
    private static final String CAMINHO_ARQUIVO = "src/arquivo/usuarios.txt";

    public UsuarioService() throws ParseException {
        this.usuariosCadastrados = new ArrayList<>();
        this.carregarUsuarios();
    }

    private void carregarUsuarios() throws ParseException {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 8) {
                    String nome = partes[0];
                    String email = partes[1];
                    LocalDate dataNascimento = LocalDate.parse(partes[2]);
                    float peso = Float.parseFloat(partes[3]);
                    int altura = Integer.parseInt(partes[4]);
                    String sexo = partes[5];
                    String objetivo = partes[6];
                    float metabolismoBasal = Float.parseFloat(partes[7]);

                    Usuario usuario = new Usuario(nome, email, dataNascimento, peso, altura, sexo, objetivo);
                    usuario.setMetabolismoBasal(metabolismoBasal);

                    // Carregar outros atributos, como diarioAtividades e refeicoes, se necessário.

                    usuariosCadastrados.add(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarUsuario(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Cadastro de Usuário:");
        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("Email: ");
        String email = scanner.next();

        LocalDate dataNascimento = null;
        try {
            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            String dataNascimentoStr = scanner.next();
            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Peso (kg): ");
        float peso = scanner.nextFloat();

        System.out.print("Altura (cm): ");
        int altura = scanner.nextInt();

        System.out.print("Sexo (M/F): ");
        String sexo = scanner.next();

        System.out.print("Objetivo: ");
        String objetivo = scanner.next();

        Usuario novoUsuario = new Usuario(nome, email, dataNascimento, peso, altura, sexo, objetivo);
        try {
            adicionarUsuario(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }

        calcularMetabolismoBasal(novoUsuario.getDataNascimento(), novoUsuario.getSexo(), novoUsuario.getPeso(), novoUsuario.getAltura());
    }

    private void salvarUsuariosEmArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Usuario usuario : usuariosCadastrados) {
                String linha = usuario.getNome() + "," + usuario.getEmail() + "," + sdf.format(usuario.getDataNascimento()) + "," + usuario.getPeso() + "," + usuario.getAltura() + "," + usuario.getSexo() + "," + usuario.getObjetivo();
                writer.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void adicionarUsuario(Usuario usuario) throws Exception {
        if (usuariosCadastrados.stream().anyMatch(u -> u.getEmail().equals(usuario.getEmail()))) {
            throw new Exception("Usuário já cadastrado!");
        }
        usuariosCadastrados.add(usuario);
        salvarUsuariosEmArquivo();
    }

    public void removerUsuario(String emailUsuario) throws Exception {
        boolean removed = usuariosCadastrados.removeIf(u -> u.getEmail().equals(emailUsuario));
        if (!removed) {
            throw new Exception("Usuário não cadastrado, não é possível remover!");
        }
    }

    public void mostrarUsuarios() throws Exception {
        if (usuariosCadastrados.isEmpty()) {
            throw new Exception("Não existem usuários cadastrados.");
        } else {
            for (Usuario usuario : usuariosCadastrados) {
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
                System.out.println("Peso: " + usuario.getPeso() + " kg");
                System.out.println("Altura: " + usuario.getAltura() + " cm");
                System.out.println("Sexo: " + usuario.getSexo());
                System.out.println("Objetivo: " + usuario.getObjetivo());
                System.out.println();
            }
        }
    }

    private float calcularMetabolismoBasal(LocalDate dataNascimento, String sexo, float peso, float altura) {
        int idade = calcularIdade(dataNascimento);

        int coeficiente = 0;
        if (sexo.equals('M')) {
            coeficiente = 5;
        } else if (sexo.equals("F")) {
            coeficiente = -161;
        }
        return (10 * peso) * 6.25F * altura - (5 * idade) + coeficiente;
    }


    private Integer calcularIdade(LocalDate date) {
        Calendar cal = GregorianCalendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR);
        int idade = anoAtual - date.getYear();//Calcula a idade apenas com os anos
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        int mesAtual = cal.get(Calendar.MONTH);

        if (date.getDayOfMonth() >= diaAtual && date.getMonth().getValue() >= mesAtual) {
            idade--;
        }
        return idade;
    }
}
