package com.example.android.final_projectlesson3;


import android.content.Context;
import android.content.DialogInterface;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int score;
    View view;
   private CheckBox checkBox1 ;
   private CheckBox checkBox2;
    private CheckBox checkBox3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1=(CheckBox) findViewById(R.id.radio_14);
        checkBox2=(CheckBox) findViewById(R.id.radio_24);
        checkBox3=(CheckBox) findViewById(R.id.radio_34);
        EditText answerE=(EditText) findViewById(R.id.edit);
        int myAnswers;
        try {
            myAnswers=Integer.parseInt(answerE.getText().toString());
            if(myAnswers==1907){
                score++;
            }
        }catch (NumberFormatException nfe){
            System.out.println("Could not parse " + nfe);
        }
        Button submit=(Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String MESSAGE="Your score is "+score+"/ "+4;
                if(score>=2){
                    MESSAGE=MESSAGE+"  :CONGRATULATION YOU PASSED";
                }else{
                    MESSAGE=MESSAGE+"  :Not enough,one more try!";
                }
                builder.setMessage(MESSAGE)
                        .setPositiveButton("Cool", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                        .setNegativeButton("", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                AlertDialog dialog = builder.create();
                dialog.show();
                //show toast
                Context context = getApplicationContext();
                CharSequence text = MESSAGE;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        Button reset=(Button) findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
            }
        });
    }

    /**
     *
     * @param view
     */
    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_1:
                if (checked)
                    score++;
                    break;
            case R.id.radio_2:
                if (checked)

                    break;
            case R.id.radio_3:
                if (checked)

                    break;
        }
    }

    /**
     *
     * @param view
     */

    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_13:
                if (checked)

                    break;
            case R.id.radio_23:
                if (checked)

                    break;
            case R.id.radio_33:
                if (checked)
                  score++;
                    break;
        }
    }

    /**
     *
     * @param
     */
    public void onRadioButtonClicked4(View view) {
                if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked()){
                    score++;
                }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("MyInt", score);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score=savedInstanceState.getInt("MyInt");
    }
}
