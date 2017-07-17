package cogito.aristotle.practices.android_mvvm_noteapp.ui.note_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cogito.aristotle.practices.android_mvvm_noteapp.R;
import cogito.aristotle.practices.android_mvvm_noteapp.entity.Note;

/**
 * Created by cogito88 on 7/13/17.
 */

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private final Context context;
    private List<Note> notes;
    private View.OnClickListener deleteClickListener;
    private View.OnClickListener viewClickListener;

    public NoteListAdapter(Context context, List<Note> notes,
                           View.OnClickListener deleteClickListener,
                           View.OnClickListener viewClickListener) {
        this.context = context;
        this.notes = notes;
        this.deleteClickListener = deleteClickListener;
        this.viewClickListener = viewClickListener;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                 .inflate(R.layout.view_note_item, parent, false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note item = notes.get(position);
        holder.noteTitleTextView.setText(item.getTitle());
        holder.noteContentTextView.setText(item.getContent());
        holder.noteRemainDateTextView.setText(context.getString(R.string.days_until, item.getDaysUntil()));
        holder.itemView.setTag(item);
        holder.noteDeleteImageButton.setTag(item);
        holder.noteDeleteImageButton.setOnClickListener(deleteClickListener);
        holder.itemView.setOnClickListener(viewClickListener);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setData(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }
}
