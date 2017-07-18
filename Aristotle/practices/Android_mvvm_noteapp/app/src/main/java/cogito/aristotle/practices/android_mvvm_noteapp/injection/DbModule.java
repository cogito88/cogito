package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.AppDatabase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by cogito88 on 7/17/17.
 */

@Module
public class DbModule {
    @Provides
    @Singleton
    AppDatabase providesNoteDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app_db").build();
    }
}
