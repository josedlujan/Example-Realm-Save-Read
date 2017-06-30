package realm.ejemplo.com.ejemplorealm;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    EditText userfield,agefield;
    Button save,read;
    private Realm myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRealm = Realm.getDefaultInstance();

        userfield = (EditText)findViewById(R.id.username);
        agefield = (EditText) findViewById(R.id.age);
        save = (Button) findViewById(R.id.save);
        read = (Button) findViewById(R.id.read);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User myUser =  myRealm.createObject(User.class);
                        myUser.setUsername(userfield.getText().toString());
                        myUser.setAge(Integer.valueOf(agefield.getText().toString()));
                    }
                });

            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RealmResults<User> users = myRealm.where(User.class).findAll();
                StringBuilder builder = new StringBuilder();
                for(User user: users){
                    builder.append( " \n username " + user.getUsername());
                    builder.append( "\n age" + user.getAge());
                }

                Log.e("TAG",builder.toString());
            }
        });


    }
}
