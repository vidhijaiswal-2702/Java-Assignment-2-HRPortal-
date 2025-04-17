const API_BASE = "http://localhost:8080/api/employees";
const form = document.getElementById("employeeForm");
const tableBody = document.getElementById("employeeTableBody");

// Sidebar navigation
function showSection(sectionId) {
  document.querySelectorAll(".dashboard-section").forEach(sec => sec.classList.remove("active"));
  const active = document.getElementById(sectionId);
  if (active) active.classList.add("active");
}

// Load all employees on page load
window.onload = async () => {
  showSection("read");
  await loadEmployees();
};

async function loadEmployees() {
  const res = await fetch(API_BASE);
  const data = await res.json();
  tableBody.innerHTML = "";

  data.forEach(emp => {
    const row = `
      <tr>
        <td>${emp.id}</td>
        <td>${emp.fullName}</td>
        <td>${emp.department}</td>
        <td>${emp.email}</td>
        <td>${emp.salary}</td>
        <td>
          <button onclick="editEmployee(${emp.id})">Edit</button>
          <button onclick="deleteEmployee(${emp.id})">Delete</button>
        </td>
      </tr>
    `;
    tableBody.innerHTML += row;
  });
}

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  // Validate form before submission
  if (!form.fullName.value || !form.department.value || !form.email.value || !form.salary.value) {
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'All fields are required!',
    });
    return;  // Stop form submission if validation fails
  }

  const employee = {
    fullName: form.fullName.value,
    department: form.department.value,
    email: form.email.value,
    salary: form.salary.value,
  };

  const id = form.empId.value;

  if (id) {
    // Update
    await fetch(`${API_BASE}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(employee),
    });
  } else {
    // Add
    await fetch(API_BASE, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(employee),
    });
  }

  form.reset();
  form.empId.value = "";
  await loadEmployees();
  showSection("read");

  // Display success message
  Swal.fire({
    icon: 'success',
    title: 'Employee Saved!',
    text: 'Employee details have been saved successfully.',
  });
});

async function editEmployee(id) {
  const res = await fetch(`${API_BASE}/${id}`);
  const emp = await res.json();

  form.empId.value = emp.id;
  form.fullName.value = emp.fullName;
  form.department.value = emp.department;
  form.email.value = emp.email;
  form.salary.value = emp.salary;

  showSection("create");
}

async function deleteEmployee(id) {
  // SweetAlert for confirmation before delete
  const result = await Swal.fire({
    title: 'Are you sure?',
    text: "You won't be able to revert this!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!'
  });

  if (result.isConfirmed) {
    await fetch(`${API_BASE}/${id}`, { method: "DELETE" });
    await loadEmployees();

    // SweetAlert success message after deletion
    Swal.fire(
      'Deleted!',
      'Employee has been deleted.',
      'success'
    );
  }
}
