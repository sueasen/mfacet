package org.worsome.sample.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.worsome.sample.business.domain.base.Main;
import org.worsome.sample.business.domain.base.ManyA;
import org.worsome.sample.business.domain.base.ManyB;
import org.worsome.sample.business.domain.base.SubA;
import org.worsome.sample.business.domain.base.SubB;

/**
 * {@link EntityJoinServiceImpl}
 *
 * @author SUEHARAA1
 */
@Service("entityJoinService")
public class EntityJoinService {

    /** entityManager */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 検索します<br>
     * <li>OneToOne One : {@link Main}  One : {@link SubA}</li>
     * <li>OneToMany One : {@link Main}  Many : {@link SubB}</li>
     * <li>ManyToMany Many : {@link MainA}  Many : {@link ManyB}</li>
     *
     * @return list
     */
    public List<Object> find() {
        List<Object> list = new ArrayList<>();
        list.add(entityManager.find(Main.class, 1));
        list.add(entityManager.find(SubA.class, 11));
        list.add(entityManager.find(SubB.class, 21));
        list.add(entityManager.find(ManyA.class, 101));
        list.add(entityManager.find(ManyB.class, 201));
        return list;
    }
}
