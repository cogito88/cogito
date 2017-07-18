package cogito.aristotle.practices.android_mvvm_noteapp.repository;

import android.arch.lifecycle.LiveData;

import org.threeten.bp.LocalDateTime;

import java.util.List;

import javax.inject.Inject;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.AppDatabase;
import io.reactivex.Completable;

/**
 * Created by cogito88 on 7/12/17.
 */

public class NoteRepositoryImpl implements INoteRepository {

    @Inject
    AppDatabase appDatabase;

    public NoteRepositoryImpl(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public LiveData<List<Note>> getNotes() {
        return this.appDatabase.noteDao().getNotes(LocalDateTime.now());
    }

    @Override
    public Completable addNote(Note note) {
        return Completable.fromAction(() -> appDatabase.noteDao().addNote(note));
    }

    @Override
    public Completable deleteNote(Note note) {
        return Completable.fromAction(() -> appDatabase.noteDao().deleteNote(note));
    }
}
