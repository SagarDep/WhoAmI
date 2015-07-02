package kr.co.sangcomz.whoami.core.transfer;

import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.Field;
import java.util.Set;


public class BundleMapper {

	public static Bundle toBundle(Object container) {
		Bundle bundle = new Bundle();
		Field[] fields = container.getClass().getDeclaredFields();
		String name;
		for (Field f:fields) {
			BundleField ref = f.getAnnotation(BundleField.class);
			String sname = f.getType().getSimpleName();
			if (ref != null) {
				f.setAccessible(true);
				name = ref.name();
				try {
					if (sname.equals("String")) {
						bundle.putString(name, (String) f.get(container));
					} else if (sname.equals("int")) {
						bundle.putInt(name, f.getInt(container));
					} else if (sname.equals("long")) {
						bundle.putLong(name, f.getLong(container));
					} else if (sname.equals("float")) {
						bundle.putFloat(name, f.getFloat(container));
					} else if (sname.equals("double")) {
						bundle.putDouble(name, f.getDouble(container));
					}
				} catch (Exception e) {
				}

			}
		}
		return bundle;
	}
	
	public static boolean fromBundle(Object container,Bundle bundle) {
		if (bundle == null) {
			return false;
		}
		Set<String> keys =  bundle.keySet();
		Class<?> cls = container.getClass();
		for (String key:keys) {
			try {
//				System.out.println("ref :::: " + cls.getDeclaredField(key));
				Field field = container.getClass().getDeclaredField(key);
				field.setAccessible(true);
				BundleField ref = field.getAnnotation(BundleField.class);
				if (ref != null) {
					if (cls.isPrimitive()) {
						String sname = field.getType().getSimpleName();
						if (sname.equals("int")) {
							field.setInt(container, bundle.getInt(key));
						} else if (sname.equals("float")) {
							field.setFloat(container, bundle.getFloat(key));
						} else {
							return false;
						}
						return true;
					} else {
						Object value = bundle.get(key);
						field.set(container, value);
					}
				}
			} catch (NoSuchFieldException e) {
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return false;
	}
		
	public static boolean fromIntent(Object container,Intent intent) {
		//Uri uri = getData();
		if (intent == null) {
			return false;
		}
		
		return fromBundle(container,intent.getExtras());
	}
}
