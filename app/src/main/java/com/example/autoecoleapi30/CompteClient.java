
package com.example.autoecoleapi30;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CompteClient extends AppCompatActivity {

    private EditText editTextAdminUsername;
    private EditText editTextAdminPassword;
    private Button btnLogin;

    private TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte_client);

        // Initialisation des éléments de l'interface utilisateur
        editTextAdminUsername = findViewById(R.id.editTextNewUsername);
        editTextAdminPassword = findViewById(R.id.editTextNewPassword);
        btnLogin = findViewById(R.id.btnlogin);

        textViewTitle = findViewById(R.id.textView);

        // Ajout d'un écouteur de clic au bouton de connexion
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération des informations d'identification
                String username = editTextAdminUsername.getText().toString();
                String password = editTextAdminPassword.getText().toString();

                // Vérification des informations d'identification (exemple simple)
                if (isValidCredentials(username, password)) {
                    // Connexion réussie, ajoutez ici le code pour rediriger vers une autre activité, etc.
                    Toast.makeText(CompteClient.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                } else {
                    // Affichage d'un message d'erreur en cas d'échec de connexion
                    Toast.makeText(CompteClient.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Ajout d'un écouteur de clic au bouton d'inscription
        btnLogin.setOnClickListener(v -> {
            Intent intent;

            intent = new Intent(getApplicationContext(),DefineSessions.class);
            startActivity(intent);


        });
    }

    // Méthode pour vérifier les informations d'identification (exemple simple)
    private boolean isValidCredentials(String username, String password) {
        // Ajoutez ici votre logique de vérification d'informations d'identification
        // Dans cet exemple, nous vérifions si le nom d'utilisateur et le mot de passe ne sont pas vides
        return !username.isEmpty() && !password.isEmpty();
    }
}
