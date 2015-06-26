/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.base.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * LoginDto
 *
 * @author SUEHARAA1
 */
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 3428490997353904743L;

    /** id */
    @NotEmpty
    @Length(max = 20)
    private String id;

    /** password */
    @NotEmpty
    @Length(max = 20)
    private String password;

    /**
     * コンストラクタ
     */
    public LoginDto() {
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

}
