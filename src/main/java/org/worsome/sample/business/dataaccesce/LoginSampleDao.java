package org.worsome.sample.business.dataaccesce;

import java.util.Date;
import java.util.List;

import org.worsome.sample.business.domain.base.LoginSample;

/**
 * {@link LoginSampleDao}
 *
 * @author SueharaA1
 */
public interface LoginSampleDao {

    /**
     * 検索します。<br>
     *
     * @param id id
     * @return ログインサンプル
     */
    LoginSample find(String id);

    /**
     * 検索します。<br>
     *
     * @param id id
     * @param password password
     * @return ログインサンプル
     */
    LoginSample find(String id, String password);

    /**
     * 検索します。<br>
     *
     * @param id id
     * @param version version
     * @return ログインサンプル
     */
    LoginSample findByVersion(String id, Date version);

    /**
     * 全件検索します。<br>
     *
     * @return ログインサンプルリスト
     */
    List<LoginSample> findAll();

    /**
     * 更新します。<br>
     *
     * @param loginSample ログインサンプル
     */
    void update(LoginSample loginSample);

    /**
     * 追加します。<br>
     *
     * @param loginSample ログインサンプル
     */
    void insert(LoginSample loginSample);

    /**
     * 削除します。<br>
     *
     * @param loginSample ログインサンプル
     */
    void delete(LoginSample loginSample);

}
