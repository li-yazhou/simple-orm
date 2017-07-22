package org.alpha.commons.dbpipe.impl;

import org.alpha.commons.dbpipe.DBPipe;
import org.alpha.commons.dbpipe.annotation.Table;
import org.alpha.commons.dbpipe.domain.Filter;
import org.alpha.commons.dbpipe.domain.PageBean;
import org.alpha.commons.dbpipe.util.JdbcUtil;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:01
 */
public class DBPipeImpl<E> implements DBPipe<E> {

    public E executeQuery(String rawSql) {
        return null;
    }

    public int executeUpdate(String rawSql){
        return -1;
    }

    public int add(E element) {
        if (element == null)
            throw new IllegalArgumentException("插入的元素为空.");
        Class clazz = element.getClass();
        String tableName = getTableName(clazz);
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length == 0)
            throw new RuntimeException(element + "没有属性.");
        // TODO: 2017/7/22 去除属性为null的占位符，下一版本优化
        String sql = getInsertSql(tableName, fields.length);
        Object[] params = getSqlParams(element, fields);
        System.out.println("insertSql = " + sql);
        System.out.println(Arrays.toString(params));
        return JdbcUtil.excuteUpdate(sql, params);
    }

    private Object[] getSqlParams(E element, Field[] fields) {
        Object[] params = new Object[fields.length];
        for (int i = 0; i < fields.length; i ++){
            fields[i].setAccessible(true);
            try {
                params[i] = fields[i].get(element);
            } catch (IllegalAccessException e) {
                System.out.println("获取" + element + "的属性值失败！");
                // e.printStackTrace();
            }
        }
        return params;
    }

    private String getInsertSql(String tableName, int length) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(tableName).append(" values(");
        for (int i = 0; i < length; i ++)  // 添加参数占位符?
            sql.append("?,");
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        return sql.toString();
    }

    private String getTableName(Class<E> clazz) {
        boolean existTableAnno = clazz.isAnnotationPresent(Table.class);
        if (!existTableAnno)
            throw new RuntimeException(clazz + " 没有Table注解.");
        Table tableAnno = (Table)clazz.getAnnotation(Table.class);
        return tableAnno.name();
    }

    public int delete(Integer id, Class<E> clazz) {
        return 0;
    }

    public int delete(String id, Class<E> clazz) {
        return 0;
    }

    public E remove(Integer id, Class<E> clazz) {
        return null;
    }

    public E remove(String id, Class<E> clazz) {
        return null;
    }

    public int update(E element) {
        return 0;
    }

    public int update(E element, boolean bool) {
        return 0;
    }

    public E query(Integer id, Class<E> clazz) {
        return null;
    }

    public E query(String id, Class<E> clazz) {
        return null;
    }

    public E query(Filter filter, Class<E> clazz) {
        return null;
    }

    public E query(PageBean pageBean, Class<E> clazz) {
        return null;
    }

    public int count(Class<E> clazz) {
        return 0;
    }

    public int getLastAutoIncrementId() {
        return 0;
    }
}
