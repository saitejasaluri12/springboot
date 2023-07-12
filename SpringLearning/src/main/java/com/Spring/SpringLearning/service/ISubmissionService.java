package com.Spring.SpringLearning.service;

import com.Spring.SpringLearning.model.SubmissionDTO;

import java.util.List;

public interface ISubmissionService {
    SubmissionDTO getSubmission(String id);
    List<SubmissionDTO> getAll();
    SubmissionDTO addSubmission(SubmissionDTO submission);
    SubmissionDTO updateSubmission(SubmissionDTO submission);

    boolean deleteSubmission(String id);




}
