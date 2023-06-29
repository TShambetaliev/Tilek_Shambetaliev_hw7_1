package com.example.tilek_shambetaliev_hw7_1.domain.repositories

import com.example.tilek_shambetaliev_hw7_1.data.models.ContactEntity

interface ContactRepository {
    
    fun addContact(contactEntity: ContactEntity)

    fun getContacts(): List<ContactEntity>

    fun updateContact(contactEntity: ContactEntity)

    fun deleteContact(contactEntity: ContactEntity)
}