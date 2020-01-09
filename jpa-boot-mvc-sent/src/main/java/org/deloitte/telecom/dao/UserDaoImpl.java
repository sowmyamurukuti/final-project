package org.deloitte.telecom.dao;

import org.deloitte.telecom.entities.MobileUser;
import org.deloitte.telecom.exceptions.MobileNoAlreadyExistsException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements IUserDao {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean checkCredentialsById(int id, String password) {
    	MobileUser user = entityManager.find(MobileUser.class, id);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }


    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
    	MobileUser user = findByMobileNo(mobileNo);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }


    @Override
    public MobileUser findUserById(int id) {
    	MobileUser user = entityManager.find(MobileUser.class, id);
        return user;
    }

    @Override
    public MobileUser findByMobileNo(String mobileNo) {
        try {
            String jql = "from MobileUser where mobileNo=:mob";
            TypedQuery<MobileUser> query = entityManager.createQuery(jql,MobileUser.class);
            query.setParameter("mob", mobileNo);
            MobileUser result = query.getSingleResult();
            return result;
        }catch (NoResultException e){
        	
            return null;
        }
    }


    @Override
    public List<MobileUser> fetchUsers(int blockSize) {
        String jql = "from MobileUser";
        TypedQuery<MobileUser> query = entityManager.createQuery(jql, MobileUser.class);
        query.setMaxResults(blockSize);
        List<MobileUser> list = query.getResultList();
        return list;
    }


    public boolean mobileNumberExists(String mobileNo) {
    	MobileUser user = findByMobileNo(mobileNo);
        return user != null;
    }
    
    @Override
    public MobileUser RechargeAmount(String mobileNo, double amount)
    {
    	MobileUser a= findByMobileNo(mobileNo);
    			double bal=a.getBalance();
    			bal=bal+amount;
    			a.setBalance(bal);
    			return a;    			
    }
    
    @Override
    public MobileUser save(MobileUser user) {
        System.out.println("inside save,user=" + user);
        String phone = user.getMobileNo();
        boolean exists = mobileNumberExists(phone);
        if (exists) {
            throw new MobileNoAlreadyExistsException("mobile no exists");
        }
        user = getEntityManager().merge(user);
        return user;
    }
    
}
