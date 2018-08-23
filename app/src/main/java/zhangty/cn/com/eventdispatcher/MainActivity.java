package zhangty.cn.com.eventdispatcher;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zhangty.cn.com.eventdispatcher.com.Login;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.constrainLayout)
    ConstraintLayout constraintLayout;
    @BindView(R.id.textView)
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        ButterKnife.bind(this);
//        constraintLayout = findViewById(R.id.constrainLayout);
//        textView = findViewById(R.id.textView);
//        imageView = new ImageView(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * String msg = "I was sended by eventBus";
                 */
                /**
                 * EventBus.getDefault().post(msg);
                 */


                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com").addConverterFactory(GsonConverterFactory.create()).build();

                Login httpApiS = retrofit.create(Login.class);
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "");
                retrofit2.Call<String> call = httpApiS.postAgencyLogin(requestBody);
                call.enqueue(new retrofit2.Callback<String>() {
                    @Override
                    public void onResponse(retrofit2.Call<String> call, retrofit2.Response<String> response) {

                        Toast.makeText(MainActivity.this, "Get Message Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(retrofit2.Call<String> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Get Message Faiure", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
//        textView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                Log.e("tag","---------------------执行TextView的OnTouchListener----------------------");
//                return false;
//            }
//        });
//
//        Glide.with(this).load("http://www.baidu.com").into(imageView);
    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//
//        Log.e("tag", "--------------------执行Activity的dispathcTouchEvent------------------------");
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        Log.e("tag", "--------------------执行Activity的onTouchEvent------------------------");
//        return super.onTouchEvent(event);
//    }

    /**
     * 定义处理接收的方法
     *
     * @param userEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userEventBus(String userEvent) {

        Toast.makeText(MainActivity.this, "执行Main方法", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
