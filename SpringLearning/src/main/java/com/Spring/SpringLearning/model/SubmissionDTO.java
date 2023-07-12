package com.Spring.SpringLearning.model;

import lombok.Data;

@Data
public class SubmissionDTO {

    private String id;
    private String consultantName;
    private String submissionDate;
    private String leadName;
    private Long rate;
    private String salesPersonName;
    private String technology;
    private String vendorName;
}
