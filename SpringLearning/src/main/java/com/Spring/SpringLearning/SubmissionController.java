package com.Spring.SpringLearning;

import com.Spring.SpringLearning.service.SubmissionServiceImpl;
import com.Spring.SpringLearning.model.SubmissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
    private final SubmissionServiceImpl submissionService;

    @Autowired
    public SubmissionController(SubmissionServiceImpl submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("get/{id}")
    public SubmissionDTO getSubmission(@PathVariable String id) {
        return submissionService.getSubmission(id);

    }

    @GetMapping("/getAll")
    public List<SubmissionDTO> getAll(){
        return submissionService.getAll();
    }

    @PostMapping("/add")
//    public SubmissionDTO addSubmission(@RequestBody SubmissionDTO submission) {
//        return submissionService.addSubmission(submission);
//
//    }
    public ResponseEntity<SubmissionDTO> addSubmission(@RequestBody SubmissionDTO submission) {
        ResponseEntity<SubmissionDTO> result= new ResponseEntity<>(HttpStatus.CREATED);
        result=ResponseEntity.status(result.getStatusCode()).body(submissionService.addSubmission(submission));

        return result;

    }

    @PutMapping("update")
    public SubmissionDTO updateSubmission( @RequestBody SubmissionDTO submission) {
        return  submissionService.updateSubmission(submission);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteSubmission(@PathVariable String id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null) ;

    }
}
