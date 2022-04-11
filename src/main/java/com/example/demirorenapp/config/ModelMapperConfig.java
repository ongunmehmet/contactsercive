package com.example.demirorenapp.config;

import com.example.demirorenapp.dto.ContactDto;
import com.example.demirorenapp.entity.ContactId;
import com.example.demirorenapp.entity.Contacts;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {
    private static final Converter<ContactDto, Contacts>
            CONTACTDTO_TO_CONTACTS_ENTITY_CONVERTER =
            (context) -> {
                var contactDto = context.getSource();
                var response = new Contacts();
                var id= new ContactId(contactDto.getName(),contactDto.getLastName());
                response.setContactId(id);
                response.setPhones(List.of(contactDto.getPhone()));
                return  response;
            };

    @Bean
    public ModelMapper getModelMapper(){
        var mapper = new ModelMapper();
        mapper.addConverter(CONTACTDTO_TO_CONTACTS_ENTITY_CONVERTER,
                ContactDto.class, Contacts.class);
        return  mapper;
    }
}
