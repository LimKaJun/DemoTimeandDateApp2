package sg.edu.rp.c346.id20026955.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker dp;
        TimePicker tp;
        Button btnDisplayDate;
        Button btnDisplayIime;
        TextView tvDisplay;
        Button btnReset;

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDate);
        btnDisplayIime = findViewById(R.id.buttonTime);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayIime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                if (min < 10){
                    tvDisplay.setText("Time is " + hour + ":0" + min);
                }else{
                    tvDisplay.setText("Time is " + hour + ":" + min);
                }
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dayOfMonth = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                tvDisplay.setText("Date is " + dayOfMonth +"/" +month +"/" +year);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,0,1);
                tvDisplay.setText("Date and time reset!");
            }
        });

    }
}