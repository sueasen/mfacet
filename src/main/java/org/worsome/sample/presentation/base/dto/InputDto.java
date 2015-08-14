/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.sample.presentation.base.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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

}
