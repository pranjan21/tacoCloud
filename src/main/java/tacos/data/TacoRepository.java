package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.domains.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {

//    Page<Taco> findAll(PageRequest page);
}
