package greenbone.repository;

import greenbone.domain.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComputerRepository extends CrudRepository<Computer, Long> {
    Page<Computer> findAll(Pageable pageable);

    List<Computer> findAllByEmployeeAbbreviation(String employeeAbbreviation);

    Optional<Computer> findByIdAndEmployeeAbbreviation(Long id, String employeeAbbreviation);
}
