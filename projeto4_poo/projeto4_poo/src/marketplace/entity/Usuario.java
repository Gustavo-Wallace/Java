package marketplace.entity;

public abstract class Usuario {
    private String nomeUsuario;
    private String senha;

    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha2) {
    }

    public void setNome(String nomeUsuario2) {
    }
}