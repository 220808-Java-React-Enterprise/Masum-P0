package models;

public class Users {
    private String name;
    private String username;
    private String Id;
    private String email;
    private String password;
    public Users(){

    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String Id, String username, String password) {
        this.Id=Id;
        this.username=username;
        this.password=password;
    }

    public void User(String id, String username, String password) {
        this.Id = Id;
        this.username = username;
        this.password = password;
    }

    public void userSet(){}
    public void userSet(String id, String username, String password) {
        this.Id = Id;
        this.username = username;
        this.password = password;
    }

    public void userSet(String Id,String name,String username,String password,String email){
        this.Id=Id;
        this.name=name;
        this.username=username;
        this.password=password;
        this.email=email;

    }

    public String getId() {
        return Id;
    }


    public String getName(){
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User Info{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
