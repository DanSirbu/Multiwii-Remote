package com.multiwii.multiwiiremote;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import view.joystick.JoystickMovedListener;

public class MainActivityEvents {
	private MainActivity mActivity;

	public MainActivityEvents(MainActivity mActivity) {
		this.mActivity = mActivity;
	}

	public JoystickMovedListener _listener = new JoystickMovedListener() {
		@Override
		public void OnMoved(int pan, int tilt) {
			mActivity.rc.setAdjustedRoll(pan);
			mActivity.rc.setAdjustedPitch(-tilt);
		}

		@Override
		public void OnReleased() {

		}

		public void OnReturnedToCenter() {
			mActivity.rc.setMid(new byte[] { RCSignals.ROLL, RCSignals.PITCH });
		};
	};

	public OnClickListener mClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.aux1Btn:
				mActivity.aux1_Click(v);
				break;
			case R.id.aux2Btn:
				mActivity.aux2_Click(v);
				break;
			case R.id.aux3Btn:
				mActivity.aux3_Click(v);
				break;
			case R.id.aux4Btn:
				mActivity.aux4_Click(v);
				break;
			case R.id.switchModes:
				mActivity.rc.switchMode();
				break;
			}
		}
	};
	public OnCheckedChangeListener mCheckChangeListener = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			//mActivity.usePhoneHeading = chkUsePhoneHeading.isChecked();
		}
	};

}
