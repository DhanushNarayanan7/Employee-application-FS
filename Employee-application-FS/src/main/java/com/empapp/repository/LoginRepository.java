package com.empapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empapp.model.LoginMasterInfo;

@Repository
public interface LoginRepository extends CrudRepository<LoginMasterInfo, String> {

	public LoginMasterInfo findLoginMasterInfoByUserMailAndPassword(String userMail, String password);
	
}
