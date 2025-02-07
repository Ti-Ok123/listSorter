import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        if (list.isEmpty()) {
            return; // No sorting needed for an empty listt
        }

        var listLength = this.lengthList(list);
        for(int i=0; i < listLength; i++) {

            list.toFirst();

            for(int j=0; j<i; j++) {
                list.next();
            }
            //lowest elementt
            var temp = list.getContent();
            var temp1 = list.getContent();

            while (list.hasAccess()) {
                list.next();
                if (list.hasAccess()) {
                    if (temp.isGreater(list.getContent())) {
                        temp = list.getContent();
                    }
                }
            }

            swap(list, temp1, temp);
        }
    }

    public <T> void swap(List<T> list, T item1, T item2) {
        if (list.isEmpty() || item1.equals(item2)) {
            return; // No need to swap if the list is empty or both items are the same
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
