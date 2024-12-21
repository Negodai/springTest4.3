package ru.springtest.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeacherDao extends CrudRepository<Teacher, Integer> {

    @Query("SELECT t FROM Teacher t WHERE t.name LIKE CONCAT('%',?1,'%')")
    Iterable<Teacher> findByName(String name);
}
