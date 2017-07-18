package cogito.aristotle.practices.android_mvvm_noteapp.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import cogito.aristotle.practices.android_mvvm_noteapp.MvvmNoteApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by cogito88 on 7/17/17.
 */

@Module
public class AppModule {
    private MvvmNoteApplication application;

    public AppModule(MvvmNoteApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context providesApplicationContext() { return application; }
}
