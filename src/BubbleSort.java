import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {  //liste wird von klein nach groß sortiert
        int lenge = lengeListe();
        System.out.println(lenge);
        ContentType a = null;  //objekt a und b werden jeweils die zu vergleichenden werte zugewiesen
        ContentType b = null;

        for(int i = 0; i < lenge; i++){ //äußere schleife
            list.toFirst();
            for(int j = 0; j < lenge -i ; j++){  //
                a = list.getContent();
                list.next();
                b = list.getContent();
                if(a.isGreater(b)){  //wenn a(element an stelle vor b) größer ist als b werden beide getauscht
                    swap(list, a,b);
                    list.toFirst();
                    for(int k = 0; k< j; k++){
                        list.next();
                    }
                }
                //a = list.getContent();
                //list.next();
                //b = list.getContent();
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

}}
