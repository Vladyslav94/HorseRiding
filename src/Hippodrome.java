import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;
    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Molly", 3, 0);
        Horse horse2 = new Horse("Billy", 3, 0);
        Horse horse3 = new Horse("Willy", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();

    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i < 11; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 101; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        horses.sort((o1, o2) -> (int) (o1.getDistance() - o2.getDistance()));
        return horses.get(horses.size() - 1);
    }

    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }
}
