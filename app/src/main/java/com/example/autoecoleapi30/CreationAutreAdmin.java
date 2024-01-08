package com.example.autoecoleapi30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreationAutreAdmin extends AppCompatActivity {

    private EditText editTextAdminUsername;
    private EditText editTextAdminPassword;
    private Button btnCreateAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation_autre_admin);

        // Liaison des vues du XML au code Java
        editTextAdminUsername = findViewById(R.id.editTextAdminUsername);
        editTextAdminPassword = findViewById(R.id.editTextAdminPassword);
        btnCreateAdmin = findViewById(R.id.btnCreateAdmin);

        // Ajout d'un OnClickListener au bouton
        btnCreateAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Appeler une méthode pour créer l'administrateur
                createAdmin();
            }
        });
    }

    private void createAdmin() {
        // Récupérer le nom d'utilisateur et le mot de passe entrés par l'utilisateur
        String username = editTextAdminUsername.getText().toString();
        String password = editTextAdminPassword.getText().toString();

        // Méthode pour insérer un administrateur dans la base de données

        DBHelper dbHelper = new DBHelper(this); // Remplacez 'context' par le contexte de votre application
        try {
            dbHelper.insertAdmin(username, password);
        } finally {
            dbHelper.close();
        }


        // Vérifier si les champs sont vides
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
        } else {
            // Appeler une méthode pour effectuer la création de l'administrateur
            // (vous devrez implémenter cette méthode en fonction de votre logique métier)
            // createAdmin(username, password);

            // Afficher un message de succès (remplacer cela avec la logique réelle)
            Toast.makeText(this, "Administrateur créé avec succès", Toast.LENGTH_SHORT).show();
        }
    }






}

