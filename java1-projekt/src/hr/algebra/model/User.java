package hr.algebra.model;

public class User {    
    private int id;
    private String username;
    private String password;
    private int roleID;

    public User(String username, String password, int roleID) {
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }

    public User(int id, String username, String password, int roleID) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String getRole() {
        switch (roleID) {
            case 1:
                return "Administrator";
            case 2:
                return "User";
            default:
                return "N/A";
        }
    }
}