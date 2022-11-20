package com.example.consent.src.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.example.consent.src.entity.CTaskInfo;
import com.example.consent.src.model.CTaskResponse;
import com.example.consent.src.model.ConsentRequest;
import com.example.consent.src.repository.ConsentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsentInfoService {
    @PersistenceContext(name = "databaseEntityManager", unitName = "db1")
    EntityManager databaseEntityManager;

    @Autowired
    ConsentInfoRepository consentInfoRepository;

    public CTaskResponse getCTaskDetails(String cTask) {
        CTaskInfo cTaskEntityInfo = (CTaskInfo) consentInfoRepository
                .fetch(databaseEntityManager, new CTaskInfo(), "cTask", cTask)
                .get(0);
        return new CTaskResponse(cTaskEntityInfo.getName(),
                cTaskEntityInfo.getEmail(), cTaskEntityInfo.getcTask(), cTaskEntityInfo.isConsentGiven()
        );
    }

    @Transactional
    public String setConsentForCTask(ConsentRequest consentRequest) {
        consentInfoRepository.update(databaseEntityManager, new CTaskInfo(), "cTask", consentRequest.getcTask(),
                        "consentGiven", consentRequest.isConsentGiven());
        return "Success";
    }
}
