package com.helin.rxsample.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.helin.rxsample.R;
import com.helin.rxsample.http.ProgressCancelListener;

import java.lang.ref.WeakReference;


/**
 *
 */
public class SimpleLoadDialog extends Handler{

    private  Dialog load = null;

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private Context context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;
    private final WeakReference<Context> reference;

    public SimpleLoadDialog(Context context, ProgressCancelListener mProgressCancelListener,
                            boolean cancelable) {
        super();
        this.reference = new WeakReference<Context>(context);
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
    }

    private void create(){
        if (load == null) {
            context  = reference.get();

            load = new Dialog(context, R.style.loadstyle);
            View dialogView = LayoutInflater.from(context).inflate(
                    R.layout.custom_sload_layout, null);
            load.setCanceledOnTouchOutside(false);
            load.setCancelable(cancelable);
            load.setContentView(dialogView);
            load.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    if(mProgressCancelListener!=null)
                        mProgressCancelListener.onCancelProgress();
                }
            });
            Window dialogWindow = load.getWindow();
            dialogWindow.setGravity(Gravity.CENTER_VERTICAL
                    | Gravity.CENTER_HORIZONTAL);
        }
        if (!load.isShowing()&&context!=null) {
            load.show();
        }
    }

    public void show(){
        create();
    }


    public  void dismiss() {
        context  = reference.get();
        if (load != null&&load.isShowing()&&!((Activity) context).isFinishing()) {
            String name = Thread.currentThread().getName();
            load.dismiss();
            load = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                create();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismiss();
                break;
        }
    }
}
