package com.helin.rxsample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.subjects.PublishSubject;

/**
 * Created by helin on 2016/11/11 10:41.
 */

public class BaseActivity extends AppCompatActivity {

    public final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject = PublishSubject.create();

//    @NonNull
//    public <T> Observable.Transformer<T, T> bindUntilEvent(@NonNull final ActivityLifeCycleEvent event) {
//        return new Observable.Transformer<T, T>() {
//            @Override
//            public Observable<T> call(Observable<T> sourceObservable) {
//                Observable<ActivityLifeCycleEvent> compareLifecycleObservable =
//                        lifecycleSubject.takeFirst(new Func1<ActivityLifeCycleEvent, Boolean>() {
//                            @Override
//                            public Boolean call(ActivityLifeCycleEvent activityLifeCycleEvent) {
//                                return activityLifeCycleEvent.equals(event);
//                            }
//                        });
//                return sourceObservable.takeUntil(compareLifecycleObservable);
//            }
//        };
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.CREATE);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleSubject.onNext(ActivityLifeCycleEvent.DESTROY);
    }
}
