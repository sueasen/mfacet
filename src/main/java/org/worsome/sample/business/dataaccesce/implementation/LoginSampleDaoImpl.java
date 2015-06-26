package org.worsome.sample.business.dataaccesce.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.worsome.sample.business.dataaccesce.LoginSampleDao;
import org.worsome.sample.business.domain.base.LoginSample;

/**
 * {@link LoginSampleDaoImpl}
 *
 * @author SueharaA1
 */
@Repository("loginSampleDao")
public class LoginSampleDaoImpl implements LoginSampleDao {

    /** entityManager */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * コンストラクタ
     *
     * @param entityManager entityManager
     */
    public LoginSampleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * コンストラクタ
     */
    public LoginSampleDaoImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginSample find(String id) {
        return entityManager.find(LoginSample.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginSample find(String id, String password) {
        LoginSample test = find(id);
        return test != null && StringUtils.equals(password, test.getPassword()) ? test : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginSample findByVersion(String id, Date version) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LoginSample> query = builder.createQuery(LoginSample.class);
        Root<LoginSample> root = query.from(LoginSample.class);

        query.where(builder.equal(root.get("version"), version));
        List<LoginSample> results = entityManager.createQuery(query).getResultList();

        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LoginSample> findAll() {
        CriteriaQuery<LoginSample> query = entityManager.getCriteriaBuilder().createQuery(LoginSample.class);
        return entityManager.createQuery(query.select(query.from(LoginSample.class))).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(LoginSample loginSample) {
        entityManager.merge(loginSample);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(LoginSample loginSample) {
        entityManager.persist(loginSample);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(LoginSample loginSample) {
        entityManager.remove(entityManager.merge(loginSample));
    }
}
