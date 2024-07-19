package learn.solarfarm.data;

import learn.solarfarm.models.SolarPanel;

import java.util.List;

public interface SolarPanelRepository {
    List<SolarPanel> findAll() throws DataAccessException;

    List<SolarPanel> findBySection(String section) throws DataAccessException;

    SolarPanel findByKey(String section, int row, int column) throws DataAccessException;

    SolarPanel findById(int solarPanelId) throws DataAccessException;

    SolarPanel create(SolarPanel solarPanel) throws DataAccessException;

    boolean update(SolarPanel solarPanel) throws DataAccessException;

    boolean deleteById(int solarPanelId) throws DataAccessException;

}
