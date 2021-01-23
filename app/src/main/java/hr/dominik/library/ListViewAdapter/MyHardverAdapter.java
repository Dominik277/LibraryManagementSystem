package hr.dominik.library.ListViewAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import hr.dominik.library.R;

public class MyHardverAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String name;
    private final String author;
    private final String ime;
    private final String email;

    public MyHardverAdapter(Activity context,String name, String author, String ime, String email) {
        super(context, R.layout.posudene_knjige_item);
        this.context = context;
        this.name = name;
        this.author = author;
        this.ime = ime;
        this.email = email;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.posudene_knjige_item,null,true);

        TextView imeKnjige = (TextView)rowView.findViewById(R.id.imeKnjige);
        TextView autorKnjige = (TextView)rowView.findViewById(R.id.autor);
        TextView posudio = (TextView)rowView.findViewById(R.id.posudio);
        TextView email = (TextView)rowView.findViewById(R.id.email);

        imeKnjige.setText(name);
        autorKnjige.setText(author);
        posudio.setText(ime);
        email.setText((CharSequence) email);

        return rowView;
    }

}
