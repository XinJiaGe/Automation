package com.jiage.automation.service;

import android.accessibilityservice.AccessibilityService;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * 作者：李忻佳
 * 日期：2019/9/15/015.
 * 说明：
 */

public abstract class MyAccessibilityService extends AccessibilityService {
    private String TAG = "Accessibility";
    public static boolean isRun = false;
    protected String packageNmae;
    protected String className;
    protected String contentDescription;
    protected String text;

    /**
     * 当系统监测到相匹配的AccessibilityEvent事件时,将调用此方法,在整个Service的生命周期中,该方法将被多次调用
     * @param event
     */
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        packageNmae = event.getPackageName()!=null?event.getPackageName().toString():"";
        className = event.getClassName()!=null?event.getClassName().toString():"";
        contentDescription = event.getContentDescription()!=null?event.getContentDescription().toString():"";
        text = event.getText()!=null?event.getText().toString():"";
        Log.d(TAG,packageNmae+"  "+className+"  "+contentDescription+"  "+text);
        onAccessibility(event);
    }

    public abstract void onAccessibility(AccessibilityEvent event);

    /**
     * 系统需要中断AccessibilityService反馈时,将调用此方法
     */
    @Override
    public void onInterrupt() {

    }

    /**
     * 当系统成功连接到该AccessibilityService时,将调用此方法
     */
    @Override
    protected void onServiceConnected() {
        isRun = true;
    }

    /**
     * 系统要关闭该服务是,将调用此方法
     * @param conn
     */
    @Override
    public void unbindService(ServiceConnection conn) {
        isRun = false;
    }
}
