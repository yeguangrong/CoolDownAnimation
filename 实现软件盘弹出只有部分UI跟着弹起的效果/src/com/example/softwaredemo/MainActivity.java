
package com.example.softwaredemo;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends Activity {

    private View mRootView;
    
    boolean mSoftWareIsShowing = false;

    /**
     * ���������ʱ�����̸߶�
     */
    private int mSoftWareHeight;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initListener();
    }
    
    private void initUI(){
        mRootView = findViewById(R.id.content_view); 
    }
    
    private void initListener(){
        //��������̵ĵ��������𣬶�̬�ƶ�UI
        mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                // ��Ҫ����Activity�����ü���ģʽΪadjustPan,Ȼ���ڼ��̵���ʱ��������ƶ���ȥ������ϵͳ�Ͳ���ı���Ļ��С
                Rect rect = new Rect();
                mRootView.getWindowVisibleDisplayFrame(rect);
                if(mRootView.getRootView().getHeight() - rect.bottom > 150){
                    mSoftWareHeight = mRootView.getRootView().getHeight() - rect.bottom;
//                    mContentView.scrollTo(0, mSoftWareHeight);
                    mRootView.setTranslationY(-mSoftWareHeight);
                    mSoftWareIsShowing = true;
                }else if(mSoftWareIsShowing){
                    mRootView.setTranslationY(0);
                    mSoftWareIsShowing = false;
                }
            }
        });
    }
}
