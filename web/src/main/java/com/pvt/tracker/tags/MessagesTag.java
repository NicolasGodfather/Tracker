package com.pvt.tracker.tags;

import com.pvt.tracker.config.MessagesConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Custom tag, using at jsp-pages for insert message with language support.
 *
 * @author Nicolas Asinovich.
 */
public class MessagesTag extends TagSupport {
	
	private static final long serialVersionUID = 1911603264081998198L;
	private String message;
		
	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
			MessagesConfig mb = (MessagesConfig) req.getSession().getAttribute("messages");
			out.println(mb.message(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
