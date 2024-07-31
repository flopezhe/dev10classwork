import React from "react";

export default function Buttons({ setShowForm }){
    return(
    <>
    <button onClick={() => setShowForm(true)} className='mb-3 btn btn-primary'>
        Add Solar Panel
    </button>
    <button onClick={() => setShowForm(false)} className='mb-3 btn btn-primary'>
        View Solar Panels
    </button></>)
}