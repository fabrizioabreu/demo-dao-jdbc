package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println();
		System.out.println("====== TEST 1: DEPARTMENT find By Id ======");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println(); 
		System.out.println("====== TEST 2: DEPARTMENT find All ======");
		List<Department> list = departmentDao.findAll();
		for ( Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println(); 
		System.out.println("====== TEST 3: DEPARTMENT INSERT ======");
		Department depart = new Department(null, "Comida");
		departmentDao.insert(depart);
		System.out.println("Insert! Novo Id: " + depart.getId());
		
		System.out.println(); 
		System.out.println("====== TEST 4: DEPARTMENT UPDATE ======");
		department = departmentDao.findById(1);
		department.setName("Refrigerados");
		departmentDao.update(department);
		System.out.println("Update Competed!");
		
		System.out.println();
		System.out.println("====== TEST 5: DEPARTMENT DELETE ======");
		System.out.println("Digite o ID para ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");

		
		sc.close();
	}

}
