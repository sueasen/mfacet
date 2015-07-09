package org.worsome.sample.business.domain.base;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * {@link ManyA}
 *
 * @author SUEHARAA1
 */
@Entity
@Table(name = "MANY_A")
public class ManyA implements java.io.Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -4716634882062762231L;

    /** id */
    @Id
    @Column(name = "ID")
    private Integer id;

    /** manyB */
    @ManyToMany(targetEntity = ManyB.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "MANY_A_B"
            , joinColumns = { @JoinColumn(name = "MANY_A_ID") }
            , inverseJoinColumns = { @JoinColumn(name = "MANY_B_ID") })
    private List<ManyB> manyBs;

    /**
     * コンストラクタ
     */
    public ManyA() {
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
     * manyBs を取得します。
     *
     * @return manyBs
     */
    public List<ManyB> getManyBs() {
        return manyBs;
    }

    /**
     * manyBs を設定します。
     *
     * @param manyBs セットする manyBs
     */
    public void setManyBs(List<ManyB> manyBs) {
        this.manyBs = manyBs;
    }

}
