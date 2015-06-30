/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.base.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * {@link LoginSampleDto}
 *
 * @author SUEHARAA1
 */
public class LoginSampleDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3428490997353904743L;

    /** id */
    @NotEmpty
    @Length(max = 20)
    private String id;

    /** password */
    @NotEmpty
    @Length(max = 20)
    private String password;

    /** version */
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
    private Date version;

    /**
     * コンストラクタ
     */
    public LoginSampleDto() {
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
     * @param version セットする version
     */
    public void setVersion(Date version) {
        this.version = version;
    }

}
