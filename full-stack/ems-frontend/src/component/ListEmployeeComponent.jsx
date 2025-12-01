import React, { useEffect } from 'react'
import { useState } from 'react'
import { listEmployee } from '../services/EmployeeClientService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => { 
	const [employees, setEmployees] = useState([])
	const navigator=useNavigate();
	useEffect( 
		() => { 
			  listEmployee()
		            .then((response)=>{ setEmployees(response.data) })
		            .catch( error => { console.log(error) })
		      },
	    [] 
)

function addNewEmployee() {
	navigator('/add-employee')
}
	
	return <div className="container">
	<h3 className="text-center">LIST OF EMPLOYEES</h3>
	<button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
	<table className="table table-striped table-bordered">
	  <thead>
	       <tr>
		       <th>ID</th>
	           <th>First Name</th>
			   <th>Last Name</th>
			   <th>Email</th>
	       </tr>
	  </thead>
	  <tbody>
	  {
		      employees.map(
				employee => 
					<tr key={employee.id}>
					<td>{employee.id}</td>
				    <td>{employee.firstName}</td>
				    <td>{employee.lastName}</td>
					<td>{employee.email}</td>
				   </tr>
			  )
       } 
	  </tbody>
	</table>
	</div> 
}
	
export default ListEmployeeComponent