package cogito.aristotle.practices.android_mvvm_noteapp.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.threeten.bp.LocalDateTime;

import java.util.List;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by cogito88 on 7/12/17.
 */

@Dao
public interface INoteDao {

    @Query("SELECT * FROM " + Note.TABLE_NAME + " WHERE " + Note.DATE_FIELD + " > :minDate")
    LiveData<List<Note>> getNotes(LocalDateTime minDate);

    @Insert(onConflict = REPLACE)
    void addNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Update(onConflict = REPLACE)
    void updateNote(Note note);

}





