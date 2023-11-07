package negocio;

import entidade.Refeicao;
import entidade.Usuario;
import exception.ErroRefeicaoDuplicadaException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RefeicaoService {

    public void adicionarRefeicao(Refeicao refeicao, Usuario usuario) {
        LocalDate hoje = LocalDate.now();

        // Filtra na lista para achar o diário da data atual
        Refeicao refeicaoAtual = usuario.getRefeicoes().stream()
                .filter(d -> d.getDataRefeicao().isEqual(hoje))
                .findFirst()
                .orElse(null);

        if (refeicaoAtual != null) {
            // Se já existe um Refeicoes para o dia atual, adiciona a refeição a ele
            usuario.getRefeicoes().add(refeicao);
        } else {
            // Se não existe um DiarioRefeicoes para o dia atual, cria um novo
            Refeicao novaRefeicao = new Refeicao();
            novaRefeicao.setDataRefeicao(hoje);
            usuario.getRefeicoes().add(novaRefeicao);
            novaRefeicao.setTotalCalorias(novaRefeicao.getTotalCalorias());
            usuario.getRefeicoes().add(novaRefeicao);
        }
    }


    public List<Refeicao> mostrarRefeicoes(Usuario usuario, LocalDate date) {
        List<Refeicao> refeicoesDoDia = usuario.getRefeicoes().stream()
                .filter(refeicao -> refeicao.getDataRefeicao().isEqual(date))
                .collect(Collectors.toList());

        // Exibe as refeições do dia
        for (Refeicao refeicao : refeicoesDoDia) {
            System.out.println("Tipo da Refeição: " + refeicao.getNome());
            System.out.println("Alimentos: " + refeicao.getAlimentos());
        }
        return refeicoesDoDia;
    }

    public void excluirRefeicao(Refeicao refeicao, Usuario usuario) {
        if (usuario.getRefeicoes() != null && !usuario.getRefeicoes().isEmpty()) {
            usuario.getRefeicoes().remove(refeicao);
            System.out.println("Refeição excluída com sucesso.");
        } else {
            System.out.println("Usuário não possui refeições cadastradas.");
        }
    }

    public Refeicao buscarRefeicoesPorDia(Usuario usuario, LocalDate data) throws Exception {
        List<Refeicao> refeicoesEncontradas = usuario.getRefeicoes().stream()
                .filter(refeicao -> refeicao.getDataRefeicao().isEqual(data))
                .collect(Collectors.toList());

        if (refeicoesEncontradas.size() == 0) {
            System.out.println("Refeicoes nao cadastrada");
        }

        // Exibe as refeições encontradas
        for (Refeicao refeicao : refeicoesEncontradas) {
            System.out.println("Data da Refeição: " + refeicao.getDataRefeicao());
            System.out.println("Tipo da Refeição: " + refeicao.getNome());
            System.out.println("Alimentos: " + refeicao.getAlimentos());
        }

        if (refeicoesEncontradas.size() > 1) {
            throw new Exception("Refeicao duplicada!");
        }

        return refeicoesEncontradas.get(0);
    }
}
