import React from "react";

export default function SolarPanel({ solarPanel }){
    return(<table className='table table-striped'>
        <thead>
            <tr>
                <th>Section</th>
                <th>Row</th>
                <th>Column</th>
                <th>Year Installed</th>
                <th>Material</th>
                <th>Tracking Software</th>
                <th>Modify</th>
            </tr>
        </thead>
        <tbody>
            <tr key={solarPanel.id}>
            <td>{solarPanel.section}</td>
            <td>{solarPanel.row}</td>
            <td>{solarPanel.column}</td>
            <td>{solarPanel.yearInstalled}</td>
            <td>{solarPanel.material}</td>
            <td>{solarPanel.tracking ? 'Yes' : 'No'}</td>
            <td>
                <button className='btn btn-warning me-2 mb-2'>
                    Edit
                </button>
                <button className='btn btn-danger'>
                    Delete
                </button>
            </td>
            </tr>
        </tbody>
    </table>)
}