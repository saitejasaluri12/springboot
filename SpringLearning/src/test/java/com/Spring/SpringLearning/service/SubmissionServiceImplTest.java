package com.Spring.SpringLearning.service;
import com.Spring.SpringLearning.model.SubmissionDTO;
import com.Spring.SpringLearning.repository.SubmissionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubmissionServiceImplTest {
    @Mock
     SubmissionRepository submissionRepository;

    @InjectMocks
    SubmissionServiceImpl submissionService;

    @Test
    public void test_getSubmission(){
        SubmissionDTO mockSubmission = getSubmission("25-1-2023","john","java","mike","kalyan");

        when(submissionRepository.getSubmission("id-1")).thenReturn(mockSubmission);

        SubmissionDTO result = submissionService.getSubmission("id-1");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("john",result.getSalesPersonName());
    }

    @Test
    public void test_addSubmission(){
        SubmissionDTO mockSubmission = getSubmission("25-1-2023","john","java","mike","kalyan");

        when(submissionRepository.addSubmission(mockSubmission)).thenReturn(mockSubmission);

        SubmissionDTO result = submissionService.addSubmission(mockSubmission);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("john",result.getSalesPersonName());
    }


@Test
public void test_delSubmission(){
    SubmissionDTO mockSubmission = getSubmission("25-1-2023","john","java","mike","kalyan");

    when(submissionRepository.deleteSubmission("john")).thenReturn(true);

    boolean result = submissionService.deleteSubmission("john");

    Assertions.assertTrue(result);
}

    @Test
    public void test_updateSubmission(){
        SubmissionDTO mockSubmission = getSubmission("25-1-2023","john","java","mike","kalyan");

        when(submissionRepository.updateSubmission(mockSubmission)).thenReturn(mockSubmission);

        SubmissionDTO result = submissionService.updateSubmission(mockSubmission);

        Assertions.assertNotNull(result);
    }



    public static SubmissionDTO getSubmission(String date, String salesPersonName, String technology, String vendorName, String consultantName){
        SubmissionDTO dto = new SubmissionDTO();
        dto.setSubmissionDate(date);
        dto.setSalesPersonName(salesPersonName);
        dto.setTechnology(technology);
        dto.setVendorName(vendorName);
        dto.setConsultantName(consultantName);
        return dto;
    }


}
