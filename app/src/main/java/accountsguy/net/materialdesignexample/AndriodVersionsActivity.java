package accountsguy.net.materialdesignexample;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AndriodVersionsActivity extends AppCompatActivity{

    FloatingActionButton floatingActionButton;
    RelativeLayout relativeLayout;
    int defaultColor;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    private Palette palette;


    private static final String[] ANDRIOD_CODE_NAME = new String[]{"Cupcake",
            "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly " +
            "Bean", "Kitkat", "Lollipop", "Marshmallow", "Nought", "Oreo", "Andriod P"};

    private static final String[] ANDRIOD_VERSION = new String[]{"1.5","1.6","2.0 - " +
            "2.1", "2.2 - 2.2.3", "2.3 - 2.3.7", "3.0 - 3.2.6", "4.0 - 4.0.4", "4.1 - 4.3.1", "4.4 – " +
            "4.4.4", "5.0 – 5.1.1", "6.0 – 6.0.1", "7.0 – 7.1.2", "8.0 – 8.1", "9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andriod_versions);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Android Versions");

        defaultColor = ContextCompat.getColor(getApplicationContext(), R.color.colorAccent);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingactionbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(relativeLayout, "I am a Snakbar", Snackbar
                        .LENGTH_LONG);
                snackbar.show();

                View snackBarView = snackbar.getView();
                snackBarView.setBackgroundColor(Color.GRAY);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclierview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        final List<AndriodVersions> versionsList = createList((ANDRIOD_CODE_NAME.length-1));

        AndriodVersionsAdapter andriodVersionsAdapter = new AndriodVersionsAdapter(versionsList,
                this);
        recyclerView.setAdapter(andriodVersionsAdapter);

        recyclerView.addOnItemTouchListener(new CustomRecyclierEvent(getApplicationContext(), new
                CustomRecyclierEvent.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), versionsList.get(position)
                        .CodeName,Toast
                        .LENGTH_LONG).show();
            }
        }));
        getPhoto();
    }

    private List<AndriodVersions> createList(int size){

        List<AndriodVersions> resultList = new ArrayList<>();
        for(int i = 0 ; i <= size ; i++){
            AndriodVersions andriodVersions = new AndriodVersions();
            andriodVersions.CodeName = "Andriod Version Name: "+ANDRIOD_CODE_NAME[i];
            andriodVersions.Version = "Andriod Version Code: "+ANDRIOD_VERSION[i];

            resultList.add(andriodVersions);
        }
        return resultList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_delete:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_search:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_settings:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getPhoto(){
        Bitmap photo = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        colorize(photo);
    }

    private void colorize(Bitmap photo){
        palette = Palette.generate(photo);
        applyPalette();
    }

    private void applyPalette() {
        getWindow().setBackgroundDrawable(new ColorDrawable(palette.getDarkVibrantColor(defaultColor)));
        recyclerView.setBackgroundColor(palette.getLightVibrantColor(defaultColor));
        toolbar.setBackgroundColor(palette.getMutedColor(defaultColor));
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(palette
                .getDarkVibrantColor(defaultColor)));
    }
}