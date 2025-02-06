import utils.List;

public class Main {
    public static void main(String[] args) {
        List<MyNumber> myList = new List<>();
        myList.append(new MyNumber(1));
        myList.append(new MyNumber(1));
        myList.append(new MyNumber(2));
        myList.append(new MyNumber(2));
        myList.append(new MyNumber(3));

        System.out.println("Vor dem Sortieren:");
        printList(myList);

        new BubbleSort<>(myList).bubbleSort();

        System.out.println("Nach dem Sortieren:");
        printList(myList);
    }

    public static void printList(List<MyNumber> list) {
        list.toFirst();
        while (list.hasAccess()) {
            System.out.print(list.getContent() + " ");
            list.next();
        }
        System.out.println();
    }
}
