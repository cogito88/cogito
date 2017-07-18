package cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;
import cogito.aristotle.practices.android_mvvm_noteapp.entity.User;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.dao.INoteDao;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.dao.IUserDao;

/**
 * Created by cogito88 on 7/12/17.
 */

@Database(entities = {User.class, Note.class}, version = 1)
@TypeConverters({DateTypeConverter.class, UserTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract IUserDao userDao();
    public abstract INoteDao noteDao();
}
