package model;

public class Discente {
    private int id;
    private String nome;
    private String curso;
    private String modalidade;
    private String statusSituacaoAcademica;

    public Discente(int id, String nome, String curso, String modalidade, String statusSituacaoAcademica) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.modalidade = modalidade;
        this.statusSituacaoAcademica = statusSituacaoAcademica;
    }
}
