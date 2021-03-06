package kr.co.sangcomz.whoami.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ViewMapper {
	public static View inflateLayout(Context context,Object container, int layoutId) {		
		View view = LayoutInflater.from(context).inflate(layoutId, null);
		mapLayout(container, view);
		return view;
	}	
	public static View mapLayout(Object container, View view) {
		View view0 = null;
		Field[] fields = container.getClass().getDeclaredFields();
		for (Field field: fields) {
			DeclareView param = field.getAnnotation(DeclareView.class);
			if (param != null) {	//To map R.id.xx into field value			
				int id = param.id();	
				view0 = view.findViewById(id);
				try {
					field.setAccessible(true);
					field.set(container, view0);

				} catch (Exception e) {
					e.printStackTrace();
				}
				String text = param.setText();
				if (text.length() > 0){
					if (field.getType().getSimpleName().equals("TextView") || field.getType().getSimpleName().equals("Button")){
						TextView a = (TextView)view0;
						a.setText(text);
					}
				}


				int visible = param.setVisible();
				if (visible == 0)
					view0.setVisibility(View.INVISIBLE);

				int drawableId = param.setDrawableId();
				if (drawableId != 0) {
					RelativeLayout layout =  (RelativeLayout)view0;
					layout.getChildAt(0).setBackgroundResource(drawableId);
				}
				//Click Listener
				String clk = param.click().trim();
				if (clk.length() > 0) {
					if (clk.equals("this") == true) {
						view0.setOnClickListener((View.OnClickListener)container);
					} else {
						try {
							Field field0 = container.getClass().getField(clk);
							view0.setOnClickListener((View.OnClickListener)field0.get(container));
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		}
		return view;
	}
}
