package edu.ucsb.ece.ece150.pickture;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
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

public class RulesActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(Html.fromHtml("<h1>RULES:</h1>\n" +
                "<p>The objective of the game is to identify a <span style=\"color: #000000;\"><strong>SET</strong></span> of three cards from the 21 cards laid out.&nbsp;</p>\n" +
                "<p>Each card has a variation of the following four features:</p>\n" +
                "<p><span style=\"color: #339966;\"><strong>COLOR</strong>:</span> Each card is red, blue, or green.</p>\n" +
                "<p><span style=\"color: #339966;\"><strong>SYMBOL</strong></span>: Each card contains rectangles, triangles, or ovals.</p>\n" +
                "<p><span style=\"color: #339966;\"><strong>NUMBER</strong></span>: Each card has one, two, or three symbols.</p>\n" +
                "<p><span style=\"color: #339966;\"><strong>SHADING</strong></span>: Each card is solid, open or shaded.</p>\n" +
                "<p>A <strong>SET</strong> consists of three cards in which each feature is <em>EITHER</em> the same on each card <em>OR</em> is different on each card.</p>\n" +
                "<p><span style=\"color: #0000ff;\"><strong>Single Player:</strong></span></p>\n" +
                "<p>The objective is to find all possible <strong>SETs</strong> and run through the deck of 81 cards as quickly as possible.</p>\n" +
                "<p><span style=\"color: #ff0000;\"><strong>Multiplayer:</strong></span></p>\n" +
                "<p>You and another player will sit across from each other sharing the mobile device. When someone finds a <strong>SET</strong>, they will click the <span style=\"color: #000000;\"><strong>SET</strong></span> button on their respective side and a timer will count down. They have a limited amount of time to claim a <strong>SET</strong>. If they don't claim one in time or what they click is incorrect, their score will decrease by 1. Every correct <strong>SET</strong> will add 1 to their score. This will continue until all 81 cards are gone or there are no more <strong>SETs</strong> possible.</p>"));
        text.setMovementMethod(new ScrollingMovementMethod());
    }
}