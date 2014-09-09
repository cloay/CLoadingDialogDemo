package com.cloay.cloadingdialogdemo.widget;

import com.cloay.cloadingdialogdemo.R;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @ClassName: CLoadingDialog 
 * @Description: �Զ�����ȶԻ���
 * @author cloay Email:shangrody@gmail.com 
 * @date 2014-9-9 ����10:23:56 
 *
 */
public class CLoadingDialog extends Dialog {
	private TextView msgTextV;
	private ImageView loadingImageV;
	public CLoadingDialog(Context context) {
		super(context);
		init();
	}
	
	public CLoadingDialog(Context context, int theme){
		super(context, theme);
		init();
	}

	
	private void init(){
		setContentView(R.layout.cloadingdlg_layout);
		msgTextV = (TextView) findViewById(R.id.loading_msg_textV);
		msgTextV.setText("loading..."); 		//defalut value
		loadingImageV = (ImageView)findViewById(R.id.loadingImageView);
		getWindow().getAttributes().gravity = Gravity.CENTER;
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus){
        AnimationDrawable animationDrawable = (AnimationDrawable) loadingImageV.getBackground();
        animationDrawable.start();
    }
	
	public void setMessage(String msg){
		msgTextV.setText(msg);
	}
}
