package org.alpha.commons.dbpipe.impl;

import org.alpha.commons.dbpipe.DbPipeImpl;
import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:31
 */
public class DbPipeImplTest {
    @Test
    public void add(){
        Student student = new Student(120, "zz", 25);
        // student.setBirthday(Calendar.getInstance());
        System.out.println(student);
        new DbPipeImpl<Student>().add(student);
    }

    @Test
    public void update(){
        Student student = new Student(120, "2017-7-31 21:50:27", 25);
        // student.setBirthday(Calendar.getInstance());
        System.out.println(student);
        new DbPipeImpl<Student>().update(student);
    }
}
