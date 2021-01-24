package hr.dominik.library.ListViewAdapter;

import android.annotation.SuppressLint;
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
    private final String imeKnjige;
    private final String autor;
    private final String posudio;
    private final String email;

    public MyHardverAdapter(Activity context,String imeKnjige,String autor,String posudio,String email) {
        super(context, R.layout.posudene_knjige_item);
        this.context = context;
        this.imeKnjige = imeKnjige;
        this.autor = autor;
        this.posudio = posudio;
        this.email = email;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.posudene_knjige_item,null,true);

        TextView imeKnjige = rowView.findViewById(R.id.imeKnjige);
        TextView autor = rowView.findViewById(R.id.autor);
        TextView posudio = rowView.findViewById(R.id.posudio);
        TextView email = rowView.findViewById(R.id.email);

        imeKnjige.setText((CharSequence) imeKnjige);
        autor.setText((CharSequence) autor);
        posudio.setText((CharSequence) posudio);
        email.setText((CharSequence) email);

        return rowView;
    }
}
