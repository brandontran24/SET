package edu.ucsb.ece.ece150.pickture;
import java.util.Random;

import edu.ucsb.ece.ece150.pickture.Card;
import android.content.Context;


public class Deck {

    // Deck has-an array of Cards
    private Card[] deck;

    // Getter method
    public Card[] getDeck() {return deck;}

    // Generates deck of 81 cards
    public void populate(Card[] deck)
    {
        deck[0] = new Card( "clear", "blue", "oval", "1", R.drawable.cbo1, false);
        deck[1] = new Card( "clear", "blue", "oval", "2", R.drawable.cbo2, false);
        deck[2] = new Card( "clear", "blue", "oval", "3", R.drawable.cbo3, false);
        deck[3] = new Card( "clear", "blue", "rectangle", "1", R.drawable.cbr1, false);
        deck[4] = new Card( "clear", "blue", "rectangle", "2", R.drawable.cbr2, false);
        deck[5] = new Card( "clear", "blue", "rectangle", "3", R.drawable.cbr3, false);
        deck[6] = new Card( "clear", "blue", "triangle", "1", R.drawable.cbt1, false);
        deck[7] = new Card( "clear", "blue", "triangle", "2", R.drawable.cbt2, false);
        deck[8] = new Card( "clear", "blue", "triangle", "3", R.drawable.cbt3, false);
        deck[9] = new Card( "clear", "green", "oval", "1", R.drawable.cgo1, false);
        deck[10] = new Card( "clear", "green", "oval", "2", R.drawable.cgo2, false);
        deck[11] = new Card( "clear", "green", "oval", "3", R.drawable.cgo3, false);
        deck[12] = new Card( "clear", "green", "rectangle", "1", R.drawable.cgr1, false);
        deck[13] = new Card( "clear", "green", "rectangle", "2", R.drawable.cgr2, false);
        deck[14] = new Card( "clear", "green", "rectangle", "3", R.drawable.cgr3, false);
        deck[15] = new Card( "clear", "green", "triangle", "1", R.drawable.cgt1, false);
        deck[16] = new Card( "clear", "green", "triangle", "2", R.drawable.cgt2, false);
        deck[17] = new Card( "clear", "green", "triangle", "3", R.drawable.cgt3, false);
        deck[18] = new Card( "clear", "red", "oval", "1", R.drawable.cro1, false);
        deck[19] = new Card( "clear", "red", "oval", "2", R.drawable.cro2, false);
        deck[20] = new Card( "clear", "red", "oval", "3", R.drawable.cro3, false);
        deck[21] = new Card( "clear", "red", "rectangle", "1", R.drawable.crr1, false);
        deck[22] = new Card( "clear", "red", "rectangle", "2", R.drawable.crr2, false);
        deck[23] = new Card( "clear", "red", "rectangle", "3", R.drawable.crr3, false);
        deck[24] = new Card( "clear", "red", "triangle", "1", R.drawable.crt1, false);
        deck[25] = new Card( "clear", "red", "triangle", "2", R.drawable.crt2, false);
        deck[26] = new Card( "clear", "red", "triangle", "3", R.drawable.crt3, false);

        //fill
        deck[27] = new Card( "fill", "blue", "oval", "1", R.drawable.fbo1, false);
        deck[28] = new Card( "fill", "blue", "oval", "2", R.drawable.fbo2, false);
        deck[29] = new Card( "fill", "blue", "oval", "3", R.drawable.fbo3, false);
        deck[30] = new Card( "fill", "blue", "rectangle", "1", R.drawable.fbr1, false);
        deck[31] = new Card( "fill", "blue", "rectangle", "2", R.drawable.fbr2, false);
        deck[32] = new Card( "fill", "blue", "rectangle", "3", R.drawable.fbr3, false);
        deck[33] = new Card( "fill", "blue", "triangle", "1", R.drawable.fbt1, false);
        deck[34] = new Card( "fill", "blue", "triangle", "2", R.drawable.fbt2, false);
        deck[35] = new Card( "fill", "blue", "triangle", "3", R.drawable.fbt3, false);
        deck[36] = new Card( "fill", "green", "oval", "1", R.drawable.fgo1, false);
        deck[37] = new Card( "fill", "green", "oval", "2", R.drawable.fgo2, false);
        deck[38] = new Card( "fill", "green", "oval", "3", R.drawable.fgo3, false);
        deck[39] = new Card( "fill", "green", "rectangle", "1", R.drawable.fgr1, false);
        deck[40] = new Card( "fill", "green", "rectangle", "2", R.drawable.fgr2, false);
        deck[41] = new Card( "fill", "green", "rectangle", "3", R.drawable.fgr3, false);
        deck[42] = new Card( "fill", "green", "triangle", "1", R.drawable.fgt1, false);
        deck[43] = new Card( "fill", "green", "triangle", "2", R.drawable.fgt2, false);
        deck[44] = new Card( "fill", "green", "triangle", "3", R.drawable.fgt3, false);
        deck[45] = new Card( "fill", "red", "oval", "1", R.drawable.fro1, false);
        deck[46] = new Card( "fill", "red", "oval", "2", R.drawable.fro2, false);
        deck[47] = new Card( "fill", "red", "oval", "3", R.drawable.fro3, false);
        deck[48] = new Card( "fill", "red", "rectangle", "1", R.drawable.frr1, false);
        deck[49] = new Card( "fill", "red", "rectangle", "2", R.drawable.frr2, false);
        deck[50] = new Card( "fill", "red", "rectangle", "3", R.drawable.frr3, false);
        deck[51] = new Card( "fill", "red", "triangle", "1", R.drawable.frt1, false);
        deck[52] = new Card( "fill", "red", "triangle", "2", R.drawable.frt2, false);
        deck[53] = new Card( "fill", "red", "triangle", "3", R.drawable.frt3, false);


        //shade
        deck[54] = new Card( "shade", "blue", "oval", "1", R.drawable.sbo1, false);
        deck[55] = new Card( "shade", "blue", "oval", "2", R.drawable.sbo2, false);
        deck[56] = new Card( "shade", "blue", "oval", "3", R.drawable.sbo3, false);
        deck[57] = new Card( "shade", "blue", "rectangle", "1", R.drawable.sbr1, false);
        deck[58] = new Card( "shade", "blue", "rectangle", "2", R.drawable.sbr2, false);
        deck[59] = new Card( "shade", "blue", "rectangle", "3", R.drawable.sbr3, false);
        deck[60] = new Card( "shade", "blue", "triangle", "1", R.drawable.sbt1, false);
        deck[61] = new Card( "shade", "blue", "triangle", "2", R.drawable.sbt2, false);
        deck[62] = new Card( "shade", "blue", "triangle", "3", R.drawable.sbt3, false);
        deck[63] = new Card( "shade", "green", "oval", "1", R.drawable.sgo1, false);
        deck[64] = new Card( "shade", "green", "oval", "2", R.drawable.sgo2, false);
        deck[65] = new Card( "shade", "green", "oval", "3", R.drawable.sgo3, false);
        deck[66] = new Card( "shade", "green", "rectangle", "1", R.drawable.sgr1, false);
        deck[67] = new Card( "shade", "green", "rectangle", "2", R.drawable.sgr2, false);
        deck[68] = new Card( "shade", "green", "rectangle", "3", R.drawable.sgr3, false);
        deck[69] = new Card( "shade", "green", "triangle", "1", R.drawable.sgt1, false);
        deck[70] = new Card( "shade", "green", "triangle", "2", R.drawable.sgt2, false);
        deck[71] = new Card( "shade", "green", "triangle", "3", R.drawable.sgt3, false);
        deck[72] = new Card( "shade", "red", "oval", "1", R.drawable.sro1, false);
        deck[73] = new Card( "shade", "red", "oval", "2", R.drawable.sro2, false);
        deck[74] = new Card( "shade", "red", "oval", "3", R.drawable.sro3, false);
        deck[75] = new Card( "shade", "red", "rectangle", "1", R.drawable.srr1, false);
        deck[76] = new Card( "shade", "red", "rectangle", "2", R.drawable.srr2, false);
        deck[77] = new Card( "shade", "red", "rectangle", "3", R.drawable.srr3, false);
        deck[78] = new Card( "shade", "red", "triangle", "1", R.drawable.srt1, false);
        deck[79] = new Card( "shade", "red", "triangle", "2", R.drawable.srt2, false);
        deck[80] = new Card( "shade", "red", "triangle", "3", R.drawable.srt3, false);
    }


    // Constructor creates deck, populates, and shuffles
    public Deck()
    {
        this.deck = new Card[81];
        populate(this.deck);
    }

}
