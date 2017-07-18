package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import javax.inject.Singleton;

import cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db.AppDatabase;
import dagger.Component;

/**
 * Created by cogito88 on 7/17/17.
 */

@Singleton
@Component(modules = {AppModule.class, DbModule.class})
public interface AppComponent {
    AppDatabase providesNoteDatabase();
}
