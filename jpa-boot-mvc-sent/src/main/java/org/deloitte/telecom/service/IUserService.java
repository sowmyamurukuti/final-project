package org.deloitte.telecom.service;

import java.util.List;


import org.deloitte.telecom.entities.MobileUser;

public interface IUserService {
    boolean checkCredentialsById(int id, String password);

    boolean checkCredentialsByMobileNo(String mobileNo, String password);

    MobileUser findUserById(int id);

    MobileUser save(MobileUser user);

    MobileUser findByMobileNo(String mobileNo);

    List<MobileUser> fetchUsers(int blockSize);

	MobileUser RechargeAmount(String mobileNo, double amount);
}
