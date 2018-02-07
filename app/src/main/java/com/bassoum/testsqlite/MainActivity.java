package com.bassoum.testsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView scoreView;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreView = (TextView) findViewById(R.id.scoreView);
        databaseManager= new DatabaseManager(this);

        databaseManager.insertScore("malick", 1000);
        databaseManager.insertScore("daff", 9000);
        databaseManager.insertScore("max", 7000);
        databaseManager.insertScore("jules", 500);
        databaseManager.insertScore("ramata", 3400);

        List<ScoreData> scores=databaseManager.readTop10();
        for (ScoreData score : scores){
            scoreView.append(score.toString() + "\n\n");
        }

        databaseManager.close();

    }
}
