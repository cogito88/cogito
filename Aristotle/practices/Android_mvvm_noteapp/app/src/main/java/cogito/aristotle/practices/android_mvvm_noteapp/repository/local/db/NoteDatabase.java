package cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.dao.INoteDao;

/**
 * Created by cogito88 on 7/12/17.
 */

@Database(entities = {Note.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract INoteDao noteDao();
}
