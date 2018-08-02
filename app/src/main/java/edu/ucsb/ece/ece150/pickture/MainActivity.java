package edu.ucsb.ece.ece150.pickture;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.app.Activity;
import android.content.IntentSender;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/*
 * Whatever you do, remember: whatever gets the job done is a good first solution.
 * Then start to redo it, keeping the job done, but the solutions more and more elegant.
 *
 * Don't satisfy yourself with the first thing that comes out.
 * Dig through the documentation, read your error logs.
 */
public class MainActivity extends AppCompatActivity {
    public static final String LOCATION = "edu.ucsb.ece.ece150.pickture.SinglePlayer";
    SharedPreferences prefs;
    TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = this.getSharedPreferences("myprefs", MODE_PRIVATE);

        Button singlePlayerButton = (Button) findViewById(R.id.button5);

        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SinglePlayer.class);
                startActivity(intent);
            }
        });

        Button multiPlayerButton = (Button) findViewById(R.id.button4);

        multiPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MultiPlayer.class);
                startActivity(intent);
            }
        });

        Button rulesButton = (Button) findViewById(R.id.button3);

        rulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });

        scoreView = (TextView)findViewById(R.id.scoreView);
        SharedPreferences.Editor ed = prefs.edit();
        long highscore = prefs.getLong("HighScore", 9999);
        long currscore = prefs.getLong("currscore", 99999);
        scoreView.setText("HIGH SCORE: " + currscore);
        if(highscore < currscore) {
            ed.putLong("currscore", highscore);
            ed.commit();
            System.out.println("THE HIGH SCORE IS CURRENTLY:" + highscore);
            String score = String.format("%d", highscore);
            scoreView.setText("HIGH SCORE: " + score);
        }
    }
}

