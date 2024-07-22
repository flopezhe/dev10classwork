package learn.solarfarm.data;

import learn.solarfarm.models.SolarPanel;

import java.util.List;

public interface SolarPanelRepository {
    List<SolarPanel> findAll() ;

    List<SolarPanel> findBySection(String section) ;

    SolarPanel findByKey(String section, int row, int column) ;

    SolarPanel findById(int solarPanelId) ;

    SolarPanel create(SolarPanel solarPanel) ;

    boolean update(SolarPanel solarPanel) ;

    boolean deleteById(int solarPanelId) ;

}
