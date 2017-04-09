package Model;

/**
 * Created by Nikita on 2017-04-09.
 */
public class Registration {

    public Boolean newRegistration(String uid, String pwd) {

        return PropertiesSingleton.saveProperty(uid, pwd);
    }
}
