package greenbone.repository;

import greenbone.domain.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends CrudRepository<Computer, Long> {
    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByEmployeeAbbreviation(Pageable pageable, String employeeAbbreviation);
}
