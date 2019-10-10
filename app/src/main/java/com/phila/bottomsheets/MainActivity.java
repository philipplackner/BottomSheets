package com.phila.bottomsheets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout bottomSheet = findViewById(R.id.bottomSheet);
        LinearLayout llPeek = findViewById(R.id.llPeek);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        behavior.setHideable(true);

        llPeek.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        behavior.setPeekHeight(llPeek.getMeasuredHeight());

        findViewById(R.id.btnToggleBottomSheet)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(behavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
                            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        } else {
                            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        }
                    }
                });
    }
}
