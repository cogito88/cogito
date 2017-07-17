package cogito.aristotle.practices.android_mvvm_noteapp.ui.note_list;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import cogito.aristotle.practices.android_mvvm_noteapp.MvvmNoteApplication;
import cogito.aristotle.practices.android_mvvm_noteapp.R;
import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;
import cogito.aristotle.practices.android_mvvm_noteapp.ui.note_add.NoteAddActivity;
import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.NoteListViewModel;
import cogito.aristotle.practices.android_mvvm_noteapp.viewmodel.NoteViewModelFactory;

/**
 * Created by cogito88 on 7/13/17.
 */

public class NoteListFragment extends LifecycleFragment {
    private NoteListViewModel noteListViewModel;
    private NoteListAdapter noteListAdapter;
    private View.OnClickListener deleteNoteClickListener = v -> {
        Note note = (Note) v.getTag();
        noteListViewModel.deleteNote(note);
    };
    private View.OnClickListener noteItemClickListener = v -> {
        Note note = (Note) v.getTag();
        Toast.makeText(getContext(), "Clicked: " + note.getTitle(), Toast.LENGTH_SHORT).show();
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_list, container, false);
        setupRecyclerView(v);
        setupAddFloatingActionButton(v);
        setupViewModel(v);
        return v;
    }

    private void setupRecyclerView(View v) {
        RecyclerView noteListRV = (RecyclerView) v.findViewById(R.id.recycler_view_notes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        noteListRV.setLayoutManager(layoutManager);
        noteListAdapter = new NoteListAdapter(getContext(), new ArrayList<>(),
                                              deleteNoteClickListener, noteItemClickListener);
        noteListRV.setAdapter(noteListAdapter);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(noteListRV.getContext(),
                layoutManager.getOrientation());
        noteListRV.addItemDecoration(dividerItemDecoration);
    }

    private void setupAddFloatingActionButton(View v) {
        FloatingActionButton fabAddNote = (FloatingActionButton) v.findViewById(R.id.fab_add);
        fabAddNote.setOnClickListener(v1 -> startActivity(new Intent(getContext(), NoteAddActivity.class)));
    }

    private void setupViewModel(View v) {
        MvvmNoteApplication application = (MvvmNoteApplication) getActivity().getApplication();
        noteListViewModel = ViewModelProviders.of(this, new NoteViewModelFactory(application)).get(NoteListViewModel.class);
        noteListViewModel.getNotes().observe(this, notes -> {
            Log.d("NOTE_CHANGED", "update note");
            noteListAdapter.setData(notes);
        });
    }
}
