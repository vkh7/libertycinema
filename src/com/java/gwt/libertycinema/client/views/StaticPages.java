package com.java.gwt.libertycinema.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;

import com.java.gwt.libertycinema.client.BodyPanel;
import com.java.gwt.libertycinema.client.services.StaticDataService;
import com.java.gwt.libertycinema.client.services.StaticDataServiceAsync;


public class StaticPages implements Command {

    private BodyPanel body;
    private HorizontalPanel existingDataMenu = new HorizontalPanel();
    private ListBox dropDown = new ListBox();
    private Button editButton = new Button("Edit");
    private RichTextArea menuDescription = new RichTextArea();
    private TextBox menuName = new TextBox();
    private Button submitButton = new Button("Save Changes");

    public StaticPages(BodyPanel body) {
        this.body = body;
    }
    
    public void setupEditor() {
        body.add(menuName);
        body.add(menuDescription);
        body.add(submitButton);
        submitButton.addClickHandler(new SubmitHandler());
    }

    public void setupOptions() {
        existingDataMenu.add(dropDown);
        existingDataMenu.add(editButton);
        body.add(existingDataMenu);        
    }
    
    @Override
    public void execute() {
        body.clear();
        setupOptions();
        setupEditor();
    }
    
    private class SubmitHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            StaticDataServiceAsync sdService =
                    (StaticDataServiceAsync) GWT.create(StaticDataService.class);
            sdService.putData(menuName.getText(), menuDescription.getHTML(), new AsyncCallback<String> () {
                public void onFailure(Throwable caught) {
                    Window.alert(caught.toString());
                }
                
                public void onSuccess(String result) {
                    Window.alert(result);
                }
            });

        }
    }
}