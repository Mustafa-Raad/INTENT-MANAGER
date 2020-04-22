package com.uth.raad.workfiveintent;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define a button to detect button b1 of main activity
        Button b = findViewById(R.id.b1);


    }

    public void go(View v){
        // there are two methods for moving to an activity by intent
        // method 1 un comment line 27 and comment line 28 and 30
        Intent i = new Intent(this, ActivityB.class);
        //Intent i = new Intent();
        // method 2 to use 2nd method uncommennt line 30 and 28
        //i.setClassName("com.uth.raad.workfiveintent","com.uth.raad.workfiveintent.ActivityB");

        startActivity(i);
        Toast.makeText(this, "activity B opend", Toast.LENGTH_SHORT).show();
    }

    public void doit(View v2){
        Intent intent = null, chooser=null;

        if (v2.getId() == R.id.b2){
            // by line 43 an action viewer called that was builtin statically in the library no need for creating new view by our self
            // we just reuse from builtin method, if we don't specify the type of data used in action view we will give suggestions for that comment line 45 and lunch the app
            intent = new Intent(Intent.ACTION_VIEW);
            // by line 45 we give a data to that action view which we already called and this geo data for a map
            intent.setData(Uri.parse("geo:19.076, 72.8777"));
            //chooser line 47 is option provider, which asks by which application u wanna see the result of provided data
            chooser = Intent.createChooser(intent, "Launch maps");
            startActivity(chooser);
        }
        if (v2.getId() == R.id.b3){
            intent= new Intent(Intent.ACTION_VIEW);
            // by this button we can launch a app market for our apps we wanna download, following line shows the line of download app
            intent.setData(Uri.parse("market://details?id=com.gvapps.englishessays"));
            // by chooser we give options for launching by which market we wanna download this app
            chooser = Intent.createChooser(intent, "select your donar: ");
            startActivity(chooser);
        }
        if (v2.getId() == R.id.b4){
            // by this button we are going to send an email to specified recipies
            intent = new Intent(Intent.ACTION_SEND);
            String[] to = {"soharb2016afzali@gmail.com","mustafa.raad@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "this is a test mail");
            intent.putExtra(Intent.EXTRA_TEXT, "hi hi welcome to this this email it is provided by a test enjine");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "choose email provider");
            startActivity(chooser);

        }
        if (v2.getId()==R.id.b5){
            Uri imageUri=Uri.parse("android.resource://com.uth.raad.workfiveintent/drawable/"+R.mipmap.ic_launcher);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");

            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.putExtra(Intent.EXTRA_TEXT, "hey I have attached this image");
            chooser=Intent.createChooser(intent, "send Image");
            startActivity(chooser);
        }
    }

}
