package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.studentService.IStudentService;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest
{

    Student student = StudentFactory.createStudent("Ameer", "", "Ismail", 218216033);

    @Autowired
    private IStudentService studentService;

    @Test
    @Nullable
    @Order(1)
    void save()
    {
        Student created = this.studentService.save(this.student);
        assertEquals(this.student, created);
        System.out.println(created);

    }

    @Test
    @Order(2)
    void read()
    {
        Optional<Student> read = this.studentService.read(student.getStudentNumber());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.student, read.get())
        );
        System.out.println(read);
    }

    @Test
    @Order(3)
    void findAll()
    {
        List<Student> ListStudents = this.studentService.findAll();
        assertEquals(1, ListStudents.size());
        System.out.println(ListStudents);
    }

    @Test
    @Order(4)
    void delete()
    {
        this.studentService.deleteById(this.student.getStudentNumber());
        List<Student> listStudent = this.studentService.findAll();
        assertEquals(0, listStudent.size());
    }
}