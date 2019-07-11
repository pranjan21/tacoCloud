package tacos.data;

import org.springframework.stereotype.Repository;

import tacos.domains.Taco;

@Repository
public interface TacoRepository {
	public Taco save(Taco taco);
}