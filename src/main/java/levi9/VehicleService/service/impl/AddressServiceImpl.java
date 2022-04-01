package levi9.VehicleService.service.impl;

import levi9.VehicleService.dto.AddressDto;
import levi9.VehicleService.repository.AddressRepository;
import levi9.VehicleService.service.AddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<AddressDto> getAllGarages() {
        Type listType = new TypeToken<List<AddressDto>>(){}.getType();
        return mapper.map(addressRepository.findAll(), listType);
    }
}
