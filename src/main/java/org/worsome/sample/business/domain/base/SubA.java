package org.worsome.sample.business.domain.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * {@link SubA}
 *
 * @author SUEHARAA1
 */
@Entity
@Table(name = "SUB_A")
public class SubA implements java.io.Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5476529207168562472L;

    /** id */
    @Id
    @Column(name = "ID")
    private Integer id;

    /** main */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAIN_ID")
    private Main main;

    /**
     * コンストラクタ
     */
    public SubA() {
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
     * main を取得します。
     *
     * @return main
     */
    public Main getMain() {
        return main;
    }

    /**
     * main を設定します。
     *
     * @param main セットする main
     */
    public void setMain(Main main) {
        this.main = main;
    }

}
