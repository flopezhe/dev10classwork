package learn.solarfarm.data;

import learn.solarfarm.models.SolarPanel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class SolarPanelJdbcTemplateRepository implements SolarPanelRepository {
    private final JdbcTemplate jdbcTemplate;

    public SolarPanelJdbcTemplateRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<SolarPanel> findAll() {
        final String sql = """
                select
                    solar_panel_id,
                    solar_panel_section,
                    solar_panel_row,
                    solar_panel_column,
                    year_installed,
                    is_tracking,
                    material
                from solar_panel;
                """;
        return jdbcTemplate.query(sql, new SolarPanelMapper());
    }

    @Override
    public List<SolarPanel> findBySection(String section)  {
        final String sql = """
                select
                    solar_panel_id,
                    solar_panel_section,
                    solar_panel_row,
                    solar_panel_column,
                    year_installed,
                    is_tracking,
                    material
                from solar_panel
                where solar_panel_section = ?;
                """;
        return jdbcTemplate.query(sql, new SolarPanelMapper(), section);
    }

    @Override
    public SolarPanel findByKey(String section, int row, int column) {
        final String sql = """
                select
                    solar_panel_id,
                    solar_panel_section,
                    solar_panel_row,
                    solar_panel_column,
                    year_installed,
                    is_tracking,
                    material
                from solar_panel
                where solar_panel_section = ? and solar_panel_row = ? and solar_panel_column = ?;
                """;
        return jdbcTemplate.query(sql, new SolarPanelMapper(), section, row, column)
                .stream().findFirst().orElse(null);
    }

    @Override
    public SolarPanel findById(int solarPanelId)  {
        final String sql = """
                select
                    solar_panel_id,
                    solar_panel_row,
                    solar_panel_column,
                    year_installed,
                    is_tracking,
                    solar_panel_section,
                    material
                from solar_panel
                where solar_panel_id = ?;
                """;
        return jdbcTemplate.query(sql, new SolarPanelMapper(), solarPanelId)
                .stream().findFirst().orElse(null);
    }

    @Override
    public SolarPanel create(SolarPanel solarPanel)  {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("solar_panel")
                .usingGeneratedKeyColumns("solar_panel_id")
                .usingColumns("solar_panel_section",
                        "solar_panel_row",
                        "solar_panel_column",
                        "year_installed",
                        "is_tracking",
                        "material");

        HashMap<String, Object> args = new HashMap<>();
        args.put("solar_panel_section", solarPanel.getSection());
        args.put("solar_panel_row", solarPanel.getRow());
        args.put("solar_panel_column", solarPanel.getColumn());
        args.put("year_installed", solarPanel.getYearInstalled());
        args.put("is_tracking", solarPanel.isTracking() ? 1 : 0);
        args.put("material", solarPanel.getMaterial().toString());

        int solarPanelId = insert.executeAndReturnKey(args).intValue();
        solarPanel.setId(solarPanelId);
        return solarPanel;
    }

    @Override
    public boolean update(SolarPanel solarPanel) {
        final String sql = """
                update solar_panel set
                    solar_panel_section = ?,
                    solar_panel_row = ?,
                    solar_panel_column = ?,
                    year_installed = ?,
                    is_tracking = ?,
                    material = ?
                where solar_panel_id = ?;
                """;

        return jdbcTemplate.update(sql,
                solarPanel.getSection(),
                solarPanel.getRow(),
                solarPanel.getColumn(),
                solarPanel.getYearInstalled(),
                solarPanel.isTracking() ? 1 : 0,
                solarPanel.getMaterial().toString(),
                solarPanel.getId()) > 0;
    }

    @Override
    public boolean deleteById(int solarPanelId)  {
        return jdbcTemplate.update("delete from solar_panel where solar_panel_id = ?;", solarPanelId) > 0;
    }
}
