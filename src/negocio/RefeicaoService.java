package negocio;

import entidade.Refeicao;
import entidade.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RefeicaoService {

    public void adicionarRefeicao(Refeicao refeicao, Usuario usuario) {
        LocalDate hoje = LocalDate.now();

        // Filtra na lista para achar o diário da data atual
        Refeicao refeicaoAtual = usuario.getRefeicoes().stream()
                .filter(d -> d.getLocalDate().isEqual(hoje))
                .findFirst()
                .orElse(null);

        if (refeicaoAtual != null) {
            // Se já existe um Refeicoes para o dia atual, adiciona a refeição a ele
            usuario.getRefeicoes().add(refeicao);
        } else {
            // Se não existe um DiarioRefeicoes para o dia atual, cria um novo
            Refeicao novaRefeicao = new Refeicao();
            novaRefeicao.setLocalDate(hoje);
            usuario.getRefeicoes().add(novaRefeicao);
            novaRefeicao.setTotalCalorias(novaRefeicao.getTotalCalorias());
            usuario.getRefeicoes().add(novaRefeicao);
        }
    }

    public List<Refeicao> mostrarRefeicoes(Usuario usuario) {
        System.out.println(usuario.getRefeicoes());
        return usuario.getRefeicoes();
    }

    public List<Refeicao> mostrarRefeicoes(Usuario usuario, LocalDate date) {
        List<Refeicao> refeicoesDoDia = usuario.getRefeicoes().stream()
                .filter(refeicao -> refeicao.getLocalDate().isEqual(date))
                .collect(Collectors.toList());

        // Exibe as refeições do dia
        for (Refeicao refeicao : refeicoesDoDia) {
            System.out.println("Tipo da Refeição: " + refeicao.getTipo());
            System.out.println("Alimentos: " + refeicao.getAlimentos());
        }
        return refeicoesDoDia;
    }
}
