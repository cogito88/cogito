package cogito.aristotle.practices.android_mvvm_noteapp.repository;

import android.arch.lifecycle.LiveData;

import javax.inject.Inject;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.User;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.AppDatabase;
import io.reactivex.Completable;
import io.reactivex.functions.Action;

/**
 * Created by cogito88 on 7/18/17.
 */

public class UserRepositoryImpl implements IUserRepository {
    @Inject
    AppDatabase appDatabase;

    public UserRepositoryImpl(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public LiveData<User> getMyAccount() {
        return appDatabase.userDao().getMyAccount();
    }

    @Override
    public Completable addUser(User user) {
        return Completable.fromAction(() -> appDatabase.userDao().addUser(user));
    }

    @Override
    public Completable updateUser(User user) {
        return Completable.fromAction(() -> appDatabase.userDao().updateUser(user));
    }
}
