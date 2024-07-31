import React, { useState } from "react";
import Buttons from "./Buttons";
import { Link } from "react-router-dom";

const INITIAL_SOLAR_PANEL = {
  id: 0,
  section: "",
  row: 0,
  column: 0,
  yearInstalled: 2024,
  material: "",
  tracking: false,
};

export default function AddForm({ setShowForm }) {
  // return (
  // <>
  // <Buttons setShowForm={setShowForm}/>
  // <form> TESTSETSET</form>
  // </>
  // )

  const [solarPanel, setSolarPanel] = useState(INITIAL_SOLAR_PANEL);

  function handleChange(event) {
    const updatedSolarPanel = { ...solarPanel };
    if (event.target.type === "checkbox") {
      updatedSolarPanel[event.target.name] = event.target.checked;
    } else {
      updatedSolarPanel[event.target.name] = event.target.value;
    }
    setSolarPanel(updatedSolarPanel);

    console.log(updatedSolarPanel);
  }

  return (
    <>
      <h1>Add Solar Panel</h1>
      <form>
        <div className="mb-3">
          <label htmlFor="section" className="form-label">
            Section
          </label>
          <input
            id="section"
            name="section"
            type="text"
            className="form-control"
            value={solarPanel.section}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="row" className="form-label">
            Row
          </label>
          <input
            id="row"
            name="row"
            type="number"
            className="form-control"
            value={solarPanel.row}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="column" className="form-label">
            Column
          </label>
          <input
            id="column"
            name="column"
            type="number"
            className="form-control"
            value={solarPanel.column}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="yearInstalled" className="form-label">
            Year Installed
          </label>
          <input
            id="yearInstalled"
            name="yearInstalled"
            type="number"
            className="form-control"
            value={solarPanel.yearInstalled}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="material" className="form-label">
            Material
          </label>
          <input
            id="material"
            name="material"
            type="text"
            className="form-control"
            value={solarPanel.material}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="tracking" className="form-label">
            Tracking Software
          </label>
          <input
            id="tracking"
            name="tracking"
            type="checkbox"
            className="form-check-input"
            checked={solarPanel.tracking}
            onChange={handleChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">
          Add
        </button>
      </form>
      <Link className="btn btn-secondary mt-3" to="/solarPanels">
        Back to Solar Panels
      </Link>
    </>
  );
}
