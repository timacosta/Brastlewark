package com.acostim.brastlewark.utils.extensions.mappers

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity

    fun mapFromEntityList(entities: List<Entity>): List<DomainModel>{
        return entities.map { mapFromEntity(it) }
    }

}