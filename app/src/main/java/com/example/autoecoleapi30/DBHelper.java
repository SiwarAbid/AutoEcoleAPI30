package com.example.autoecoleapi30;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "votre_base_de_donnees.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ADMINS = "Admins";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_Role="admin";

    private static final String CREATE_TABLE_ADMINS =
            "CREATE TABLE " + TABLE_ADMINS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT," +
                    COLUMN_Role + "Admin" +")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Créer les tables lors de la création de la base de données
        db.execSQL(CREATE_TABLE_ADMINS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Mettez à jour la base de données si nécessaire
    }

    // Méthode pour insérer un administrateur dans la base de données
    public void insertAdmin(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String query = "INSERT INTO " + TABLE_ADMINS + " (" + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + "," + COLUMN_Role + ") " +
                    "VALUES ('" + username + "', '" + password + "','Admin')";
            db.execSQL(query);
        } finally {
            db.close();
        }
    }
}
