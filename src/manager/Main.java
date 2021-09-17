package manager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Interface pro = new Function();
        while(true){
            // 1. Add students. 2. All student information. 3. Specific student information. 4. Delete student information. 5. Revise student information. 6. exit
            System.out.println("1. 학생추가 2.전체 학생정보 3. 특정 학생정보 4.학생정보 삭제 5.학생정보 수정 6. 종료");
            System.out.print("입력 : ");
            int num = System.in.read() -48;
            switch(num){
                case 1: pro.insert(); break;
                case 2: pro.allView(); break;
                case 3: pro.findView(); break;
                case 4: pro.delete(); break;
                case 5: pro.modify(); break;
                case 6: pro.exit(); break;
            }
            System.out.println();
        }
    }
}
