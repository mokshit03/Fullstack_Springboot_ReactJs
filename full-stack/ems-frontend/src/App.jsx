import './App.css'
import Footer from './component/FooterComponent'
import Header from './component/HeaderComponent'
import ListEmployeeComponent from './component/ListEmployeeComponent'
import EmployeeComponent from './component/EmployeeComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
function App() {

  return (
    <>
	 <BrowserRouter>
	   <Header/>
	      <Routes>
	           <Route path='/'        element={ <ListEmployeeComponent />}> </Route>
			   <Route path='/employees' element={ <ListEmployeeComponent />}> </Route>
			   <Route path='/add-employee' element={ <EmployeeComponent />}> </Route>
	      </Routes>
	   <Footer/>
	 </BrowserRouter>
    </>
  )
}

export default App
