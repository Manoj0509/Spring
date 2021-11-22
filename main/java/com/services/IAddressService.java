package com.services;

import com.entities.AddressEntity;

import com.exceptions.AddressNotFoundException;

public interface IAddressService {
	public AddressEntity addAddress(AddressEntity address) throws AddressNotFoundException;
	public AddressEntity removeAddress(Long custId) throws AddressNotFoundException;
	public AddressEntity updateAddress(Long custId,AddressEntity address) throws AddressNotFoundException;
	public AddressEntity getAddress() throws AddressNotFoundException;

}
//