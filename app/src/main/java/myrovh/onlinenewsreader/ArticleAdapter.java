package myrovh.onlinenewsreader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private static OnItemClickListener listener;
    private ArrayList<Article> data = new ArrayList<>();

    public ArticleAdapter(ArrayList<Article> inputData) {
        data = inputData;
        listener = null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_article, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleView.setText(data.get(position).getTitle());
        holder.descriptionView.setText(data.get(position).getDescription());
        Picasso.with(holder.itemView.getContext()).load(data.get(position).getThumbnailUrl()).fit().centerCrop().into(holder.thumbnailView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener inListener) {
        listener = inListener;
    }

    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    //Define ViewHolder for Adapter
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView descriptionView;
        private final ImageView thumbnailView;

        public ViewHolder(View v) {
            super(v);
            titleView = (TextView) v.findViewById(R.id.titleView);
            descriptionView = (TextView) v.findViewById(R.id.descriptionView);
            thumbnailView = (ImageView) v.findViewById(R.id.thumbnailView);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(v, getLayoutPosition());
                    }
                }
            });
        }
    }
}
