package com.example.room_database.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface BookmarkDAO {
    @Insert(onConflict = REPLACE)
    void insertBookmark(BookmarkEntity bookmark);

    @Update
    void updateBookMark(BookmarkEntity bookmark);

    @Query("SELECT * FROM Bookmark")
    List<BookmarkEntity> getAllBookmark();

    @Query("SELECT * FROM Bookmark WHERE id = :id")
    BookmarkEntity getBookmark(int id);

    @Query("DELETE FROM Bookmark")
    void deleteAll();

}
