package com.barclays.trade.confirmationlayer.service;

import com.barclays.trade.confirmationlayer.entity.ClientConfirmation;
import com.barclays.trade.confirmationlayer.entity.Confirmation;
import com.barclays.trade.confirmationlayer.message.ConfirmationMessage;
import com.barclays.trade.confirmationlayer.message.Message;
import com.barclays.trade.confirmationlayer.model.ConfirmationDto;
import com.barclays.trade.confirmationlayer.model.ErrorType;
import com.barclays.trade.confirmationlayer.model.Fault;
import com.barclays.trade.confirmationlayer.notification.InvalidConfirmationNotification;
import com.barclays.trade.confirmationlayer.notification.Notifier;
import com.barclays.trade.confirmationlayer.notification.NotifierFactory;
import com.barclays.trade.confirmationlayer.startup.StaticConfirmationLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to process events and produce Confirmation notifications
 */
@Service
public class ConfirmationService  {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfirmationService.class);

    private final NotifierFactory notifierFactory;

    public ConfirmationService(NotifierFactory notifierFactory) {
        this.notifierFactory = notifierFactory;
    }

    public Message processConfirmations(List<ClientConfirmation> clientConfirmationList) {
        LOGGER.info("Processing confirmations {}", clientConfirmationList);
        List<ConfirmationDto> apiResponseDto = new ArrayList<>();
        for (ClientConfirmation clientConfirmation : clientConfirmationList) {
            Confirmation confirmation = StaticConfirmationLoader.confirmationMap.get(clientConfirmation.getConfirmationId());
            ConfirmationDto confirmationDto = creatConfirmationDto(confirmation);
            //this would go for Api Response
            apiResponseDto.add(creatConfirmationDto(confirmation));
            ConfirmationMessage messageToNotify = ConfirmationMessage.builder()
                    .confirmationDtoList(Collections.singletonList(confirmationDto)).build();
            Notifier<Message> notifier = notifierFactory.getNotifier(confirmation.getConfirmationType());
            handleInvalidConfirmationType(notifier, messageToNotify);
            //message used by specific notifier service
            notifier.notify(messageToNotify);

        }
       return ConfirmationMessage.builder().confirmationDtoList(apiResponseDto).build();
    }

    private void handleInvalidConfirmationType(Notifier<Message> notifier, ConfirmationMessage messageToNotify) {
        if(notifier instanceof InvalidConfirmationNotification){
            Fault fault = new Fault();
            fault.setDescription("No valid type of confirmation claimed by the rule");
            fault.setErrorType(ErrorType.INVALID_CONFIRMATION);
            messageToNotify = ConfirmationMessage.builder().fault(fault).build();
        }
    }

    private ConfirmationDto creatConfirmationDto(Confirmation confirmation) {
       return ConfirmationDto.builder()
               .message("Notifying for "+ confirmation.getConfirmationType())
                .msgType(confirmation.getConfirmationType().name())
                .msgMedium(confirmation.getDeliveryModes())
                .build();

    }

}
