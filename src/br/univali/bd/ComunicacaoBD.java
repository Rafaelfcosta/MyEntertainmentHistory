package br.univali.bd;

import br.univali.dados.Entretenimento;
import br.univali.dados.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael F
 */
public class ComunicacaoBD {

    private static Connection conexao = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    private static final int SERIE = 1;
    private static final int FILME = 2;
    private static final int ANIME = 3;
    private static final int GAME = 4;
    private static final int MUSICA = 5;

    public static void inserirTestUsers() throws Exception {
        for (int i = 0; i < 10; i++) {
            String a = (i < 10) ? "0" : "";
            inserirUsuario("Test User " + a + i);
        }
    }

    public static void deletar(int id) throws Exception {
        comandoSQL("DELETE FROM ENTRETENIMENTOS WHERE id_entretenimento = " + id);
    }

    public static void verUsuarios() throws Exception {
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM USUARIOS";
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_usuario");
            String nome = rs.getString("nome");
            System.out.println(id + " -> " + nome);
        }
    }

    public static JComboBox getUsuarios(JComboBox combo) throws Exception {
        combo.removeAllItems();
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM USUARIOS";
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_usuario");
            String nome = rs.getString("nome");
            combo.addItem(nome);
        }
        return combo;
    }

    public static ArrayList<Usuario> getUsuarios() throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM USUARIOS";
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_usuario");
            String nome = rs.getString("nome");

            usuarios.add(new Usuario(id, nome));
        }
        return usuarios;
    }

    public static String getUsuario(int id) throws Exception {
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM USUARIOS WHERE id_usuario = " + id;
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        rs.next();
        return rs.getString("nome").toUpperCase();
    }

    public static void verEntretenimentos() throws Exception {
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS";
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");
            System.out.println(id + " -> " + titulo + " | " + getCategoria(categoria) + " | " + (int) duracao / 60 + " horas consumidas");
        }
    }

    public static DefaultTableModel getEntretenimentos() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Título");
        modelo.addColumn("Categoria");
        modelo.addColumn("Duração da Sessão");

        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS";
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            Vector linha = new Vector();

            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");

            linha.add(titulo);
            linha.add(getCategoria(categoria));
            if ((int) duracao / 60 > 0) {
                linha.add((int) duracao / 60 + " horas");
            } else {
                linha.add((int) duracao + " minutos");
            }
            modelo.addRow(linha);
        }
        return modelo;
    }

    public static ArrayList<Entretenimento> getEntretenimentos(int id_usuario) throws Exception {
        ArrayList<Entretenimento> entretenimentos = new ArrayList<>();

        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS WHERE id_usuario = " + id_usuario;
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");

            entretenimentos.add(new Entretenimento(id, titulo, duracao, categoria));
        }
        return entretenimentos;
    }

    public static ArrayList<Entretenimento> getEntretenimentos(int id_usuario, String texto) throws Exception {
        ArrayList<Entretenimento> entretenimentos = new ArrayList<>();

        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS WHERE titulo LIKE '%" + texto + "%' AND id_usuario = " + id_usuario;
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");

            entretenimentos.add(new Entretenimento(id, titulo, duracao, categoria));
        }
        return entretenimentos;
    }

    public static ArrayList<Entretenimento> getEntretenimentos(int id_usuario, int cat) throws Exception {
        ArrayList<Entretenimento> entretenimentos = new ArrayList<>();

        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS WHERE id_usuario = " + id_usuario + " AND categoria = " + cat;
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");

            entretenimentos.add(new Entretenimento(id, titulo, duracao, categoria));
        }
        return entretenimentos;
    }

    public static void verEntretenimentos(int id_usuario) throws Exception {
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS WHERE id_usuario = " + id_usuario;
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while (rs.next()) {
            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");
            System.out.println(id + " -> " + titulo + " | " + getCategoria(categoria) + " | " + (int) duracao / 60 + " horas consumidas");
        }
    }

    public static String getCategoria(int categoria) {
        switch (categoria) {
            case SERIE:
                return "Série";
            case FILME:
                return "Filme";
            case ANIME:
                return "Anime";
            case GAME:
                return "Game";
            case MUSICA:
                return "Música";
            default:
                return "";
        }
    }

    public static void inserirUsuario(String nomeUsuario) throws Exception {
        conexao = GerenciadorConexao.getConexao();
        String SQL = "INSERT INTO USUARIOS "
                + "(nome) VALUES"
                + "(?)";
        pst = conexao.prepareStatement(SQL);
        pst.setString(1, nomeUsuario);
        pst.executeUpdate();
    }

    public static boolean inserirEntretenimento(String titulo, int categoria, double duracao_sessao, int id_usuario) throws Exception {
        conexao = GerenciadorConexao.getConexao();
        String SQL = "INSERT INTO ENTRETENIMENTOS "
                + "(titulo, categoria, duracao_sessao, id_usuario) VALUES"
                + "(?,?,?,?)";
        pst = conexao.prepareStatement(SQL);
        pst.setString(1, titulo);
        pst.setInt(2, categoria);
        pst.setDouble(3, duracao_sessao);
        pst.setInt(4, id_usuario);
        //pst.executeUpdate();
        if (pst.execute()) {
            return true;
        } else {
            return false;
        }
    }

    public static void comandoSQL(String SQL) throws Exception {
        conexao = GerenciadorConexao.getConexao();
        pst = conexao.prepareStatement(SQL);
        pst.executeUpdate();
    }
}
