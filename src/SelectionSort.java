import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        for (int i = 0; i < laengeList(list) - 1; i++) {
            list.toFirst();
            for (int k = 0; k < i; k++) {
                list.next();
                ContentType minimum = list.getContent();
                while (list.hasAccess()) {
                    if (list.getContent().isLess(minimum)) {
                        minimum = list.getContent();
                    }
                    list.next();
                }

                list.toFirst();
                for (int j = 0; j < i; j++) {
                    list.next();
                    ContentType item1 = list.getContent();
                    list.setContent(minimum);
                    list.next();
                    while (list.hasAccess()) {
                        if (list.getContent().equals(minimum)) {
                            list.setContent(item1);
                        } else list.next();
                    }
                }
            }
        }
    }
    public int laengeList (List < ContentType > list) {
        if (list.isEmpty() || list == null) return 0;
        int laenge = 0;
        list.toFirst();
        while (list.hasAccess()) {
            laenge++;
            list.next();
        }
        return laenge;
    }
}
