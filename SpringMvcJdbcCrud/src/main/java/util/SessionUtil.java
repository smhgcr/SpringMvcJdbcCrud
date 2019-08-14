package util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

	public static String control(HttpServletRequest req, String page) {

		boolean statu = req.getSession().getAttribute("userSession") != null;

		if (statu) {

			return page;
		}

		return "redirect:/";
	}
}
