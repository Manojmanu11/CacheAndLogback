package com.example.Logging.service;

import com.example.Logging.entity.Student;
import com.example.Logging.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student add(Student student){
        return studentRepository.save(student);
    }
    public List<Student> get(){
        return  studentRepository.findAll();
    }
    public Optional<Student> findById(int id){
        return studentRepository.findById(id);
    }
    public  void delete(int id){
        studentRepository.deleteById(id);
    }
    public Student update(Integer id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student user = optionalStudent.get();
            user.setName(updatedStudent.getName());
            user.setAge(updatedStudent.getAge());
            user.setGender(updatedStudent.getGender());
            return studentRepository.save(user);
        }
        return null;
    }


}
