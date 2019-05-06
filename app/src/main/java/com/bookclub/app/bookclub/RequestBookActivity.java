package com.bookclub.app.bookclub;

import android.content.Context;

import android.graphics.Bitmap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.bookclub.app.bookclub.bookclubapi.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RequestBookActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<RequestBookListItem> requestBookListItems;
    SearchView searchBar;
    ImageButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_book);
        searchBar = findViewById(R.id.searchBar);
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SearchBookTask(searchBar.getQuery().toString()).execute();
            }
        });

    }



    public static class ViewHolder{
        TextView author, bookTitle;
        ImageButton bookImage, wishButton;
        CardView cardView;
    }

    public class RequestBookListAdapter extends ArrayAdapter<RequestBookListItem>{

        Animation scaleUp;


        public RequestBookListAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Nullable
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final RequestBookListItem requestBookListItem= getItem(position);
            ViewHolder viewHolder;

            final View result;
            Bitmap bitmap = null;
            if (convertView == null){
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.request_book_list_item, parent, false);
                viewHolder.cardView = convertView.findViewById(R.id.pad);
                viewHolder.author = convertView.findViewById(R.id.authorName);
                viewHolder.bookTitle = convertView.findViewById(R.id.bookTitle);
                viewHolder.bookImage = convertView.findViewById(R.id.bookImage);
                viewHolder.wishButton = convertView.findViewById(R.id.wishButton);
                result = convertView;
                convertView.setTag(viewHolder);

            }
            else{
                viewHolder = (ViewHolder)convertView.getTag();
                result = convertView;
            }

            Picasso.get()
                    .load(requestBookListItem.getBook().getBookPhotoUrl())
                    .resize(300, 400)
                    .error(R.drawable.book)
                    .placeholder(R.drawable.book)
                    .into(viewHolder.bookImage);
            System.out.println(requestBookListItem.getBook().getBookPhotoUrl());

            viewHolder.author.setText(requestBookListItem.getBook().getAuthorName());
            viewHolder.bookTitle.setText(requestBookListItem.getBook().getTitle());


            viewHolder.wishButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO wish operation
                    new WishBookTask(requestBookListItem.getBook()).execute();
                }
            });

          //  viewHolder.cardView.startAnimation(scaleUp);

            return convertView;

        }


        @Override
        public int getCount() {
            return requestBookListItems.size();
        }
    }

    public class RequestBookListItem{

        Book book;

        public RequestBookListItem(Book book) {
            this.book = book;
        }

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }
    }

    public class SearchBookTask extends AsyncTask<Void, Void, Void>{

        String query;

        public SearchBookTask(String query) {
            this.query = query;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

    public class WishBookTask extends AsyncTask<Void, Void, Void>{

        Book book;

        public WishBookTask(Book book) {
            this.book = book;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }


}
