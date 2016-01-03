package devexchanges.info.notificationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ReceiveNotifyActivity extends AppCompatActivity {

    private TextView notificationTitle;
    private TextView notificationMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        notificationMessage = (TextView) findViewById(R.id.msg);
        notificationTitle = (TextView) findViewById(R.id.title);

        Bundle extras = getIntent().getExtras();

        notificationMessage.setText("Notification content: " + extras.getString("Body"));
        notificationTitle.setText("Notification title: " + extras.getString("Title"));
    }
}