package com.example.a15017274.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvType;
    ArrayAdapter aa;
    ArrayList<Holidays> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvHoliday);
        tvType = (TextView) findViewById(R.id.tvType);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tvType.setText(type);

        holiday = new ArrayList<>();
        if(type.equals("secular")) {
            holiday.add(new Holidays("New Year's Day", "01 Jan 2017"));
            holiday.add(new Holidays("Labour Day", "1 May 2017"));

        } else if (type.equals("ethnic & religion")) {
            holiday.add(new Holidays("Chinese New Year", "28-29 Jan 2017"));
            holiday.add(new Holidays("Good Friday", "14 April 2017"));
        }

        aa = new HolidaysAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedYear = holiday.get(position);

                Toast.makeText(getBaseContext(), selectedYear.getName() + " Date: " + selectedYear.getDate(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
