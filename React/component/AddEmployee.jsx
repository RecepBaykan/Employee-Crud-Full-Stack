import React, { useState, useEffect } from "react";
import { Button, Card, Space, Form, Input } from "antd";
import {
  createEmployee,
  getEmployee,
  updateEmployee,
} from "../Services/EmployeeServices";
import { useNavigate, useParams } from "react-router-dom";

const AddEmployee = () => {
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const navigate = useNavigate();
  const { id } = useParams();

  function handleFirstName(e) {
    setFirstname(e.target.value);
  }

  function handleLastName(e) {
    setLastName(e.target.value);
  }

  function handleEmail(e) {
    setEmail(e.target.value);
  }

  // Form validation
  const [errors, setErrors] = useState({
    firstname: "",
    lastname: "",
    email: "",
  });

  function validateForm() {
    let valid = true;
    const errorsCopy = { ...errors };

    if (firstname.trim()) {
      errorsCopy.firstname = "";
    } else {
      errorsCopy.firstname = "First Name is required!";
      valid = false;
    }

    if (lastname.trim()) {
      errorsCopy.lastname = "";
    } else {
      errorsCopy.lastname = "Last Name is required!";
      valid = false;
    }

    if (email.trim()) {
      errorsCopy.email = "";
    } else {
      errorsCopy.email = "Email is required!";
      valid = false;
    }

    setErrors(errorsCopy);
    return valid;
  }

  function pageTitle(){
    if(id){
        return "Update Employee"
    }else{
        return "Add Employee"
    }
}

  useEffect(() => {
    if (id) {
      getEmployee(id).then((response) => {
        setFirstname(response.data.firstname);
        setLastName(response.data.lastname);
        setEmail(response.data.email);
      }).catch(error => {
        console.log(error);
      });
    }
  }, [id]);

  function saveEmployee(e) {
    e.preventDefault(); // sayfayı yenilemeyi engeller
    if (validateForm()) {
      const employee = { firstname, lastname, email };
      if (id) {
        updateEmployee(id, employee).then((response) => {
          console.log(response.data);
          navigate("/employeList");
        });
      } else {
        createEmployee(employee).then((response) => {
          console.log(response.data);
          navigate("/employeList");
        });
      }
    }
  }

  return (
    <>
      <Card
        title={id ? "Update Employee" : "Add Employee"}
        style={{ width: 300 }}
      >
        <p>First Name</p>
        <Form.Item
          validateStatus={errors.firstname ? "error" : ""}
          help={errors.firstname}
        >
          <Input
            placeholder={id ? firstname : "Example: Jack or Clark Jack"}
            onChange={handleFirstName}
          />
        </Form.Item>
        <p>Last Name</p>
        <Form.Item
          validateStatus={errors.lastname ? "error" : ""}
          help={errors.lastname}
        >
          <Input
            placeholder={id ? lastname : "Example: Sparrow"}
            onChange={handleLastName}
          />
        </Form.Item>
        <p>E-mail</p>
        <Form.Item
          validateStatus={errors.email ? "error" : ""}
          help={errors.email}
        >
          <Input
            placeholder={id ? email : "Example: jack_sparrow@gmail.com"}
            onChange={handleEmail}
          />
        </Form.Item>
        <p>
          <Button type="primary" onClick={saveEmployee}>
            Save
          </Button>
        </p>
      </Card>
    </>
  );
};

export default AddEmployee;
