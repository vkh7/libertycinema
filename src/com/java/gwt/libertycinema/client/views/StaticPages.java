package com.java.gwt.libertycinema.client.views;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import com.java.gwt.libertycinema.shared.StaticDataInfo;


public class StaticPages implements Command {

    private BodyPanel body;
    private HorizontalPanel existingDataMenu = new HorizontalPanel();
    private ListBox dropDown = new ListBox();
    private RichTextArea menuDescription = new RichTextArea();
    private TextBox menuName = new TextBox();
    private Button submitButton = new Button("Save Changes");

    public StaticPages(BodyPanel body) {
        this.body = body;
    }

    public void updateEditor(String name, String Description) {
        menuName.setText(name);
        menuDescription.setHTML(Description);
    }
    
    public void setupEditor() {
        body.add(menuName);
        body.add(menuDescription);
        body.add(submitButton);
        submitButton.addClickHandler(new SaveHandler());
    }
    
    public void setupOptions() {
        existingDataMenu.add(dropDown);
        body.add(existingDataMenu);
        updateMenuList();
        dropDown.addChangeHandler(new EditHandler());
    }
    
    @Override
    public void execute() {
        body.clear();
        setupOptions();
        setupEditor();
    }
    
    public void updateMenuList() {
        StaticDataServiceAsync sdService =
                (StaticDataServiceAsync) GWT.create(StaticDataService.class);
        sdService.getAllMenus(new AsyncCallback<List<StaticDataInfo>> () {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert(caught.toString());
            }
            
            @Override
            public void onSuccess(List<StaticDataInfo> result) {
                dropDown.clear();
                for (StaticDataInfo sd: result) {
                    dropDown.addItem(sd.getMenuName());
                }
            }
        });
    }
    
    private class SaveHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            StaticDataServiceAsync sdService =
                    (StaticDataServiceAsync) GWT.create(StaticDataService.class);
            sdService.putMenuItem(menuName.getText(), menuDescription.getHTML(),
                    new AsyncCallback<StaticDataInfo> () {
                public void onFailure(Throwable caught) {
                    Window.alert(caught.toString());
                }
                
                public void onSuccess(StaticDataInfo data) {
                    updateMenuList();
                }
            });
        }
    }
    
    private class EditHandler implements ChangeHandler {

        @Override
        public void onChange(ChangeEvent event) {
            StaticDataServiceAsync sdService =
                    (StaticDataServiceAsync) GWT.create(StaticDataService.class);
            String title = dropDown.getValue(dropDown.getSelectedIndex());
            sdService.getMenuItem(title, new AsyncCallback<StaticDataInfo> () {
                public void onFailure(Throwable caught) {
                    Window.alert(caught.toString());
                }
                
                public void onSuccess(StaticDataInfo data) {
                    updateEditor(data.getMenuName(), data.getMenuDescription());
                }
            });
            
        }
    }
}