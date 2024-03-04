package org.hse.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonStSchedule = findViewById(R.id.button_students_schedule);
        Button buttonTeSchedule = findViewById(R.id.button_teachers_schedule);

//        buttonStSchedule.setOnClickListener(v -> {
//            Toast.makeText(MainActivity2.this, R.string.button_st_schedule_text, Toast.LENGTH_SHORT).show();
//        });
//
//        buttonTeSchedule.setOnClickListener(v -> {
//            Toast.makeText(MainActivity2.this, R.string.button_te_schedule_text, Toast.LENGTH_SHORT).show();
//        });

        buttonStSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStudent();
            }
        });

        buttonTeSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTeacher();
            }
        });
    }

    private void showStudent() {
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }

    private void showTeacher() {
        Intent intent = new Intent(this, TeacherActivity.class);
        startActivity(intent);
    }
}