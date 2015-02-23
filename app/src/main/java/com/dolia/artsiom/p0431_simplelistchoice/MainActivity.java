package com.dolia.artsiom.p0431_simplelistchoice;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    final String LOG_TAG = "myLog";
    ListView lvMain;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
          this, R.array.names, android.R.layout.simple_list_item_multiple_choice);

        lvMain.setAdapter(adapter);

        Button btnChecked = (Button) findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        names = getResources().getStringArray(R.array.names);
    }

    @Override
    public void onClick(View v){

        Log.d(LOG_TAG, "Checked: ");

        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();

        for(int i = 0; i < sbArray.size(); i++){

            int key = sbArray.keyAt(i);

            if (sbArray.get(key)){

                Log.d(LOG_TAG, names[key]);
            }
        }
    }
}
