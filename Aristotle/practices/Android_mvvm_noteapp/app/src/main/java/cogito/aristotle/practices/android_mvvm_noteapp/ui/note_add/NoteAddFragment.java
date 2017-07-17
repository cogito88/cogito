package cogito.aristotle.practices.android_mvvm_noteapp.ui.note_add;

import android.app.DatePickerDialog;
import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.threeten.bp.LocalDateTime;

import cogito.aristotle.practices.android_mvvm_noteapp.MvvmNoteApplication;
import cogito.aristotle.practices.android_mvvm_noteapp.R;
import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.NoteAddViewModel;
import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.NoteViewModelFactory;

/**
 * Created by cogito88 on 7/13/17.
 */

public class NoteAddFragment extends LifecycleFragment implements DatePickerDialog.OnDateSetListener {
    private NoteAddViewModel noteAddViewModel;
    private EditText edtNoteTitle;
    private EditText edtNoteContent;
    private TextView tvNoteDate;
    private Button btSetDate;
    private Button btAddNote;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteAddViewModel = ViewModelProviders.of(this, new NoteViewModelFactory((MvvmNoteApplication) getActivity().getApplication()))
                                             .get(NoteAddViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_add, container, false);
        setupViews(v);
        setupEvents();
        setupData();
        return v;
    }

    public void setupViews(View v) {
        this.edtNoteTitle = (EditText) v.findViewById(R.id.edt_note_title);
        this.edtNoteContent = (EditText) v.findViewById(R.id.edt_note_content);
        this.tvNoteDate = (TextView) v.findViewById(R.id.tv_note_date);
        this.btSetDate = (Button) v.findViewById(R.id.bt_set_date);
        this.btAddNote = (Button) v.findViewById(R.id.bt_add_note);
    }

    public void setupEvents() {
        this.edtNoteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                noteAddViewModel.setNoteTitle(editable.toString());
            }
        });

        this.edtNoteContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                noteAddViewModel.setNoteContent(editable.toString());
            }
        });

        this.btSetDate.setOnClickListener(v -> {
            LocalDateTime localDateTime = noteAddViewModel.getNoteDateTime();
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this,
                                                localDateTime.getYear(),
                                                localDateTime.getMonthValue() - 1,
                                                localDateTime.getDayOfMonth());
            datePickerDialog.show();

        });

        this.btAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteAddViewModel.addNote();
                getActivity().finish();
            }
        });
    }

    public void setupData() {
        edtNoteTitle.setText(noteAddViewModel.getNoteTitle());
        edtNoteContent.setText(noteAddViewModel.getNoteContent());
        tvNoteDate.setText(noteAddViewModel.getNoteDateTime().toString());
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        noteAddViewModel.setNoteDateTime(LocalDateTime.of(year, month + 1, dayOfMonth, 0, 0));
        tvNoteDate.setText(noteAddViewModel.getNoteDateTime().toString());
    }
}
