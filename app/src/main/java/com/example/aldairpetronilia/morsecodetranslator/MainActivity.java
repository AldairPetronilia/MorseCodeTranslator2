package com.example.aldairpetronilia.morsecodetranslator;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, Character> characterHashMap = new HashMap<String, Character>();

    public void convertText (View view){
        EditText inputEditText = (EditText)findViewById(R.id.inputEditText);
        TextView outputTextView = (TextView) findViewById(R.id.outputTextView);
        String input = inputEditText.getText().toString();
        outputTextView.setText(convertToMorseCode(input));


    }

    private String convertToMorseCode(String input) {
        String translation = "";
        for (int i =0; i < input.length(); i++) {
            if (input.charAt(i) == ' ' ) {
                translation = translation + "/" + " ";
            } else {
                translation = translation + characterHashMap.get(String.valueOf(input.charAt(i)).toUpperCase()).getMorseCodeTranslation() + " ";
            }
        }
        return translation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadCharacterHashmap();

    }

    private void loadCharacterHashmap() {
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        try {
            inputStream = assetManager.open("Morse Code Alphabet");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String nextLine = null;
            while (( nextLine = bufferedReader.readLine()) != null) {
                characterHashMap.put(nextLine.substring(0,1), new Character(nextLine.substring(0,1),nextLine.substring(2)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
