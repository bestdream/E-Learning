package com.util;

import java.beans.PropertyEditorSupport;

public class StringEscapeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			value=cleanXSS(value);
			setValue(value);
		}
	}
	private String cleanXSS(String value) {
		value = value.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
		return value;
	}
}
