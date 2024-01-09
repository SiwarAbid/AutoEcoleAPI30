package com.example.autoecoleapi30;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperReservation extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "auto_ecole_db";
    private static final int DATABASE_VERSION = 1;

    // Table pour les réservations de séances d'apprentissage
    public static final String TABLE_LEARNING_SESSIONS = "learning_sessions";
    public static final String COLUMN_LEARNING_SESSION_ID = "session_id";
    public static final String COLUMN_LEARNING_SESSION_DATE = "session_date";
    // Ajoutez d'autres colonnes nécessaires pour les séances d'apprentissage

    // Table pour les réservations de séances de code
    public static final String TABLE_CODE_SESSIONS = "code_sessions";
    public static final String COLUMN_CODE_SESSION_ID = "session_id";
    public static final String COLUMN_CODE_SESSION_DATE = "session_date";
    // Ajoutez d'autres colonnes nécessaires pour les séances de code

    // Table pour les réservations de séances de parking
    public static final String TABLE_PARKING_SESSIONS = "parking_sessions";
    public static final String COLUMN_PARKING_SESSION_ID = "session_id";
    public static final String COLUMN_PARKING_SESSION_DATE = "session_date";
    // Ajoutez d'autres colonnes nécessaires pour les séances de parking

    public DBHelperReservation (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Créer la table des séances d'apprentissage
        String createLearningSessionsTableQuery = "CREATE TABLE " + TABLE_LEARNING_SESSIONS + " (" +
                COLUMN_LEARNING_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LEARNING_SESSION_DATE + " TEXT " + ")";


        db.execSQL(createLearningSessionsTableQuery);

        // Créer la table des séances de code
        String createCodeSessionsTableQuery = "CREATE TABLE " + TABLE_CODE_SESSIONS + " (" +
                COLUMN_CODE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CODE_SESSION_DATE + " TEXT " + ")";


        db.execSQL(createCodeSessionsTableQuery);

        // Créer la table des séances de parking
        String createParkingSessionsTableQuery = "CREATE TABLE " + TABLE_PARKING_SESSIONS + " (" +
                COLUMN_PARKING_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PARKING_SESSION_DATE + " TEXT " + " )";


        db.execSQL(createParkingSessionsTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Gestion des mises à jour de la base de données si nécessaire
    }


    public long insertLearningSessionReservation(String sessionDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEARNING_SESSION_DATE, sessionDate);
        // Ajoutez d'autres colonnes nécessaires pour les séances d'apprentissage

        long newRowId = db.insert(TABLE_LEARNING_SESSIONS, null, values);
        db.close();

        return newRowId;
    }
}
