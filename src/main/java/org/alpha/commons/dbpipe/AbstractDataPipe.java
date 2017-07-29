package org.alpha.commons.dbpipe;

import org.alpha.commons.dbpipe.domain.Filter;
import org.alpha.commons.dbpipe.domain.PageBean;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-22 16:00
 */
public interface AbstractDataPipe<E> {
    E executeQuery(String rawSql);
    int executeUpdate(String rawSql);
    int[] batch(String[] rawSqls);
    int[] batch(String[] rawSqls, Object[][] params);
    int add(E element);
    int update(E element);
    int update(E element, boolean bool);
    int delete(Integer id, Class<E> clazz);
    int delete(String id, Class<E> clazz);
    E remove(Integer id, Class<E> clazz);
    E remove(String id, Class<E> clazz);
    E query(Integer id, Class<E> clazz);
    E query(String id, Class<E> clazz);
    E query(Filter filter, Class<E> clazz);
    E query(PageBean pageBean, Class<E> clazz);
    int count(Class<E> clazz);
    int getLastAutoIncrementId();
}
