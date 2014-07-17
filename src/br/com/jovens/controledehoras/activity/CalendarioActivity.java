package br.com.jovens.controledehoras.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import br.com.jovens.controledehoras.R;

public class CalendarioActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);

		final CalendarView calendario = (CalendarView) findViewById(R.id.calendario);

		calendario.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {

				Toast.makeText(CalendarioActivity.this,
						dayOfMonth + "/" + month + "/" + year,
						Toast.LENGTH_LONG).show();
			}
		});

	}
}
