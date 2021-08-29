package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {

			System.out.print("Product #" + i + " data:\nCommon, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price: ");
			double price = sc.nextDouble();

			if (resp == 'c') {
				list.add(new Product(name, price));

			} else if (resp == 'i') {

				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));

			} else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date d = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, d));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product x : list) {
			
			System.out.println(x.priceTag());

		}
		sc.close();

	}

}
