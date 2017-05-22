package com.chrono.src.ui.states.error;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chrono.R;

/**
 * Created by Filip Kowalski on 22.05.17.
 */

public class StadardErrorView extends ErrorView {

	private TextView titleTextView;
	private TextView subtitleTextView;

	private String title;
	private String subtitle;

	private OnClickListener buttonClickListener;

	public StadardErrorView(Context context, OnClickListener buttonClickListener, String title, String subtitle) {
		super(context);
		this.buttonClickListener = buttonClickListener;
		this.title = title;
		this.subtitle = subtitle;

		init(context);
	}

	private void init(Context context) {
		setOrientation(VERTICAL);
		setGravity(Gravity.CENTER);
		ViewGroup.LayoutParams layoutParams =
				new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		setLayoutParams(layoutParams);
		View view = View.inflate(context, R.layout.layout_error, this);
		view.setBackgroundColor(Color.WHITE);

		titleTextView = (TextView) view.findViewById(R.id.text_error_title);
		subtitleTextView = (TextView) view.findViewById(R.id.text_error_subtitle);

		Button button = (Button) view.findViewById(R.id.button_error);
		button.setOnClickListener(buttonClickListener);

		initValues();
	}

	private void initValues() {
		titleTextView.setText(title);
		subtitleTextView.setText(subtitle);
	}

	@Override
	public void setError(@ErrorTypeGenerator.ErrorType int errorType) {
		// not used
	}
}