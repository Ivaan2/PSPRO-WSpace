package Unidad04.Ejemplo03;

public class Usuario {
    String usuario;
    String password;

    /**
     *
     */
    public Usuario() {
        super();
    }

    /**
     * @param usuario
     * @param password
     */
    public Usuario(String usuario, String password) {
        super();
        this.usuario = usuario;
        this.password = password;
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
