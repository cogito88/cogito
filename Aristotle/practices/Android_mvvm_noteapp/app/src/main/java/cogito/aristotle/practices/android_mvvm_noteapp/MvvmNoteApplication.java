package cogito.aristotle.practices.android_mvvm_noteapp;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import cogito.aristotle.practices.android_mvvm_noteapp.injection.AppComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.AppModule;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.DaggerAppComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.DaggerNoteComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.DaggerUserComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.DbModule;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.NoteComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.NoteModule;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.UserComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.UserModule;

/**
 * Created by cogito88 on 7/12/17.
 */

public class MvvmNoteApplication extends Application {
    private final AppComponent appComponent = createAppComponent();
    private final NoteComponent noteComponent = createNoteComponent();
    private final UserComponent userComponent = createUserComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }

    protected AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dbModule(new DbModule())
                .build();
    }

    protected UserComponent createUserComponent() {
        return DaggerUserComponent.builder()
                .appComponent(this.getAppComponent())
                .userModule(new UserModule())
                .build();
    }

    protected NoteComponent createNoteComponent() {
        return DaggerNoteComponent.builder()
                .appComponent(this.getAppComponent())
                .noteModule(new NoteModule())
                .build();
    }

    public AppComponent getAppComponent() { return appComponent; }

    public NoteComponent getNoteComponent() {
        return noteComponent;
    }

    public UserComponent getUserComponent() {return userComponent;}
}
