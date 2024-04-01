package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Car {
    String name;
    int pos=0;
    String a="-";

    public Car(String name) {
        this.name=name;
    }

    public void move() {
        int n= Randoms.pickNumberInRange(0,9);
        if (n>=5) {
            pos = pos + 1;
        }
    }

    public void print() {
        System.out.println(this.name+":"+a.repeat(pos));
    }

}
public class Application {
    public static int check(String a) {
        int re=0;
        if(a.length()>6) {
            re=1;
        }
        return re;
    }

    public static void car_move(Car[] car,int n) {
        int i;

        for (i=0;i<n;i++) {
            car[i].move();
            car[i].print();
        }
    }

    public static void main(String[] args) {
        int i;
        int input;
        String name;
        Car[] cars=new Car[10];

        Scanner scanner= new Scanner(System.in);

        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 / 최대 10개)");
        name=scanner.nextLine();

        if (name.contains(",,")) {
            throw new IllegalArgumentException("잘못된 입력(쉼표가 두개 들어감)");
        }

        String[] result=name.split(",");

        for (i=0;i<result.length;i++) {
            if (check(result[i]) == 1) throw new IllegalArgumentException("잘못된 입력(이름이 5자 이상임)");
        }

        for (i=0;i< result.length;i++) {
            cars[i]=new Car(result[i]);
            cars[i].pos=0;
        }

        System.out.println("시도할 횟수는 몇회인가요?");

        if (!scanner.hasNextInt()) {
            throw new InputMismatchException("잘못된 입력(숫자가 아님)");
        }
        else {
            input=scanner.nextInt();
        }

        for (i=0;i<input;i++) {
            car_move(cars,input);
            System.out.println("\n");
        }

        int max=0;

        for (i=0;i<input;i++) {
            if (cars[i].pos>max) max=cars[i].pos;
        }

        ArrayList win=new ArrayList();

        for (i=0;i<input;i++) {
            if (cars[i].pos==max) win.add(cars[i].name);
        }

        System.out.println("최종우승자 : "+win);

    }
}
