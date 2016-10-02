package com.pvt.tracker.controller;

import com.pvt.tracker.config.MessagesConfig;
import org.springframework.stereotype.Controller;

/**
 * Realization controller to load languages for each user
 */
@Controller
public class MessagesController extends MainController {

	/**
	 * Switch language. At the user's request to upload files
	 * with the language and put the object in the session.
	 */
	public void change() {
		String lang = param("lang");
		MessagesConfig mb = new MessagesConfig();
		if (lang.equals("RU")) {
			mb.setLanguage(MessagesConfig.Lang.RU);
		} else if (lang.equals("EN")) {
			mb.setLanguage(MessagesConfig.Lang.EN);
		}
		session("messages", mb);
		redirect("/");
	}
	
}
