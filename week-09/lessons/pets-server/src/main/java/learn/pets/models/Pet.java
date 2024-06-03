package learn.pets.models;

import java.time.LocalDate;
import java.util.Objects;

public class Pet {
    private int id;
    private String name;
    private String species;
    private String breed;
    private String description;
    private LocalDate dob;
    private String imageUrl;


    public Pet(String name, String species, String breed, String description, LocalDate dob, String imageUrl) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;
        this.dob = dob;
        this.imageUrl = imageUrl;
    }

    public Pet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id && name.equals(pet.name) && Objects.equals(species, pet.species) && Objects.equals(breed, pet.breed) && Objects.equals(description, pet.description) && Objects.equals(dob, pet.dob) && Objects.equals(imageUrl, pet.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, breed, description, dob, imageUrl);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", description='" + description + '\'' +
                ", dob=" + dob +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
