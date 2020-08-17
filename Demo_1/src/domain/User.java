package domain;

public class User {
    private String username;
    private String password;
    private String verifyCode;

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifycode='" + verifyCode + '\'' +
                '}';
    }
}
