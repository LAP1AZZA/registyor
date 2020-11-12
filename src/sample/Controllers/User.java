package sample.Controllers;

public class User {
    private String login;
    private String name;
    private String password;
    private boolean priority;

    public User (String login, String name, String password, boolean admin_status) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.priority = admin_status;
    }


    public User() {}
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getAdmin_status() {
        return priority;
    }
    public void setAdmin_status(boolean priority) {
        this.priority = priority;
    }
}

