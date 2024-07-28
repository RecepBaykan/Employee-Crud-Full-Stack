import EmployeeDataList from "../component/EmployeeDataList";
import { HeaderComponent } from "../component/HeaderComponent";
import { FooterComponent } from "../component/FooterComponent";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom" ;
import AddEmployee from "../component/AddEmployee";


function App() {
  return (
    <>
      <Router>
        <HeaderComponent />
        <Routes>
          <Route path='/' element={<EmployeeDataList />} />
          <Route path='/employeList' element={<EmployeeDataList />} />
          <Route path='/add-employee' element={<AddEmployee/>}></Route>
          <Route path='/update-Employee/:id' element={<AddEmployee/>}></Route>
        </Routes>
        <FooterComponent />
      </Router>
    </>
  );
}

export default App;
