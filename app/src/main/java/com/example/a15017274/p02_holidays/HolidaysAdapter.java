package com.example.a15017274.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017274 on 27/4/2017.
 */

public class HolidaysAdapter extends ArrayAdapter<Holidays> {

    private ArrayList<Holidays> holiday;
    private Context context;
    private TextView tvName, tvDate;
    private ImageView ivIcon;

    public HolidaysAdapter(Context context, int resource, ArrayList<Holidays> objects) {
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView)rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);


        Holidays currentHoliday = holiday.get(position);
        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());

        if (currentHoliday.getName().equalsIgnoreCase("New Year's Day")) {
            ivIcon.setImageResource(R.drawable.newyear);
        } else if (currentHoliday.getName().equalsIgnoreCase("Labour Day")) {
            ivIcon.setImageResource(R.drawable.labourday);
        } else if (currentHoliday.getName().equalsIgnoreCase("Chinese New Year")) {
            ivIcon.setImageResource(R.drawable.cny);
        } else if (currentHoliday.getName().equalsIgnoreCase("Good Friday")) {
            ivIcon.setImageResource(R.drawable.goodfriday);
        }

        return rowView;
    }

}

