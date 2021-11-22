package com.services;

import com.entities.UserEntity;
import com.exceptions.UserException;

public class UserValidationimpl {
	
	public static UserEntity validateUser(UserEntity user) throws UserException {
			if(user.getUsername() != null)
			{
				if(user.getPassword() != null)
				{
					return user;
				}
				else throw new UserException("Password cannot be empty");
			}
			else throw new UserException("Username cannot be empty");
	}	
}
