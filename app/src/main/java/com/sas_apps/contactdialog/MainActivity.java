package com.sas_apps.contactdialog;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        new ContactDialogBuilder(this)
                .setName("Name Surname")
                .setSubText("123-4567890")
                .setOption1Text("Make call")
                .setOption1Drawable(R.drawable.ic_call)
                .setOption2Text("Send message")
                .setOption2Drawable(R.drawable.ic_message)
                .setBackgroundColor(Color.BLACK)
                .setImageResource(R.drawable.ic_launcher_background)
                .setCancelable(true)
                .setOnOption1ClickListener(new OnDialogClickListener() {
                    @Override
                    public void OnClickListener(ContactDialog contactDialog) {
                        Toast.makeText(MainActivity.this, "Option 1 clicked", Toast.LENGTH_SHORT).show();
                        contactDialog.dismiss();
                    }
                })
                .setOnOption2ClickListener(new OnDialogClickListener() {
                    @Override
                    public void OnClickListener(ContactDialog contactDialog) {
                        Toast.makeText(MainActivity.this, "Option 2 clicked", Toast.LENGTH_SHORT).show();
                        contactDialog.dismiss();
                    }
                })
                .build().show();
    }
}
