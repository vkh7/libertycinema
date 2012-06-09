package com.java.gwt.libertycinema.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;

public class BaseAsyncCallback implements AsyncCallback {

    @Override
    public void onFailure(Throwable caught) {
        new ErrorDialogBox().show();
    }

    @Override
    public void onSuccess(Object result) {
    }

    private class ErrorDialogBox extends DialogBox {

        public ErrorDialogBox() {
            setText("Wah.. Wah.. Wah..! Something's gone wrong :(");
            Button ok = new Button("OK");
            ok.addClickHandler(new ClickHandler() {
                
                @Override
                public void onClick(ClickEvent event) {
                    ErrorDialogBox.this.hide();
                }
            });
        }
    }
}
