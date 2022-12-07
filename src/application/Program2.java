package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("===Department findById===");
		Department department = departmentDao.findByID(2);
		System.out.println(department);

		System.out.println("\n===Department findAll===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===Department Insert===");
		Department newDepartment = new Department(null, "Especiarias");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n===Department Update===");
		department = departmentDao.findByID(1);
		department.setName("Frigorifico");
		departmentDao.update(department);
		System.out.println("Updade Completed!");

		System.out.println("\n===Department Delete===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");

		sc.close();

	}

}
