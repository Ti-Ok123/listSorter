import utils.List;

public class Main {
    public static void main(String[] args) {
        List<MyNumber> myList = new List<>();
        myList.append(new MyNumber(12));
        myList.append(new MyNumber(3));
        myList.append(new MyNumber(4));
        myList.append(new MyNumber(3));
        myList.append(new MyNumber(5));
        myList.append(new MyNumber(3));
        myList.append(new MyNumber(8));
        myList.append(new MyNumber(4));
        myList.append(new MyNumber(6));
        myList.append(new MyNumber(5));
        myList.append(new MyNumber(1));

        System.out.println("Vor dem Sortieren:");
        printList(myList);
        new BubbleSort<>(myList).bubbleSort();
//        new SelectionSort<>(myList).selectionSort();
//        new InsertionSort<>(myList).insertionSort();

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
