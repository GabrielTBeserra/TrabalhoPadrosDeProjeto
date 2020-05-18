package br.unaerp.Beans;

public class Jogador {
    private Integer id;
    private String nome;
    private Integer timeId;

    public Jogador(Integer id, String nome, Integer timeId) {
        this.id = id;
        this.nome = nome;
        this.timeId = timeId;
    }

    public Jogador(String nome, Integer timeId) {
        this.nome = nome;
        this.timeId = timeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", timeId=" + timeId +
                '}';
    }
}
