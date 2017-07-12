package cogito.aristotle.practices.android_mvvm_noteapp.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;
import io.reactivex.Completable;

/**
 * Created by cogito88 on 7/12/17.
 */

public interface INoteRepository {
    LiveData<List<Note>> getNotes();
    Completable addNote(Note note);
    Completable deleteNote(Note note);
}
