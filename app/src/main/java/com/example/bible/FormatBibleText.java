package com.example.bible;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class FormatBibleText {
    public static void format(@NonNull LinearLayout parentLayout) {
        int totalChapters = parentLayout.getChildCount();
        TextView textView;
        String text, wantedText, subText1, subText2, result;

        for (int i = 0; i < totalChapters; i++) {
            textView = (TextView) parentLayout.getChildAt(i);
            text = textView.getText().toString();

            wantedText = text.replaceAll("\\(.*?\\) ?", "");

            subText1 = wantedText.substring(0, 28);
            subText1 = subText1.replaceAll("(\\d+)", "$1\n\n");
            subText2 = wantedText.substring(28);
            subText2 = subText2.replaceAll("(\\d+)", "\n\n$1");
            result = subText1 + subText2;
            textView.setText(result);
        }
    }
}
