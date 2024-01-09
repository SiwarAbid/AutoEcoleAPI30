package com.example.autoecoleapi30;// Importez les packages nécessaires
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SuppressionAdmin extends AppCompatActivity {

    private EditText editTextAdminUsernameToDelete;
    private Button btnDeleteAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supression_admin);

        // Liaison des vues du XML au code Java
        editTextAdminUsernameToDelete = findViewById(R.id.editTextAdminUsernameToDelete);
        btnDeleteAdmin = findViewById(R.id.btnDeleteAdmin);

        // Gérer le clic sur le bouton de suppression de l'admin
        btnDeleteAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer le nom d'utilisateur à supprimer
                String adminUsernameToDelete = editTextAdminUsernameToDelete.getText().toString();

                // Vérifier si le champ du nom d'utilisateur n'est pas vide
                if (!adminUsernameToDelete.isEmpty()) {
                    // Appeler la méthode de suppression d'administrateur de DBHelper
                    DBHelper dbHelper = new DBHelper(SuppressionAdmin.this);
                    dbHelper.deleteAdmin(adminUsernameToDelete);

                    // Vous pouvez également afficher un message de succès ici si nécessaire
                } else {
                    // Afficher un message si le champ du nom d'utilisateur est vide
                    editTextAdminUsernameToDelete.setError("Entrez un nom d'utilisateur");
                }
            }
        });
    }
}
