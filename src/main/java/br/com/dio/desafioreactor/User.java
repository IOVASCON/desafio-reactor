package br.com.dio.desafioreactor;

public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private boolean admin;

    public User(long id, String name, String email, String password, boolean admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    // Métodos para usar os campos, se necessário
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
