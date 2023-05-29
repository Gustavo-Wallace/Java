package projeto3;

abstract class Usuario {
    private String nomeUsuario;
    String senha;

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

    public void setNome(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }
}