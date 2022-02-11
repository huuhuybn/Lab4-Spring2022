package com.poly.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(Context context) {
        super(context, "data.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String student = "Create table student(id integer primary key,name text,phone text)";
        sqLiteDatabase.execSQL(student);

        String monHoc = "Create table monHoc(id integer primary key,name text, tieude text)";
        sqLiteDatabase.execSQL(monHoc);
    }

    public void themSinhVien() {
        String insert = "INSERT INTO student (id,name ,phone) " +
                "VALUES (1 , Huy , 0913360468)";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        sqLiteDatabase.execSQL(insert);
    }

    public long insertStudent(int id, String name, String phone) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        long ketqua = sqLiteDatabase.insert("student",
                null, contentValues);
        return ketqua;
    }

    public long updateStudent(int id, String name, String phone) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        long ketqua = sqLiteDatabase.update("student", contentValues, "id=?", new String[]{id + ""});
        return ketqua;
    }

    public long deleteStudent(int id) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        long ket = sqLiteDatabase.delete("student", "id=?", new String[]{id + ""});
        return ket;
    }

    public ArrayList<Student> getAllStudents() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ArrayList<Student> students = new ArrayList<>();
        String query = "Select * from student";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                Student student = new Student(id,name,phone);
                students.add(student);
            }
            cursor.close();
        }
        return students;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
