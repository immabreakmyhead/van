package com.example.van;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database_name";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "texts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TEXT = "text";
    private static final String COLUMN_IMAGE_NAME = "image_name";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TEXT + " TEXT, "
                + COLUMN_IMAGE_NAME + " TEXT)";
        db.execSQL(CREATE_TABLE);

        // Insert pre-defined data with specific IDs
        insertDataWithId(db, 1, "", "icon");
        insertDataWithId(db, 2, "Van Gogh hoped that a large work featuring several people would help prove himself to the outside world. Paintings of peasants having their daily meal were popular at that time. He practiced for months painting heads, and many studies preceded the Potato Eaters. He was satisfied with the result but his brother Theo and his artist friend Anthon van Rappard were very critical of his work.", "nuen");
        insertDataWithId(db, 3, "Vincent spent the final, highly productive months of his life in the French city of Oise, where he committed suicide.", "oise");
        insertDataWithId(db, 4, "Bridges across the Seine at Asnières was painted in open air. The light yellow of the embankment and the bridge walls shows the effect of bright sunlight.", "paris");
        insertDataWithId(db, 5, "Van Gogh's rolling night sky full of bright stars is probably one of the world's most famous artworks.", "star");
    }
    private void insertDataWithId(SQLiteDatabase db, int id, String text, String imageName) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_TEXT, text);
        values.put(COLUMN_IMAGE_NAME, imageName);
        db.insert(TABLE_NAME, null, values);
    }
    public String[] getTextAndImageName(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] result = new String[2];

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COLUMN_TEXT, COLUMN_IMAGE_NAME},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            result[0] = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXT));
            result[1] = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_NAME));
            cursor.close();
        }
        return result;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
