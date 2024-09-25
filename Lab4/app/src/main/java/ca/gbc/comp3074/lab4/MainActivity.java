package ca.gbc.comp3074.lab4;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> openDialog());
    }


    boolean selected [] = {false, false, false};
    private void openDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean temp[] = {false, false,false};
        for(int i=0; i<selected.length; i++){
            temp[i] = selected[i];
        }

        builder.setTitle("Alert Dialog");
        //builder.setMessage("Hi I am a dialog!");

        builder.setMultiChoiceItems(R.array.colors, null, (dialog, which, isChecked) -> {
            if(isChecked){
                Log.d("DIALOG", "Selected item " +which);
            }else{
                Log.d("DIALOG", "Removed item " +which);
            }
        });

        //buttons
        builder.setPositiveButton("OK",(dialog, which) -> {
            Log.d("DIALOG", "POSITIVE");
            for(int i=0; i<temp.length; i++){
                selected[i] = temp[i];
            }
        });



        builder.setNeutralButton("Neutral", (dialog, which) -> {
            Log.d("DIALOG", "NEUTRAL");
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {
            Log.d("DIALOG", "NEGATIVE");
        });

        AlertDialog d = builder.create();
        d.setCanceledOnTouchOutside(false);
        d.show();
    }

}