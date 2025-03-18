SELECT * FROM employees;

--
SELECT * FROM employees
WHERE salary > 50000;

--
SELECT first_name, last_name, salary
FROM employees
ORDER BY salary DESC;

--
SELECT COUNT(*) AS total_employees
FROM employees;

--
INSERT INTO employees (first_name, last_name, email, hire_date, salary)
VALUES ('John', 'Smith', 'john.smith@example.com', '2025-01-15', 60000);


--
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
         JOIN departments d ON e.department_id = d.department_id;

--
SELECT d.department_name, AVG(e.salary) AS average_salary
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;

--
SELECT first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

--
UPDATE employees
SET salary = salary * 1.1
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'IT');

--
SELECT d.department_name, COUNT(e.employee_id) AS employee_count
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name
HAVING COUNT(e.employee_id) > 5;

--
WITH RankedEmployees AS (
    SELECT
        e.first_name,
        e.last_name,
        e.salary,
        d.department_name,
        DENSE_RANK() OVER (PARTITION BY e.department_id ORDER BY e.salary DESC) AS salary_rank
    FROM
        employees e
            JOIN
        departments d ON e.department_id = d.department_id
)
SELECT
    first_name,
    last_name,
    department_name,
    salary
FROM
    RankedEmployees
WHERE
    salary_rank <= 3
ORDER BY
    department_name, salary_rank;

--
SELECT
    e.first_name AS employee_first_name,
    e.last_name AS employee_last_name,
    m.first_name AS manager_first_name,
    m.last_name AS manager_last_name
FROM
    employees e
        LEFT JOIN
    employees m ON e.manager_id = m.employee_id;

