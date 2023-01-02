package hr.algebra.model;

public class User {
    private int idUser;
    private String username;
    private String password;
    private int roleID;

    public User(String userName, String password, int roleID) {
        this.username = userName;
        this.password = password;
        this.roleID = roleID;
    }

    public User(int id, String userName, String password, int roleID) {
        this.idUser = id;
        this.username = userName;
        this.password = password;
        this.roleID = roleID;
    }

    public User(int idUser, String userName, String password) {
        this.idUser = idUser;
        this.username = userName;
        this.password = password;
    }
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}