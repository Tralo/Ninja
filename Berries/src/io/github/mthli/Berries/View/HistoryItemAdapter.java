package io.github.mthli.Berries.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.github.curioustechizen.ago.RelativeTimeTextView;
import io.github.mthli.Berries.Database.Record;
import io.github.mthli.Berries.R;

import java.util.List;

public class HistoryItemAdapter extends ArrayAdapter<Record> {
    private Context context;
    private int layoutResId;
    private List<Record> list;

    public HistoryItemAdapter(Context context, int layoutResId, List<Record> list) {
        super(context, layoutResId, list);

        this.context = context;
        this.layoutResId = layoutResId;
        this.list = list;
    }

    class Holder {
        TextView title;
        TextView url;
        RelativeTimeTextView time;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        Holder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(layoutResId, viewGroup, false);

            holder = new Holder();
            holder.title = (TextView) view.findViewById(R.id.history_item_title);
            holder.url = (TextView) view.findViewById(R.id.history_item_url);
            holder.time = (RelativeTimeTextView) view.findViewById(R.id.history_item_time);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        Record record = list.get(position);
        holder.title.setText(record.getTitle());
        holder.url.setText(record.getURL());
        holder.time.setReferenceTime(record.getTime());

        return view;
    }
}