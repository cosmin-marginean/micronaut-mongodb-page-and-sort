package com.test

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import java.util.*

@Serdeable
@MappedEntity
data class Pojo(
    val name: String,
    val parentId:String = "1",

    @field: Id
    val id: String = UUID.randomUUID().toString()
)
