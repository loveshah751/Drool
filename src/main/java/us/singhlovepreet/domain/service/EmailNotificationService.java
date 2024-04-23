package us.singhlovepreet.domain.service;

import lombok.extern.java.Log;

import java.util.Objects;
import java.util.logging.Level;

@Log
public class EmailNotificationService {

    public boolean isValidEmailAddress(String emailAddress) {
        if(Objects.nonNull(emailAddress)) {
          log.info("Starting to make a API call to Auth Service to validate the Email Address");
          // can have Add the private method below which will make http call to third party API for the validation.
            return apiCall(emailAddress);
        }
        return false;
    }

    private boolean apiCall(String emailAddress) {
        return emailAddress.contains("@");
    }

    public void sendEmail(String emailAddress, String message) {
        if(isValidEmailAddress(emailAddress)) {
            log.info(message);
        }else{
            log.log(Level.SEVERE, "Failed to send the Message, InValid email Address");
        }

    }
}
