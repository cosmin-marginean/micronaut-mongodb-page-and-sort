package com.test

import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.PageableRepository

@MongoRepository
interface PojoRepository : PageableRepository<Pojo, String> {

    fun findByParentId(parentId: String, sort: Sort, page: Pageable): Page<Pojo>
    fun findByParentId(parentId: String, sort: Sort): List<Pojo>
}