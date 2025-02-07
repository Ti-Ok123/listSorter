import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        if (list.isEmpty()) {
            return; // Keine Sortierung nötig, wenn die Liste leer istt
        }

        var laenge = lengthList(this.list);

        list.toFirst();

        for (int i = 0; i <= laenge; i++) {
            while (list.hasAccess()) {
                ContentType current = list.getContent();
                list.next();

                if (list.hasAccess()) {
                    ContentType next = list.getContent();
                    if (current.isGreater(next)) {
                        // Werte tauschen
                        swap(list, current, next);
                        list.toFirst();
                        for (int j = 0; j < i; j++) {
                            list.next();
                        }
                    }
                }
            }
        }
    }

    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        if (list.isEmpty() || item1.equals(item2)) {
            return; // No need to swap if the list is empty or both items are the samee
        }

        list.toFirst();
        boolean foundItem1 = false, foundItem2 = false;

        // Find both elements
        while (list.hasAccess()) {
            if (list.getContent().equals(item1)) {
                foundItem1 = true;
            } else if (list.getContent().equals(item2)) {
                foundItem2 = true;
            }
            list.next();
        }

        // If both elements are found, swap them
        if (foundItem1 && foundItem2) {
            list.toFirst();
            while (list.hasAccess()) {
                if (list.getContent().equals(item1)) {
                    list.setContent(item2);
                } else if (list.getContent().equals(item2)) {
                    list.setContent(item1);
                }
                list.next();
            }
        }
    }

    private <T> int lengthList(List<T> pList) {
        int counter = 0;
        pList.toFirst();
        while(pList.hasAccess()) {
            counter++;
            pList.next();
        }
        return counter;
    }
}
