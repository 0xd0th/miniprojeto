package model;

public class Disciplina {
    private int id;
    private String curso;
    private String nome;
    private int vagas;

    public Disciplina(int id, String curso, String nome, int vagas) {
        this.id = id;
        this.curso = curso;
        this.nome = nome;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public String getCurso() {
        return curso;
    }

    public String getNome() {
        return nome;
    }

    public int getVagas() {
        return vagas;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNome: %s\nCurso: %s\nVagas: %d\n",
                id, nome, curso, vagas);
    }
}
