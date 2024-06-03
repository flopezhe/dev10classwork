package learn.pets.data;

import learn.pets.data.mappers.PetMapper;
import learn.pets.models.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.sql.Date;

@Repository
public class PetJdbcTemplateRepository implements PetRepository{
    private final JdbcTemplate jdbcTemplate;
    public PetJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Pet> findAll() {
        final String sql = "select * " + "from pet limit 1000;";
        return jdbcTemplate.query(sql, new PetMapper());
    }

    @Override
    public Pet findById(int id) {
        final String sql = "select * " + "from pet " + "where id = ?;";
        return jdbcTemplate.query(sql, new PetMapper(), id).stream().findFirst().orElse(null);
    }

    @Override
    public Pet add(Pet pet) {
        final String sql = "insert into pet (name, species, breed, description, dob, image_url) " +
                "values (?,?,?,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pet.getName());
            ps.setString(2, pet.getSpecies());
            ps.setString(3, pet.getBreed());
            ps.setString(4, pet.getDescription());
            ps.setDate(5, pet.getDob() == null ? null : Date.valueOf(pet.getDob()));
            ps.setString(6, pet.getImageUrl());

            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        pet.setId(keyHolder.getKey().intValue());
        return pet;
    }

    @Override
    public boolean update(Pet pet) {
        final String sql = "update pet set "
                + "name = ?, "
                + "species = ?, "
                + "breed = ?, "
                + "description = ?, "
                + "dob = ?, "
                + "image_url = ? "
                + "where id = ?;";
        return jdbcTemplate.update(sql,
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getDescription(),
                pet.getDob(),
                pet.getImageUrl(),
                pet.getId()) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return jdbcTemplate.update("delete from pet where id = ?;", id) > 0;
    }
}
