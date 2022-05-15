package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        /*
        ImageView img = findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(ListActivity.this);
                ab.setTitle("Profile").setMessage("MADness").setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Random rand = new Random();
                        int rand1 = rand.nextInt(Integer.MAX_VALUE);
                        Intent i2 = new Intent(ListActivity.this, MainActivity.class);
                        i2.putExtra("randomInt",rand1);
                        startActivity(i2);
                    }
                });
                ab.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                ab.show();
            }
        });
         */
        ArrayList<User> userList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            Random r = new Random();
            Integer i1 = r.nextInt();
            Integer i2 = r.nextInt();
            Integer i3 = r.nextInt(2);

            String name = "Name" + i1;
            String desc = "Description" + i2;
            Boolean followed = false;
            if(i3 == 1){
                followed = true;
            }
            User u = new User(name, desc, i, followed);
            userList.add(u);
        }

        RecyclerView rv = findViewById(R.id.recyclerView);
        ListActivityAdapter adapter = new ListActivityAdapter(userList, ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);
    }
}