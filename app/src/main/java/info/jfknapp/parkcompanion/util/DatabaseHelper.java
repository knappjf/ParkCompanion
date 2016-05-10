package info.jfknapp.parkcompanion.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import info.jfknapp.parkcompanion.contacts.Contact;
import info.jfknapp.parkcompanion.tasks.Task;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ParkCompanion";
    private static final int DATABASE_VERSION = 1;

    //Table names
    private static final String TABLE_CONTACTS = "contacts";
    private static final String TABLE_TASKS = "tasks";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createContactsTable = "CREATE TABLE " + TABLE_CONTACTS + " (" +
                "name VARCHAR," +
                "full_name VARCHAR," +
                "phone VARCHAR," +
                "park VARCHAR," +
                "title VARCHAR)";

        String createTasksTable = "CREATE TABLE " + TABLE_TASKS + " (" +
                "name VARCHAR," +
                "description TEXT," +
                "park VARCHAR)";

        db.execSQL(createContactsTable);
        db.execSQL(createTasksTable);
    }

    public List<String> getTaskList() {
        String sql = "SELECT name FROM " + TABLE_TASKS;
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);

        List<String> result = null;

        if (cursor.moveToFirst()) {
            result = new ArrayList<>();

            do {
                result.add(cursor.getString(0));
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        return result;
    }

    public Task getTask(String name) {
        String sql = "SELECT * FROM " + TABLE_TASKS + " WHERE name='" + name + "'";
        Cursor cursor = this.getReadableDatabase().rawQuery(sql, null);
        Task result = null;

        if (cursor.moveToFirst()) {
            result = new Task(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("description")), cursor.getString(cursor.getColumnIndex("park")));
        }

        cursor.close();
        return result;
    }

    public void addTask(Task task) {
        ContentValues values = new ContentValues();
        values.put("name", task.getName());
        values.put("description", task.getDescription());
        values.put("park", task.getPark());

        getWritableDatabase().insert(TABLE_TASKS, null, values);
    }

    public void deleteTask(String name) {
        getWritableDatabase().delete(TABLE_TASKS, "name='" + name + "'", null);
    }

//    public List<String> getContactList(){}
//    public Contact getContact(String name){}
//    public void addContact(Contact contact){}
//    public void deleteContact(String name){}
}
