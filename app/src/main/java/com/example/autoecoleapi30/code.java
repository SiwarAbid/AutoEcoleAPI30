package com.example.autoecoleapi30;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoecoleapi30.DBHelper;

public class code extends AppCompatActivity {
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);

        dbHelper = new DBHelper(this);

        // Utilisez dbHelper pour effectuer des opérations sur la base de données
        int Id = 1;
        String date = "2023-01-01";
         String Time="9h:00";

        if (!dbHelper.isLearningSessionReserved(Id, date,Time)) {
            dbHelper.reserveLearningSession( Id, date, Time);
            Toast.makeText(this, "Réservation réussie.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "La réservation existe déjà.", Toast.LENGTH_SHORT).show();
        }
    }
}
