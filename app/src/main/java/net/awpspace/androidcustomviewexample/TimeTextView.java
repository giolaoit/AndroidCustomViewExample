package net.awpspace.androidcustomviewexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 26-Jul-15.
 */
public class TimeTextView extends TextView {

    private int duration;

    public TimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TimeTextView, 0, 0);
        try {
            duration = a.getInteger(R.styleable.TimeTextView_duration, 0);
        } finally {
            a.recycle();
        }
        setDuration(duration);
    }

    int hours;
    int minutes;

    public void setDuration(float duration) {
        int durationInMinutes = Math.round(duration / 60);
        hours = durationInMinutes / 60;
        minutes = durationInMinutes % 60;

        String hourText = "";
        String minuteText = "";

        if (hours > 0) {
            hourText = hours + (hours == 1 ? " hour " : " hours ");
        }
        if (minutes > 0) {
            minuteText = minutes + (minutes == 1 ? " minute" : " minutes");
        }
        if (hours == 0 && minutes == 0) {
            minuteText = "less than 1 minute";
        }

        String durationText = hourText + ", " + minuteText;
        setText(Html.fromHtml(durationText), BufferType.SPANNABLE);
    }
}
