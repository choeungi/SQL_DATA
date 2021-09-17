package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Function implements Interface{
    private SqlDAO dao = new SqlDAO();
    private Scanner in = new Scanner(System.in);

    @Override
    public void insert(){
        String name;
        do{ // 중복값 검사 | Duplicate value check.
            System.out.print("추가할 학생의 이름을 입력 하세요 : "); // Name of the student to be added
            name = in.next();
            if(dao.DBFindName(name)) System.out.println("이미 추가된 학생입니다. 다시 입력해 주세요"); // A student who's already been added. Try again please
        }while(dao.DBFindName(name));
        System.out.print("국어 점수 입력 : "); // a national language grades Input
        int lng = in.nextInt();
        System.out.print("수학 점수 입력 : "); // mathematics grades Input
        int mth = in.nextInt();
        System.out.print("스포츠 점수 입력 : "); // sports grades Input
        int sp = in.nextInt();
        int res = dao.insertDB(name,lng,mth,sp);
        if(res > 0) System.out.println(name +"님의 정보 추가에 성공하였습니다.");
        else if(res == 0) System.out.println(name + "님의 정보 추가에 실패하였습니다.");
        else System.out.println("DB 서버오류 발생");
    }

    @Override
    public void allView(){
        ArrayList<Format> list = dao.list();
        if(list == null || list.size() == 0) System.out.println("등록된 학생이 존재하지 않습니다.");
        else{
            System.out.printf("이름   국어\t수학\t스포츠\t평균\n"); // name   a national language / mathematics / sports
            for(Format f : list){
                f.print();
            }
        }
    }
    @Override
    public void findView(){
        System.out.print("검색할 착생의 이름 : "); // The name of the student you want to search for.
        String name = in.next();
        Format f = dao.FindDB(name);
        if(dao.DBFindName(name) == false) System.out.println("존재하지 않는 학생입니다, 다시 시도해주세요."); // A student who doesn't exist. Try again please
        else f.print();
    }

    @Override
    public void delete(){
        System.out.print("삭제할 착생의 이름 : "); // Name of the student to be deleted.
        String name = in.next();
        int res = dao.deleteDB(name);
        if(res > 0) System.out.println(name +"학생의 정보를 삭제하였습니다.");
        else if(res == 0) System.out.println(name +"학생의 정보 삭제에 실패하였습니다.");
        else System.out.println("DB 서버오류 발생");
    }

    @Override
    public void modify(){
        System.out.print("수정할 착생의 이름 : "); // Name of the student to be modified.
        String name = in.next();
        System.out.print("수정할 국어 점수 : ");
        int lng = in.nextInt();
        System.out.print("수정할 수학 점수 : ");
        int mth = in.nextInt();
        System.out.print("수정할 스포츠 점수 : ");
        int sp = in.nextInt();
        int res = dao.modifyDB(name,lng,mth,sp);
        if(res > 0) System.out.println(name +"학생의 정보를 수정하였습니다.");
        else if(res == 0) System.out.println(name +"학생의 정보 수정에 실패하였습니다.");
        else System.out.println("DB 서버오류 발생");
    }

    @Override
    public void exit(){
        System.out.println("프로그램을 종료합니다."); // exit program
        System.exit(0);
    }
}
