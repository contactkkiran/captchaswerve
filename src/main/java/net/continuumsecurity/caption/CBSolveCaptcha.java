package net.continuumsecurity.caption;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import net.continuumsecurity.captcha.caption.CaptchaSolver;

public class CBSolveCaptcha implements ISolveCaptcha {
	public final static String CHARSET="UTF-8";
	private CaptchaSolver solver;
	
	public void CBSolveCaptcha() {
		 solver = new CaptchaSolver();
	}
	
	public String solveFromUrl(String strUrl) {
		String result = null;
		try {
			URL url = new URL(strUrl);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Accept-Charset",  CHARSET);
			InputStream response = conn.getInputStream();
			
			solver.initialize();
			return(solver.solveCaptchaFromUrl(response));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
