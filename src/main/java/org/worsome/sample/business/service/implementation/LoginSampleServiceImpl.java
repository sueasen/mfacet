package org.worsome.sample.business.service.implementation;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worsome.sample.business.dataaccesce.LoginSampleDao;
import org.worsome.sample.business.domain.base.LoginSample;
import org.worsome.sample.business.service.LoginSampleService;
import org.worsome.sample.presentation.base.dto.LoginSampleDto;

/**
 * {@link LoginSampleServiceImpl}
 *
 * @author SUEHARAA1
 */
@Service("loginSampleService")
public class LoginSampleServiceImpl implements LoginSampleService {

    /** loginSampleDao */
    private LoginSampleDao loginSampleDao;

    /**
     * コンストラクタ
     *
     * @param loginSampleDao loginSampleDao
     */
    @Autowired
    public LoginSampleServiceImpl(LoginSampleDao loginSampleDao) {
        this.loginSampleDao = loginSampleDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginSample login(String id, String password) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(password)) {
            return null;
        }
        return loginSampleDao.find(id, password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginSample find(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return loginSampleDao.find(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LoginSample> findAll() {
        return loginSampleDao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(LoginSampleDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException();
        }
        LoginSample loginSample = new LoginSample();
        BeanUtils.copyProperties(dto, loginSample);
        loginSampleDao.update(loginSample);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(LoginSampleDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException();
        }
        LoginSample loginSample = new LoginSample();
        BeanUtils.copyProperties(dto, loginSample);

        loginSampleDao.insert(loginSample);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(LoginSampleDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException();
        }
        LoginSample loginSample = new LoginSample();
        BeanUtils.copyProperties(dto, loginSample);
        loginSampleDao.delete(loginSample);
    }

}
