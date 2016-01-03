package devexchanges.info.notificationsample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateNotifyActivity extends AppCompatActivity {

    private View btnCreateNotify;
    private EditText txtTitle;
    private EditText txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        txtMsg = (EditText)findViewById(R.id.msg);
        txtTitle = (EditText)findViewById(R.id.title);

        btnCreateNotify = findViewById(R.id.btn_create);
        btnCreateNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotification(txtTitle.getText().toString(), txtMsg.getText().toString());
                finish(); // In this example, I finish current activity after push a notify
            }
        });

    }

    private void createNotification(String notificationTitle, String notificationMessage) {
        Intent intent = new Intent(this, ReceiveNotifyActivity.class);
        intent.putExtra("Title", notificationTitle);
        intent.putExtra("Body", notificationMessage);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_notify) // icon of notification
                .setContentTitle(notificationTitle) // title of the notification
                .setContentText(notificationMessage) // content of the notification
                .setContentIntent(pi) // content Intent
                .setAutoCancel(true) // auto dismiss notification when user clicked
                .build();

        //Building notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
