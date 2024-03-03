package com.ling.commonlib.baserx;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.JsonParseException;
import com.ling.commonlib.BaseApplication;
import com.ling.commonlib.R;
import com.ling.commonlib.utils.LogUtils;
import com.ling.commonlib.utils.SystemUtil;
import com.ling.commonlib.utils.ToastUtil;
import com.ling.commonlib.widget.LoadingDialog;

import java.net.SocketTimeoutException;

import io.reactivex.subscribers.ResourceSubscriber;


/**
 */

public abstract class RxSubscriber<T> extends ResourceSubscriber<T>
{
    private Context mContext;
    private boolean showDialog = false;
    private boolean compression = false;
    private String msg;

    public RxSubscriber(Context context)
    {
        this.mContext = context;

    }

    public RxSubscriber(Context context, boolean showDialog)
    {
        this.mContext = context;
        this.showDialog = showDialog;
    }

    public RxSubscriber(Context context, boolean showDialog, String msg)
    {
        this.mContext = context;
        this.showDialog = showDialog;
        this.msg = msg;
    }

    public RxSubscriber(Context context, boolean showDialog, String msg, boolean compression)
    {
        this.mContext = context;
        this.showDialog = showDialog;
        this.msg = msg;
        this.compression = compression;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //开始加载
        if (showDialog)
        {
            LoadingDialog.showDialogForLoading(mContext, msg, true);
        }
    }

    @Override
    public void onComplete()
    {
        //完成关闭动画
        if (showDialog)
        {
            LoadingDialog.cancelDialogForLoading();
        }
    }

    @Override
    public void onNext(T t)
    {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e)
    {
        LogUtils.INSTANCE.logd(e.getMessage());
        //错误关闭动画
        if (showDialog)
        {
            LoadingDialog.cancelDialogForLoading();
        }
        e.printStackTrace();
        //网络
        if (!SystemUtil.isConnected())
        {
            //ToastUtil.showShort(getAppContext().getString(R.string.no_net));
            _onError(BaseApplication.Companion.getAppContext().getString(R.string.no_net));
        }
        //服务器
        else if (e instanceof AppException)
        {
            if (!TextUtils.equals("1040", ((AppException) e).code))
            {
                if (!TextUtils.isEmpty(e.getMessage()))
                {
                    ToastUtil.showShort(e.getMessage());
                }
            }
            _onError(e.getMessage());
        }
        else if (e instanceof JsonParseException)
        {
            ToastUtil.showShort("数据解析出错");
            _onError("数据格式错误");
        }
        else if (e instanceof SocketTimeoutException)
        {
            ToastUtil.showShort("网络请求超时，请稍后重试");
            _onError("网络请求超时，请稍后重试");
        }
        //其它
        else
        {
            if (!compression)
            {
                ToastUtil.showShort(BaseApplication.Companion.getAppContext().getString(R.string.net_error));
                _onError(BaseApplication.Companion.getAppContext().getString(R.string.net_error));
            }
            else
            {
                ToastUtil.showShort(BaseApplication.Companion.getAppContext().getString(R.string.update_error));
            }

        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);
}
