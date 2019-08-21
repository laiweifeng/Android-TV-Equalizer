package com.laiweifeng.tv.eq;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public abstract class BaseActivity extends Activity {
	
	private BaseActivity bActivity;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayouId());
		this.bActivity=this;
		initWindow();
		init();
		findViews();
		initData();
		setListener();
		setting();
	}

	private void initWindow() {
		int version = Build.VERSION.SDK_INT;
		Window window = getWindow();
		if (version >= Build.VERSION_CODES.KITKAT) {
			window.getDecorView().setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
							View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
							View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
							View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
							View.SYSTEM_UI_FLAG_FULLSCREEN |
							View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
			);
		}
		else
		{
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE );
		}
	}

	protected abstract int getLayouId();


	public Context getContext(){
		return bActivity;
	}
	
	/**
	 * 进入时初始化参数
	 */
	public abstract void init();
	/**
	 * 查找所有的控件
	 */
	public abstract void findViews();
	/**
	 * 初始化页面数据
	 */
	public abstract void initData();
	/**
	 * 设置控件的监听事件
	 */
	public abstract void setListener();
	
	/**
	 * 后续参数设置
	 */
	public abstract void setting();

	

}
