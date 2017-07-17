package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import javax.inject.Singleton;

import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.NoteAddViewModel;
import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.NoteListViewModel;
import dagger.Component;

/**
 * Created by cogito88 on 7/12/17.
 */

@Singleton
@Component(modules = {NoteModule.class})
public interface NoteComponent {
    void inject(NoteListViewModel noteListViewModel);
    void inject(NoteAddViewModel noteAddViewModel);

    interface Injectable {
        void inject(NoteComponent noteComponent);
    }
}
