import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        int lenge = lengeListe();
        ContentType kleinstes;
        ContentType tauschobjekt;
        //int indexKleinstes = 0;
        for(int j = 0; j < lenge - 1; j++) {
            System.out.println("j ist "+j);
            list.toFirst();
            for(int k = 0; k < j; k++){
                list.next();
            }
            kleinstes = list.getContent();
            tauschobjekt = list.getContent();
            //indexKleinstes = j;
            for (int i = j; i < lenge ; i++) {
                System.out.println("i ist "+i);
                list.next();
                if(list.getContent().isLess(kleinstes)){
                    kleinstes = list.getContent();
                    //indexKleinstes = i;

                }
                swap(list, tauschobjekt, kleinstes);
            }

        }
    }

    public int lengeListe(){
        int lenge = 0;
        list.toFirst();
        while(list.hasAccess()){
            lenge++;
            list.next();
        }
        list.toFirst();
        return lenge;

    }

    public <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        list.toFirst();
        if (list.isEmpty() || item1.equals(item2)) {
            return; // No need to swap if the list is empty or both items are the same
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
        list.toFirst();

    }
}