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

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nTitulo: %s\nAutor: %s\nAno: %d\nStatus: %s\n",
                id, titulo, autor, ano, status);
    }

}
