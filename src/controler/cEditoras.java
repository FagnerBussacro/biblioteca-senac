package controler;

import dataBase.mySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mEditoras;
import java.util.List;

public class cEditoras {

    public void cadastrarEditoras(mEditoras modelEditoras) {
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO editoras (nome) VALUES (?)");
            stmt.setString(1, modelEditoras.getNome());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Editora cadastrada");
    }

    public List<mEditoras> listar() {
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mEditoras> lista = new ArrayList<>();

        try {// caso não dê select, aparece uma mensagem de erro
            stmt = conn.prepareStatement("SELECT * FROM editoras");
            rs = stmt.executeQuery();                                    //executar e armazenar em rs

            while (rs.next()) {
                mEditoras modelEditoras = new mEditoras();
                modelEditoras.setId_editora(rs.getInt("id_editora"));
                modelEditoras.setNome(rs.getString("nome"));

                lista.add(modelEditoras);

            }

        } catch (SQLException ex) {//mensagem de erro
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        return lista;

    }

    public List<mEditoras> pesquisar(String texto, int filtro) {
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null; //pegar e executar o comando em sql

        List<mEditoras> lista = new ArrayList<>();

        try {// caso não dê select, aparece uma mensagem de erro

            if (filtro == 0) {
                stmt = conn.prepareStatement("SELECT * FROM editoras "
                        + "WHERE id_editora = ?");
                stmt.setString(1, texto);
                rs = stmt.executeQuery();

            } else {
                stmt = conn.prepareStatement("SELECT * FROM editoras "
                        + "WHERE nome LIKE ?");
                stmt.setString(1, "%" + texto + "%"); // substitiu 1 pelo ? do comando sql acima
                rs = stmt.executeQuery(); //executar e armazenar em rs

            }

            while (rs.next()) {
                mEditoras modelEditoras = new mEditoras();
                modelEditoras.setId_editora(rs.getInt("id_editora"));
                modelEditoras.setNome(rs.getString("nome"));

                lista.add(modelEditoras);

            }

        } catch (SQLException ex) {//mensagem de erro
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        return lista;

    }

    public void alterarEditoras(mEditoras modelEditoras) {
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE editoras SET nome = ? WHERE "
                    + "id_editora = ?");
            stmt.setString(1, modelEditoras.getNome());
            stmt.setInt(2, modelEditoras.getId_editora());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        JOptionPane.showMessageDialog(null, "Editora alterado com sucesso");
    }

    public void ExcluirEditoras(mEditoras modelEditoras) {
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM editoras "
                    + "WHERE id_editora = ?");
            stmt.setInt(1, modelEditoras.getId_editora());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        JOptionPane.showMessageDialog(null, "Editora excluido com sucesso");
    }

}
