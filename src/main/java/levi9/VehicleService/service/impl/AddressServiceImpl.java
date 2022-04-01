package levi9.VehicleService.service.impl;

import levi9.VehicleService.dto.AddressDto;
import levi9.VehicleService.repository.AddressRepository;
import levi9.VehicleService.service.AddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Override
    public List<AddressDto> getAllGarages() {
        return addressRepository.findAll().stream()
                .map(garage -> mapper.map(garage, AddressDto.class))
                .collect(Collectors.toList());
    }
}
