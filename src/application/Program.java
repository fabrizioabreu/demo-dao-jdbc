package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println(); // Aula 250
		System.out.println("====== TEST 3: seller find All ======");
		list = sellerDao.findAll();
		for ( Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println(); // Aula 251
		System.out.println("====== TEST 4: seller INSERT ======");
		Seller newSeller = new Seller(null, "Natasha", "natasha@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Insert! New Id = " + newSeller.getId());
		
		System.out.println(); // Aula 252
		System.out.println("====== TEST 5: seller UPDATE ======");
		seller = sellerDao.findById(1);
		seller.setName("João do Caminhão");
		sellerDao.update(seller);
		System.out.println("Update Competed!");
		
		System.out.println(); // Aula 253
		System.out.println("====== TEST 6: seller DELETE ======");
		System.out.println("Digite o ID para ser deletado: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		sc.close();
	}

}
