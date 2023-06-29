package com.example.tilek_shambetaliev_hw7_1.domain.usecases

import com.example.tilek_shambetaliev_hw7_1.data.models.ContactEntity
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.ContactRepository

class GetContactsUseCase(
    private val contactRepository: ContactRepository
) {

    fun getContacts():List<ContactEntity>{
        return contactRepository.getContacts()
    }
}