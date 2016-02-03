package ch.bullfin.bmstestapp;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mock the seat layout
        GridLayout rootLayout = (GridLayout) findViewById(R.id.root_view);
        for (int i = 0; i < 50; i++) {
            TextView textView = new TextView(this);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
            textView.setText(String.valueOf(i));
            textView.setBackgroundResource(R.drawable.seat_selector);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView tView = (TextView) view;
                    tView.setSelected(!tView.isSelected());

                    Toast.makeText(MainActivity.this, tView.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            int dp30 = dp(30);
            int dp5 = dp(5);

            GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
            lp.height = dp30;
            lp.width = dp30;
            lp.setMargins(dp5, dp5, dp5, dp5);
            rootLayout.addView(textView, lp);
        }

        // change the max zoom value
        ZoomView zoomView = (ZoomView) findViewById(R.id.zoomview);
        zoomView.setMaxZoom(5.0f);
    }

    private int dp(int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
