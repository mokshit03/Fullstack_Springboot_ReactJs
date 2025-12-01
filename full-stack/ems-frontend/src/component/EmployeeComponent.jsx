import React from "react";
import { useState } from "react";
import {createEmployee} from "../services/EmployeeClientService";
import { useNavigate } from "react-router-dom";

const EmployeeComponent = () => {
		const[firstName, setFirstName] = useState('');
		const[lastName, setLastName] = useState('');
		const[email, setEmail] = useState('');
	
	    
    function handleFirstName(event)
    {
	    setFirstName(event.target.value)	
    }
	
	function handleLastName(event)
	{
	   setLastName(event.target.value)	
    }
	
	function handleEmail(event)
	{
	   setEmail(event.target.value)	
    }
	
	const navigator = useNavigate();
	
	function saveEmployee(event)
	{
		event.preventDefault();
		const employee = {firstName, lastName, email}
		console.log(employee)
		
		createEmployee(employee).then(  (response)=>{
			console.log(response.data)
			navigator('/employees')
		}  )
	}
		return (
		<div className="container">
			   <br></br>
			   <br></br>
		<div className="row">
		   <div className="card col-md-6 offset-md-3 offset-md-3">
		       <h2 className="text-center">Add Employee</h2>
			   <div className="card-body">
			   <form>
			       <div className="form-group mb-2">
				   <label className="form-label">First Name</label>
				   <input type='text' placeholder='First Name' name='firstName' value={firstName} className='form-control' onChange={handleFirstName}></input>
				   
				   <label className="form-label">Last Name</label>
				   <input type="text" placeholder="Last Name" name="Lname" value={lastName} className="form-control" onChange={handleLastName}></input>
				   
				   <label className="form-label">Email</label>
				   <input type="email" placeholder="Email" name="email" value={email} className="form-control" onChange={handleEmail}></input>
			   <br></br>
				<button className="btn btn-success" onClick={saveEmployee}>submit</button>   
				   </div>
				</form>
		</div>
		</div>
		</div>
		</div>
	);
}

export default EmployeeComponent