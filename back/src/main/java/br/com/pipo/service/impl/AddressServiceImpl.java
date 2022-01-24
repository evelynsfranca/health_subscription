package br.com.pipo.service.impl;

import br.com.pipo.model.Address;
import br.com.pipo.repository.AddressRepository;
import br.com.pipo.service.AddressService;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(
        AddressRepository addressRepository
    ) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
