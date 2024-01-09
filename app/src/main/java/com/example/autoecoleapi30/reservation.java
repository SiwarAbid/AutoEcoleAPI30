package com.example.autoecoleapi30;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reservation extends AppCompatActivity {
    private DBHelper dbHelper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation);

        dbHelper = new DBHelper(this);

        // Exemple de réservation d'une session d'apprentissage
        int Id = 1;
        String Date = "2023-01-01";
        String Time = "9h:00";

        dbHelper.reserveLearningSession(Id, Date,Time);
        Toast.makeText(this, "Réservation de session d'apprentissage réussie.", Toast.LENGTH_SHORT).show();

        // Exemple de réservation d'une session de code
        int Idcode = 2;
        String Datecode = "2023-01-02";
        String Timecode = "9h:00";

        dbHelper.reserveCodeSession(Idcode,Datecode,Timecode);
        Toast.makeText(this, "Réservation de session de code réussie.", Toast.LENGTH_SHORT).show();


        // Exemple de réservation d'une session de parking
        int Idparking = 3;
        String Dateparking = "2023-01-03";
        String Timeparking = "2023-01-03";

        dbHelper.reserveParkingSession(Idparking, Dateparking,Timeparking);
        Toast.makeText(this, "Réservation de session de stationnement réussie.", Toast.LENGTH_SHORT).show();
    }
}
