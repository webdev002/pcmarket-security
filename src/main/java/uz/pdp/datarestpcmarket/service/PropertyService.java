package uz.pdp.datarestpcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.datarestpcmarket.entity.Property;
import uz.pdp.datarestpcmarket.payload.ApiResponse;
import uz.pdp.datarestpcmarket.payload.ReferenceDto;
import uz.pdp.datarestpcmarket.repository.PropertyRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getProperty() {
        List<Property> byProperty = propertyRepository.findByProperty();
        return byProperty;
    }

    public Property getPropertyById(Integer id){
        Optional<Property> byId = propertyRepository.findById(id);
        if (byId.isEmpty()){
            return byId.get();
        }
        return null;
    }

    public ApiResponse addProperty(ReferenceDto referenceDto){
        Property property =  new Property();
        property.setMemory(referenceDto.getMemory());
        property.setProcessor(referenceDto.getProcessor());
        property.setVideoCard(referenceDto.getVideoCard());
        property.setMonitor(referenceDto.getMonitor());
        property.setColor(referenceDto.getColor());
        propertyRepository.save(property);
        return new ApiResponse("Property saqlandi!",true);
    }

    public ApiResponse editProperty(ReferenceDto referenceDto,Integer id){
        boolean existsByMemoryAndIdNot = propertyRepository.existsByMemoryAndIdNot(referenceDto.getMemory(),id);
        if (existsByMemoryAndIdNot){
            return new ApiResponse("Bunday idlik Property mavjud emas!",false);
        }
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if (!optionalProperty.isEmpty()){
            Property property = optionalProperty.get();
            property.setMemory(referenceDto.getMemory());
            property.setProcessor(referenceDto.getProcessor());
            property.setMonitor(referenceDto.getMonitor());
            property.setVideoCard(referenceDto.getVideoCard());
            property.setColor(referenceDto.getColor());
            propertyRepository.save(property);
            return new ApiResponse("Property tahrirlandi",true);
        }
        return new ApiResponse("error",false);


    }

    public ApiResponse deleteProperty(Integer id){
        propertyRepository.deleteById(id);
        return new ApiResponse("Property ochirildi",true);
    }
}
