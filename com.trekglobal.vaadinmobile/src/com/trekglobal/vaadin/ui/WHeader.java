package com.trekglobal.vaadin.ui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;

public class WHeader extends HorizontalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1444858543479291226L;
	
	private NativeButton leftButton;
	private Label centerLabel;
	private NativeButton rightButton;
	
	public WHeader(IToolbarView parentView, boolean showLeft, boolean showRight) {
		
		leftButton = new NativeButton();
		centerLabel = new Label(parentView.getWindowTitle());
		rightButton = new NativeButton();
		leftButton.setStyleName("bx-toolbar-button");
		leftButton.setId("left-toolbar-button");
		rightButton.setStyleName("bx-toolbar-button");

		centerLabel.addStyleName("bx-pagetitle");
		
		leftButton.setVisible(showLeft);
		rightButton.setVisible(showRight);
		
		if (showLeft)
			leftButton.addClickListener(event -> parentView.onLeftButtonPressed());
		
		if (showRight)
			rightButton.addClickListener(event -> parentView.onRightButtonPressed());
		
		//Takes care of the right alignment
		setSizeFull();
		
		addComponent(leftButton);
		addComponent(centerLabel);
		addComponent(rightButton);
		addStyleName("bx-toolbar");
		setComponentAlignment(leftButton, Alignment.MIDDLE_LEFT);
		setComponentAlignment(centerLabel, Alignment.MIDDLE_CENTER);
		setComponentAlignment(rightButton, Alignment.MIDDLE_RIGHT);

	}
	
	public void setLogoutButton() {
		rightButton.setIcon(VaadinIcons.POWER_OFF);
	}
	
	public void setMenuButton() {
		rightButton.setIcon(VaadinIcons.MENU);
	}
	
	public void setHomeButton() {
		rightButton.setIcon(VaadinIcons.HOME);
	}
	
	public void setBackButton() {
		leftButton.setIcon(VaadinIcons.ARROW_LEFT);
	}
	
	public void hideLeftButton() {
		leftButton.setIcon(null);
	}
	
	public void updateTitle(String title) {
		centerLabel.setValue(title);
	}
	
	public void setAboutButton() {
		rightButton.setIcon(VaadinIcons.INFO_CIRCLE_O);
	}

}
