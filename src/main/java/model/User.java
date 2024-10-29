package model;

import java.util.Objects;

public class User {
    private Usertype userType;
    private String userName;
    private String pasword;
    private NotificationType notificationType = NotificationType.MAIL;
    private String mail;

    public User(Usertype userType, String userName, String pasword, NotificationType notificationType, String mail) {
        this.userType = userType;
        this.userName = userName;
        this.pasword = pasword;
        this.notificationType = notificationType;
        this.mail = mail;
    }

    public Usertype getUserType() {
        return userType;
    }

    public void setUserType(Usertype userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o){
        if(this == o ) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User)o;
        return userType == user.userType && Objects.equals(userName, user.userName) && Objects.equals(pasword, user.pasword);
    }

    @Override
    public int hashCode(){
        return Objects.hash(userType, userName, pasword);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "tipoUsuario=" + userType +
                ", nombreUsuario='" + userName + '\'' +
                ", contrasenia='" + pasword + '\'' +
                '}';
    }


}
