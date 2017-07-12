package cogito.aristotle.practices.android_mvvm_noteapp;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import cogito.aristotle.practices.android_mvvm_noteapp.injection.DaggerNoteComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.NoteComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.NoteModule;

/**
 * Created by cogito88 on 7/12/17.
 */

public class MvvmNoteApplication extends Application {
    private final NoteComponent noteComponent = createNoteComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }

    protected NoteComponent createNoteComponent() {
        return DaggerNoteComponent.builder()
                .noteModule(new NoteModule(this))
                .build();
    }

    public NoteComponent getNoteComponent() {
        return noteComponent;
    }
}
