package accountsguy.net.materialdesignexample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.fab_button);
        textView = (TextView) findViewById(R.id.textview);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_button:
                Intent cardIntent = new Intent(this, AndriodVersionsActivity.class);
                ActivityOptions transitionActivityOption = ActivityOptions
                        .makeSceneTransitionAnimation(this, textView, "Transitionfromtext");
                startActivity(cardIntent, transitionActivityOption.toBundle());
                return;
        }
    }
}
