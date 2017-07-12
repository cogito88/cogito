package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import cogito.aristotle.practices.android_mvvm_noteapp.MvvmNoteApplication;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.INoteRepository;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.NoteRepositoryImpl;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.NoteDatabase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by cogito88 on 7/12/17.
 */

@Module
public class NoteModule {
    private MvvmNoteApplication noteApplication;

    public NoteModule(MvvmNoteApplication noteApplication) {
        this.noteApplication = noteApplication;
    }

    @Provides
    Context applicationContext() { return noteApplication; }

    @Provides
    @Singleton
    INoteRepository providesINoteRepository(NoteDatabase noteDatabase) {
        return new NoteRepositoryImpl(noteDatabase);
    }

    @Provides
    @Singleton
    NoteDatabase providesNoteDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_db").build();
    }

}
