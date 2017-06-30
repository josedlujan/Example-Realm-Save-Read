package realm.ejemplo.com.ejemplorealm;

import io.realm.RealmObject;

/**
 * Created by jose on 27/06/17.
 */

public class User extends RealmObject {
    String username;
    int age;

    public User(){}

    public User(String username, int age){
        this.username  = username;
        this.age = age;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
