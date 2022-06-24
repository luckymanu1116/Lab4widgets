package com.example.lab4widgets;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private TextView teamScoreRedTextView;
    private TextView teamScoreBlueTextView;

    private int incrementBy;
    private int teamRedScore;
    private int teamBlueScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamRedScore = 0;
        teamBlueScore = 0;

        //finding all the views by ids, refer to the xml page for the ids,
        //the names are self explanatory
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        teamScoreRedTextView = findViewById(R.id.team_score_red);
        teamScoreBlueTextView = findViewById(R.id.team_score_blue);

        teamScoreBlueTextView.setText(Integer.toString(teamBlueScore));
        teamScoreRedTextView.setText(Integer.toString(teamRedScore));

        Button upButtonRed = findViewById(R.id.buttonUp_red);
        Button downButtonRed = findViewById(R.id.buttonDown_red);
        Button upButtonBlue = findViewById(R.id.buttonUp_blue);
        Button downButtonBlue = findViewById(R.id.buttonDown_blue);

        //setting onClickListeners for these vie
        radioGroup.setOnCheckedChangeListener(this);
        upButtonRed.setOnClickListener(this);
        downButtonRed.setOnClickListener(this);
        upButtonBlue.setOnClickListener(this);
        downButtonBlue.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //selecting the increment value using the radio button
        switch (i){
            case 1:
                incrementBy = 1;
                break;
            case 2:
                incrementBy = 2;
                break;
            case 3:
                incrementBy = 3;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //according to the buttons clicked the respective functions are performed
        switch (id){
            case R.id.buttonUp_blue:
                teamBlueScore += incrementBy;
                teamScoreBlueTextView.setText(Integer.toString(teamBlueScore));
                break;
            case R.id.buttonDown_blue:
                teamBlueScore -= incrementBy;
                teamScoreBlueTextView.setText(Integer.toString(teamBlueScore));
                break;
            case R.id.buttonUp_red:
                teamRedScore += incrementBy;
                teamScoreRedTextView.setText(Integer.toString(teamRedScore));
                break;
            case R.id.buttonDown_red:
                teamRedScore -= incrementBy;
                teamScoreRedTextView.setText(Integer.toString(teamRedScore));
                break;
        }
    }
}