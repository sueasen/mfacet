package org.worsome.sample.business.service;

import java.util.List;

import org.worsome.sample.business.domain.base.LoginSample;
import org.worsome.sample.presentation.base.dto.LoginSampleDto;

/**
 * {@link LoginSampleService}
 *
 * @author SUEHARAA1
 */
public interface LoginSampleService {

    /**
     * ログインします。
     *
     * @param id id
     * @param password password
     * @return loginUser
     */
    LoginSample login(String id, String password);

    /**
     * ログインサンプルを取得します。
     *
     * @param id id
     * @return loginSample
     */
    LoginSample find(String id);

    /**
     * ログインサンプルを全件取得します。
     *
     * @return loginSampleリスト
     */
    List<LoginSample> findAll();

    /**
     * ログインサンプルを更新します。
     *
     * @param dto dto
     */
    void update(LoginSampleDto dto);

    /**
     * ログインサンプルを登録します。
     *
     * @param dto dto
     */
    void insert(LoginSampleDto dto);

    /**
     * ログインサンプルを削除します。
     *
     * @param dto dto
     */
    void delete(LoginSampleDto dto);

}
