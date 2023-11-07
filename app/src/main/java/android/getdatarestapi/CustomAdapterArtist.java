package android.getdatarestapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CustomAdapterArtist extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Artist>lsData = new ArrayList<>();

    public CustomAdapterArtist(@NonNull Context context, int resource, ArrayList<Artist>lsData) {
        super(context, resource, lsData);
        this.context=context;
        this.resource=resource;
        this.lsData=lsData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Artist artist = lsData.get(position);
        if(convertView==null)
            convertView= LayoutInflater.from(context).inflate(resource,null);

        ImageView imgArtist = (ImageView) convertView.findViewById(R.id.imgArtist);
        Picasso.with(context).load(artist.getPictureLink()).
                resize(100,100).into(imgArtist);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(artist.getName());

        TextView tvNumFans = (TextView) convertView.findViewById(R.id.tvNumFans);
        tvNumFans.setText(artist.getNumberFans());
        return convertView;

    }
}
