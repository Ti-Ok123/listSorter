import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        int laengeListe = laengeList(list);
        for(int i = 0; i < laengeListe; i++){
            for (int j = 0; j < laengeListe - 1; j++){
                list.toFirst();
                for (int k = 0; k < j; k++){
                    list.next();
                    ContentType item1 = list.getContent();
                    list.next();
                    ContentType item2 = list.getContent();
                    if(item1.isGreater(item2)){
                        swap(list, item1, item2);
                    }
                }
            }
        }
    }

    public int laengeList(List<ContentType> list){
        if(list.isEmpty() || list == null) return 0;
        int laenge = 0;
        list.toFirst();
        while(list.hasAccess()){
            laenge++;
            list.next();
        } return laenge;
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
}
