package cn.Air_Stack.BaseClass;

public class User {

    public User(){

    }
    public User(String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(int id,String userName,String passWord){
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }
    private int id;
    private String userName;
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return String.valueOf(id);
    }

    @Override
    public String toString(){
        return(
                "id:"+this.id+'\n'+
                "username:"+this.userName+'\n'+
                "password:"+this.passWord+'\n'
        );
    }
}
