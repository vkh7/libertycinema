package com.java.gwt.libertycinema.client.views;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

import com.java.gwt.libertycinema.client.BaseLayout;


public class ImageUpload implements Command {

    private final BaseLayout baseLayout;
    private final FormPanel form = new FormPanel();
    private final Label errorText = new Label();

    public ImageUpload(BaseLayout baseLayout) {
        this.baseLayout = baseLayout;
    }

    public void execute() {
        form.setAction("/libertycinema/uploadimage");
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        FlexTable grid = new FlexTable();
        grid.setStyleName("formTable");

        grid.setWidget(1, 0, new Label("Title:"));
        final TextBox title = new TextBox();
        title.setName("title");
        grid.setWidget(1, 1, title);
        grid.setWidget(1, 2, errorText);
        errorText.setStyleName("validationText");

        grid.setWidget(2, 0, new Label("Description:"));
        final TextArea description = new TextArea();
        description.setName("description");
        grid.setWidget(2, 1, description);

        grid.setWidget(3, 0, new Label("Pick a file:"));
        FileUpload upload = new FileUpload();
        upload.setName("image");
        grid.setWidget(3, 1, upload);

        grid.setWidget(4, 1, new Button("Upload Image", new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.submit();
            }
        }));

        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            public void onSubmit(SubmitEvent event) {
                if (title.getText().length() == 0) {
                    errorText.setText("Please fill in a title string");
                    event.cancel();
                }
            }
        });

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            public void onSubmitComplete(SubmitCompleteEvent event) {
            }
        });

        form.setWidget(grid);

        baseLayout.getMainPanel().setTitle("Image Uploads");
        baseLayout.getMainPanel().setContent(form);
    }

}