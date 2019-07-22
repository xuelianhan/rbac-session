package org.ict.rbac.json;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.gson.Gson;

public class GsonTest {


	private static final String price_range_pattern  = "^[\\(](\\d+),(\\d+)[\\]]$";
	
	private static final Pattern range_pattern = Pattern.compile(price_range_pattern);
	
	public void test() {
		String price1 = "(4,50]";
		String price2 = "(40,50]";
		String price3 = "(40,   50]";
		String price4 = "(40,   50)";
		String price5 = "40,   50";
		String price6 = "[40,   50)";
		List<String> list = new ArrayList<>();
		list.add(price1);
		list.add(price2);
		list.add(price3);
		list.add(price4);
		list.add(price5);
		list.add(price6);
		list.forEach(price ->{
			Matcher m = range_pattern.matcher(price);
			System.out.println(price + "matches:" + m.matches());
			if (m.matches()) {
				System.out.println("group:" + m.group());
				Range range = Range.range(10, BoundType.OPEN, 20, BoundType.CLOSED);
				System.out.println("range:" + new Gson().toJson(range));
				String s = m.group();
				String ns = s.substring(0, s.length());
			}
		});
	}
}
