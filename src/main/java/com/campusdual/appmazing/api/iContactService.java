package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ContactDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;

import java.util.List;

/*
*
* Misma explicación que en PRODUCT
*
* */

public interface iContactService {
    ContactDTO queryContact(ContactDTO contact);
    List<ContactDTO> queryAllContact();

    int insertContact(ContactDTO contact);
    int updateContact(ContactDTO contact);
    int deleteContact(ContactDTO contact);
}
