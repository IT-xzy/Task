package util;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class Xsmtpapi {
	List<String> toList;

	Map<String, List<String>> subMap;

	Map<String, String> sectionMap;

	JSONObject x = new JSONObject();

	public Xsmtpapi(List<String> toList) {
		this.toList = toList;
		x.put("to", toList);
	}

	public Xsmtpapi(List<String> toList, Map<String, List<String>> subMap) {
		this.toList = toList;
		this.subMap = subMap;
		x.put("to", toList);
		x.put("sub", subMap);
	}

	public Xsmtpapi(List<String> toList, Map<String, List<String>> subMap, Map<String, String> sectionMap) {
		this.toList = toList;
		this.subMap = subMap;
		this.sectionMap = sectionMap;
		x.put("to", toList);
		x.put("sub", subMap);
		x.put("section", sectionMap);
	}

	@Override
	public String toString() {
		return x.toString();
	}
}
