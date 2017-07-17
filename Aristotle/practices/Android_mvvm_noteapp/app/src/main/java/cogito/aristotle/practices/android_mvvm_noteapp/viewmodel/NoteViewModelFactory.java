package cogito.aristotle.practices.android_mvvm_noteapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import cogito.aristotle.practices.android_mvvm_noteapp.MvvmNoteApplication;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.NoteComponent;

/**
 * Created by cogito88 on 7/13/17.
 */

public class NoteViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private MvvmNoteApplication application;

    public NoteViewModelFactory(MvvmNoteApplication application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T t = super.create(modelClass);
        if(t instanceof NoteComponent.Injectable) {
            ((NoteComponent.Injectable) t).inject(application.getNoteComponent());
        }
        return t;
    }
}
