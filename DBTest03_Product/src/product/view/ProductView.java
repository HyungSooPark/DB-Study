package product.view;

import java.util.List;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.vo.Product;

public class ProductView {
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() {
		System.out.println("1. 전체출력");
		System.out.println("2. 선택출력");
		System.out.println("3. 추가");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("6. 종료");
		System.out.println("--------------");
		System.out.print("메뉴 선택: ");
		int select = sc.nextInt();
		
		return select;
	}
	
	public ProductView() {
		int select=0;
		
		ProductController pc = new ProductController();
		
		while(select!=6) {
			select = getMenu();
			
			switch(select) {
			case 1:
				List<Product> res = pc.selectAll();
				for(Product p : res) {
					System.out.println(p);
				}
				System.out.println();
				break;
			case 2:
				System.out.print("선택할 ID: ");
				String select_id = sc.next();
				Product resOne = pc.selectOne(select_id);
				System.out.println(resOne);
				System.out.println();
				break;
			case 3:
				Product p = new Product();
				System.out.print("ID: ");
				p.setpId(sc.next());
				sc.nextLine();
				System.out.print("Name: ");
				p.setpName(sc.nextLine());
				System.out.print("Price: ");
				p.setPrice(sc.nextInt());
				sc.nextLine();
				System.out.print("Desc: ");
				p.setDesc(sc.nextLine());
				int insert_res = pc.insert(p);
				if(insert_res>0) {
					System.out.println("추가 성공");
				}
				else {
					System.out.println("추가 실패");
				}
				System.out.println();
				break;
			case 4:
				Product update_p = new Product();
				System.out.print("수정할 ID: ");
				update_p.setpId(sc.next());
				sc.nextLine();
				System.out.print("Name: ");
				update_p.setpName(sc.nextLine());
				System.out.print("Price: ");
				update_p.setPrice(sc.nextInt());
				sc.nextLine();
				System.out.print("Desc: ");
				update_p.setDesc(sc.nextLine());
				int res_update = pc.update(update_p);
				if(res_update>0) {
					System.out.println("수정 성공");
				}
				else {
					System.out.println("수정 실패");
				}
				System.out.println();
				break;
			case 5:
				System.out.print("삭제할 ID: ");
				String delete_id = sc.next();
				int del_res = pc.delete(delete_id);
				if(del_res>0) {
					System.out.println("삭제 성공");
				}
				else {
					System.out.println("삭제 실패");
				}
				System.out.println();
				break;
			case 6:
				System.out.println("종료합니다.");
				sc.close();
				break;
			default:
				System.out.println("잘못된 입력입니다.\n");
				break;
			}
		}
	}
}
