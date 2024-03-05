package org.hse.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.MotionEffect;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class TeacherActivity extends AppCompatActivity {

    private final static String TAG = "TeacherActivity";
    private TextView time;
    private TextView status;
    private TextView subject;
    private TextView cabinet;
    private TextView corp;
    private TextView teacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        final Spinner spinner = findViewById(R.id.groupList);

        List<Group> groups = new ArrayList<>();
        initGroupList(groups);

        ArrayAdapter<?> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, groups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                Object item = adapter.getItem(selectedItemPosition);
                Log.d(TAG, "selectedItem: " + item);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        time = findViewById(R.id.time);
        initTime();

        status = findViewById(R.id.status);
        subject = findViewById(R.id.subject);
        cabinet = findViewById(R.id.cabinet);
        corp = findViewById(R.id.corp);
        teacher = findViewById(R.id.teacher);

        initData();
    }


    private void initGroupList(List<Group> groups) {
        groups.add(new Group(1,"Преподаватель 1"));
        groups.add(new Group(2,"Преподаватель 2"));
    }

    private void initTime() {
        Date currentTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", new Locale("ru", "RU"));
        timeFormat.setTimeZone(TimeZone.getTimeZone("GMT+5"));

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", new Locale("ru", "RU"));
        dayFormat.setTimeZone(TimeZone.getTimeZone("GMT+5"));

        String formattedTime = timeFormat.format(currentTime);
        String dayOfWeek = dayFormat.format(currentTime);

        String result = formattedTime + ", " + Character.toUpperCase(dayOfWeek.charAt(0)) + dayOfWeek.substring(1);;

        time.setText(result);
    }

    private void initData() {
        status.setText(R.string.status_base);
        subject.setText(R.string.subject_base);
        cabinet.setText(R.string.cabinet_base);
        corp.setText(R.string.corp_base);
        teacher.setText(R.string.teacher_base);
    }
}