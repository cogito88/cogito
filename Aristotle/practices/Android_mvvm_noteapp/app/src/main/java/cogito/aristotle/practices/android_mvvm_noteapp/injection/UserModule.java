package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import javax.inject.Singleton;

import cogito.aristotle.practices.android_mvvm_noteapp.repository.IUserRepository;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.UserRepositoryImpl;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.AppDatabase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by cogito88 on 7/18/17.
 */

@Module
public class UserModule {
    @Provides
    @SessionScope
    IUserRepository providesUserRepository(AppDatabase appDatabase) {
        return new UserRepositoryImpl(appDatabase);
    }
}
