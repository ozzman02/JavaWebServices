package com.bharath.trainings.ws.client;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;


public class UTPasswordCallback implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callbacks[i];
            if (wsPasswordCallback.getIdentifier().equals("cxf")) {
                wsPasswordCallback.setPassword("cxf");
                return;
            }
        }
    }

}
