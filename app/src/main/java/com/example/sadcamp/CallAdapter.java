package com.example.sadcamp;


import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;



import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ContactData> contactList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView emailView;
        private final CircleImageView imgView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nameView = (TextView) view.findViewById(R.id.name);
            emailView = (TextView) view.findViewById(R.id.email);
            imgView = (CircleImageView) view.findViewById(R.id.imageview);
        }

        public TextView getNameView() {
            return nameView;
        }

        public TextView getEmailView() {
            return emailView;
        }

        public CircleImageView getImgView() {
            return imgView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CallAdapter(Context context, ArrayList<ContactData> dataSet) {
        this.context = context;
        this.contactList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getNameView().setText(contactList.get(position).getName());
        viewHolder.getEmailView().setText(contactList.get(position).getMail());
        viewHolder.getImgView().setImageResource(contactList.get(position).getPic());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewHolder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    ContactData contactData = contactList.get(pos); // 'position'을 'pos'로 변경
                    Gson gson = new Gson();
                    String jsonContactData = gson.toJson(contactData);

                    // Create and show a Dialog with the JSON contact data
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Contact Information")
                            .setMessage(jsonContactData)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
