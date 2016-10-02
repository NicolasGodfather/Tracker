package com.pvt.tracker;


import com.pvt.tracker.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PermissionsTag extends TagSupport {

	private static final long serialVersionUID = 242682661874554L;
	private String rule;

	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		User user = (User) req.getSession().getAttribute("logged_user");
		for (User userType : user.getUserTypes()) {
			if (userType.getUserType().getPermission().contains(rule)) {
				return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;
	}

	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}


}
