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
 * {@link InputDto}
 *
 * @author SUEHARAA1
 */
public class InputDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3428490997353904743L;

    /** text */
    @NotEmpty
    @Length(max = 20)
    private String text;

    /** textarea */
    @Length(min = 3, max = 100)
    private String textarea;

    /** checkbox */
    private boolean checkbox;

    /** checkboxes */
    private String[] checkboxes;

    /** radiobutton */
    private String radiobutton;

    /** select */
    private String select;

    /** selects */
    private String[] selects;

    /** password */
    private String password;

    /** date */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;

    /** number */
    private Integer number;

    /** email */
    private String email;

    /**
     * コンストラクタ
     */
    public InputDto() {
    }

    /**
     * text を取得します。
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * text を設定します。
     *
     * @param text セットする text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * textarea を取得します。
     *
     * @return textarea
     */
    public String getTextarea() {
        return textarea;
    }

    /**
     * textarea を設定します。
     *
     * @param textarea セットする textarea
     */
    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    /**
     * checkbox を取得します。
     *
     * @return checkbox
     */
    public boolean isCheckbox() {
        return checkbox;
    }

    /**
     * checkbox を設定します。
     *
     * @param checkbox セットする checkbox
     */
    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    /**
     * checkboxes を取得します。
     *
     * @return checkboxes
     */
    public String[] getCheckboxes() {
        return checkboxes;
    }

    /**
     * checkboxes を設定します。
     *
     * @param checkboxes セットする checkboxes
     */
    public void setCheckboxes(String[] checkboxes) {
        this.checkboxes = checkboxes;
    }

    /**
     * radiobutton を取得します。
     *
     * @return radiobutton
     */
    public String getRadiobutton() {
        return radiobutton;
    }

    /**
     * radiobutton を設定します。
     *
     * @param radiobutton セットする radiobutton
     */
    public void setRadiobutton(String radiobutton) {
        this.radiobutton = radiobutton;
    }

    /**
     * select を取得します。
     *
     * @return select
     */
    public String getSelect() {
        return select;
    }

    /**
     * select を設定します。
     *
     * @param select セットする select
     */
    public void setSelect(String select) {
        this.select = select;
    }

    /**
     * selects を取得します。
     *
     * @return selects
     */
    public String[] getSelects() {
        return selects;
    }

    /**
     * selects を設定します。
     *
     * @param selects セットする selects
     */
    public void setSelects(String[] selects) {
        this.selects = selects;
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
     * date を取得します。
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * date を設定します。
     *
     * @param date セットする date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * number を取得します。
     *
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * number を設定します。
     *
     * @param number セットする number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * email を取得します。
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * email を設定します。
     *
     * @param email セットする email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
