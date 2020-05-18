package br.unaerp.DAO;

import br.unaerp.Beans.Jogador;
import br.unaerp.interfaces.JogadorDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAOImple implements JogadorDAO {
    public void insert(Jogador jogador) throws SQLException {
        String novoJogador = "insert into jogador (name , time_id) values (? , ?)";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(novoJogador);
        preparedStatement.setString(1, jogador.getNome());
        preparedStatement.setInt(2, jogador.getTimeId());

        preparedStatement.execute();
    }

    public void delete(String jogadorID) throws SQLException {
        String delJogador = "delete from jogador where id = '" + jogadorID + "'";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(delJogador);
        preparedStatement.execute();
    }

    public void update(Jogador jogador) throws SQLException {
        String updateJogador = "update jogador set name = ? , time_id = ? where id = ?";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(updateJogador);
        preparedStatement.setString(1, jogador.getNome());
        preparedStatement.setInt(2, jogador.getTimeId());
        preparedStatement.setInt(3, jogador.getId());
        preparedStatement.execute();
    }

    public Jogador show(String timeId) throws SQLException {
        return null;
    }

    public List<Jogador> showAll() throws SQLException {
        List<Jogador> listaJogadores = new ArrayList<Jogador>();

        String query = "select * from jogador";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            listaJogadores.add(new Jogador(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("time_id")));
        }

        return listaJogadores;
    }
}
