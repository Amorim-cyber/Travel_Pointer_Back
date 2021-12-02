package com.app.travelPointer.exceptions;

import com.app.travelPointer.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
