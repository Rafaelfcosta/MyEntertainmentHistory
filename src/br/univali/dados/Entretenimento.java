package br.univali.dados;

/**
 *
 * @author Rafael F
 */
public class Entretenimento {
    private int id;
    private String titulo;
    private double duracao;
    private int categoria;

    public Entretenimento(int id, String titulo, double duracao, int categoria) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCategoria() {
        return categoria;
    }

    public double getDuracao() {
        return duracao;
    }
    
}
