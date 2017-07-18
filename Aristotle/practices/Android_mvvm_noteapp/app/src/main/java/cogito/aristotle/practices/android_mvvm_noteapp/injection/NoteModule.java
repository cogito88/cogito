package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import cogito.aristotle.practices.android_mvvm_noteapp.MvvmNoteApplication;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.INoteRepository;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.NoteRepositoryImpl;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.AppDatabase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by cogito88 on 7/12/17.
 */

@Module
public class NoteModule {
    @Provides
    @SessionScope
    INoteRepository providesINoteRepository(AppDatabase appDatabase) {
        return new NoteRepositoryImpl(appDatabase);
    }

}
