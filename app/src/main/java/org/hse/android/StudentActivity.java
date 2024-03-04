package org.hse.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.MotionEffect;

import android.nfc.Tag;
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

public class StudentActivity extends AppCompatActivity {

    private final static String TAG = "StudentActivity";
    private TextView time;
    private TextView status;
    private TextView subject;
    private TextView cabinet;
    private TextView corp;
    private TextView teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

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

    static class Group {

        private Integer id;
        private String name;
        public Group(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        @Override
        public String toString() {
            return name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    private void initGroupList(List<Group> groups) {
        int k = 0;
        for (int i = 21; i < 24; i++)
            for (int j = 1; j < 4; j++){
                groups.add(new Group(k, "PI-" + i + "-" + j));
                k++;
            }
    }

    private void initTime() {
        Date currentTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", new Locale("ru", "RU"));
        timeFormat.setTimeZone(TimeZone.getTimeZone("GMT+5"));

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", new Locale("ru", "RU"));
        dayFormat.setTimeZone(TimeZone.getTimeZone("GMT+5"));

        String formattedTime = timeFormat.format(currentTime);
        String dayOfWeek = dayFormat.format(currentTime);

        String result = formattedTime + ", " + dayOfWeek;

        time.setText(result);
    }

    private void initData() {
        status.setText("Нет пар");
        subject.setText("Дисциплина");
        cabinet.setText("Кабинет");
        corp.setText("Корпус");
        teacher.setText("Преподаватель");
    }
}



