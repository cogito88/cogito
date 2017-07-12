package cogito.aristotle.practices.android_mvvm_noteapp.repository;

import android.arch.lifecycle.LiveData;

import org.threeten.bp.LocalDateTime;

import java.util.List;

import javax.inject.Inject;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.NoteDatabase;
import io.reactivex.Completable;

/**
 * Created by cogito88 on 7/12/17.
 */

public class NoteRepositoryImpl implements INoteRepository {

    @Inject
    NoteDatabase noteDatabase;

    public NoteRepositoryImpl(NoteDatabase noteDatabase) {
        this.noteDatabase = noteDatabase;
    }

    @Override
    public LiveData<List<Note>> getNotes() {
        return this.noteDatabase.noteDao().getNotes(LocalDateTime.now());
    }

    @Override
    public Completable addNote(Note note) {
        return Completable.fromAction(() -> noteDatabase.noteDao().addNote(note));
    }

    @Override
    public Completable deleteNote(Note note) {
        return Completable.fromAction(() -> noteDatabase.noteDao().deleteNote(note));
    }
}
