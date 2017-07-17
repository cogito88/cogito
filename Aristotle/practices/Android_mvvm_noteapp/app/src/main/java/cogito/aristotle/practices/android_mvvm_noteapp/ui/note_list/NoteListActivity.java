package cogito.aristotle.practices.android_mvvm_noteapp.ui.note_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cogito.aristotle.practices.android_mvvm_noteapp.R;

/**
 * Created by cogito88 on 7/13/17.
 */

public class NoteListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
    }
}
