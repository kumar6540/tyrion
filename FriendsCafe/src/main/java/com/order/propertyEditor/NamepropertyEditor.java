package com.order.propertyEditor;

import java.beans.PropertyEditorSupport;

public class NamepropertyEditor extends PropertyEditorSupport {


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		String myConvertedString = text.toUpperCase();
		setValue(myConvertedString);
	}
}