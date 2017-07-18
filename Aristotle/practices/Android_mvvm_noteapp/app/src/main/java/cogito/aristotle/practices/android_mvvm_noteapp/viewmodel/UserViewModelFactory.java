package cogito.aristotle.practices.android_mvvm_noteapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import cogito.aristotle.practices.android_mvvm_noteapp.MvvmNoteApplication;
import cogito.aristotle.practices.android_mvvm_noteapp.injection.UserComponent;

/**
 * Created by cogito88 on 7/18/17.
 */

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private MvvmNoteApplication application;

    public UserViewModelFactory(MvvmNoteApplication application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T userVM = super.create(modelClass);
        if (userVM instanceof UserComponent.Injectable) {
            ((UserComponent.Injectable)userVM).inject(application.getUserComponent());
        }
        return userVM;
    }
}
