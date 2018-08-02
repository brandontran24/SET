package edu.ucsb.ece.ece150.pickture;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.TestLooperManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.app.Activity;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Random;

import edu.ucsb.ece.ece150.pickture.Card;

public class MultiPlayer extends AppCompatActivity implements View.OnClickListener {

    Card[] checkCards = new Card[81];
    ImageView[] replaceViews = new ImageView[3];
    int[] selectedViewsTags = {0, 0, 0};
    int[] selectedViewsIds = {0, 0, 0};
    Card[] selectedCards = new Card[3];
    int count = 0;
    int dealtCards;
    boolean isSet;
    Deck deck = new Deck();
    int iterator;
    ImageView[] iViews = new ImageView[21];
    int cardsLeft;
    int score1 = 0;
    int score2 = 0;
    TextView timeView;
    TextView cardView;
    TextView scoreView1, scoreView2, winnerView1, winnerView2, scoreText1, scoreText2;
    TextView setView1, setView2, timeView1, timeView1count, timeView2, timeView2count;
    boolean set1select = false;
    boolean set2select = false;
    boolean scoreMade;
    long clickstart;
    long endstart;
    long start;
    int globalscore = 0;
    boolean endgame = false;
    Thread t;

    public boolean checkDeck(){
        int idx = 0;
        for(int i = 0; i < 81; i++)
        {
            checkCards[i] = null;
        }
        for(int i = 0; i < 81; i++){
            if(deck.getDeck()[i].getValid()){
                checkCards[idx] = deck.getDeck()[i];
                idx++;
            }
        }

        for(int i = 0; i < idx - 2; i++){
            for(int j = i+1; j < idx - 1; j++){
                for(int k = j+1; k < idx; k++){
                    if(validateSet(checkCards[i], checkCards[j], checkCards[k])){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Shuffles deck
    public void shuffle(Card[] deck, int lowbound)
    {
        // Swaps every card with a random card in the deck
        Random rand = new Random();
        for (int i = 80; i > lowbound; i--)
        {
            int j = (rand.nextInt(80 - lowbound)) + lowbound;
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    private void startClock(){
        t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(10);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar c = Calendar.getInstance();
                                long now = c.getTimeInMillis();
                                long diff = now-start;
                                long sec = diff/1000;

                                cardsLeft = 81-(dealtCards+1);
                                String curTime;
                                String scoreCount1 = String.format("        %d", score1);
                                String scoreCount2 = String.format("        %d", score2);
                                scoreView1.setText(scoreCount1);
                                scoreView2.setText(scoreCount2);

                                if(set1select){
                                    timeView1.setVisibility(View.VISIBLE);
                                    timeView1count.setVisibility(View.VISIBLE);
                                    diff = clickstart - now;
                                    sec = diff/1000;
                                    curTime = String.format("    %d.%d", sec, diff-(sec*1000));
                                    if(sec + (diff-(sec*1000)) > 0.00) {
                                        timeView1count.setText(curTime);
                                    }
                                    else{
                                        set1select = false;
                                        if(!scoreMade){
                                            if(score1 > 0) {
                                                score1--;
                                            }
                                        }
                                        timeView1.setVisibility(View.INVISIBLE);
                                        timeView1count.setVisibility(View.INVISIBLE);
                                        setView2.setAlpha((float)1.0);
                                        scoreText1.setAlpha((float)1.0);
                                        scoreView1.setAlpha((float)1.0);
                                        scoreText2.setAlpha((float)1.0);
                                        scoreView2.setAlpha((float)1.0);
                                    }
                                }
                                if(set2select){
                                    timeView2.setVisibility(View.VISIBLE);
                                    timeView2count.setVisibility(View.VISIBLE);
                                    diff = clickstart - now;
                                    sec = diff/1000;
                                    curTime = String.format("     %d.%d", sec, diff-(sec*1000));
                                    timeView2count.setText(curTime);
                                    if(sec + (diff-(sec*1000)) > 0.00) {
                                        timeView2count.setText(curTime);
                                    }
                                    else{
                                        set2select = false;
                                        if(!scoreMade){
                                            if(score2 > 0) {
                                                score2--;
                                            }
                                        }
                                        timeView2.setVisibility(View.INVISIBLE);
                                        timeView2count.setVisibility(View.INVISIBLE);
                                        setView1.setAlpha((float)1.0);
                                        scoreText1.setAlpha((float)1.0);
                                        scoreView1.setAlpha((float)1.0);
                                        scoreText2.setAlpha((float)1.0);
                                        scoreView2.setAlpha((float)1.0);
                                    }
                                }
                                if(endgame || !checkDeck()){
                                    diff = endstart - now;
                                    if(diff < 0)
                                    {
                                        t.interrupt();
                                    }
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Intent intent = new Intent(MultiPlayer.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        t.start();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.SET1){
            if(!set2select && !set1select) {
                set1select = true;
                setView2.setAlpha((float)0.2);
                scoreText2.setAlpha((float)0.2);
                scoreView2.setAlpha((float)0.2);
                Calendar c = Calendar.getInstance();
                clickstart = c.getTimeInMillis() + 2000;
            }
            return;
        }
        if(v.getId() == R.id.SET2){
            if(!set1select && !set2select) {
                set2select = true;
                setView1.setAlpha((float)0.2);
                scoreText1.setAlpha((float)0.2);
                scoreView1.setAlpha((float)0.2);
                Calendar c = Calendar.getInstance();
                clickstart = c.getTimeInMillis() + 2000;
            }
            return;
        }
        v.setAlpha((float)0.2);
        int tag = (Integer) v.getTag();
        if(tag != selectedViewsTags[0] && tag != selectedViewsTags[1] && tag != selectedViewsTags[2]){
            selectedViewsTags[count] = tag;
            selectedViewsIds[count] = v.getId();
            System.out.println(selectedViewsTags[0]);
            System.out.println(selectedViewsTags[1]);
            System.out.println(selectedViewsTags[2]);
            count++;
        }
        else{
            if(tag == selectedViewsTags[0]){
                selectedViewsTags[0] = selectedViewsTags[1];
                selectedViewsTags[1] = selectedViewsTags[2];
            }
            if(tag == selectedViewsTags[1]){
                selectedViewsTags[1] = selectedViewsTags[2];
            }
            v.setAlpha((float)1.0);
            count--;
        }

        if(count == 3){
            if(set1select || set2select) {
                validate();
            }
            else{
                reset();
            }
        }

    }

    public void validate(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 81; j++){
                if(deck.getDeck()[j].getDrawableID() == selectedViewsTags[i]){
                    deck.getDeck()[j].setSelected(true);
                }
            }
        }

        int idx = 0;
        for(int k = 0; k < 81; k++){
            if(deck.getDeck()[k].getSelected()){
                selectedCards[idx] = deck.getDeck()[k];
                idx++;
            }
        }

        isSet = validateSet(selectedCards[0], selectedCards[1], selectedCards[2]);

        if(isSet) {
            selectedCards[0].setValid(false);
            selectedCards[1].setValid(false);
            selectedCards[2].setValid(false);
            replaceViews[0] = (ImageView) this.findViewById(selectedViewsIds[0]);
            replaceViews[1] = (ImageView) this.findViewById(selectedViewsIds[1]);
            replaceViews[2] = (ImageView) this.findViewById(selectedViewsIds[2]);
            if(dealtCards == 80){
                for (int i = 1; i < 4; i++) {
                    replaceViews[i - 1].setVisibility(View.INVISIBLE);
                }
            }
            else {
                for (int i = 1; i < 4; i++) {
                    deck.getDeck()[dealtCards + i].setiView(replaceViews[i - 1]);
                    replaceViews[i - 1].setImageResource(deck.getDeck()[dealtCards + i].getDrawableID());
                    replaceViews[i - 1].setTag(deck.getDeck()[dealtCards + i].getDrawableID());
                }
                dealtCards += 3;
            }

            if(set1select) {
                score1++;
                scoreMade = true;
                set1select = false;
            }

            if(set2select) {
                score2++;
                scoreMade = true;
                set2select = false;
            }

            scoreMade = false;
            timeView2.setVisibility(View.INVISIBLE);
            timeView2count.setVisibility(View.INVISIBLE);
            setView1.setAlpha((float)1.0);
            timeView1.setVisibility(View.INVISIBLE);
            timeView1count.setVisibility(View.INVISIBLE);
            setView2.setAlpha((float)1.0);

            scoreText1.setAlpha((float)1.0);
            scoreView1.setAlpha((float)1.0);
            scoreText2.setAlpha((float)1.0);
            scoreView2.setAlpha((float)1.0);

            globalscore++;
            if(globalscore == 27) {
                if(score1 > score2){
                    winnerView1.setVisibility(View.VISIBLE);
                    winnerView2.setVisibility(View.INVISIBLE);
                }
                else if(score2 > score1){
                    winnerView2.setVisibility(View.VISIBLE);
                    winnerView1.setVisibility(View.INVISIBLE);
                }
                else{
                    winnerView2.setVisibility(View.VISIBLE);
                    winnerView1.setVisibility(View.VISIBLE);
                }
                endgame = true;
                Calendar c = Calendar.getInstance();
                endstart = c.getTimeInMillis() + 2500;
            }
        }
        else {
            if(set1select) {
                if(score1 > 0) {
                    score1--;
                }
                scoreMade = true;
                set1select = false;
            }

            if(set2select) {
                if(score2 > 0) {
                    score2--;
                }
                scoreMade = true;
                set2select = false;
            }

            scoreMade = false;
            timeView2.setVisibility(View.INVISIBLE);
            timeView2count.setVisibility(View.INVISIBLE);
            setView1.setAlpha((float)1.0);
            timeView1.setVisibility(View.INVISIBLE);
            timeView1count.setVisibility(View.INVISIBLE);
            setView2.setAlpha((float)1.0);

            scoreText1.setAlpha((float)1.0);
            scoreView1.setAlpha((float)1.0);
            scoreText2.setAlpha((float)1.0);
            scoreView2.setAlpha((float)1.0);
        }

        reset();
        clickListen();
    }

    public void clickListen(){
        for (int i = 0; i < 21; i++){
            iViews[i].setOnClickListener(this);
        }
        setView1.setOnClickListener(this);
        setView2.setOnClickListener(this);
    }

    public void reset(){
        replaceViews = new ImageView[3];
        selectedViewsTags[0] = 0;
        selectedViewsTags[1] = 0;
        selectedViewsTags[2] = 0;
        selectedViewsIds[0] = 0;
        selectedViewsIds[1] = 0;
        selectedViewsIds[2] = 0;
        selectedCards = new Card[3];
        count = 0;
        for(int k = 0; k < 81; k++) {
            deck.getDeck()[k].setSelected(false);
        }
        for(int i = 0; i < 21; i++){
            iViews[i].setAlpha((float)1.0);
        }
    }

    // Checks the logic (a == b == c) and (a != b != c != a)
    static boolean validateHelper(String a, String b, String c)
    {
        boolean res = false;

        if(a.equals(b) && b.equals(c))
        {
            res = true;
        }

        if(!(a.equals(b)) && !(b.equals(c)) && !(a.equals(c)))
        {
            res = true;
        }

        return res;
    }

    // A valid SET! is three cards where, for each trait, all three cards
    // share the same trait or are all exclusively different
    static boolean validateSet(Card a, Card b, Card c)
    {
        String x;
        String y;
        String z;

        // Texture Check
        x = a.getTexture();
        y = b.getTexture();
        z = c.getTexture();
        boolean textureCheck = validateHelper(x, y, z);

        // Color Check
        x = a.getColor();
        y = b.getColor();
        z = c.getColor();
        boolean colorCheck = validateHelper(x, y, z);

        // Shape Check
        x = a.getShape();
        y = b.getShape();
        z = c.getShape();
        boolean shapeCheck = validateHelper(x, y, z);

        // Count Check
        x = a.getCount();
        y = b.getCount();
        z = c.getCount();
        boolean countCheck = validateHelper(x, y, z);

        return (textureCheck && colorCheck && shapeCheck && countCheck);
    }

    static boolean isSet(Deck deck, int a, int b, int c)
    {
        return validateSet(deck.getDeck()[a],
                deck.getDeck()[b],
                deck.getDeck()[c]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
        Calendar c = Calendar.getInstance();
        start = c.getTimeInMillis();
        //shuffle(deck.getDeck(), 0);

        startClock();
        timeView = (TextView) this.findViewById(R.id.timercount);
        cardView = (TextView) this.findViewById(R.id.cardsleftcount);
        scoreView1 = (TextView) this.findViewById(R.id.scorecount1);
        scoreView2 = (TextView) this.findViewById(R.id.scorecount2);
        scoreText1 = (TextView) this.findViewById(R.id.score1);
        scoreText2 = (TextView) this.findViewById(R.id.score2);

        iViews[0] = (ImageView) this.findViewById(R.id.image_1);
        iViews[1] = (ImageView) this.findViewById(R.id.image_2);
        iViews[2] = (ImageView) this.findViewById(R.id.image_3);
        iViews[3] = (ImageView) this.findViewById(R.id.image_4);
        iViews[4] = (ImageView) this.findViewById(R.id.image_5);
        iViews[5] = (ImageView) this.findViewById(R.id.image_6);
        iViews[6] = (ImageView) this.findViewById(R.id.image_7);
        iViews[7] = (ImageView) this.findViewById(R.id.image_8);
        iViews[8] = (ImageView) this.findViewById(R.id.image_9);
        iViews[9] = (ImageView) this.findViewById(R.id.image_10);
        iViews[10] = (ImageView) this.findViewById(R.id.image_11);
        iViews[11] = (ImageView) this.findViewById(R.id.image_12);
        iViews[12] = (ImageView) this.findViewById(R.id.image_13);
        iViews[13] = (ImageView) this.findViewById(R.id.image_14);
        iViews[14] = (ImageView) this.findViewById(R.id.image_15);
        iViews[15] = (ImageView) this.findViewById(R.id.image_16);
        iViews[16] = (ImageView) this.findViewById(R.id.image_17);
        iViews[17] = (ImageView) this.findViewById(R.id.image_18);
        iViews[18] = (ImageView) this.findViewById(R.id.image_19);
        iViews[19] = (ImageView) this.findViewById(R.id.image_20);
        iViews[20] = (ImageView) this.findViewById(R.id.image_21);
        setView1 = (TextView) this.findViewById(R.id.SET1);
        setView2 = (TextView) this.findViewById(R.id.SET2);
        timeView1 = (TextView) this.findViewById(R.id.time1);
        timeView1count = (TextView) this.findViewById(R.id.time1count);
        timeView2 = (TextView) this.findViewById(R.id.time2);
        timeView2count = (TextView) this.findViewById(R.id.time2count);
        winnerView1 = (TextView) this.findViewById(R.id.winner1);
        winnerView2 = (TextView) this.findViewById(R.id.winner2);

        for (int i = 0; i < 21; i++) {
            deck.getDeck()[i].setiView(iViews[i]);
            iViews[i].setImageResource(deck.getDeck()[i].getDrawableID());
            iViews[i].setTag(deck.getDeck()[i].getDrawableID());
        }
        dealtCards = 20;

        for (int i = 0; i < 21; i++){
            iViews[i].setOnClickListener(this);
        }

        setView1.setOnClickListener(this);
        setView2.setOnClickListener(this);
        timeView1.setVisibility(View.INVISIBLE);
        timeView1count.setVisibility(View.INVISIBLE);
        timeView2.setVisibility(View.INVISIBLE);
        timeView2count.setVisibility(View.INVISIBLE);
        winnerView1.setVisibility(View.INVISIBLE);
        winnerView2.setVisibility(View.INVISIBLE);


    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }
}

