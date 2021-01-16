package hr.dominik.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProgramiranjeAdapter extends ArrayAdapter<ProgramiranjeKnjige> {

    public ProgramiranjeAdapter(@NonNull Context context, ArrayList<ProgramiranjeKnjige> programiranjeKnjigeArrayList) {
        super(context, 0,programiranjeKnjigeArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item,parent,false);
        }
        ProgramiranjeKnjige programiranjeKnjige = getItem(position);

        TextView programiranjeText = listitemView.findViewById(R.id.naslovGridView);
        TextView pisacText = listitemView.findViewById(R.id.pisacGridView);
        TextView straniceText = listitemView.findViewById(R.id.straniceGridView);
        TextView godinaText = listitemView.findViewById(R.id.godineGridView);
        ImageView programiranjeSlika = listitemView.findViewById(R.id.slikaGridView);


        programiranjeText.setText(programiranjeKnjige.getImeKnjige());
        pisacText.setText(programiranjeKnjige.getPisac());
        straniceText.setText(programiranjeKnjige.getStranice());
        godinaText.setText(programiranjeKnjige.getGodina());
        programiranjeSlika.setImageResource(programiranjeKnjige.getSlika());
        return listitemView;
    }
}
