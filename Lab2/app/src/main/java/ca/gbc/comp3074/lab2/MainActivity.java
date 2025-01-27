
package ca.gbc.comp3074.lab2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Log.d("LAB2", "I am alive and in onCreate");


        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView name = findViewById(R.id.name);
        //name.setText(R.string.app_name);
        name.setAllCaps(true);

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "This is a toast! Cheers!", Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LAB2","I'm in onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LAB2","I'm in onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LAB2","I'm in onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("LAB2","I'm in onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LAB2","I'm in onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("LAB2","I'm in onRestart");
    }
}