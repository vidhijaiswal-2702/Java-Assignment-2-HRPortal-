document.addEventListener('DOMContentLoaded', function() {
    const deleteButtons = document.querySelectorAll('.delete-button');

    deleteButtons.forEach(button => {
        button.addEventListener('click', function() {
            const employeeId = this.getAttribute('data-employee-id');
            if (confirm('Are you sure you want to delete this employee?')) {
                window.location.href = '/employees/delete/' + employeeId;
            }
        });
    });
});