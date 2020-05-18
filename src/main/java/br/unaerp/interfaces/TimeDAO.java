package br.unaerp.interfaces;

import br.unaerp.Beans.Time;

import java.sql.SQLException;
import java.util.List;

public interface TimeDAO {
    // Insere um novo time
    void insert(Time time) throws SQLException;

    // Deleta um time a partir de um ID
    void delete(String timeId) throws SQLException;

    // Atualiza um time
    void update(Time time) throws SQLException;

    // Exibe informacoes sobre um time
    Time show(String timeId) throws SQLException;

    // Exibe todos times
    List<Time> showAll() throws SQLException;
}
