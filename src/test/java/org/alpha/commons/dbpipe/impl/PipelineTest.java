package org.alpha.commons.dbpipe.impl;

import org.alpha.commons.dbpipe.Pipeline;
import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 17:31
 */
public class PipelineTest {
    @Test
    public void add(){
        Student student = new Student(1, "zz", 25);
        // student.setBirthday(Calendar.getInstance());
        System.out.println(student);
        new Pipeline<Student>().add(student);
    }
}
