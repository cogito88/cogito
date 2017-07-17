package cogito.aristotle.practices.android_mvvm_noteapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.NoteComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.INoteRepository;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cogito88 on 7/13/17.
 */

public class NoteListViewModel extends ViewModel implements NoteComponent.Injectable {
    private static final String DELETE_NOTE_TAG = "NOTE_DELETE";
    @Inject
    INoteRepository noteRepository;
    private LiveData<List<Note>> notes = new MutableLiveData<>();

    @Override
    public void inject(NoteComponent noteComponent) {
        noteComponent.inject(this);
        notes = noteRepository.getNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void deleteNote(Note note) {
        noteRepository.deleteNote(note)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(DELETE_NOTE_TAG, "delete note compelte");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(DELETE_NOTE_TAG, "onError: " + e.getMessage());
                    }
                });
    }
}
