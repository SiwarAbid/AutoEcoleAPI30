package com.example.autoecoleapi30;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAdminUsername;
    private EditText editTextAdminPassword;
    private Button SeConnecter;
    private Button inscrire;
    private TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des éléments de l'interface utilisateur
        editTextAdminUsername = findViewById(R.id.editTextAdminUsername);
        editTextAdminPassword = findViewById(R.id.editTextAdminPassword);
        SeConnecter = findViewById(R.id.bSeConnecter);
        inscrire = findViewById(R.id.binscrire);
        textViewTitle = findViewById(R.id.textView);

        // Ajout d'un écouteur de clic au bouton de connexion
        SeConnecter.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CompteAdmin.class);
            startActivity(intent);

        });

        // Ajout d'un écouteur de clic au bouton d'inscription

        inscrire.setOnClickListener(v -> {
            Intent intent;

                intent = new Intent(MainActivity.this, CompteClient.class);
                startActivity(intent);


        });}
    // Méthode pour vérifier les informations d'identification (exemple simple)
    private boolean isValidCredentials(String username, String password) {
        // Ajoutez ici votre logique de vérification d'informations d'identification
        // Dans cet exemple, nous vérifions si le nom d'utilisateur et le mot de passe ne sont pas vides
        return !username.isEmpty() && !password.isEmpty();
    }
}
