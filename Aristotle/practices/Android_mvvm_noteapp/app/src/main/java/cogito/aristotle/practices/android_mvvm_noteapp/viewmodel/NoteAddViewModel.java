package cogito.aristotle.practices.android_mvvm_noteapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import org.threeten.bp.LocalDateTime;

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

public class NoteAddViewModel extends ViewModel implements NoteComponent.Injectable {
    private static final String NOTE_ADD_TAG = "NOTE_ADD";

    @Inject
    INoteRepository noteRepository;

    private String noteTitle;
    private String noteContent;
    private LocalDateTime noteDateTime;

    public NoteAddViewModel() {
        this.noteDateTime = LocalDateTime.now();
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public LocalDateTime getNoteDateTime() {
        return noteDateTime;
    }

    public void setNoteDateTime(LocalDateTime noteDateTime) {
        this.noteDateTime = noteDateTime;
    }

    @Override
    public void inject(NoteComponent noteComponent) {
        noteComponent.inject(this);
    }

    public void addNote() {
        Note note = new Note(0, noteTitle, noteContent, noteDateTime);
        noteRepository.addNote(note).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(NOTE_ADD_TAG, "add note complete");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(NOTE_ADD_TAG, "add note error: " + e.getMessage());
                    }
                });
    }
}
