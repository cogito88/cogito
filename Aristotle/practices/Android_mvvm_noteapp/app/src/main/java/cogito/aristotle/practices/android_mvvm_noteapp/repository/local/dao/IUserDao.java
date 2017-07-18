package cogito.aristotle.practices.android_mvvm_noteapp.repository.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by cogito88 on 7/17/17.
 */

@Dao
public interface IUserDao {
    @Query("SELECT * FROM " + User.TABLE_NAME + " WHERE " + User.TYPE_FIELD + " == " + User.USER_TYPE.USER_TYPE_ME)
    LiveData<User> getMyAccount();

    @Insert(onConflict = REPLACE)
    void addUser(User user);

    @Update(onConflict = REPLACE)
    void updateUser(User user);
}
