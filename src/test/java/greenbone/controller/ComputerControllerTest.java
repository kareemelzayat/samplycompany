package greenbone.controller;

import greenbone.domain.Computer;
import greenbone.model.ComputerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootTest
public class ComputerControllerTest {

    @Autowired
    private ComputerController computerController;

    @Test
    @Order(0)
    void testListReturnsEmptyList() {
        // when
        Page<Computer> result = computerController.list(Pageable.unpaged());

        // then
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @Order(1)
    void testPostCreatesComputer() {
        // given
        ComputerDto newComputer = new ComputerDto(
                "00-B0-D0-63-C2-26",
                "new computer",
                "127.0.0.1",
                "kez",
                "this is a new computer"
        );

        // when
        ResponseEntity<ComputerDto> result = computerController.create(newComputer);

        // then
        Assertions.assertTrue(result.getStatusCode().is2xxSuccessful());
        Assertions.assertEquals(newComputer.getMacAddress(), result.getBody().getMacAddress());
        Assertions.assertEquals(newComputer.getName(), result.getBody().getName());
        Assertions.assertEquals(newComputer.getIpAddress(), result.getBody().getIpAddress());
        Assertions.assertEquals(newComputer.getEmployeeAbbreviation(), result.getBody().getEmployeeAbbreviation());
        Assertions.assertEquals(newComputer.getDescription(), result.getBody().getDescription());
    }

    @Test
    @Order(2)
    void testListReturnsCreatedComputers() {
        // when
        Page<Computer> result = computerController.list(Pageable.unpaged());

        // then
        Assertions.assertEquals(1L, result.getTotalElements());
    }

    @Test
    @Order(1)
    void testPutUpdatesAComputer() {
        return;
    }

    @Test
    @Order(1)
    void testUnassignFromEmployee() {
        return;
    }

    @Test
    @Order(1)
    void testDelete() {
        return;
    }

    @Test
    @Order(1)
    void testListReturnsNothing() {
        return;
    }
}
