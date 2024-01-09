package com.example.autoecoleapi30;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "auto_ecole.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ADMINS = "Admins";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ROLE = "role"; // Utilisez un nom de colonne plus générique pour le rôle

    private static final String TABLE_RESERVE_LEARNING_SESSION = "ReserveLearningSession";
    private static final String COLUMN_LEARNING_SESSION_ID = "learningSessionId";
    public static final String COLUMN_LEARNING_SESSION_DATE = "session_date";
    public static final String COLUMN_LEARNING_SESSION_Time = "session_Time";


    private static final String TABLE_RESERVE_CODE_SESSION = "ReserveCodeSession";
    private static final String COLUMN_CODE_SESSION_ID = "codeSessionId";
    public static final String COLUMN_CODE_SESSION_DATE = "code_date";
    public static final String COLUMN_CODE_SESSION_Time = "code_Time";
    // Ajoutez d'autres colonnes pour la table ReserveCodeSession

    private static final String TABLE_RESERVE_PARKING_SESSION = "ReserveParkingSession";
    private static final String COLUMN_PARKING_SESSION_ID = "parkingSessionId";
    public static final String COLUMN_PARKING_SESSION_DATE = "parking_Time";
    public static final String COLUMN_PARKING_SESSION_Time = "parking_Time";

    // Ajoutez d'autres colonnes pour la table ReserveParkingSession

    private static final String CREATE_TABLE_ADMINS =
            "CREATE TABLE " + TABLE_ADMINS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT," +
                    COLUMN_ROLE + " TEXT" + ")";

    private static final String CREATE_TABLE_RESERVE_LEARNING_SESSION =
            "CREATE TABLE " + TABLE_RESERVE_LEARNING_SESSION + " (" +
                    COLUMN_LEARNING_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_LEARNING_SESSION_DATE + " TEXT," +
                    COLUMN_LEARNING_SESSION_Time + " TEXT" + ")";

    // Ajoutez d'autres colonnes nécessaires pour ReserveLearningSession


    private static final String CREATE_TABLE_RESERVE_CODE_SESSION =
            "CREATE TABLE " + TABLE_RESERVE_CODE_SESSION + " (" +
                    COLUMN_CODE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    COLUMN_CODE_SESSION_DATE + " TEXT," +
                    COLUMN_CODE_SESSION_Time + " TEXT" + ")";
                    // Ajoutez d'autres colonnes nécessaires pour ReserveCodeSession


    private static final String CREATE_TABLE_RESERVE_PARKING_SESSION =
            "CREATE TABLE " + TABLE_RESERVE_PARKING_SESSION + " (" +
                    COLUMN_PARKING_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_PARKING_SESSION_DATE + " TEXT," +
                    COLUMN_PARKING_SESSION_Time + " TEXT" + ")";
                    // Ajoutez d'autres colonnes nécessaires pour ReserveParkingSession


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public void onCreate(SQLiteDatabase db) {
        // Créer les tables lors de la création de la base de données
        db.execSQL(CREATE_TABLE_ADMINS);
        db.execSQL(CREATE_TABLE_RESERVE_LEARNING_SESSION);
        db.execSQL(CREATE_TABLE_RESERVE_CODE_SESSION);
        db.execSQL(CREATE_TABLE_RESERVE_PARKING_SESSION);
    }

   
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Mettez à jour la base de données si nécessaire
    }

    // Ajoutez des méthodes pour insérer des données dans les nouvelles tables
    // (par exemple, insertReserveLearningSession, insertReserveCodeSession, insertReserveParkingSession)



    // Méthode pour insérer un administrateur dans la base de données
    public void insertAdmin(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String COLUMN_Role = null;
            String query = "INSERT INTO " + TABLE_ADMINS + " (" + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + "," + COLUMN_Role + ") " +
                    "VALUES ('" + username + "', '" + password + "','Admin')";
            db.execSQL(query);
        } finally {
            db.close();
        }
    }


    public long insertLearningSessionReservation(String sessionDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEARNING_SESSION_DATE, sessionDate);
        values.put(COLUMN_LEARNING_SESSION_Time, sessionDate);
        // Ajoutez d'autres colonnes nécessaires pour les séances d'apprentissage

        long newRowId = db.insert(TABLE_RESERVE_LEARNING_SESSION, null, values);
        db.close();

        return newRowId;
    }


}
