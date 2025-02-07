import utils.ComparableContent;
import utils.List;

public class QuickSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public QuickSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void quickSort() {
        int size = getSize();
        quicksort_intern(0, size - 1);
    }

    private void quicksort_intern(int left, int right) {
        if (left >= right) return;

        int pivotIndex = getMiddleIndex(left, right);
        int partitionIndex = partition(left, right, pivotIndex);

        quicksort_intern(left, partitionIndex);
        quicksort_intern(partitionIndex + 1, right);
    }

    private int partition(int left, int right, int pivotIndex) {
        ContentType pivotValue = getElementAt(pivotIndex);
        int i = left;
        int j = right;

        while (true) {
            while (getElementAt(i).isLess(pivotValue)) i++; // Suche links ein zu großes Element
            while (pivotValue.isLess(getElementAt(j))) j--; // Suche rechts ein zu kleines Element

            if (i >= j) return j; // Zeiger haben sich gekreuzt, Partitionierung beendett

            // Hier wird die neue swap Methode verwendet
            swap(list, getElementAt(i), getElementAt(j));
            i++;
            j--;
        }
    }

    private int getMiddleIndex(int left, int right) {
        return left + (right - left) / 2;
    }

    private ContentType getElementAt(int index) {
        list.toFirst();
        for (int i = 0; i < index && list.hasAccess(); i++) {
            list.next();
        }
        return list.hasAccess() ? list.getContent() : null;
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

    private int getSize() {
        int size = 0;
        list.toFirst();
        while (list.hasAccess()) {
            size++;
            list.next();
        }
        return size;
    }
}
