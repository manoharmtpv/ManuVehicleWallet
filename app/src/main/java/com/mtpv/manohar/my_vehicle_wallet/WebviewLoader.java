package com.mtpv.manohar.my_vehicle_wallet;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import android.webkit.WebView;

public class WebviewLoader {

	private Map<WebView, String> webviews = Collections
			.synchronizedMap(new WeakHashMap<WebView, String>());

	public void DisplayImage(String url, WebView wv) {
		webviews.put(wv, url);
		String page = "<html><body><center><img src=\"" + url
				+ "\" width=\"100%\"/></center></body></html>";
		wv.loadDataWithBaseURL("fake", page, "text/html", "UTF-8", "");
	}

}
