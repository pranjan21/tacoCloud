package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.domains.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	private JdbcTemplate jdbcTemplate;

	public JdbcIngredientRepository(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		return jdbcTemplate.query("select id, name, type from Ingredient", 
				this::mapRowToIngredient);
	}

	@Override
	public Ingredient findOne(String id) {
		return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {

		this.jdbcTemplate.update("insert into Ingredient id, name, type values (?,?,?)", 
				ingredient.getId(), 
				ingredient.getName(), 
				ingredient.getType());
		return ingredient;
	}

	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
		return new Ingredient(
				rs.getString("id"),
				rs.getString("name"),
				Ingredient.Type.valueOf(rs.getString("type")));
	}

}
