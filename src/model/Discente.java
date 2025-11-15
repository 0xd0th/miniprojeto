package model;

public class Discente {
    private int id;
    private String nome;
    private String curso;
    private String modalidade;
    private String status;

    public Discente(int id, String nome, String curso, String modalidade, String status) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.modalidade = modalidade;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNome: %s\nCurso: %s\nModalidade: %s\nStatus: %s\n",
                id, nome, curso, modalidade, status);
    }

}
