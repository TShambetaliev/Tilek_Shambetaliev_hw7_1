package com.example.tilek_shambetaliev_hw7_1.domain.usecases

import com.example.tilek_shambetaliev_hw7_1.data.models.ContactEntity
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.ContactRepository

class AddContactUseCases (
    private val contactRepository: ContactRepository
    ){

    fun addContact(contactEntity: ContactEntity){
        contactRepository.addContact(contactEntity)
    }
}