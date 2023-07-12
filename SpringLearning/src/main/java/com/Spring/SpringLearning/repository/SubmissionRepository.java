package com.Spring.SpringLearning.repository;

import com.Spring.SpringLearning.model.SubmissionDTO;

import java.util.List;

public interface SubmissionRepository {
    SubmissionDTO getSubmission(String id);
    List<SubmissionDTO> getAll();
    SubmissionDTO addSubmission(SubmissionDTO submission);
    SubmissionDTO updateSubmission(SubmissionDTO submission);
    boolean deleteSubmission(String id);


}

