import React from "react";
import Buttons from "./Buttons";
import { Link } from 'react-router-dom';

export default function AddForm({setShowForm}){
    // return (
    // <>
    // <Buttons setShowForm={setShowForm}/>
    // <form> TESTSETSET</form>
    // </>
    // )
    return (
        <>
            <h1>Add Solar Panel</h1>
            <form>
                <div className='mb-3'>
                    <label className='form-label'>Section</label>
                    <input type='text' className='form-control' />
                </div>
                <div className='mb-3'>
                    <label className='form-label'>Row</label>
                    <input type='number' className='form-control' />
                </div>
                <div className='mb-3'>
                    <label className='form-label'>Column</label>
                    <input type='number' className='form-control' />
                </div>
                <div className='mb-3'>
                    <label className='form-label'>Year Installed</label>
                    <input type='number' className='form-control' />
                </div>
                <div className='mb-3'>
                    <label className='form-label'>Material</label>
                    <input type='text' className='form-control' />
                </div>
                <div className='mb-3'>
                    <label className='form-label'>Tracking Software</label>
                    <input type='checkbox' className='form-check-input' />
                </div>
                <button type='submit' className='btn btn-primary'>Add</button>
            </form>
            <Link className='btn btn-secondary mt-3' to='/solarPanels'>Back to Solar Panels</Link>
        </>
    );
}

