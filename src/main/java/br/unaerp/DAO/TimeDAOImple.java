package br.unaerp.DAO;

import br.unaerp.Beans.Time;
import br.unaerp.interfaces.TimeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAOImple implements TimeDAO {

    public void insert(Time time) throws SQLException {
        String novoTime = "insert into time (name) values (?)";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(novoTime);
        preparedStatement.setString(1, time.getNome());

        preparedStatement.execute();
    }

    public void delete(String timeId) throws SQLException {
        String delTime = "delete from time where id = '" + timeId + "'";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(delTime);
        preparedStatement.execute();
    }

    public void update(Time time) throws SQLException {
        String updateJogador = "update time set name = ? where id = ?";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(updateJogador);
        preparedStatement.setString(1, time.getNome());
        preparedStatement.setInt(2, time.getId());
        preparedStatement.execute();
    }

    public Time show(String timeId) throws SQLException {
        return null;
    }

    public List<Time> showAll() throws SQLException {
        List<Time> listaDeTimes = new ArrayList<Time>();

        String query = "select * from time";

        PreparedStatement preparedStatement = ConnectionFactory.getInstance().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            listaDeTimes.add(new Time(resultSet.getInt("id"), resultSet.getString("name")));
        }

        return listaDeTimes;
    }
}
