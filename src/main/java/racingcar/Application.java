package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

<<<<<<< HEAD

class Car {
    String name;
    int pos = 0;
    String a = "-";

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int n = Randoms.pickNumberInRange(0, 9);
        if (n >= 5) {
=======
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
>>>>>>> 673d411298d993086d799b3400df386bd974b41f
            pos = pos + 1;
        }
    }

    public void print() {
<<<<<<< HEAD
        System.out.println(this.name + ":" + a.repeat(pos));
    }

    public static void raceCars(Car[] cars, int tries) {
        for (int i = 0; i < tries; i++) {
            for (Car car : cars) {
                car.move();
                car.print();
            }
            System.out.println();
        }
    }

    public static ArrayList<String> findWinners(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.pos > maxPosition) {
                maxPosition = car.pos;
            }
        }
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.pos == maxPosition) {
                winners.add(car.name);
            }
        }
        return winners;
    }

    public static int getValidTries(Scanner scanner) {
        int tries;
        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            try {
                tries = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력(숫자가 아님)");
                scanner.nextLine(); // 버퍼 비우기
            }
        } while (true);
        return tries;
    }

    public static String[] getValidCarNames(Scanner scanner) {
        String[] carNames;
        do {
            System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 / 최대 10개 / 1개당 최대 5글자)");
            String input = scanner.nextLine();
            if (input.contains(",,")) {
                System.out.println("잘못된 입력(쉼표가 두개 들어감)");
                continue;
            }
            carNames = input.split(",");
            boolean valid = true;
            for (String name : carNames) {
                if (name.length() > 6) {
                    System.out.println("잘못된 입력(이름이 5자 이상임)");
                    valid = false;
                    break;
                }
            }
            if (valid) break;
        } while (true);
        return carNames;
    }

    public static Car[] initializeCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }
}

=======
        System.out.println(this.name+":"+a.repeat(pos));
    }

}
>>>>>>> 673d411298d993086d799b3400df386bd974b41f
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
<<<<<<< HEAD
        Scanner scanner = new Scanner(System.in);

        String[] carNames = Car.getValidCarNames(scanner);
        int tries = Car.getValidTries(scanner);

        Car[] cars = Car.initializeCars(carNames);

        Car.raceCars(cars, tries);

        ArrayList<String> winners = Car.findWinners(cars);

        System.out.println("최종우승자 : " + winners);
=======
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

>>>>>>> 673d411298d993086d799b3400df386bd974b41f
    }
}
 