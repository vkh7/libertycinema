package com.java.gwt.libertycinema.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;

import com.google.gwt.dom.client.Style.Unit;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LibertyCinema implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
	DockLayoutPanel p = new DockLayoutPanel(Unit.EM);
	// Create a vertical panel, add buttons to north
	// Create a vertical panel, add acks to the south
	// Create a horizontal panel, add content to middle
	p.addNorth(new HTML("header"), 2);
	p.addSouth(new HTML("footer"), 2);
	p.add(new HTML("asdjlkasdljadsassadass"));
	RootLayoutPanel.get().add(p);

    }
}
