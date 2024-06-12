package controler;

import dataBase.mySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mAutores;
import view.vAutores;
import view.vPrincipal;

public class cAutores {

    public void cadastrarAutores(mAutores modelAutores) { // Botão Cadastrar
        // Conexão com o banco
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null; // liberar para usar comando sql
        ResultSet rs = null;//pegar e executar o comando em sql

        try { // Inserir na tabela pelo painel
            stmt = conn.prepareStatement("INSERT INTO autores (nome, endereco, "
                    + "numero, bairro, cidade, cpf) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, modelAutores.getNome());
            stmt.setString(2, modelAutores.getEndereco());
            stmt.setString(3, modelAutores.getEnderecoNum());
            stmt.setString(4, modelAutores.getBairro());
            stmt.setString(5, modelAutores.getCidade());
            stmt.setString(6, modelAutores.getCpf());

            stmt.executeUpdate();//Abrir a entrada para cadastrar os dados

        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso");

    }

    public List<mAutores> listar() { // funcao para mostrar os dados no banco de dado de autores
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mAutores> lista = new ArrayList<>(); // variavel para listar todos os produtos na tabela
        try {
            stmt = conn.prepareStatement("SELECT * FROM autores");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mAutores modelAutores = new mAutores();
                modelAutores.setId_autor(rs.getInt("id_autor"));
                modelAutores.setNome(rs.getString("nome"));
                modelAutores.setEndereco(rs.getString("endereco"));
                modelAutores.setEnderecoNum(rs.getString("numero"));
                modelAutores.setBairro(rs.getString("bairro"));
                modelAutores.setCidade(rs.getString("cidade"));
                modelAutores.setCpf(rs.getString("cpf"));

                lista.add(modelAutores);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public List<mAutores> pesquisar(String texto, int filtro) { // funcao para buscar dados por aproximacao no bando de dados
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mAutores> lista = new ArrayList<>();

        try {

            if (filtro == 0) {
                stmt = conn.prepareStatement("SELECT * FROM autores WHERE id_autor = ?");
                stmt.setString(1, texto); // pesquisar aproximadamente o que digita na label jTextBusca
                rs = stmt.executeQuery();
            }
            if (filtro == 1) {
                stmt = conn.prepareStatement("SELECT * FROM autores WHERE nome LIKE ?");
                stmt.setString(1, "%" + texto + "%"); // pesquisar aproximadamente o que digita na label jTextBusca
                rs = stmt.executeQuery();

            }
            if (filtro == 2) {
                stmt = conn.prepareStatement("SELECT * FROM autores WHERE endereco LIKE ?");
                stmt.setString(1, "%" + texto + "%"); // pesquisar aproximadamente o que digita na label jTextBusca
                rs = stmt.executeQuery();

            }
            if (filtro == 3) {
                stmt = conn.prepareStatement("SELECT * FROM autores WHERE numero LIKE ?");
                stmt.setString(1, "%" + texto + "%"); // pesquisar aproximadamente o que digita na label jTextBusca
                rs = stmt.executeQuery();
            }

            if (filtro == 4) {
                stmt = conn.prepareStatement("SELECT * FROM autores WHERE bairro LIKE ?");
                stmt.setString(1, "%" + texto + "%"); // pesquisar aproximadamente o que digita na label jTextBusca
                rs = stmt.executeQuery();

            }
            if (filtro == 5) {
                stmt = conn.prepareStatement("SELECT * FROM autores WHERE cidade LIKE ?");
                stmt.setString(1, "%" + texto + "%"); // pesquisar aproximadamente o que digita na label jTextBusca
                rs = stmt.executeQuery();

            }
            if (filtro == 6) {
                stmt = conn.prepareStatement("SELECT * FROM autores WHERE cpf LIKE ?");
                stmt.setString(1, "%" + texto + "%"); // pesquisar aproximadamente o que digita na label jTextBusca
                rs = stmt.executeQuery();

            }
            /*stmt = conn.prepareStatement("SELECT * FROM autores WHERE nome LIKE ?");
            stmt.setString(1, "%" + texto + "%"); // pesquisar aproximadamente o que digita na label jTextBusca
            rs = stmt.executeQuery();*/

            while (rs.next()) {
                mAutores modelAutores = new mAutores();
                modelAutores.setId_autor(rs.getInt("id_autor"));
                modelAutores.setNome(rs.getString("nome"));
                modelAutores.setEndereco(rs.getString("endereco"));
                modelAutores.setEnderecoNum(rs.getString("numero"));
                modelAutores.setBairro(rs.getString("bairro"));
                modelAutores.setCidade(rs.getString("cidade"));
                modelAutores.setCpf(rs.getString("cpf"));

                lista.add(modelAutores);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void alterarAutores(mAutores modelAutores) { // Botão Alterar
        // Conexão com o banco
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null; // liberar para usar comando sql
        ResultSet rs = null;//pegar e executar o comando em sql

        try { // Inserir na tabela pelo painel
            stmt = conn.prepareStatement("UPDATE autores SET nome = ?, endereco = ?, "
                    + "numero = ?, bairro = ?, cidade = ?, cpf = ? WHERE id_autor = ?");

            stmt.setString(1, modelAutores.getNome());
            stmt.setString(2, modelAutores.getEndereco());
            stmt.setString(3, modelAutores.getEnderecoNum());
            stmt.setString(4, modelAutores.getBairro());
            stmt.setString(5, modelAutores.getCidade());
            stmt.setString(6, modelAutores.getCpf());
            stmt.setInt(7, modelAutores.getId_autor());

            stmt.executeUpdate();//Abrir a entrada para cadastrar os dados

        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Autor Alterado com sucesso");

    }

    public void ExcluirAutores(mAutores modelAutores) { // Botão Cadastrar
        // Conexão com o banco
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null; // liberar para usar comando sql
        ResultSet rs = null;//pegar e executar o comando em sql

        try { // Inserir na tabela pelo painel
            stmt = conn.prepareStatement("DELETE FROM autores WHERE id_autor = ?");
            stmt.setInt(1, modelAutores.getId_autor());

            stmt.executeUpdate();//Abrir a entrada para cadastrar os dados

        } catch (SQLException ex) {
            Logger.getLogger(cAutores.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Autor excluido com sucesso");

    }

}
