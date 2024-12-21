package ru.springtest;


import static java.lang.System.out;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.springtest.dao.DaoConfig;
import ru.springtest.dao.Teacher;
import ru.springtest.dao.TeacherDao;

import java.lang.System;

public class Main {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(DaoConfig.class)) {

            TeacherDao dao = context.getBean(TeacherDao.class);

            var oneT = dao.findById(2);
            oneT.ifPresentOrElse(System.out::println, () -> out.println("Нет такого учителя"));

            dao.deleteById(22);

            Teacher newT = new Teacher(22, "Пупкин Василий Петрович", "Ялта, до востребования", "22211112221");
            dao.save(newT);

            var anotherT = dao.findById(22);
            anotherT.ifPresentOrElse(t -> {
                        t.setName("Пупкин Петр Васильевич");
                        dao.save(t);
                    },
                    () -> out.println("Нет такого учителя")
            );

            for (Teacher t : dao.findAll())
                out.println(t);

            for (Teacher t : dao.findByName("Петр"))
                out.println(t);
        }
    }
}
