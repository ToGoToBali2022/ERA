package test.bwei.com.era;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencedUtils {

	
	private static final String NAME="NQQnnn";
	
	public static void save(Context context,String key,Object values){
		SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
		Editor edit = sp.edit();
		String type = values.getClass().getSimpleName();
		if ("Integer".equals(type)) {
			edit.putInt(key, (int) values);
		}else if ("String".equals(type)){
			edit.putString(key, (String) values);
		}else if ("Boolean".equals(type)){
			edit.putBoolean(key, (Boolean) values);
		}else if ("Long".equals(type)){
			edit.putLong(key, (Long) values);
		}else if ("Float".equals(type)){
			edit.putFloat(key, (Float) values);
		}
		edit.commit();
	}
	
	
	public static Object take(Context context,String key,Object values){
		SharedPreferences sp = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
		String type = values.getClass().getSimpleName();
		
		if ("Integer".equals(type)) {
		return	sp.getInt(key, 0);
		}else if ("String".equals(type)){
			return	sp.getString(key,"");
		}else if ("Boolean".equals(type)){
			return	sp.getBoolean(key,false);
		}else if ("Long".equals(type)){
			return	sp.getLong(key, 0);
		}else if ("Float".equals(type)){
			return	sp.getFloat(key, 0f);
		}
		
		return null;}
}

