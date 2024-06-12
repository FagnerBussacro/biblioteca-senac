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
import model.mLivros;

public class cLivros {

    public void cadastrarLivros(mLivros modelLivros) {
        // Conexão com o banco
        Connection conn = mySql.conexao();

        PreparedStatement stmt = null; // liberar para usar comando sql
        ResultSet rs = null;//pegar e executar o comando em sql
        try {
            stmt = conn.prepareStatement("INSERT INTO livros (fk_editoras_id_editora, "
                    + "fk_autores_id_autor, titulo, descricao, ano) VALUES (?,?,?,?,?)");

            stmt.setInt(1, modelLivros.getFkEditoras().getId_editora());
            stmt.setInt(2, modelLivros.getFkAutores().getId_autor());
            stmt.setString(3, modelLivros.getTitulo());
            stmt.setString(4, modelLivros.getDescricao());
            stmt.setInt(5, modelLivros.getAno());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(cLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");
    }
    

}
