package junho;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Pratice {

//    private static Map<Long, Member> store = new HashMap<>();

    static Queue<String> queue = new LinkedList<>();

    public static Member member;

    void start(){
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("1. 회원 가입 | 2.종료 | ");
            String command = sc.nextLine();
            switch (command) {
                case "1":
                    join();
                    break;
                case "2":
                    System.out.println("종료 하겠습니다.");
                    check=false;
                    sc.close();
                    break;
            }

        }
    }

    static Queue<String> Re(){
        return queue;
    }
     Member join() {

        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요 특수 문자제외 숫자,알파벳 한자씩 포함 8~16자리 아이디 : ");
        String id = sc.nextLine();

        while (true) {
            if (id.matches("^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$")) {
                break;
            }
            System.out.print("아이디를 입력하세요 특수 문자제외 숫자,알파벳 한자씩 포함 8~16자리 아이디 :");

            id = sc.nextLine();
        }
        System.out.print("비밀번호를 입력하세요 8 ~ 16자 영문, 숫자, 특수문자를 최소 한가지씩 조합 ");
        String pass1 = sc.nextLine();
        String pass2;
        while (true) {
            while (true) {
                if (pass1.matches("^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,16}$")) {
                    break;
                }
                System.out.print("비밀번호를 입력하세요 8 ~ 16자 영문, 숫자, 특수문자를 최소 한가지씩 조합 ");
                pass1 = sc.nextLine();
            }

            System.out.print("비밀전호 2차 확인 : ");
            pass2 = sc.nextLine();
            if (pass1.equals(pass2)) {
                break;
            } else {
                System.out.println("비밀번호 1차와 다릅니다.");
                System.out.print("비밀번호를 입력하세요 8 ~ 16자 영문, 숫자, 특수문자를 최소 한가지씩 조합 ");
                pass1 = sc.nextLine();
            }
        }
        member = new Member(id, pass1, pass2);
        System.out.println("아이디 : " + member.getId() + " 비번1 : " + member.getPass1() + " 비번2 : " + member.getPass2());
        queue.offer(member.getId());
        return member;




    }

}


