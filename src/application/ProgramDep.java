package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDep {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		
		System.out.println("\n=== TESTE 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== TESTE 3: department insert ===");
		Department newDepartment = new Department(null, "tools");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted, new seller id = " + newDepartment.getId());
		
		System.out.println("\n=== TESTE 4: department update ===");
		department = departmentDao.findById(4);
		department.setName("Library");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 5: seller delete ===");
		System.out.println("Enter id for delete test:");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
