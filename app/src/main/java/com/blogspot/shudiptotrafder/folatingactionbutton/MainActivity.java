package com.blogspot.shudiptotrafder.folatingactionbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton main,people,school;
    Animation fabOpen,fabClose,fabRotate,fabRotateAntiClockWise;

    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //assign fab button
        main = (FloatingActionButton) findViewById(R.id.main_fab);
        people = (FloatingActionButton) findViewById(R.id.fab_people);
        school = (FloatingActionButton) findViewById(R.id.fab_school);

        //set animation
        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);
        fabRotate = AnimationUtils.loadAnimation(this,R.anim.rotate_clockwise);
        fabRotateAntiClockWise = AnimationUtils.loadAnimation(this,R.anim.rotate_anit_clockwise);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("Click", "click");

                if (isOpen){
                    people.setAnimation(fabClose);
                    school.setAnimation(fabClose);
                    main.setAnimation(fabRotateAntiClockWise);
                    people.setClickable(false);
                    school.setClickable(false);
                    people.setVisibility(View.GONE);
                    school.setVisibility(View.GONE);
                    isOpen = false;

                } else {
                    people.setVisibility(View.VISIBLE);
                    school.setVisibility(View.VISIBLE);
                    people.setAnimation(fabOpen);
                    school.setAnimation(fabOpen);
                    main.setAnimation(fabRotate);
                    people.setClickable(true);
                    school.setClickable(true);
                    people.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Welcome to people", Toast.LENGTH_SHORT).show();
                        }
                    });

                    school.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Welcome to school", Toast.LENGTH_SHORT).show();
                        }
                    });

                    isOpen = true;
                }
            }
        });

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
