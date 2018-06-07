package com.why.project.articleremovedeldialogdemo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.why.project.articleremovedeldialogdemo.R;


/**
 * Created by HaiyuKing
 * Used 回收、删除对话框
 */

public class ArticleRemoveDelDialog extends AlertDialog {
	private static final String TAG = ArticleRemoveDelDialog.class.getSimpleName();

	private Context context;//上下文
	private String buildTitle;//标题

	private TextView title_tv;
	private TextView remove_tv;
	private TextView del_tv;

	public ArticleRemoveDelDialog(Context context, String buildTitle) {
		super(context, R.style.style_alert_confirm_dialog);

		//设置为false，按对话框以外的地方不起作用
		setCanceledOnTouchOutside(true);
		//设置为false，按返回键不能退出
		setCancelable(true);

		this.context = context;
		this.buildTitle = buildTitle;
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alert_dialog_remove_del);

		initViews();
		initDatas();
		initEvents();
	}

	/**初始化view*/
	private void initViews() {
		title_tv = findViewById(R.id.title_tv);
		remove_tv = findViewById(R.id.remove_tv);
		del_tv = findViewById(R.id.del_tv);
	}

	/**初始化数据*/
	private void initDatas() {
		title_tv.setText(buildTitle);//设置标题
		//设置标题区域的宽度
		final DisplayMetrics display = new DisplayMetrics();
		((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(display);
		title_tv.setLayoutParams(new LinearLayout.LayoutParams(display.widthPixels - context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_confirm_margin) * 2, ViewGroup.LayoutParams.WRAP_CONTENT));
	}

	/**初始化监听事件*/
	private void initEvents() {
		//回收
		remove_tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mOnRemoveDelButtonClickListener != null){
					mOnRemoveDelButtonClickListener.onRemoveButtonClick();
				}
				dismiss();
			}
		});
		//删除
		del_tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mOnRemoveDelButtonClickListener != null){
					mOnRemoveDelButtonClickListener.onDelButtonClick();
				}
				dismiss();
			}
		});
	}

	public static abstract interface OnRemoveDelButtonClickListener
	{
		//回收按钮的点击事件接口
		public abstract void onRemoveButtonClick();
		//删除按钮的点击事件接口
		public abstract void onDelButtonClick();
	}

	private OnRemoveDelButtonClickListener mOnRemoveDelButtonClickListener;

	public void setOnRemoveDelButtonClickListener(OnRemoveDelButtonClickListener mOnRemoveDelButtonClickListener)
	{
		this.mOnRemoveDelButtonClickListener = mOnRemoveDelButtonClickListener;
	}


}
