package com.practicas.fetchtest.data.api.dto

import com.practicas.fetchtest.model.RandomObject

/**
 * Data Transfer Object, design pattern used to transform the data from api into the model that it will be used
 */
class RandomObjectDTOMapper {
    private fun fromDTOToRandomObjectDomain(randomObjectDTO: RandomObjectDTO): RandomObject {
        return RandomObject(randomObjectDTO.id, randomObjectDTO.listId, randomObjectDTO.name)
    }

    fun sortedList(randomObjectDTOList: List<RandomObjectDTO>, group: Int): List<RandomObject> {
        val groupList = randomObjectDTOList.filter {
            it.listId == group
        }

        val emptyList = groupList.filter {
            !it.name.isNullOrEmpty()
        }

        val nullList = emptyList.sortedBy {
            it.name
        }

        return nullList.map { fromDTOToRandomObjectDomain(it) }
    }
}