package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Custom_GridView_BanCo extends ArrayAdapter<Integer> {
	
	Context context;
	int resource;
	Integer[] objects;
	Integer[] giaTien = {0,100,200,300,400,500};
	ArrayAdapter<Integer> adapter;
	
	public Custom_GridView_BanCo(Context context, int resource, Integer[] objects) {
		super(context, resource, objects);

		this.context = context;
		this.resource = resource;
		this.objects = objects;
		adapter = new ArrayAdapter<Integer>(context,android.R.layout.simple_spinner_item,giaTien);
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		View view = View.inflate(context,resource, null);
		ImageView imgBanCo = (ImageView) view.findViewById(R.id.imgBanCo);
		Spinner spinGiaTien = (Spinner) view.findViewById(R.id.spinGiaTien);
		
		imgBanCo.setImageResource(objects[position]);
		spinGiaTien.setAdapter(adapter);
		
		spinGiaTien.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int positionspin, long id) {
				MainActivity.gtDatCuoc[position] = giaTien[positionspin];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		return view;
	}

}
