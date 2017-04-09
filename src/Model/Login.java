package Model;

public class Login {

    public boolean authenticate(String uid, String pwd) {

        return PropertiesSingleton.checkProperty(uid, pwd);
    }
}
