package learn.solarfarm.data;

import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SolarPanelMapper implements RowMapper<SolarPanel> {
    @Override
    public SolarPanel mapRow(ResultSet rs, int rowNum) throws SQLException {
        SolarPanel solarPanel = new SolarPanel();

        solarPanel.setId(rs.getInt("solar_panel_id"));
        solarPanel.setSection(rs.getString("solar_panel_section"));
        solarPanel.setRow(rs.getInt("solar_panel_row"));
        solarPanel.setColumn(rs.getInt("solar_panel_column"));
        solarPanel.setYearInstalled(Integer.parseInt(rs.getString("year_installed")));
        solarPanel.setTracking(rs.getInt("is_tracking") == 1);
        solarPanel.setMaterial(Material.valueOf(rs.getString("material")));

        return solarPanel;
    }
}
