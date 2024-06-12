package model;

public class mLivros {

    private int id_livros;
    private String titulo;
    private String descricao;
    private int ano;
    private mEditoras fkEditoras;
    private mAutores fkAutores;

    public int getId_livros() {
        return id_livros;
    }

    public void setId_livros(int id_livros) {
        this.id_livros = id_livros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public mEditoras getFkEditoras() {
        return fkEditoras;
    }

    public void setFkEditoras(mEditoras fkEditoras) {
        this.fkEditoras = fkEditoras;
    }

    public mAutores getFkAutores() {
        return fkAutores;
    }

    public void setFkAutores(mAutores fkAutores) {
        this.fkAutores = fkAutores;
    }

}
