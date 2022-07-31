package com.example.wiseone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuoteRecyclerAdapter extends RecyclerView.Adapter<QuoteViewHolder>{

    Context context;
    List<QuoteResponse> list;
    CopyListener listener;

    public QuoteRecyclerAdapter(Context context, List<QuoteResponse> list, CopyListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolder(LayoutInflater.from(context).inflate(R.layout.list_quote, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        holder.textQuote.setText(list.get(position).getText());
        holder.textAuthor.setText(list.get(position).getAuthor());
        holder.copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCopyClicked(list.get(holder.getAdapterPosition()).getText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class QuoteViewHolder extends RecyclerView.ViewHolder {

    TextView textQuote, textAuthor;
    Button copyButton;

    public QuoteViewHolder(@NonNull View itemView) {
        super(itemView);

        textQuote = itemView.findViewById(R.id.textQuote);
        textAuthor = itemView.findViewById(R.id.textAuthor);
        copyButton = itemView.findViewById(R.id.copyButton);

    }
}
