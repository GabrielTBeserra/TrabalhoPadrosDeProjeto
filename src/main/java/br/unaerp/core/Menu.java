package br.unaerp.core;

import br.unaerp.Beans.Jogador;
import br.unaerp.Beans.Time;
import br.unaerp.DAO.JogadorDAOImple;
import br.unaerp.DAO.TimeDAOImple;
import br.unaerp.interfaces.JogadorDAO;
import br.unaerp.interfaces.TimeDAO;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void menu() {
        System.out.println("==============================");
        System.out.println("1 - Jogador");
        System.out.println("2 - Time");
        System.out.println("3 - SAIR");
        System.out.println("==============================");

        Scanner in = new Scanner(System.in);
        int s = Integer.parseInt(in.nextLine());
        switch (s) {
            case 1: {
                jogadorMenu();
                break;
            }
            case 2: {
                timeMenu();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Informacao incorreta");
                menu();
            }

        }
    }

    public void jogadorMenu() {
        System.out.println("==============================");
        System.out.println("1 - Criar novo");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Deletar");
        System.out.println("4 - Listar todos");
        System.out.println("5 - SAIR");
        System.out.println("==============================");

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();

        switch (s) {
            case 1: {
                criarJogador();
                break;
            }
            case 2: {
                editarJogador();
                break;
            }
            case 3: {
                deletarJogador();
                break;
            }
            case 4: {
                listarTodosJogadores();
                break;
            }
            case 5: {
                menu();
                break;
            }

            default: {
                System.out.println("Informacao incorreta");
                menu();
            }
        }
    }

    public void timeMenu() {
        System.out.println("==============================");
        System.out.println("1 - Criar novo");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Deletar");
        System.out.println("4 - Listar todos");
        System.out.println("5 - SAIR");
        System.out.println("==============================");

        Scanner in = new Scanner(System.in);
        int s = Integer.parseInt(in.nextLine());

        switch (s) {
            case 1: {
                criarTime();
                break;
            }
            case 2: {
                editarTime();
                break;
            }
            case 3: {
                deletarTime();
                break;
            }
            case 4: {
                listarTodosTimes();
                break;
            }
            case 5: {
                menu();
                break;
            }

            default: {
                System.out.println("Informacao incorreta");
                menu();
            }
        }
    }

    private void criarTime() {
        try {
            System.out.println("Nome: ");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            TimeDAOImple timeDAOImple = new TimeDAOImple();
            timeDAOImple.insert(new Time(s));
        } catch (SQLException throwables) {
            System.out.println("Houve alguem erro, tente novamente (" + throwables.getMessage() + ")");
            menu();
        }

        System.out.println("Time criado com sucesso!");
        menu();
    }

    private void editarTime() {
        try {
            System.out.println("ID: ");
            Scanner idin = new Scanner(System.in);
            Integer id = Integer.parseInt(idin.nextLine());
            System.out.println("Nome: ");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            TimeDAOImple timeDAOImple = new TimeDAOImple();
            timeDAOImple.update(new Time(id, s));
        } catch (SQLException throwables) {
            System.out.println("Houve alguem erro, tente novamente (" + throwables.getMessage() + ")");
            menu();
        }

        System.out.println("Time atualizado com sucesso!");
        menu();
    }

    private void deletarTime() {
        try {
            System.out.println("ID: ");
            Scanner idin = new Scanner(System.in);
            String id = idin.nextLine();
            TimeDAOImple timeDAOImple = new TimeDAOImple();
            timeDAOImple.delete(id);
        } catch (SQLException throwables) {
            System.out.println("Houve alguem erro, tente novamente (" + throwables.getMessage() + ")");
            deletarTime();
        }

        System.out.println("Time excluido com sucesso!");
        menu();
    }

    private void criarJogador() {
        try {
            System.out.println("Nome: ");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            System.out.println("Time ID: ");
            Scanner timei = new Scanner(System.in);
            Integer tim = Integer.parseInt(timei.nextLine());
            JogadorDAO timeDAOImple = new JogadorDAOImple();
            timeDAOImple.insert(new Jogador(s, tim));
        } catch (SQLException throwables) {
            System.out.println("Houve alguem erro, tente novamente (" + throwables.getMessage() + ")");
            criarJogador();
        }

        System.out.println("Jogador criado com sucesso!");
        menu();
    }

    private void editarJogador() {
        try {
            System.out.println("ID: ");
            Scanner idin = new Scanner(System.in);
            Integer id = Integer.parseInt(idin.nextLine());
            System.out.println("Nome: ");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            System.out.println("Time ID: ");
            Scanner timei = new Scanner(System.in);
            Integer tim = Integer.parseInt(timei.nextLine());

            JogadorDAO jogadorDAO = new JogadorDAOImple();
            jogadorDAO.update(new Jogador(id, s, tim));
        } catch (SQLException throwables) {
            System.out.println("Houve alguem erro, tente novamente error: (" + throwables.getMessage() + ")");
            editarJogador();
        }

        System.out.println("Jogador atualizado com sucesso!");
        menu();
    }

    private void deletarJogador() {
        try {
            System.out.println("ID: ");
            Scanner idin = new Scanner(System.in);
            String id = idin.nextLine();
            JogadorDAO timeDAOImple = new JogadorDAOImple();
            timeDAOImple.delete(id);
        } catch (SQLException throwables) {
            System.out.println("Houve alguem erro, tente novamente (" + throwables.getMessage() + ")");
            menu();
        }

        System.out.println("Jogador excluido com sucesso!");
        menu();
    }

    private void listarTodosJogadores() {
        JogadorDAO jogadorDAO = new JogadorDAOImple();
        Iterator<Jogador> iterator = null;
        try {
            List<Jogador> jogadorList = jogadorDAO.showAll();
            iterator = jogadorList.iterator();
        } catch (SQLException e) {
            System.out.println("Houve alguem erro, tente novamente (" + e.getMessage() + ")");
        }

        System.out.println("Lista de jogadores");
        System.out.println("********************************");

        while (iterator.hasNext()) {
            Jogador j = iterator.next();
            System.out.println("ID: " + j.getId());
            System.out.println("Nome: " + j.getNome());
            System.out.println("Time ID: " + j.getTimeId());
            System.out.println("********************************");
        }
        menu();
    }

    private void listarTodosTimes() {
        TimeDAO timeDAO = new TimeDAOImple();
        Iterator<Time> iterator = null;
        try {
            List<Time> timeList = timeDAO.showAll();
            iterator = timeList.iterator();
        } catch (SQLException e) {
            System.out.println("Houve alguem erro, tente novamente (" + e.getMessage() + ")");
        }

        System.out.println("Lista de times");
        System.out.println("********************************");

        while (iterator.hasNext()) {
            Time j = iterator.next();
            System.out.println("ID: " + j.getId());
            System.out.println("Nome: " + j.getNome());
            System.out.println("********************************");
        }
        menu();
    }
}