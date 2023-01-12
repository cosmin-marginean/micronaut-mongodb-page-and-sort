package com.test

import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

@MicronautTest(transactional = false)
class BugTest {

    @Inject
    lateinit var repository: PojoRepository

    @Test
    fun test() {
        repository.save(Pojo("c"))
        repository.save(Pojo("b"))
        repository.save(Pojo("a"))

        val sort = Sort.of(Sort.Order.asc("name"))

        assertContentEquals(listOf("a", "b", "c"), repository.findByParentId("1", sort).map { it.name })
        assertContentEquals(listOf("a", "b", "c"), repository.findByParentId("1", sort, Pageable.from(0, 10)).map { it.name })
    }
}