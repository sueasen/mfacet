package org.worsome.mfacet.business.dataaccesce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.CollectionUtils;

/**
 * {@link EntityManagerSupport}
 *
 * @author SueharaA1
 * @param <E> entity の型
 */
public class EntityManagerSupport<E> {

    /** COL_NAME_VERSION */
    private static final String COL_NAME_VERSION = "version";

    /** entityManager */
    private final EntityManager entityManager;

    /** entityClass */
    private final Class<E> entityClass;

    /**
     * コンストラクタ
     *
     * @param entityManager entityManager
     * @param entityClass entityClass
     */
    public EntityManagerSupport(EntityManager entityManager, Class<E> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    /**
     * entityManager を取得します。
     *
     * @return entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * criteriaQuery を取得します。
     *
     * @return entityManager
     */
    public CriteriaQuery<E> createQuery() {
        return createQuery(entityClass);
    }

    /**
     * criteriaQuery を取得します。
     *
     * @param <T> entity の型
     * @param paramClass Entityクラス
     * @return entityManager
     */
    public <T> CriteriaQuery<T> createQuery(Class<T> paramClass) {
        return entityManager.getCriteriaBuilder().createQuery(paramClass);
    }

    /**
     * entity を取得します。
     *
     * @param <T> entity の型
     * @param <K> key の型
     * @param paramClass Entityクラス
     * @param key キー
     * @return entity
     */
    public <T, K> T find(Class<T> paramClass, K key) {
        return entityManager.find(paramClass, key);
    }

    /**
     * entity を取得します。
     *
     * @param <K> key の型
     * @param key キー
     * @return entity
     */
    public <K> E find(K key) {
        return find(entityClass, key);
    }

    /**
     * entity を取得します。
     *
     * @param <K> key の型
     * @param <V> version の型
     * @param key キー
     * @param version バージョン
     * @return entity
     */
    public <K, V> E findByVersion(K key, V version) {
        return findByVersion(entityClass, key, version);
    }

    /**
     * entity を取得します。
     *
     * @param <T> entity の型
     * @param <K> key の型
     * @param <V> version の型
     * @param paramClass Entityクラス
     * @param key キー
     * @param version バージョン
     * @return entity
     */
    public <T, K, V> T findByVersion(Class<T> paramClass, K key, V version) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = createQuery(paramClass);
        Root<T> root = query.from(paramClass);
        query.where(builder.equal(root.get(COL_NAME_VERSION), version));
        List<T> results = entityManager.createQuery(query).getResultList();
        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

    /**
     * entity リストを取得します。
     *
     * @param <T> entity の型
     * @param paramClass Entityクラス
     * @return entity リスト
     */
    public <T> List<T> findAll(Class<T> paramClass) {
        CriteriaQuery<T> query = this.createQuery(paramClass);
        return entityManager.createQuery(query.select(query.from(paramClass))).getResultList();
    }

    /**
     * entity リストを取得します。
     *
     * @return entity リスト
     */
    public List<E> findAll() {
        return findAll(entityClass);
    }

    /**
     * entity を更新します。
     *
     * @param <T> entity の型
     * @param entity entity
     * @return entity
     */
    public <T> T update(T entity) {
        return entityManager.merge(entity);
    }

    /**
     * entity を更新します。
     *
     * @param <T> entity の型
     * @param entity entity
     */
    public <T> void insert(T entity) {
        entityManager.persist(entity);
    }

    /**
     * entity を削除します。
     *
     * @param <T> entity の型
     * @param entity entity
     */
    public <T> void delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

}
