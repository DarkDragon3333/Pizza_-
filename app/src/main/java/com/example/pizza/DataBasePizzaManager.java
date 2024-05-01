package com.example.pizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DataBasePizzaManager extends SQLiteOpenHelper {
    private static String DB_NAME = "pizza.db";
    private static final int SCHEMA = 1; // версия базы данных
    static final String NAME_AND_PRICE = "Name_and_price",
            ID = "id", NAME = "Name", RECIPE = "recipe",
            EIGHTEEN_PRICE = "eighteen_price", TWENTY_FOUR_PRICE = "twenty_four_price", THIRTY_PRICE = "thirty_price",
            EIGHTEEN_WEIGHT = "eighteen_weight", TWENTY_FOUR_WEIGHT = "twenty_four_weight", THIRTY_WEIGHT = "thirty_weight";

    public DataBasePizzaManager(Context context) {
        super(context, DB_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PIZZA_TABLE = "CREATE TABLE " + NAME_AND_PRICE + "("
                + ID + " INTEGER PRIMARY KEY,"
                + NAME + " TEXT,"
                + RECIPE + " TEXT,"
                + EIGHTEEN_PRICE + " TEXT,"
                + TWENTY_FOUR_PRICE + " TEXT,"
                + THIRTY_PRICE + " TEXT,"
                + EIGHTEEN_WEIGHT + " TEXT,"
                + TWENTY_FOUR_WEIGHT + " TEXT,"
                + THIRTY_WEIGHT + " TEXT);";
        sqLiteDatabase.execSQL(CREATE_PIZZA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NAME_AND_PRICE);
        onCreate(sqLiteDatabase);
    }

    Cursor ReadData(){
        String query = "SELECT * FROM " + NAME_AND_PRICE;
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor cursor = null;

        if (bd != null){
            cursor =  bd.rawQuery(query, null);
        }

        return cursor;
    }

    void InsertData(
            int id, String name, String recipe,
            String eighteen_price, String twenty_four_price, String thirty_price,
            String eighteen_weight, String twenty_four_weight, String thirty_weight) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(RECIPE, recipe);
        contentValues.put(EIGHTEEN_PRICE, eighteen_price);
        contentValues.put(TWENTY_FOUR_PRICE, twenty_four_price);
        contentValues.put(THIRTY_PRICE, thirty_price);
        contentValues.put(EIGHTEEN_WEIGHT, eighteen_weight);
        contentValues.put(TWENTY_FOUR_WEIGHT, twenty_four_weight);
        contentValues.put(THIRTY_WEIGHT, thirty_weight);

        db.insert(NAME_AND_PRICE, null, contentValues);
    }

}
