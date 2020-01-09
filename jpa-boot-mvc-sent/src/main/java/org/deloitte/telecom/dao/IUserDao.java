package org.deloitte.telecom.dao;

import java.util.List;

import org.deloitte.telecom.entities.MobileUser;

public interface IUserDao {
    boolean checkCredentialsById(int id, String password);

    boolean checkCredentialsByMobileNo(String mobileNo, String password);

    MobileUser findUserById(int id);

    MobileUser save(MobileUser user);

    MobileUser findByMobileNo(String mobileNo);

    List<MobileUser> fetchUsers(int blockSize);

	MobileUser RechargeAmount(String mobileNo, double amount);
}
