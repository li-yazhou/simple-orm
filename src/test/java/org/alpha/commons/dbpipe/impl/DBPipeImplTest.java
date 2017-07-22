package org.alpha.commons.dbpipe.impl;

import org.junit.Test;

import java.util.Calendar;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:31
 */
public class DBPipeImplTest {
    @Test
    public void add(){
        Student student = new Student(1, "zz", 25);
        // student.setBirthday(Calendar.getInstance());
        System.out.println(student);
        new DBPipeImpl<Student>().add(student);
    }
}
