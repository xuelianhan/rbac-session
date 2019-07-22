package org.ict.rbac.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.WordUtils;

import com.google.common.base.CaseFormat;

/**
 * @see https://www.geeksforgeeks.org/camel-case-given-sentence/
 * @author hanxuelian001
 *
 */
public class Detail {
	private String  browse_cnt180;
	private String  browse_cnt90;
	private String  browse_cnt60;
	private String  browse_cnt30;
	private String  browse_cnt15;
	private String  browse_cnt7;
	private String  browse_cnt3;
	private String  browse_cnt2;
	private String  browse_cnt1;
	private String  favorite_cnt180;
	private String  favorite_cnt90;
	private String  favorite_cnt60;
	private String  favorite_cnt30;
	private String  favorite_cnt15;
	private String  favorite_cnt7;
	private String  favorite_cnt3;
	private String  favorite_cnt2;
	private String  favorite_cnt1;
	private String  showing_cnt180;
	private String  showing_cnt90;
	private String  showing_cnt60;
	private String  showing_cnt30;
	private String  showing_cnt15;
	private String  showing_cnt7;
	private String  showing_cnt5;
	private String  showing_cnt3;
	private String  showing_cnt2;
	private String  showing_cnt1;
	private String  showing_frequency_cnt180;
	private String  showing_frequency_cnt90;
	private String  showing_frequency_cnt60;
	private String  showing_frequency_cnt30;
	private String  showing_frequency_cnt15;
	private String  showing_frequency_cnt7;
	private String  showing_frequency_cnt5;
	private String  showing_frequency_cnt3;
	private String  showing_frequency_cnt2;
	private String  showing_frequency_cnt1;
	private String  phone_400_cnt180;
	private String  phone_400_cnt90;
	private String  phone_400_cnt60;
	private String  phone_400_cnt30;
	private String  phone_400_cnt15;
	private String  phone_400_cnt7;
	private String  phone_400_cnt3;
	private String  phone_400_cnt2;
	private String  phone_400_cnt1;
	private String  im_cnt180;
	private String  im_cnt90;
	private String  im_cnt60;
	private String  im_cnt30;
	private String  im_cnt15;
	private String  im_cnt7;
	private String  im_cnt3;
	private String  im_cnt2;
	private String  im_cnt1;
	private String  liuzi_cnt180;
	private String  liuzi_cnt90;
	private String  liuzi_cnt60;
	private String  liuzi_cnt30;
	private String  liuzi_cnt15;
	private String  liuzi_cnt7;
	private String  liuzi_cnt3;
	private String  liuzi_cnt2;
	private String  liuzi_cnt1;
	private String  liuyan_cnt180;
	private String  liuyan_cnt90;
	private String  liuyan_cnt60;
	private String  liuyan_cnt30;
	private String  liuyan_cnt15;
	private String  liuyan_cnt7;
	private String  liuyan_cnt3;
	private String  liuyan_cnt2;
	private String  liuyan_cnt1;
	private String  active_cnt_rencent180;
	private String  active_cnt_rencent90;
	private String  active_cnt_rencent60;
	private String  active_cnt_rencent30;
	private String  active_cnt_rencent15;
	private String  active_cnt_rencent7;
	private String  active_cnt_rencent5;
	private String  active_cnt_rencent3;
	private String  active_cnt_rencent2;
	private String  active_cnt_rencent1;
	private String  hefang_cnt_rencent180;
	private String  hefang_cnt_rencent90;
	private String  hefang_cnt_rencent60;
	private String  hefang_cnt_rencent30;
	private String  hefang_cnt_rencent15;
	private String  hefang_cnt_rencent7;
	private String  hefang_cnt_rencent3;
	private String  hefang_cnt_rencent2;
	private String  hefang_cnt_rencent1;
	private String  last_active_date;
	private String  first_active_date;
	private String  avg_online_time;
	private String  rent_search_cnt30;
	private String  rent_search_cnt15;
	private String  rent_search_cnt7;
	private String  rent_search_cnt5;
	private String  rent_search_cnt3;
	private String  rent_search_cnt2;
	private String  rent_search_cnt1;
	private String  rent_channel_cnt30;
	private String  rent_channel_cnt15;
	private String  rent_channel_cnt7;
	private String  rent_channel_cnt5;
	private String  rent_channel_cnt3;
	private String  rent_channel_cnt2;
	private String  rent_channel_cnt1;
	private String  zx_frist_access_date;
	private String  zx_last_access_date;
	private String  zx_vr_view_count;
	private String  zx_life_view_count_7day;
	private String  zx_contact_im_count_7day;
	private String  zx_contact_400_count_7day;
	private String  zx_is_clue_7day;
	private String  zx_is_clue;
	private String  zx_clue_type;
	private String  zx_clue_from_ershou_detail;
	private String  zx_clue_from_life_banner;
	private String  zx_clue_in_part_deco;
	private String  zx_viewed_part_deco;
	private String  zx_has_coupon;
	private String  zx_prefer_deco_style;
	private String  search_cnt180;
	private String  search_cnt90;
	private String  search_cnt60;
	private String  search_cnt30;
	private String  search_cnt15;
	private String  search_cnt7;
	private String  search_cnt3;
	private String  search_cnt2;
	private String  search_cnt1;
	private String  vr_cnt180;
	private String  vr_showing_cnt90;
	private String  vr_showing_cnt60;
	private String  vr_showing_cnt30;
	private String  vr_showing_cnt15;
	private String  vr_showing_cnt7;
	private String  vr_showing_cnt3;
	private String  vr_showing_cnt2;
	private String  vr_showing_cnt1;
	private String  gujia_cnt180;
	private String  gujia_cnt90;
	private String  gujia_cnt60;
	private String  gujia_cnt30;
	private String  gujia_cnt15;
	private String  gujia_cnt7;
	private String  gujia_cnt3;
	private String  gujia_cnt2;
	private String  gujia_cnt1;
	private String  last_showing_date;
	
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "last_showing_date";
		System.out.println();
		
		List<Field> privateFields = new ArrayList<>();
		Field[] allFields = Detail.class.getDeclaredFields();
		for (Field field : allFields) {
		    if (Modifier.isPrivate(field.getModifiers())) {
		        privateFields.add(field);
		    }
		}
		privateFields.forEach(item ->{
			String filedName = item.getName();
			String camelName = replaceUnderLineToCamelV(filedName);
			String typeName = item.getType().getSimpleName();
			System.out.println("@JsonProperty(\"" + filedName +  "\")");
			System.out.println("private " + typeName + " " + camelName + ";");
			
		});
	}
	
	public static String replaceUnderLineToCamelV(String input) {
		char[] arr = input.toCharArray();
		int p = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '_') {
				if (i != arr.length - 1) {
					arr[i+1] = Character.toUpperCase(arr[i+1]);
				}
				count++;
				continue;
			} else {
				arr[p++] = arr[i];
			}
		}
		return String.valueOf(arr).substring(0, arr.length - count);
	}
	
	/**
	 * @see https://stackoverflow.com/questions/1143951/what-is-the-simplest-way-to-convert-a-java-string-from-all-caps-words-separated
	 * @param input
	 * @return
	 */
	public static String replaceUnderLineToCamel(String input) {
		String result = "";
		result = WordUtils.capitalizeFully(input, new char[]{'_'}).replaceAll("_", "");
		CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "THIS_IS_AN_EXAMPLE_STRING");
		return result;
	}

}
