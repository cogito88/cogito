package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cogito88 on 7/12/17.
 */

@Singleton
@Component(modules = {NoteModule.class})
public interface NoteComponent {

}
