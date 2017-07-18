package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.UserLoginViewModel;
import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.UserRegisterViewModel;
import dagger.Component;

/**
 * Created by cogito88 on 7/18/17.
 */

@SessionScope
@Component(dependencies = AppComponent.class, modules = UserModule.class)
public interface UserComponent {
    void inject(UserRegisterViewModel userRegisterViewModel);
    void inject(UserLoginViewModel userLoginViewModel);

    interface Injectable {
        void inject(UserComponent userComponent);
    }
}
