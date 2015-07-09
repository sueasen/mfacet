package org.worsome.sample.business.domain.base;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * {@link ManyB}
 *
 * @author SUEHARAA1
 */
@Entity
@Table(name = "MANY_B")
public class ManyB implements java.io.Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3911982916360458720L;

    /** id */
    @Id
    @Column(name = "ID")
    private Integer id;

    /** manyA */
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "manyBs")
    private List<ManyA> manyAs;

    /**
     * コンストラクタ
     */
    public ManyB() {
    }

    /**
     * id を取得します。
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id を設定します。
     *
     * @param id セットする id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * manyAs を取得します。
     *
     * @return manyAs
     */
    public List<ManyA> getManyAs() {
        return manyAs;
    }

    /**
     * manyAs を設定します。
     *
     * @param manyAs セットする manyAs
     */
    public void setManyAs(List<ManyA> manyAs) {
        this.manyAs = manyAs;
    }

}
