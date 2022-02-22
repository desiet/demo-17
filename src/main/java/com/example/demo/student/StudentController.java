package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collagestudent")
public class StudentController {

    @Autowired
     StudentService studentService;

    @GetMapping("/")
    public List<CollageStudent> hello() {
        return studentService.getAllStudent();

    }
   @PostMapping("/")
   @ResponseStatus(HttpStatus.CREATED)
  public void registerNewStudent(@RequestBody CollageStudent collageStudent){
       studentService.addNewStudent(collageStudent);

 }

  @DeleteMapping(path="{collageStudentId}")
public void deleteStudent(@PathVariable("collageStudentId") Long collageStudentId){

        studentService.deleletStudent(collageStudentId);
  }

  @PutMapping(path= "{studentId}")
  public void updateStudent(){


  }
}