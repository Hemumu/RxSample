package com.helin.rxsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //登陆示例
//        Observable<HttpResult<UserEntity>> ob = Api.getDefault().login( "name", "psw");
//        HttpUtil.getInstance().toSubscribe(ob,new ProgressSubscriber<UserEntity>(this) {
//            @Override
//            protected void _onError(String message) {
//                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            protected void _onNext(UserEntity userEntity) {
//                Toast.makeText(MainActivity.this, userEntity.getName()+"", Toast.LENGTH_SHORT).show();
//            }
//
//        },"cacheKey",false,false);

    }
}
