package com.why.project.articleremovedeldialogdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.why.project.articleremovedeldialogdemo.dialog.ArticleRemoveDelDialog;

public class MainActivity extends AppCompatActivity {

	private Button btn_open;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	private void initViews() {
		btn_open = findViewById(R.id.btn_open);
	}

	private void initEvents() {
		btn_open.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ArticleRemoveDelDialog articleRemoveDelDialog = new ArticleRemoveDelDialog(MainActivity.this,"这是一个标题，可能会很长文本，如果超过宽度的话，会省略号");
				articleRemoveDelDialog.setOnRemoveDelButtonClickListener(new ArticleRemoveDelDialog.OnRemoveDelButtonClickListener() {
					@Override
					public void onRemoveButtonClick() {
						Toast.makeText(MainActivity.this,"回收",Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onDelButtonClick() {
						Toast.makeText(MainActivity.this,"删除",Toast.LENGTH_SHORT).show();
					}
				});
				articleRemoveDelDialog.show();
			}
		});
	}
}
