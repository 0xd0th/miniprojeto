package model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String status;

    public Livro(int id, String titulo, String autor, int ano, String status) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.status = status;
    }

}
