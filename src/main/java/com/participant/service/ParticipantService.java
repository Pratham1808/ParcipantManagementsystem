package com.participant.service;

import org.springframework.stereotype.Service;

import com.participant.entity.Participant;

@Service
public class ParticipantService {
	public void calculateScore(Participant participant) {
        // Calculate the total marks
        double theoryAvg =((participant.getTheoryMarks1()+participant.getTheoryMarks2())/2);
        double practicalAvg = ((participant.getPracticalMarks1()+participant.getPracticalMarks2())/2);
        participant.setTotal((theoryAvg + practicalAvg) / 2);

        // Calculate the result
        if (participant.isSportsQuota()) {
            if (participant.getTotal() >= 70) {
                participant.setResult("PASS");
            } else {
                participant.setResult("FAIL");
            }
        } else {
            if (participant.getTotal() >= 75) {
                participant.setResult("PASS");
            } else {
                participant.setResult("FAIL");
            }
        }
    }
}
