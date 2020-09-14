package dbForLry;

public class Login_user {
    private String account;            //登录账户
    private String password;            //密码

    public Login_user(String account, String password){
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    @Override
    public  String toString() {
        return "User{"+
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
