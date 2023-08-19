package com.practicas.fetchtest.data.api.dto

import com.practicas.fetchtest.model.RandomObject

class RandomObjectDTOMapper {
    private   fun fromDTOToRandomObjectDomain(randomObjectDTO: RandomObjectDTO): RandomObject {
        return RandomObject(randomObjectDTO.id, randomObjectDTO.listId, randomObjectDTO.name)
    }

    fun fromRandomDTOListToRandomObjectDomainList(randomObjectDTOList: List<RandomObjectDTO>): List<RandomObject> {
        return randomObjectDTOList.map { fromDTOToRandomObjectDomain(it) }
    }
}