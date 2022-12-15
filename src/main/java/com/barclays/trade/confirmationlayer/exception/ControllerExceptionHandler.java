package com.barclays.trade.confirmationlayer.exception;

import com.barclays.trade.confirmationlayer.message.ConfirmationMessage;
import com.barclays.trade.confirmationlayer.message.Message;
import com.barclays.trade.confirmationlayer.model.ErrorType;
import com.barclays.trade.confirmationlayer.model.Fault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Common handler for controller exceptions
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ExceptionHandler(MessageValidationException.class)
    public ResponseEntity<Object> handleMessageValidationExceptions(Exception ex, WebRequest request){

        Message confirmationMessage =  ConfirmationMessage.builder().fault(createFaultObject(ex, "Please enrich and resend", ErrorType.VALIDATION)).build();
        return new ResponseEntity<>(confirmationMessage, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<Object> handleNoDataExceptions(Exception ex, WebRequest request){
        Message confirmationMessage =  ConfirmationMessage.builder().fault(createFaultObject(ex, "Please check the event details", ErrorType.NO_DATA)).build();
        return new ResponseEntity<>(confirmationMessage, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ClientRuleException.class)
    public ResponseEntity<Object> handleClientRuleExceptions(Exception ex, WebRequest request){
        Message confirmationMessage =  ConfirmationMessage.builder().fault(createFaultObject(ex, "Please check the event details", ErrorType.RULE_VALIDATION)).build();
        return new ResponseEntity<>(confirmationMessage, HttpStatus.BAD_REQUEST);

    }


    private Fault createFaultObject(Exception ex, String description , ErrorType errorType) {
        Fault fault = new Fault();
        fault.setErrorMsg(ex.getMessage());
        fault.setErrorType(errorType);
        fault.setDescription(description);
        return fault;
    }


}
