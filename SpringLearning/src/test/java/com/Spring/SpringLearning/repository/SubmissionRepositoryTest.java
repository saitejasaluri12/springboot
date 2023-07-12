package com.Spring.SpringLearning.repository;
import com.Spring.SpringLearning.model.SubmissionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;


public class SubmissionRepositoryTest {
    static SubmissionRepositoryClass submissionRepository;

    @BeforeAll
    public static void init() {
        submissionRepository = new SubmissionRepositoryClass();
    }
    @Test
    public void test_addSubmission() throws Exception{

        SubmissionDTO dto= getSubmission("25-1-2023","john","java","mike","kalyan");
        Class<?> myClass = SubmissionRepositoryClass.class;
        Field privateField = myClass.getDeclaredField("submissions");
        privateField.setAccessible(true);
        HashMap<String,SubmissionDTO> hm = (HashMap<String, SubmissionDTO>) privateField.get(submissionRepository);
        int size=hm.size();

        SubmissionDTO result = submissionRepository.addSubmission(dto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("john",result.getSalesPersonName());
        Assertions.assertEquals("mike",result.getVendorName());
        Assertions.assertEquals(size+1,hm.size());
    }

    @Test
    public void test_updateSubmission() throws NoSuchFieldException, IllegalAccessException {
        SubmissionDTO dto= getSubmission("25-1-2023","john","java","mike","kalyan");
        Class<?> myClass = SubmissionRepositoryClass.class;
        Field privateField = myClass.getDeclaredField("submissions");
        privateField.setAccessible(true);
        HashMap<String,SubmissionDTO> hm = (HashMap<String, SubmissionDTO>) privateField.get(submissionRepository);
        hm.put("id-1",dto);

        SubmissionDTO dto1= getSubmission("25-1-2023","john","java","alex","kalyan");
        dto1.setId("id-1");
        SubmissionDTO result = submissionRepository.updateSubmission(dto1);


        Assertions.assertEquals("alex",hm.get("id-1").getVendorName());

        Assertions.assertNotNull(result);

    }

    @Test
    public void test_delSubmission() throws Exception{
        SubmissionDTO dto= getSubmission("25-1-2023","john","java","mike","kalyan");
        Class<?> myClass = SubmissionRepositoryClass.class;
        Field privateField = myClass.getDeclaredField("submissions");
        privateField.setAccessible(true);
        HashMap<String,SubmissionDTO> hm = (HashMap<String, SubmissionDTO>) privateField.get(submissionRepository);
        hm.put("id-1",dto);

        boolean result= submissionRepository.deleteSubmission("kalyan");

        Assertions.assertTrue(result);
        Assertions.assertEquals(0,hm.size());

    }
    @Test
    public void test_getSubmission() throws Exception{
        SubmissionDTO dto= getSubmission("25-1-2023","john","java","mike","kalyan");
        Class<?> myClass = SubmissionRepositoryClass.class;
        Field privateField = myClass.getDeclaredField("submissions");
        privateField.setAccessible(true);
        HashMap<String,SubmissionDTO> hm = (HashMap<String, SubmissionDTO>) privateField.get(submissionRepository);
        hm.put("id-1",dto);

        SubmissionDTO result=submissionRepository.getSubmission("id-1");
        Assertions.assertEquals("john",result.getSalesPersonName());
    }

    public static SubmissionDTO getSubmission(String date,String salesPersonName,String technology, String vendorName,String consultantName){
        SubmissionDTO dto = new SubmissionDTO();
        dto.setSubmissionDate(date);
        dto.setSalesPersonName(salesPersonName);
        dto.setTechnology(technology);
        dto.setVendorName(vendorName);
        dto.setConsultantName(consultantName);
        return dto;
    }
}
