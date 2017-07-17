package cogito.aristotle.practices.android_mvvm_noteapp.ui.note_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import cogito.aristotle.practices.android_mvvm_noteapp.R;

/**
 * Created by cogito88 on 7/13/17.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder {
    TextView noteTitleTextView;
    TextView noteContentTextView;
    TextView noteRemainDateTextView;
    ImageButton noteDeleteImageButton;

    public NoteViewHolder(View itemView) {
        super(itemView);

        noteTitleTextView = (TextView) itemView.findViewById(R.id.tv_note_title);
        noteContentTextView = (TextView) itemView.findViewById(R.id.tv_note_content);
        noteRemainDateTextView = (TextView) itemView.findViewById(R.id.tv_note_remain_date);
        noteDeleteImageButton = (ImageButton) itemView.findViewById(R.id.imb_note_delete);
    }
}
