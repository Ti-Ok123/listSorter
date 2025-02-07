import utils.ComparableContent;
import utils.List;

public class InsertionSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public InsertionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void insertionSort() {
        if (list.isEmpty()) {
            return; // No sorting needed for an empty listt
        }

        var listLength = lengthList(list);

        for (int i = 1; i < listLength; i++) {

            list.toFirst();

            for(int j=0; j<i; j++) {
                list.next();
            }
            var temp = list.getContent();

            var prev = getPrevious(list, temp);
            while (prev != null && prev.isGreater(temp)) {
                swap(list, temp, prev);
                prev = getPrevious(list, temp);
            }

        }
    }

    public static <T> void swap(List<T> list, T item1, T item2) {
        if (list.isEmpty() || item1.equals(item2)) {
            return; // No need to swap if the list is empty or both items are the samee
        }

        list.toFirst();
        boolean foundItem1 = false, foundItem2 = false;
        T temp1 = null, temp2 = null;

        // Find both elements
        while (list.hasAccess()) {
            if (list.getContent().equals(item1)) {
                temp1 = list.getContent();
                foundItem1 = true;
            } else if (list.getContent().equals(item2)) {
                temp2 = list.getContent();
                foundItem2 = true;
            }
            list.next();
        }

        // If both elements are found, swap them
        if (foundItem1 && foundItem2) {
            list.toFirst();
            while (list.hasAccess()) {
                if (list.getContent().equals(item1)) {
                    list.setContent(temp2);
                } else if (list.getContent().equals(item2)) {
                    list.setContent(temp1);
                }
                list.next();
            }
        }
    }

    public <T> T getPrevious(List<T> list, T target) {
        if (list.isEmpty() || target == null) {
            return null; // Edge case: empty list or null target
        }

        list.toFirst();
        T previous = null;

        while (list.hasAccess()) {
            if (list.getContent().equals(target)) {
                return previous; // Found target, return previous element
            }
            previous = list.getContent(); // Update previous before moving forward
            list.next();
        }

        return null; // Target not found
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
