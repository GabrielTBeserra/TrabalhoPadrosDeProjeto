package br.unaerp.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTables() throws SQLException {
        String enableForennig = "PRAGMA foreign_keys = ON;";

        String tableTime = "create table if not exists time\n" +
                "(\n" +
                "    id   INTEGER primary key autoincrement,\n" +
                "    name varchar(100) NOT NULL\n" +
                ");";
        String tableJogador = "create table if not exists jogador\n" +
                "(\n" +
                "    id      INTEGER primary key autoincrement,\n" +
                "    name    varchar(100) NOT NULL,\n" +
                "    time_id INTEGER      NOT NULL,\n" +
                "    foreign key (time_id) references \"time\" (id)\n" +
                ");";

        Statement forenign = ConnectionFactory.getInstance().createStatement();
        forenign.execute(enableForennig);

        Statement table1 = ConnectionFactory.getInstance().createStatement();
        table1.execute(tableTime);

        Statement table2 = ConnectionFactory.getInstance().createStatement();
        table2.execute(tableJogador);
    }

}
