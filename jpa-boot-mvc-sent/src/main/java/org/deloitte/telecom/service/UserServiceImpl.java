package org.deloitte.telecom.service;

import org.deloitte.telecom.dao.IUserDao;
import org.deloitte.telecom.entities.MobileUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(IUserDao dao) {
        this.userDao = dao;
    }

    @Override
    public boolean checkCredentialsById(int id, String password) {
        return userDao.checkCredentialsById(id, password);
    }


    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
    	
        return userDao.checkCredentialsByMobileNo(mobileNo, password);
    }

    @Override
    public MobileUser findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public MobileUser save(MobileUser user) {
        return userDao.save(user);
    }

    @Override
    public MobileUser findByMobileNo(String mobileNo) {
    	MobileUser user = userDao.findByMobileNo(mobileNo);
        return user;
    }

    @Override
    public List<MobileUser> fetchUsers(int blockSize) {
        List<MobileUser> users = userDao.fetchUsers(blockSize);
        return users;
    }

	@Override
	public MobileUser RechargeAmount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		return userDao.RechargeAmount(mobileNo, amount);
	}

    /*
    @PostConstruct
    public void init(){
       AppUser user1=new AppUser("satya","satya");
       userDao.save(user1);
       AppUser user2=new AppUser("pranav","pranav");
       userDao.save(user2);
    }*/
}
