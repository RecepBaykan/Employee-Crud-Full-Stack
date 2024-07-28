import React, { useEffect } from "react";
import { useState } from "react";
import { Card } from "antd";
import { deleteEmployee, listEmployees } from "../Services/EmployeeServices";
import { Button, Flex } from "antd";
import { useNavigate, useParams } from "react-router-dom";

const EmployeeDataList = () => {
  const [employess, setEmplooyes] = useState([]);

  useEffect(() => {
    getAllEmployee();
  }, []);

  function getAllEmployee(){
    listEmployees()
      .then((response) => {
        setEmplooyes(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  const navigate = useNavigate();

  function addEmployee() {
    navigate("/add-employee");
  }

  function updateEmployee(id) {
    navigate(`/update-Employee/${id}`);
  }


  function deleteE(id){
    deleteEmployee(id).then((response) => {
      getAllEmployee();
    }).catch(error => {console.log(error)})
    
   
  }

  return (
    <>
      <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
        {employess.map((employee) => (
          <Card
            key={employee.id}
            title={"ID: " + employee.id}
            style={{
              width: 300,
              border: "1px solid black",
            }}
          >
            <p>
              {employee.firstname} {employee.lastname}
            </p>
            <p>{employee.email}</p>
            <p>
              <Button
                type="primary"
                style={{ backgroundColor: "green" }}
                onClick={() => updateEmployee(employee.id)}
              >
                Update
              </Button>{" "}
              <Button
                type="primary"
                style={{ backgroundColor: "red" }}
                onClick={() => deleteE(employee.id)}
              >
                Delete
              </Button>
            </p>
          </Card>
        ))}
      </div>
      <br></br>
      <Button type="primary" onClick={addEmployee}>
        Add Employee
      </Button>
    </>
  );
};

export default EmployeeDataList;
