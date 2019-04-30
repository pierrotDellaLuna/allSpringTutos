package ictcg.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ictcg.com.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
