package com.anti1991.hangman;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity
{

    String word = "WORD";

    int mFailCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Retrieving the letter from the edit text
     * @param v (button clicked)
     */
    public void introduceLetter(View v)
    {

        EditText myEdit = (EditText) findViewById(R.id.insertedLetter);

        String letterInserted = myEdit.getText().toString();

        if(letterInserted.length() > 0)
            checkLetter(letterInserted);
        else //Toast to show message as a pop up.
            Toast.makeText(this, "Please introduce a Letter", Toast.LENGTH_SHORT).show();
    }

    /**
     * checks the inputted letter against the word
     * @param letter
     */
    public void checkLetter(String letter)
    {
        boolean letterFound = false;
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == letter.charAt(0))
            {
                showLetterAtIndex(i,letter.charAt(0));
                letterFound = true;

            }
        }


        if(!letterFound)
        {
            letterFailed();
        }

    }

    public void letterFailed()
    {
        mFailCounter++;

        ImageView image = (ImageView) findViewById(R.id.imageView);

        switch(mFailCounter)
        {
            case 1:
                image.setImageResource(R.drawable.hangdroid_1);
                break;
            case 2:
                image.setImageResource(R.drawable.hangdroid_2);
                break;
            case 3:
                image.setImageResource(R.drawable.hangdroid_3);
                break;
            case 4:
                image.setImageResource(R.drawable.hangdroid_4);
                break;
            case 5:
                image.setImageResource(R.drawable.hangdroid_5);
                break;
            default:
                break;
        }

    }


    public void showLetterAtIndex(int position, char letterGuessed)
    {
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.letterLayout);

        TextView text = (TextView) layoutLetter.getChildAt(position);

        text.setText(Character.toString(letterGuessed));

    }
}
