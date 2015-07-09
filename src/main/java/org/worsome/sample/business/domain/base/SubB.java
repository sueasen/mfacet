package org.worsome.sample.business.domain.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * {@link SubB}
 *
 * @author SUEHARAA1
 */
@Entity
@Table(name = "SUB_B")
public class SubB implements java.io.Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5159551272760754042L;

    /** id */
    @Id
    @Column(name = "ID")
    private Integer id;

    /** main */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAIN_ID", referencedColumnName = "ID")
    private Main main;

    /**
     * コンストラクタ
     */
    public SubB() {
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
