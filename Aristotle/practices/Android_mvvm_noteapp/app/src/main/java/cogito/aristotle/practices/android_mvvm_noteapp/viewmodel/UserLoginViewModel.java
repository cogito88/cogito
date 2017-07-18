package cogito.aristotle.practices.android_mvvm_noteapp.viewmodel;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cogito.aristotle.practices.android_mvvm_noteapp.injection.UserComponent;
import cogito.aristotle.practices.android_mvvm_noteapp.repository.IUserRepository;

/**
 * Created by cogito88 on 7/18/17.
 */

public class UserLoginViewModel extends ViewModel implements UserComponent.Injectable {
    @Inject
    IUserRepository userRepository;

    @Override
    public void inject(UserComponent userComponent) {
        userComponent.inject(this);
    }
}
