package org.worsome.mfacet.business.dataaccesce;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * {@link AbstractDao}
 *
 * @author SueharaA1
 * @param <E> entity の型
 */
public abstract class AbstractDao<E> {

    /** entityManager */
    @PersistenceContext
    private EntityManager entityManager;

    /** entityManagerSupport */
    private EntityManagerSupport<E> entityManagerSupport;

    /** entityClass */
    private final Class<E> entityClass;

    /**
     * コンストラクタ
     *
     * @param entityClass entityClass
     */
    public AbstractDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * entityManagerSupport を取得します。
     *
     * @return entityManagerSupport
     */
    protected EntityManagerSupport<E> getEntityManagerSupport() {
        if (entityManagerSupport == null) {
            this.entityManagerSupport = new EntityManagerSupport<>(this.entityManager, this.entityClass);
        }
        return entityManagerSupport;
    }

    /**
     * entityManagerSupport を設定します。
     *
     * @param entityManagerSupport セットする entityManagerSupport
     */
    void setEntityManagerSupport(EntityManagerSupport<E> entityManagerSupport) {
        this.entityManagerSupport = entityManagerSupport;
    }

}
