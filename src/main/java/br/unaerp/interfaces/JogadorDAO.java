package br.unaerp.interfaces;

import br.unaerp.Beans.Jogador;
import br.unaerp.Beans.Time;

import java.sql.SQLException;
import java.util.List;

public interface JogadorDAO {
    // Insere um novo jogador
    void insert(Jogador jogador) throws SQLException;

    // Deleta um jogador a partir de um ID
    void delete(String timeId) throws SQLException;

    // Atualiza um jogador
    void update(Jogador jogador) throws SQLException;

    // Exibe informacoes sobre um jogador
    Jogador show(String timeId) throws SQLException;

    // Exibe todos jogadores
    List<Jogador> showAll() throws SQLException;
}
