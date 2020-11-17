package jdbc.dao;


import jdbc.entity.Employees;

public interface EmployeesDao {
    public void insert(Employees employees);
    public void delete(Employees employees);
    public void update(Employees employees);
    public Employees getEmpById(int id);
}
