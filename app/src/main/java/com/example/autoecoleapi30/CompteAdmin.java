package com.example.autoecoleapi30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class CompteAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte_admin); // Assurez-vous de remplacer "votre_layout" par le nom de votre fichier de mise en page XML

        // Définir une liste d'éléments pour le Spinner
        String[] elements = {"nouvelle réservation", "creation autre admin", "Suppression admin"};

        // Trouver le Spinner dans votre layout
        Spinner spinner = findViewById(R.id.spinnerActions); // Assurez-vous de remplacer "mon_spinner" par l'ID de votre Spinner dans le fichier XML

        // Créer un ArrayAdapter pour lier la liste d'éléments au Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elements);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Appliquer l'adapter au Spinner
        spinner.setAdapter(adapter);

        // Gérer les sélections du Spinner ici, si nécessaire
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = elements[position];
                // Réagir à la sélection de l'élément
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Gérer le cas où rien n'est sélectionné
            }
        });
    }
}