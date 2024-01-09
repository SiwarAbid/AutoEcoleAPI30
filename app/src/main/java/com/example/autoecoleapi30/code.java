package com.example.autoecoleapi30;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoecoleapi30.DBHelper;

public class code extends AppCompatActivity {

    private DBHelperReservation DBHelper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);

        DBHelper DBHelperReservation  = new DBHelper(this);

        // ... autres initialisations

        Button  btnReserveCodeSession = findViewById(R.id.btnReserveCodeSession);

        btnReserveCodeSession.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Obtenez la date de la séance d'apprentissage (vous devez implémenter cette partie)
                String sessionDate = "2023-12-31"; // Remplacez par la logique pour obtenir la date

                // Insérez la réservation dans la base de données
                long newRowId = DBHelper.insertLearningSessionReservation(sessionDate);

                if (newRowId != -1) {
                    // La réservation a été insérée avec succès
                    Toast.makeText(code.this, "Réservation réussie!", Toast.LENGTH_SHORT).show();
                } else {
                    // Erreur lors de l'insertion de la réservation
                    Toast.makeText(code.this, "Erreur lors de la réservation", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
