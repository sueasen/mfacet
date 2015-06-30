package org.worsome.sample.business.domain.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * {@link LoginSample}
 *
 * @author SUEHARAA1
 */
@Entity
@Table(name = "LOGIN_SAMPLE")
public class LoginSample implements java.io.Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3428490997353904743L;

    /** id */
    @Id
    @Column(name = "ID")
    private String id;

    /** password */
    @Column(name = "PASSWORD")
    private String password;

    /** version */
    @Column(name = "VERSION")
    @Temporal(TemporalType.TIMESTAMP)
    @Version
    private Date version;

    /**
     * コンストラクタ
     */
    public LoginSample() {
    }

    /**
     * id を取得します。
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * id を設定します。
     *
     * @param id セットする id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * password を取得します。
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * password を設定します。
     *
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * version を取得します。
     *
     * @return version
     */
    public Date getVersion() {
        return version;
    }

    /**
     * version を設定します。
     *
     * @param version セットする versione
     */
    public void setVersion(Date version) {
        this.version = version;
    }

}
