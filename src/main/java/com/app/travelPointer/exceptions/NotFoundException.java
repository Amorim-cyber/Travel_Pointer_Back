package com.app.travelPointer.exceptions;

import com.back.publicOffer.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
