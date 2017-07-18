package cogito.aristotle.practices.android_mvvm_noteapp.repository;

import android.arch.lifecycle.LiveData;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.User;
import io.reactivex.Completable;

/**
 * Created by cogito88 on 7/18/17.
 */

public interface IUserRepository {
    LiveData<User> getMyAccount();
    Completable addUser(User user);
    Completable updateUser(User user);
}
