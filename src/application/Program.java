package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(); // Aula 248
		System.out.println("====== TEST 1: seller find By Id ======");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);

		System.out.println(); // Aula 249
		System.out.println("====== TEST 2: seller find By Department ======");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for ( Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println(); // Aula2 50
		System.out.println("====== TEST 3: seller find All ======");
		list = sellerDao.findAll();
		for ( Seller obj : list) {
			System.out.println(obj);
		}
	}

}
