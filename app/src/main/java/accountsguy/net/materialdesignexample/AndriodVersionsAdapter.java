package accountsguy.net.materialdesignexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by advic on 01/04/2018.
 */


public class AndriodVersionsAdapter extends RecyclerView.Adapter<AndriodVersionsAdapter.Holder> {

    private List<AndriodVersions> andriodVersionsList;
    Activity activity;
    AndriodVersions androiVersions;

    public AndriodVersionsAdapter(List<AndriodVersions> andriodVersionsList,
                                  AndriodVersionsActivity andriodVersionsActivity){
        this.andriodVersionsList = andriodVersionsList;
        activity = andriodVersionsActivity;
    }

    //When ever a new View created this method will be called.
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .activity_android_versions_view, parent, false);
        return new Holder(itemview);
    }

    // It will bind the data to view Holder.
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        AndriodVersions androiVersions = andriodVersionsList.get(position);
        holder.nameTextView.setText(androiVersions.CodeName);
        holder.versionTextView.setText(androiVersions.Version);

        Palette.PaletteAsyncListener paletteAsyncListener = new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Log.i("Adapter: ", "PaletteAsyncListener");
            }
        };

        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), (R.drawable.android_versions));
        if(bitmap!=null && !bitmap.isRecycled()){
            Palette.from(bitmap).generate(paletteAsyncListener);
        }

        Palette palette = Palette.generate(bitmap);
        int a = 0x000000;
        int vibrant = palette.getVibrantColor(a);
        int vibrantLight = palette.getLightVibrantColor(a);
        int vibrantDark = palette.getDarkVibrantColor(a);
        int muted = palette.getMutedColor(a);
        int mutedLight = palette.getLightMutedColor(a);
        int mutedDark = palette.getDarkMutedColor(a);
        int darkMutedColor = palette.getDarkMutedColor(a);


        holder.nameTextView.setTextColor(darkMutedColor);
        holder.versionTextView.setTextColor(darkMutedColor);
    }

    @Override
    public int getItemCount() {
        return andriodVersionsList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        protected TextView nameTextView, versionTextView;

        public Holder(View view){
            super(view);

            nameTextView = (TextView) view.findViewById(R.id.androidname);
            versionTextView = (TextView) view.findViewById(R.id.androidversion);
        }
    }
}
