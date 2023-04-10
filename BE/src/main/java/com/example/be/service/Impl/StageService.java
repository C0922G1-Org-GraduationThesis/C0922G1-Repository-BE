package com.example.be.service.Impl;

import com.example.be.model.Stage;
import com.example.be.repository.IStageRepository;
import com.example.be.service.IStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StageService implements IStageService {
    @Autowired
    private IStageRepository stageRepository;


    @Override
    public Stage findStageById(int stageId) {
        return stageRepository.findById(stageId).get();
    }
}
