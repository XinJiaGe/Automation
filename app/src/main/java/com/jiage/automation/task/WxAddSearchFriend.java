package com.jiage.automation.task;

import android.content.Context;
import android.view.accessibility.AccessibilityEvent;

import com.jiage.automation.service.MyAccessibilityService;

/**
 * 作者：李忻佳
 * 日期：2019/9/15/015.
 * 说明：
 */

public class WxAddSearchFriend extends MyAccessibilityService {
    private static WxAddSearchFriend mInstance;

    public static WxAddSearchFriend getInstance() {
        if (mInstance == null) {
            synchronized (WxAddSearchFriend.class) {
                if (mInstance == null) {
                    mInstance = new WxAddSearchFriend();
                }
            }
        }
        return mInstance;
    }

    public void startTask(){

    }

    @Override
    public void onAccessibility(AccessibilityEvent event) {

    }
}
