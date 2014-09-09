package com.cloay.cloadingdialogdemo;

import com.cloay.cloadingdialogdemo.widget.CLoadingDialog;

import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * 
 * @ClassName: MainActivity 
 * @Description: This a demo for CLoadingDialog. 
 * @author cloay Email:shangrody@gmail.com 
 * @date 2014-9-9 ÉÏÎç10:44:04 
 *
 */
public class MainActivity extends ActionBarActivity {
	private Button loadingBtn;
	private CLoadingDialog loadingDlg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loadingBtn = (Button)findViewById(R.id.loading_btn);
		loadingBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				loading();
			}
		});
		
		loadingDlg = new CLoadingDialog(this, R.style.CLoadingDialog);
		loadingDlg.setMessage("Loading...");
	}

	private void loading(){
		loadingDlg.show();
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(8*1000); //sleep 5 seconds
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				loadingDlg.dismiss();
				Toast.makeText(MainActivity.this, "Loading done£¡", Toast.LENGTH_SHORT).show();
				super.onPostExecute(result);
			}
			
		}.execute();
	}
}
