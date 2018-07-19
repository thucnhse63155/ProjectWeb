/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

public class Cabinet {

    private Map<String, Dog> bag = new TreeMap(); // Mặc định sort value theo key( ID )
    // Mỗi lần cất 1 dog ta cất 2 thứ ! 1 con dog và mã số của con dog dùng làm key
    // Tìm key có hay k có nghĩa là tìm id có hay k
    // Dog add vào giỏ từ từ, nghĩa là k cần constructor
    // đây là hàm sẽ mời nhập 1 con dog từ bàn phím. Sau đó bỏ vào tủ

    public void addDog() {
        // Nhập thông tin dog
        String id, name;
        int yob;
        double weight;
        boolean idExistance; // lưu trạng thái tồn tại của id
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the dog #" + bag.size());
        do {
            System.out.println("Input the dog id: ");
            id = sc.nextLine().trim().toUpperCase(); // cắt trằng dư, đổi qa chữ hoa cho đẹp ! 
            idExistance = bag.containsKey(id);
            if (idExistance) {
                System.out.println("Sorry, Dupplicate ID, Input another ID");
            }
        } while (idExistance);

        // Chửi nếu id trùng !! Còn trùng là còn chửi Check nếu id có r !
        System.out.println("Input the dog name: ");
        name = sc.nextLine().trim().toUpperCase();

        System.out.println("Input the dog yob: ");
        yob = Integer.parseInt(sc.nextLine());

        System.out.println("Input the dog weight: ");
        weight = Double.parseDouble(sc.nextLine());
        // Đã đủ infor của Dog -> New để bỏ vào giỏ !
        bag.put(id, new Dog(name, id, yob, weight));
        System.out.println("The dog #" + bag.size() + "has been added");
    }

    public void printDogListByIdAsc() {
        if (bag.isEmpty()) {
            // có thể xài bag.size() == 0
            System.out.println("The database is empty !! Nothing to show");
            return;
        }
        System.out.println("The dog list");
        for (Dog x : bag.values()) {
            x.showDetailed();
        }

        // Đây là hàm k mời nhập info của dog vì hàm nhận info qa tham số. Ta chỉ việc bỏ Dog vào giỏ
//    public void addDog(String id, String name, int yob, double weight) {
//
//    }
        // ta có 2 hàm trùng tên nhau nhưng khác tham số !! Hiện tượng 2 hàm trùng tên nhau nhưng khác về tham số (data-type k 
        // quan tâm tên biến ) - Ta gọi là overloading - Quá tải hàm
    }

    // Nhập vào Id muốn search! Tìm thấy hoặc k thấy !! Nếu xài ArrayList thì bạn sẽ phải dùng for 
    // for(i =0 ; i<bag.size();i++)
    // if (bag.get(i).getId().compareToIgnoreCase(??)
    // return i hoặc là return bag,get(i); // trả về con trỏ !!
    public void searchDog() {
        String id;
        if (bag.isEmpty()) {
            System.out.println("The dog list is empty");
            return;
        }
        System.out.println("Input dog's ID that you want to search");
        id = new Scanner(System.in).nextLine().toUpperCase();
        Dog x = bag.get(id);
        if (x == null) {
            System.out.println("Dog not found");
        } else {
            System.out.println("Dog found here ");
            x.showDetailed();
        }
    }

    public void Update() {
        String id;
        if (bag.isEmpty()) {
            System.out.println("The dog list is empty, nothing to update");
            return;
        }
        System.out.println("Input dog's ID that you want to update");
        id = new Scanner(System.in).nextLine().toUpperCase();
        Dog x = bag.get(id);
        if (x == null) {
            System.out.println("Dog not found");
        } else {
            System.out.println("Dog found here ");
            x.showDetailed();
            // Phải hỏi nó muốn sửa cm gì ?
            String name;
            System.out.print("Input new name: ");
            name = new Scanner(System.in).nextLine().trim().toUpperCase();
            x.setName(name);
            System.out.println("Update sucessful");
            System.out.println("Here is he/she again");
            x.showDetailed();
        }
    }
}
