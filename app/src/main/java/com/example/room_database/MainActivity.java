package com.example.room_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.room_database.database.AppDatabase;
import com.example.room_database.database.BookmarkEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        insertBookmark();
        updateBookmark(1);
        getAllBookmark();
        findBookmark(1);
    }

    private void insertBookmark() {
        BookmarkEntity bm = new BookmarkEntity();
        bm.title = "This is title";
        bm.content = "This is content";
        db.bookmarkDAO().insertBookmark(bm);
    }

    private void updateBookmark(int id) {
        BookmarkEntity bm = db.bookmarkDAO().getBookmark(id);
        bm.title = "This is new title";
        db.bookmarkDAO().updateBookMark(bm);
    }

    private void findBookmark(int id){
        BookmarkEntity model = db.bookmarkDAO().getBookmark(id);
        Log.d("TAG","Find bookmark with id"+ model.id+"title: " + model.title);
    }

    private void getAllBookmark() {
        List<BookmarkEntity> list = db.bookmarkDAO().getAllBookmark();
        for(BookmarkEntity model: list) {
            Log.d("Tag", "id: "+ model.id+ "title" + model.title);
        }
    }
}