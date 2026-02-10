package com.example.s0603.common;

import com.example.s0603.dao.SinhVienDAOImpl;
import com.example.s0603.entity.SinhVien;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
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
                if(choice == 1) themSV(sinhVienDAOImpl, sc);
                else if (choice==2) timSV(sinhVienDAOImpl, sc);
                else break;
            }
        };
    }

    public void menu(){
        System.out.println("===========================");
        System.out.println("1. Thêm");
        System.out.println("2. Tìm");
        System.out.println("3. Xóa");
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
}
