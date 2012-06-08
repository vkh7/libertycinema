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
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;

import com.java.gwt.libertycinema.client.MainPanel;
import com.java.gwt.libertycinema.client.services.StaticDataService;
import com.java.gwt.libertycinema.client.services.StaticDataServiceAsync;
import com.java.gwt.libertycinema.shared.StaticDataInfo;


public class StaticPages implements Command {

    private MainPanel body;
    private ListBox dropDown = new ListBox();
    private RichTextArea menuDescription = new RichTextArea();
    private TextBox menuName = new TextBox();
    private Button submitButton = new Button("Save Changes");

    public StaticPages(MainPanel body) {
        this.body = body;
    }

    public void updateEditor(String name, String Description) {
        menuName.setText(name);
        menuDescription.setHTML(Description);
    }

    public void setupEditor() {
        Grid grid = new Grid(4, 2);
        grid.setWidget(0, 0, new Label("Pick a menu item:"));
        grid.setWidget(0, 1, dropDown);
        grid.setWidget(1, 0, new Label("Menu Name:"));
        grid.setWidget(1, 1, menuName);
        grid.setWidget(2, 0, new Label("Menu Description:"));
        grid.setWidget(2, 1, menuDescription);
        grid.setWidget(3, 1, submitButton);

        body.add(grid);
        updateMenuList();
        submitButton.addClickHandler(new SaveHandler());
        dropDown.addChangeHandler(new EditHandler());
    }

    @Override
    public void execute() {
        body.clear();
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