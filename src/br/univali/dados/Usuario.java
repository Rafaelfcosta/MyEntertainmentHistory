package br.univali.dados;

/**
 *
 * @author Rafael F
 */
public class Usuario {
    int id;
    String nome;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
