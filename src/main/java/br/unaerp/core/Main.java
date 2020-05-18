package br.unaerp.core;

import br.unaerp.DAO.CreateTable;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CreateTable.createTables();
        Menu menu = new Menu();
        menu.menu();
    }
}