package com.helin.rxsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.helin.rxsample.base.ActivityLifeCycleEvent;
import com.helin.rxsample.base.BaseActivity;
import com.helin.rxsample.enity.Subject;
import com.helin.rxsample.http.Api;
import com.helin.rxsample.http.HttpUtil;
import com.helin.rxsample.http.ProgressSubscriber;
import com.helin.rxsample.view.SimpleLoadDialog;

import java.util.List;

import rx.Observable;

public class MainActivity extends BaseActivity {

    private TextView mText;
    private SimpleLoadDialog dialogHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogHandler = new SimpleLoadDialog(MainActivity.this, null, true);
        mText = (TextView) findViewById(R.id.text);
        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialogHandler.obtainMessage(SimpleLoadDialog.SHOW_PROGRESS_DIALOG).sendToTarget();
                doGet();
            }
        });
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        dialogHandler.obtainMessage(SimpleLoadDialog.DISMISS_PROGRESS_DIALOG).sendToTarget();
    }

    private void doGet() {
        //获取豆瓣电影TOP 100
        Observable ob = Api.getDefault().getTopMovie(0, 100);
        //嵌套请求
//        ob.flatMap(new Func1<String, Observable<HttpResult<Subject>>>() {
//
//            @Override
//            public Observable<HttpResult<Subject>> call(String s) {
//                return Api.getDefault().getUser("aa");
//            }
//        });


        HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<List<Subject>>(this) {
            @Override
            protected void _onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }

            @Override
            protected void _onNext(List<Subject> list) {
                String str = "";
                for (int i = 0; i < list.size(); i++) {
                    str += "电影名：" + list.get(i).getTitle() + "\n";
                }
                mText.setText(str);
            }
        }, "cacheKey", ActivityLifeCycleEvent.DESTROY, lifecycleSubject, false, false);
    }
}
