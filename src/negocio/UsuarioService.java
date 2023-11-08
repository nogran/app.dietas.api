package negocio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entidade.Usuario;
import enums.ObjetivoEnum;
import exception.ErroConverterEntidadeException;
import exception.ErroConverterJsonException;
import exception.ErroLeituraArquivoException;
import exception.ErroSalvarArquivoException;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UsuarioService {

    private final List<Usuario> usuariosCadastrados;
    private static final String CAMINHO_ARQUIVO = "src/arquivo/usuarios.txt";

    public UsuarioService() throws ParseException {
        List<Usuario> usuariosCadastrados1;
        usuariosCadastrados1 = carregarUsuarios();
        this.usuariosCadastrados = usuariosCadastrados1;
    }

    private static List<Usuario> carregarUsuarios() throws ParseException {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Usuario usuario = parseJsonParaUsuario(linha);
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
        } catch (Exception e) {
            throw new ErroLeituraArquivoException("usuario.txt", e);
        }
        return usuarios;
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

        System.out.print("Objetivo (" + Arrays.toString(ObjetivoEnum.values()) + "): ");
        String objetivo = scanner.next();

        ObjetivoEnum objetivoEnum = ObjetivoEnum.getTipo(objetivo);

        Usuario novoUsuario = new Usuario(nome, email, dataNascimento, peso, altura, sexo, objetivoEnum);
        novoUsuario.setRefeicoes(new ArrayList<>());
        novoUsuario.setDiarioExercicios(new ArrayList<>());
        try {
            adicionarUsuario(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
            System.out.println();
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
        var metabolismo = calcularMetabolismoBasal(novoUsuario.getDataNascimento(), novoUsuario.getSexo(), novoUsuario.getPeso(), novoUsuario.getAltura());
        novoUsuario.setMetabolismoBasal(metabolismo);
    }

    public void removerUsuario(Scanner scanner) throws Exception {
        mostrarUsuarios();
        System.out.println("Digite o email do usuário para remover: ");
        String emailUsuario = scanner.next();
        Usuario usuarioRemovido = null;
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getEmail().equals(emailUsuario)) {
                usuarioRemovido = usuario;
                break;
            }
        }
        if (usuarioRemovido == null) {
            System.out.println("Usuário não cadastrado, não é possível remover!");
            return;
        }
        usuariosCadastrados.remove(usuarioRemovido);
        salvarUsuariosEmArquivo();
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

    public Usuario entrarComUsuario(String email) {
        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getEmail().equals(email)) {
                usuarioEncontrado = usuario;
            }
        }
        return usuarioEncontrado;
    }

    private static Usuario parseJsonParaUsuario(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(json, Usuario.class);
        } catch (Exception e) {
            throw new ErroConverterJsonException("usuario.txt", e);
        }
    }

    private void adicionarUsuario(Usuario usuario) throws Exception {
        if (usuariosCadastrados.stream().anyMatch(u -> u.getEmail().equals(usuario.getEmail()))) {
            throw new Exception("Usuário já cadastrado!");
        }
        usuariosCadastrados.add(usuario);
        salvarUsuariosEmArquivo();
    }

    private void salvarUsuariosEmArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Usuario usuario : usuariosCadastrados) {
                String json = converterUsuarioParaJson(usuario);
                writer.println(json);
            }
        } catch (Exception e) {
            throw new ErroSalvarArquivoException("usuario.txt", e);
        }
    }

    public void salvarUsuariosEmArquivo(Usuario usuario) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Usuario i : usuariosCadastrados) {
                String json = converterUsuarioParaJson(usuario);
                writer.println(json);
            }
        } catch (Exception e) {
            throw new ErroSalvarArquivoException("usuario.txt", e);
        }
    }

    private String converterUsuarioParaJson(Usuario usuario) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.writeValueAsString(usuario);
        } catch (Exception e) {
            throw new ErroConverterEntidadeException("Usuario", e);
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
