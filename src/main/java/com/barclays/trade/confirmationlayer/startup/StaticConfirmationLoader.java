package com.barclays.trade.confirmationlayer.startup;

import com.barclays.trade.confirmationlayer.dao.ConfirmationDao;
import com.barclays.trade.confirmationlayer.entity.Confirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Service to load Static confirmation on startup as they do not change often
 * so load them once application up
 */
@Service
public class StaticConfirmationLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaticConfirmationLoader.class);

    private final ConfirmationDao confirmationDao;
    public static List<Confirmation> confirmationList;

    public StaticConfirmationLoader(ConfirmationDao confirmationDao) {
        this.confirmationDao = confirmationDao;
    }

    @EventListener
    public void loadConfirmationOnStartUp(ApplicationReadyEvent applicationReadyEvent){

        LOGGER.info("populating all confirmation as cache");
        List<Confirmation> result = confirmationDao.findAll();
        confirmationList = Collections.unmodifiableList(result);

    }

}
