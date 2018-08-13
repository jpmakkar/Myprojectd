package in.gov.prsc.www.myproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class SplashActivity extends AppCompatActivity {

    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        title=(TextView)findViewById(R.id.title);
        title.setTypeface(EasyFonts.captureIt(this));
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        h.sendEmptyMessageDelayed(102,100);
        h.sendEmptyMessageDelayed(103,2000);
    }
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if(msg.what==103){
                Intent i=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.begin,R.anim.end);
                finish();
            }
            if(msg.what==102){
                Animation animation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.yo);
                title.setVisibility(View.VISIBLE);
                title.startAnimation(animation);
            }

        }
    };
}
