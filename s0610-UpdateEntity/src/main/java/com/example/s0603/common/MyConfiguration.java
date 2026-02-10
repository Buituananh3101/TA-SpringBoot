package com.example.s0603.common;

import com.example.s0603.dao.SinhVienDAOImpl;
import com.example.s0603.entity.SinhVien;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean // ko có @Lazy lên khi chạy lập tức Bean này được tạo ra
    public CommandLineRunner getRuner(SinhVienDAOImpl sinhVienDAOImpl) {
        return runner -> {
            Scanner sc = new Scanner(System.in);
            while (true) {
                menu();
                int choice = sc.nextInt();
                sc.nextLine();
                if      (choice==1) themSV(sinhVienDAOImpl, sc);
                else if (choice==2) timSV(sinhVienDAOImpl, sc);
                else if (choice==3) hienThiAllSV(sinhVienDAOImpl);
                else if (choice==4) timSVTheoTen(sinhVienDAOImpl, sc);
                else if (choice==5) updateAllTen(sinhVienDAOImpl,sc);
                else if (choice==6) updateTen(sinhVienDAOImpl,sc);
                else break;
            }
        };
    }

    public void menu(){
        System.out.println("===========================");
        System.out.println("1. Thêm");
        System.out.println("2. Tìm");
        System.out.println("3. Hiển thị all sv");
        System.out.println("4. Tìm sv theo tên");
        System.out.println("5. updateAllTen");
        System.out.println("6. updateTen");
        System.out.print("Lựa chọn: ");
        System.out.println();
    }

    public void themSV(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc) {
        // Lấy in4
        System.out.println("Họ đệm");
        String ho_dem=sc.nextLine();
        System.out.println("Tên");
        String ten= sc.nextLine();
        System.out.println("Email");
        String email=sc.nextLine();
        SinhVien sinhVien=new SinhVien(ho_dem,ten,email);
        // Lưu vào db
        sinhVienDAOImpl.save(sinhVien);
    }

    public void timSV(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc){
        System.out.println("Nhập mã sv");
        int id = sc.nextInt();
        SinhVien s = sinhVienDAOImpl.getById(id);
        if(s==null) System.out.println("Ko có sv này");
        else System.out.println(s);
    }

    public void hienThiAllSV(SinhVienDAOImpl sinhVienDAOImpl){
        List<SinhVien> list = sinhVienDAOImpl.getAll();
        if(list.isEmpty()) System.out.println("Ko có sv nào");
        else list.forEach(System.out::println);
//      else list.forEach(sv->System.out.println(sv)); nó giống cái này
    }

    public void timSVTheoTen(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc){
        String ten = sc.nextLine();
        List<SinhVien> list = sinhVienDAOImpl.getByName(ten);
        if(list.isEmpty()) System.out.println("Ko có sv nào");
        else list.forEach(System.out::println);
    }

    public void updateAllTen(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc){
        System.out.println("Nhập tên: ");
        String ten = sc.nextLine();
        sinhVienDAOImpl.updateAllTen(ten);
    }

    public void updateTen(SinhVienDAOImpl sinhVienDAOImpl, Scanner sc){
        System.out.println("Nhập ID cần thay: ");
        int id = sc.nextInt();
        sc.nextLine();
        SinhVien s =sinhVienDAOImpl.getById(id);
        if(s==null)  System.out.println("Ko có ");
        else{
            System.out.println("Đổi họ đệm");
            String ho_dem = sc.nextLine();
            System.out.println("Đổi tên");
            String ten = sc.nextLine();
            System.out.println("Email");
            String email=sc.nextLine();
            sinhVienDAOImpl.updateTen(new SinhVien(id, ho_dem,ten,email));
        }
    }

}
