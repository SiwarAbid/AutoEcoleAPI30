
package com.example.autoecoleapi30;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DefineSessions extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_sessions);


        // Liaison des vues du XML au code Java
        View view = findViewById(R.id.view);
        TextView textView = findViewById(R.id.textView);
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        Button btnReserveLearningSession = findViewById(R.id.btnReserveLearningSession);
        Button btnReserveCodeSession = findViewById(R.id.btnReserveCodeSession);
        Button btnReserveParkingSession = findViewById(R.id.btnReserveParkingSession);

        // Vous pouvez définir des actions pour les boutons ici, par exemple :
        btnReserveLearningSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actions à effectuer lors du clic sur le bouton de réservation d'une séance d'apprentissage












            }
        });
        btnReserveLearningSession.setOnClickListener(v -> {
            Intent intent;

            intent = new Intent(DefineSessions.this, reservation.class);
            startActivity(intent);


        });


// passer au interface de  réservation de seance de code

        btnReserveCodeSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Actions à effectuer lors du clic sur le bouton de réservation d'une séance d'apprentissage












            }
        });
        btnReserveCodeSession.setOnClickListener(v -> {
            Intent intent;

            intent = new Intent(DefineSessions.this, reservation.class);
            startActivity(intent);


        });
    // passer au interface de réservation seance code

        btnReserveParkingSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actions à effectuer lors du clic sur le bouton de réservation d'une séance d'apprentissage



            }
        });
        btnReserveParkingSession.setOnClickListener(v -> {
            Intent intent;

            intent = new Intent(DefineSessions.this, reservation.class);
            startActivity(intent);


        });










    }

}
