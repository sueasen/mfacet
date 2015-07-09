package org.worsome.sample.business.domain.base;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * {@link Main}
 *
 * @author SUEHARAA1
 */
@Entity
@Table(name = "MAIN")
public class Main implements java.io.Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8556220302335712244L;

    /** id */
    @Id
    @Column(name = "ID")
    private Integer id;

    /** subA */
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "main")
    @JoinColumn(name = "ID", referencedColumnName = "MAIN_ID")
    private SubA subA;

    /** subBs */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAIN_ID")
    private Set<SubB> subBs;

    /**
     * コンストラクタ
     */
    public Main() {
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
     * subA を取得します。
     *
     * @return subA
     */
    public SubA getSubA() {
        return subA;
    }

    /**
     * subA を設定します。
     *
     * @param subA セットする subA
     */
    public void setSubA(SubA subA) {
        this.subA = subA;
    }

    /**
     * subBs を取得します。
     *
     * @return subas
     */
    public Set<SubB> getSubBs() {
        return subBs;
    }

    /**
     * subBs を設定します。
     *
     * @param subBs セットする subBs
     */
    public void setSubBs(Set<SubB> subBs) {
        this.subBs = subBs;
    }

}
