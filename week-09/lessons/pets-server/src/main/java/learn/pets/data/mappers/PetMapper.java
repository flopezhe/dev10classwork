package learn.pets.data.mappers;


import learn.pets.models.Pet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PetMapper implements RowMapper<Pet> {


    @Override
    public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
        Pet pet = new Pet();
        pet.setId(resultSet.getInt("id"));
        pet.setDescription(resultSet.getString("description"));
        pet.setBreed(resultSet.getString("breed"));
        if (resultSet.getDate("dob") != null) {
            pet.setDob(resultSet.getDate("dob").toLocalDate());
        }
        pet.setName(resultSet.getString("name"));
        pet.setSpecies(resultSet.getString(("species")));
        pet.setImageUrl(resultSet.getString("image_url"));
        return pet;
    }
}
