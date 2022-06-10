package C8A;

public class Client {
    private int dni;
    private String password;

    public Client(int dni, String password) {
        this.dni = dni;
        this.password = password;
    }

    public int getDni() {
        return dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
