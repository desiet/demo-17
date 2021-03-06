package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

      @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }


    public List<CollageStudent> getAllStudent() {
        return  studentRepository.findAll();

    }

    public void addNewStudent(CollageStudent collageStudent) {
        Optional<CollageStudent>collageStudentOptional=studentRepository
                .findByEmail(collageStudent.getEmail());
        if(collageStudentOptional.isPresent()){

            throw new IllegalStateException("email taken");
        }
        studentRepository.save(collageStudent);


    }

    public void deleletStudent(Long collageStudentId) {
         boolean exists =studentRepository.existsById(collageStudentId);
        if(!exists){
            throw  new IllegalStateException( "collageStudent Id"+"collageStudentId"+"does not exists");
        }
        studentRepository.deleteById(collageStudentId);
    }
}